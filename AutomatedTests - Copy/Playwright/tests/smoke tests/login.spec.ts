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

test("Sign into web app", async ({ page }) => {
  await signIn(page, testUsers.User1);

  await expect(page.locator("h1")).toContainText("Messaging with");
});
