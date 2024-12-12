import { test, expect } from "@playwright/test";
import { lorem, generatedMessage } from "../../variables/lorem";
import signIn from "../../composables/signIn";
import getUsersByBrowser from "../../composables/getUsersByBrowser";
import type BrowserUsersInterface from "../../interfaces/BrowserUsersInterface";
import navigateFeature from "../../composables/navigateFeature";
import getStarted from "../../composables/getStartedClick";

const cardName = generatedMessage.Subject;
const cardDetails = generatedMessage.Body.substring(1, 25);

let testUsers: BrowserUsersInterface;

test.beforeEach("Navigate to web app", async ({ page, browserName }) => {
  page.goto("/");
  await page.waitForLoadState();

  testUsers = getUsersByBrowser(browserName);
});

test("Create Info Library card", async ({ page }) => {
  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Info Library");

  await expect(page.locator("h1.page-title")).toHaveText("Info Library");

  await getStarted(page);

  await page.getByRole("button", { name: "New card" }).click();
  await page.getByRole("button", { name: "New custom card" }).click();

  await expect(page.locator("form#newcard")).toBeVisible();

  await page
    .getByRole("textbox", { name: "title" })
    .pressSequentially(cardName);
  await page.getByLabel("Description").pressSequentially(cardDetails);
  await page
    .getByRole("textbox", { name: "Name" })
    .pressSequentially(lorem.generateWords(2));

  await page.getByRole("button", { name: "Save" }).click();
  await page.locator("form#newcard").waitFor({ state: "hidden" });

  await expect(
    page.locator("li.info-card.border-gray.current-user:nth-child(1)")
  ).toContainText(cardName);
});

test("Edit Info Library card", async ({ page }) => {
  await signIn(page, testUsers.User2);
  await navigateFeature(page, "Info Library");

  await expect(page.locator("h1.page-title")).toHaveText("Info Library");

  await getStarted(page);

  await page
    .locator("li.info-card.border-gray.current-user:nth-child(1) > header")
    .locator("div.indicator")
    .click();
  await expect(page.getByRole("button", { name: "Edit" })).toBeVisible();
  await page.getByRole("button", { name: "Edit" }).click();
  await expect(page.locator("form#newcard")).toBeVisible();

  await page.getByLabel("Title").fill("");
  await page.getByLabel("Title").pressSequentially(cardName);
  await page.getByLabel("Description").fill("");
  await page.getByLabel("Description").pressSequentially(cardDetails);
  await page.getByLabel("Name").fill("");
  await page.getByLabel("Name").pressSequentially(lorem.generateWords(2));
  await page.getByRole("button", { name: "Save" }).click();

  await expect(page.locator("form#newcard")).not.toBeVisible();

  await expect(
    page.locator("li.info-card.border-gray.current-user:nth-child(1)")
  ).toContainText(cardName);
});

test("Delete Info Library card", async ({ page }) => {
  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Info Library");

  await expect(page.locator("h1.page-title")).toHaveText("Info Library");

  await getStarted(page);

  const deleteCardPromise = page.waitForResponse((res) =>
    res.url().includes("api/InfoLibrary/DeleteCard")
  );
  await page
    .locator("li.info-card.border-gray.current-user:nth-child(1) > header")
    .locator("div.indicator")
    .click();
  await expect(page.getByRole("button", { name: "Delete" })).toBeVisible();
  await page.getByRole("button", { name: "Delete" }).click();
  await expect(page.getByRole("button", { name: "Delete card" })).toBeVisible();
  await page.getByRole("button", { name: "Delete card" }).click();
  await deleteCardPromise;

  await expect(
    page.getByRole("button", { name: "Delete card" })
  ).not.toBeVisible();
});

test("Create Info Library tab", async ({ page }) => {
  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Info Library");

  await expect(page.locator("h1.page-title")).toHaveText("Info Library");

  await getStarted(page);

  const newTabPromise = page.waitForResponse((res) =>
    res.url().includes("api/InfoLibrary/CreateTab")
  );
  await page.getByRole("button", { name: "New tab" }).click();
  await expect(page.getByLabel("Tab name")).toBeVisible();
  await page.getByLabel("Tab name").fill(generatedMessage.Subject);
  await page.getByRole("button", { name: "Save" }).click();
  await newTabPromise;

  await expect(page.locator("h2.tab-name")).toContainText(
    generatedMessage.Subject
  );
});

test("Edit Info Library tab", async ({ page }) => {
  await signIn(page, testUsers.User2);
  await navigateFeature(page, "Info Library");

  await expect(page.locator("h1.page-title")).toHaveText("Info Library");

  await getStarted(page);

  const editTabPromise = page.waitForResponse((res) =>
    res.url().includes("api/InfoLibrary/EditTab")
  );

  await page
    .locator("li:nth-child(2) > button.tab-handle.ellipsis.font-bold.hover")
    .click();

  await page
    .locator("div.relative.has-dropdown.tab-edit-delete.ellipse-button")
    .click();

  await page.getByRole("button", { name: "Rename tab" }).click();
  await page.getByLabel("Tab name").fill("");
  await page.getByLabel("Tab name").pressSequentially(generatedMessage.Subject);
  await page.getByRole("button", { name: "Save" }).click();
  await editTabPromise;

  await expect(page.locator("h2.tab-name")).toContainText(
    generatedMessage.Subject
  );
});

test("Delete Info Library tab", async ({ page }) => {
  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Info Library");

  await expect(page.locator("h1.page-title")).toHaveText("Info Library");

  await getStarted(page);

  const deleteTabPromise = page.waitForResponse((res) =>
    res.url().includes("api/InfoLibrary/DeleteTab")
  );
  await page
    .locator("li:nth-child(2) > button.tab-handle.ellipsis.font-bold.hover")
    .click();
  await page
    .locator("div.relative.has-dropdown.tab-edit-delete.ellipse-button")
    .click();
  await page.getByRole("button", { name: "Delete tab" }).click();
  await page
    .locator("button.btn.primary")
    .filter({ hasText: "Delete tab" })
    .click();
  await deleteTabPromise;

  await expect(
    page.locator("button.btn.primary").filter({ hasText: "Delete tab" })
  ).not.toBeVisible();
});
