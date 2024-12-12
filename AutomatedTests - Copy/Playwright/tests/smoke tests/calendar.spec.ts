import { test, expect } from "@playwright/test";
import { generatedMessage } from "../../variables/lorem";
import signIn from "../../composables/signIn";
import getUsersByBrowser from "../../composables/getUsersByBrowser";
import type BrowserUsersInterface from "../../interfaces/BrowserUsersInterface";
import navigateFeature from "../../composables/navigateFeature";
import getStarted from "../../composables/getStartedClick";

let testUsers: BrowserUsersInterface;
const eventName = generatedMessage.Subject;
const eventDescription = generatedMessage.Body;

test.beforeEach("Navigate to web app", async ({ page, browserName }) => {
  page.goto("/");
  await page.waitForLoadState();

  testUsers = getUsersByBrowser(browserName);
});

test("Create Calendar event", async ({ page }) => {
  const skeletonEl = page
    .locator("div.day:nth-child(1)")
    .filter({ has: page.locator("button.no-color.event.skeleton") });

  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Shared Calendar");

  await expect(page.locator("h1")).toContainText("Shared Calendar");

  await getStarted(page);

  await expect(page.locator("h1")).toContainText("Shared Calendar");

  await page
    .locator("button.btn.primary.newPlusBtn.ml-auto.align-middle")
    .click();
  await expect(page.locator("h2.sub-header")).toHaveText("New event");

  const createEventPromise = page.waitForResponse((res) =>
    res.url().includes("api/Calendar/CreateEntry")
  );

  await page.getByLabel("Event name").fill(eventName);
  await page.getByLabel("Details").fill(eventDescription);
  await page.getByRole("button", { name: "Create event" }).click();
  await createEventPromise;

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  await expect(page.locator("div.day.current-day")).toContainText(eventName);
});

test("Delete Calendar event", async ({ page }) => {
  const skeletonEl = page
    .locator("div.day:nth-child(1)")
    .filter({ has: page.locator("button.no-color.event.skeleton") });

  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Shared Calendar");

  await expect(page.locator("h1")).toContainText("Shared Calendar");

  await getStarted(page);

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  await expect(page.locator("h1")).toContainText("Shared Calendar");

  await page
    .locator("div.day")
    .locator("button.default-color.event")
    .first()
    .click();
  await page
    .locator("div.modal-animation-enter-active.modal-animation-enter-to")
    .isHidden();

  const deleteEventPromise = page.waitForResponse((res) =>
    res.url().includes("/api/Calendar/DeleteEntry")
  );

  await page
    .locator(
      "div.relative.has-dropdown.tab-edit-delete.ellipse-button-menu-desktop"
    )
    .click();
  await page.getByRole("button", { name: "Delete event" }).click();
  await page
    .locator("div.dialog-content.dialog-body")
    .getByRole("button", { name: "Delete event" })
    .click();
  await deleteEventPromise;

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  await expect(page.locator("div.calendar.month-view")).toBeVisible();
});

test("Edit Calendar event", async ({ page }) => {
  const skeletonEl = page
    .locator("div.day:nth-child(1)")
    .filter({ has: page.locator("button.no-color.event.skeleton") });

  await signIn(page, testUsers.User2);
  await navigateFeature(page, "Shared Calendar");

  await expect(page.locator("h1")).toContainText("Shared Calendar");

  await getStarted(page);

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  await expect(page.locator("h1")).toContainText("Shared Calendar");
  await page
    .locator("div.day")
    .filter({ hasText: "1" })
    .locator("button.honey.event")
    .click();
  await page
    .locator("div.modal-animation-enter-active.modal-animation-enter-to")
    .isHidden();

  const getEventPromise = page.waitForResponse((res) =>
    res.url().includes("api/Calendar/GetEntries")
  );

  await page
    .locator(
      "div.relative.has-dropdown.tab-edit-delete.ellipse-button-menu-desktop"
    )
    .click();
  await page.getByRole("button", { name: "Edit event" }).click();
  await getEventPromise;

  let editEventPromise = page.waitForResponse((res) =>
    res.url().includes("api/Calendar/EditEntry")
  );
  await page.getByLabel("Details").pressSequentially("edit");
  await page.getByRole("button", { name: "Save" }).click();
  await editEventPromise;

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  await expect(page.locator("div.calendar.month-view")).toBeVisible();
});

test("Cancel Calendar event", async ({ page }) => {
  const skeletonEl = page
    .locator("div.day:nth-child(1)")
    .filter({ has: page.locator("button.no-color.event.skeleton") });
  const currentDate = new Date();
  const today = currentDate.getDate().toString();

  await signIn(page, testUsers.User2);
  await navigateFeature(page, "Shared Calendar");

  await expect(page.locator("h1")).toContainText("Shared Calendar");

  await getStarted(page);

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  let cancelEventPromise = page.waitForResponse((res) =>
    res.url().includes("api/Calendar/CancelOccurrence")
  );

  await expect(page.locator("h1")).toContainText("Shared Calendar");
  await page
    .locator("div.day")
    .filter({ hasText: today })
    .locator("button.violet.event")
    .first()
    .click();

  await page
    .locator(
      "div.relative.has-dropdown.tab-edit-delete.ellipse-button-menu-desktop"
    )
    .click();

  await page.getByRole("button", { name: "Cancel event" }).click();
  await page
    .locator("div.modal")
    .getByRole("button", { name: "Cancel event" })
    .click();

  await cancelEventPromise;

  if (await skeletonEl.isVisible()) {
    await skeletonEl.waitFor({ state: "hidden" });
  }

  await expect(
    page
      .locator("div.day")
      .filter({ hasText: today })
      .locator("button.canceled-event")
      .first()
  ).toBeVisible();
});
