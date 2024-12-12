import { Page } from "@playwright/test";
import type User from "../interfaces/UserInterface";

async function signIn(page: Page, user: User) {
  const messageThreadsPromise = page.waitForResponse((res) =>
    res.url().includes("Messaging/GetConversationsPaged")
  );

  await page.getByLabel("Email").fill(user.Email);
  await page.getByLabel("Password").fill(user.Password);
  await page.getByRole("button", { name: "Sign In" }).click();

  await messageThreadsPromise;
}

export default signIn;
