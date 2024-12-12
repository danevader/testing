import { test, expect } from "@playwright/test";
import { generatedMessage } from "../../variables/lorem";
import signIn from "../../composables/signIn";
import getUsersByBrowser from "../../composables/getUsersByBrowser";
import type BrowserUsersInterface from "../../interfaces/BrowserUsersInterface";
import navigateFeature from "../../composables/navigateFeature";

let testUsers: BrowserUsersInterface;
const folderName = generatedMessage.Subject;
const descriptionMaxLength = 400;
const folderDescription = generatedMessage.Body.substring(
  0,
  descriptionMaxLength
);

test.beforeEach("Navigate to web app", async ({ page, browserName }) => {
  page.goto("/");
  await page.waitForLoadState();

  testUsers = getUsersByBrowser(browserName);
});

test("Create Vault folder", async ({ page }) => {
  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Vault File Storage");

  await expect(page.locator("h1")).toContainText("Vault File Storage");

  const createFolderPromise = page.waitForResponse((res) =>
    res.url().includes("/api/vault/folder")
  );

  await page.getByRole("button", { name: "New folder" }).click();
  await page.getByLabel("Folder name").fill(folderName);
  await page.getByLabel("Description (optional)").fill(folderDescription);
  await page.getByRole("button", { name: "Save" }).click();
  await createFolderPromise;

  await expect(page.locator("h1")).toContainText("Vault File Storage");
  await expect(page.getByLabel("Folder name")).not.toBeVisible();
  await expect(page.locator("li.row.row-hover:nth-child(1)")).toContainText(
    folderName
  );
});

test("Delete Vault folder", async ({ page }) => {
  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Vault File Storage");

  await expect(page.locator("h1")).toContainText("Vault File Storage");

  const trashFolderPromise = page.waitForResponse((res) =>
    res.url().includes("/api/vault/folder/trash")
  );

  await page
    .locator("li.row.row-hover:nth-child(1)")
    .locator("button.btn.tertiary.menu")
    .click();
  await page.getByRole("button", { name: "Move to trash" }).click();
  await page.locator("div.dialog").isVisible();
  await page.getByRole("button", { name: "Move to trash" }).click();
  await trashFolderPromise;

  const getTrashPromise = page.waitForResponse((res) =>
    res.url().includes("api/vault/item/searchFilterSort")
  );

  await page.locator("button.btn.tertiary.trash").click();
  await getTrashPromise;

  const deleteFolderPromise = page.waitForResponse((res) =>
    res.url().includes("/api/vault/folder/delete")
  );

  await page
    .locator("li.row.row-hover:nth-child(1)")
    .locator("button.btn.tertiary.menu")
    .click();
  await page.getByRole("button", { name: "Delete" }).click();
  await page.locator("div.dialog").isVisible();
  await page.getByRole("button", { name: "Delete" }).click();
  await deleteFolderPromise;

  await expect(page.locator("h1")).toContainText("Vault File Storage");
});

test("Upload Vault file", async ({ page }) => {
  await signIn(page, testUsers.User2);
  await navigateFeature(page, "Vault File Storage");

  await expect(page.locator("h1")).toContainText("Vault File Storage");

  const fileChooserPromise = page.waitForEvent("filechooser");
  const uploadFilePromise = page.waitForResponse((res) =>
    res.url().includes("/api/vault/file")
  );

  await page.getByRole("button", { name: "Upload file" }).click();
  const fileChooser = await fileChooserPromise;
  await fileChooser.setFiles("./tests/testAttachments/attachment.jpg");
  await uploadFilePromise;

  await expect(page.locator("svg.fa-circle-check")).toBeVisible();
  await expect(page.locator("li.row.row-hover:last-child")).toContainText(
    "attachment.jpg"
  );
});

test("Delete Vault file", async ({ page }) => {
  await signIn(page, testUsers.User2);
  await navigateFeature(page, "Vault File Storage");

  await expect(page.locator("h1")).toContainText("Vault File Storage");

  const trashFilePromise = page.waitForResponse((res) =>
    res.url().includes("/api/vault/file/trash")
  );

  await page
    .locator("li.row.row-hover:nth-child(1)")
    .locator("button.btn.tertiary.menu")
    .click();
  await page.getByRole("button", { name: "Move to trash" }).click();
  await page.locator("div.dialog").isVisible();
  await page.getByRole("button", { name: "Move to trash" }).click();
  await trashFilePromise;

  const getTrashPromise = page.waitForResponse((res) =>
    res.url().includes("api/vault/item/searchFilterSort")
  );

  await page.locator("button.btn.tertiary.trash").click();
  await getTrashPromise;

  const deleteFilePromise = page.waitForResponse((res) =>
    res.url().includes("/api/vault/file/delete")
  );

  await page
    .locator("li.row.row-hover:nth-child(1)")
    .locator("button.btn.tertiary.menu")
    .click();
  await page.getByRole("button", { name: "Delete" }).click();
  await page.locator("div.dialog").isVisible();
  await page.getByRole("button", { name: "Delete" }).click();
  await deleteFilePromise;

  await expect(page.locator("h1")).toContainText("Vault File Storage");
});
