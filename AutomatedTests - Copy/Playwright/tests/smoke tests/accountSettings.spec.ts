import { test, expect } from "@playwright/test";
import signIn from "../../composables/signIn";
import getUsersByBrowser from "../../composables/getUsersByBrowser";
import type BrowserUsersInterface from "../../interfaces/BrowserUsersInterface";
import navigateFeature from "../../composables/navigateFeature";

let testUsers: BrowserUsersInterface;

test.beforeEach("Navigate to web app", async ({ page, browserName }) => {
  page.goto("/");
  await page.waitForLoadState();

  testUsers = getUsersByBrowser(browserName);
});

test("Enable dark mode", async ({ page }) => {
  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Account Settings");

  await expect(page.locator("h1")).toContainText("Account Settings");
  await page.locator("li.tab-link").filter({ hasText: "Appearance" }).click();
  await page.locator("input#dark").click();

  let storageData = await page.evaluate(() => {
    let data = {};
    for (let i = 0; i < localStorage.length; i++) {
      const key: any = localStorage.key(i);
      if (key == "vueuse-color-scheme") {
        data[key] = localStorage.getItem(key);
      }
    }
    return data;
  });

  expect(storageData).toStrictEqual({ "vueuse-color-scheme": "dark" });
  await expect(page.locator("h1")).toHaveCSS("color", "oklch(0.99 0.02 270)");
});
