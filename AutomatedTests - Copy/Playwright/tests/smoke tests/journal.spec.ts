import { test, expect } from "@playwright/test";
import { lorem, generatedMessage } from "../../variables/lorem";
import signIn from "../../composables/signIn";
import navigateFeature from "../../composables/navigateFeature";
import getUsersByBrowser from "../../composables/getUsersByBrowser";
import type BrowserUsersInterface from "../../interfaces/BrowserUsersInterface";
import getStarted from "../../composables/getStartedClick";

const journalSubject = generatedMessage.Subject;
const journalBody = generatedMessage.Body;

let testUsers: BrowserUsersInterface;

test.beforeEach("Navigate to web app", async ({ page, browserName }) => {
  page.goto("/");

  await page.waitForLoadState();
  testUsers = getUsersByBrowser(browserName);
});

test("Create new Journal Entry", async ({ page }) => {
  const skeletonEl = page.locator("li.row:nth-child(1)").filter({
    has: page.locator("h3.journal-title.font-size-2.font-bold.skeleton"),
  });

  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Personal Journal");
  await getStarted(page);

  await expect(page.locator("h1.page-title")).toHaveText("Personal Journal");

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  await page.getByRole("button", { name: "New entry" }).click();
  await expect(
    page.locator("h2.sub-header").filter({ hasText: "New journal entry" })
  ).toBeVisible();
  await page.getByRole("textbox", { name: "title" }).fill(journalSubject);
  await page.getByLabel("Add your entry details").fill(journalBody);
  await page.getByRole("button", { name: "Save" }).click();
  await expect(
    page
      .locator("li.row:nth-child(1)")
      .locator("h3.journal-title.font-size-2.font-bold")
  ).toHaveText(journalSubject);
});

test("Edit journal entry", async ({ page }) => {
  const skeletonEl = page.locator("li.row:nth-child(1)").filter({
    has: page.locator("h3.journal-title.font-size-2.font-bold.skeleton"),
  });

  await signIn(page, testUsers.User2);
  await navigateFeature(page, "Personal Journal");
  await getStarted(page);

  await expect(page.locator("h1.page-title")).toHaveText("Personal Journal");

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  const journalEntryPromise = page.waitForResponse((res) =>
    res.url().includes("/api/Journal/GetJournalEntry")
  );

  await page
    .locator("li.row:nth-child(1)")
    .filter({
      has: page.locator("h3.journal-title.font-size-2.font-bold"),
    })
    .click();
  await journalEntryPromise;
  await expect(page.locator("h2.sub-header")).toHaveText("Edit journal entry");

  await page.getByLabel("Title").fill(lorem.generateWords(3));
  await page
    .getByLabel("Add your entry details")
    .fill(lorem.generateParagraphs(2));
  await page.getByRole("button", { name: "Save" }).click();

  await expect(
    page.locator("li.row:nth-child(1)").filter({
      has: page.locator("h3.journal-title.font-size-2.font-bold"),
    })
  ).toBeVisible();
});

test("Upload and delete Journal attachments", async ({ page }) => {
  const skeletonEl = page.locator("li.row:nth-child(1)").filter({
    has: page.locator("h3.journal-title.font-size-2.font-bold.skeleton"),
  });

  await signIn(page, testUsers.User2);
  await navigateFeature(page, "Personal Journal");
  await getStarted(page);

  await expect(page.locator("h1.page-title")).toHaveText("Personal Journal");

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  const journalEntryPromise = page.waitForResponse((res) =>
    res.url().includes("/api/Journal/GetJournalEntry")
  );

  await page
    .locator("li.row:nth-child(1)")
    .filter({
      has: page.locator("h3.journal-title.font-size-2.font-bold"),
    })
    .click();
  await journalEntryPromise;
  await expect(page.locator("h2.sub-header")).toHaveText("Edit journal entry");

  const deleteAttachmentPromise = page.waitForResponse((res) =>
    res.url().includes("api/Journal/DeleteJournalAttachment")
  );
  await page.locator("div.attachments-list").click();
  await page
    .locator(
      "div.attachment-delete.overflow-hidden.color-brand.align-middle.flex"
    )
    .click();
  await page.getByRole("button", { name: "Delete attachment" }).click();
  await deleteAttachmentPromise;

  const fileChooserPromise = page.waitForEvent("filechooser");
  await page.locator("div.dropzone.w-100").click();
  const fileChooser = await fileChooserPromise;
  await fileChooser.setFiles("./tests/testAttachments/attachment.jpg");
  await page.getByRole("button", { name: "Save" }).click();

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  await expect(
    page.locator("li.row:nth-child(1)").filter({
      has: page.locator("h3.journal-title.font-size-2.font-bold"),
    })
  ).toBeVisible();
});

test("Delete Journal entry", async ({ page }) => {
  const skeletonEl = page.locator("li.row:nth-child(1)").filter({
    has: page.locator("h3.journal-title.font-size-2.font-bold.skeleton"),
  });

  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Personal Journal");
  await getStarted(page);

  await expect(page.locator("h1.page-title")).toHaveText("Personal Journal");

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  const journalEntryPromise = page.waitForResponse((res) =>
    res.url().includes("/api/Journal/GetJournalEntry")
  );

  await page
    .locator("li.row:nth-child(1)")
    .filter({
      has: page.locator("h3.journal-title.font-size-2.font-bold"),
    })
    .click();
  await journalEntryPromise;
  await expect(page.locator("h2.sub-header")).toHaveText("Edit journal entry");

  const deleteEventPromise = page.waitForResponse((res) =>
    res.url().includes("api/Journal/DeleteJournalEntry")
  );
  await page.getByRole("button", { name: "delete entry" }).click();
  await page
    .locator("button.btn.primary")
    .filter({ hasText: "Delete entry" })
    .click();
  await deleteEventPromise;

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  await expect(
    page.locator("li.row:nth-child(1)").filter({
      has: page.locator("h3.journal-title.font-size-2.font-bold"),
    })
  ).toBeVisible();
});

test("Search returning no results", async ({ page }) => {
  const skeletonEl = page.locator("li.row:nth-child(1)").filter({
    has: page.locator("h3.journal-title.font-size-2.font-bold.skeleton"),
  });

  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Personal Journal");
  await getStarted(page);

  await expect(page.locator("h1.page-title")).toHaveText("Personal Journal");

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  const searchPromise = page.waitForResponse((res) =>
    res.url().includes("api/Journal/GetJournalEntries")
  );
  await page.getByPlaceholder("Search").fill("12345678901234567890");
  await page.getByRole("button", { name: "search" }).click();
  await searchPromise;
  await expect(page.locator("div.load-more.font-weight-2")).toHaveText(
    "Total: 0"
  );
});

test("Search journal by subject and body", async ({ page }) => {
  const skeletonEl = page.locator("li.row:nth-child(1)").filter({
    has: page.locator("h3.journal-title.font-size-2.font-bold.skeleton"),
  });

  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Personal Journal");
  await getStarted(page);

  await expect(page.locator("h1.page-title")).toHaveText("Personal Journal");

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  const searchPromise = page.waitForResponse((res) =>
    res.url().includes("api/Journal/GetJournalEntries")
  );
  await page.getByPlaceholder("Search").fill("palindrome");
  await page.getByRole("button", { name: "search" }).click();
  await searchPromise;
  await expect(page.locator("div.load-more.font-weight-2")).toHaveText(
    "Total: 2"
  );
});
