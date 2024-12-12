import { test, expect } from "@playwright/test";
import { lorem, generatedMessage } from "../../variables/lorem";
import signIn from "../../composables/signIn";
import getUsersByBrowser from "../../composables/getUsersByBrowser";
import type BrowserUsersInterface from "../../interfaces/BrowserUsersInterface";

const msgSubject = generatedMessage.Subject;
const msgBody = generatedMessage.Body;

let testUsers: BrowserUsersInterface;

test.beforeEach("Navigate to web app", async ({ page, browserName }) => {
  page.goto("/");
  await page.waitForLoadState();

  testUsers = getUsersByBrowser(browserName);
});

test("Create a new message thread (no attachment)", async ({ page }) => {
  await signIn(page, testUsers.User1);

  await page.getByRole("button", { name: "New message" }).click();

  await page.getByRole("textbox", { name: "subject" }).fill(msgSubject);
  await page.getByRole("textbox", { name: "message" }).fill(msgBody);
  await page.getByRole("button", { name: "Send" }).click();

  await expect(page.locator("h2.ellipsis")).toHaveText(msgSubject);
  await expect(
    page.locator("div.message-bubble.stack.size-0.align-self-end > span")
  ).toHaveText(msgBody);
});

test("Create a new message thread (with attachment)", async ({ page }) => {
  await signIn(page, testUsers.User2);

  await page.getByRole("button", { name: "New message" }).click();

  const fileChooserPromise = page.waitForEvent("filechooser");
  await page.getByRole("textbox", { name: "subject" }).fill(msgSubject);
  await page.getByRole("textbox", { name: "message" }).fill(msgBody);
  await page.locator("div.dropzone.w-100").click();
  const fileChooser = await fileChooserPromise;
  await fileChooser.setFiles("./tests/testAttachments/attachment.jpg");

  await page.getByRole("button", { name: "Send" }).click();

  await expect(page.locator("h2.ellipsis")).toHaveText(msgSubject);
  await expect(
    page.locator("div.message-bubble.stack.size-0.align-self-end > span")
  ).toHaveText(msgBody);
});

test("Reply to thread without attachments", async ({ page }) => {
  const testMessage = lorem.generateParagraphs(2);

  await signIn(page, testUsers.User1);

  await page
    .locator("li.row:nth-child(1)")
    .filter({
      has: page.locator("time.message-date.gray-light"),
    })
    .click();

  await expect(page.locator("h2.ellipsis")).toBeVisible();
  await page.getByRole("textbox", { name: "message" }).fill(testMessage);

  await page.getByRole("button", { name: "Send" }).click();

  await expect(
    page.getByRole("button", { name: "Saving" }).locator("div.loader")
  ).toBeVisible();
  await expect(
    page.getByRole("button", { name: "Saving" }).locator("div.loader")
  ).not.toBeVisible();
  await expect(
    page
      .locator("div.message-container.parent:last-child")
      .locator("div.message-bubble.stack.size-0.align-self-end")
  ).toContainText(testMessage);
});

test("Reply to thread with attachment", async ({ page }) => {
  const testMessage = lorem.generateParagraphs(2);

  await signIn(page, testUsers.User2);

  await page
    .locator("li.row:nth-child(1)")
    .filter({
      has: page.locator("time.message-date.gray-light"),
    })
    .click();

  await expect(page.locator("h2.ellipsis")).toBeVisible();
  await page.getByRole("textbox", { name: "message" }).fill(testMessage);

  const fileChooserPromise = page.waitForEvent("filechooser");
  await page.locator("div.dropzone.w-100").click();
  const fileChooser = await fileChooserPromise;
  await fileChooser.setFiles("./tests/testAttachments/attachment.jpg");

  await page.getByRole("button", { name: "Send" }).click();
  await expect(
    page.getByRole("button", { name: "Saving" }).locator("div.loader")
  ).toBeVisible();
  await expect(
    page.getByRole("button", { name: "Saving" }).locator("div.loader")
  ).not.toBeVisible();
  await expect(
    page
      .locator("div.message-container.parent:last-child")
      .locator("span.font-size-1.brand")
  ).toHaveText("attachment.jpg");
});

test("Search returning no results", async ({ page }) => {
  await signIn(page, testUsers.User1);

  await expect(
    page.locator("li.row:nth-child(1)").filter({
      has: page.locator("time.message-date.gray-light"),
    })
  ).toBeVisible();
  await page.getByPlaceholder("Search").fill("12345678901234567890");
  await expect(page.locator("span.no-results-found-title")).toHaveText(
    "No results found"
  );
});

test("Search messages by subject and body", async ({ page }) => {
  await signIn(page, testUsers.User1);

  await expect(
    page.locator("li.row:nth-child(1)").filter({
      has: page.locator("time.message-date.gray-light"),
    })
  ).toBeVisible();
  await page.getByPlaceholder("Search").fill("palindrome");
  await expect(page.locator("div.load-more.font-weight-2")).toHaveText(
    "Total: 2"
  );

  const getThreadPromise = page.waitForResponse((res) =>
    res.url().includes("/api/Conversations/GetPagedThread")
  );
  await page.locator("li.row:nth-child(1)").click();
  await getThreadPromise;

  await expect(
    page.locator("div.message-bubble.highlighted > span > span")
  ).toHaveCSS("background-color", "oklch(0.49 0.19 210)");

  await expect(
    page.locator("div.message-bubble.highlighted > span > span")
  ).toContainText("palindrome");
});
