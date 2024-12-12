import { Page } from "@playwright/test";

async function getStarted(page: Page) {
  if (await page.getByRole("button", { name: "Get started" }).isVisible()) {
    await page.getByRole("button", { name: "Get started" }).click();
  }
}

export default getStarted;
