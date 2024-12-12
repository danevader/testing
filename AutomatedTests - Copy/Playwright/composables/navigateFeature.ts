import { Page } from "@playwright/test";

async function navigateFeature(page: Page, featureName: string) {
  await page.locator("li.nav-item").filter({ hasText: featureName }).click();
  // await page.locator("div.loading").waitFor({ state: "hidden" });
}

export default navigateFeature;
