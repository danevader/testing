// import {
//   test,
//   expect,
//   Page,
//   webkit,
//   firefox,
//   chromium,
// } from "@playwright/test";

// import { QaUrl } from "../variables/globals";
// import generatedMessage from "../variables/lorem";

// test("Send message via Chrome", async () => {
//   const browser = await chromium.launch();
//   const context = await browser.newContext();
//   const page = await context.newPage();

//   const generatedMessage = {
//     Subject: lorem.generateWords(3),
//     Body: lorem.generateParagraphs(2),
//   };

//   await page.goto(QaUrl + "/login");

//   await page.waitForLoadState();

//   await page.getByLabel("Email").fill("tptesting350@gmail.com");
//   await page.getByLabel("Password").fill("0plmNKO(((");
//   await page.getByRole("button", { name: "Sign In" }).click();

//   await page.waitForLoadState();
//   await expect(page.locator("h1")).toContainText("Messaging with");

//   //Create new message
//   await page.getByRole("button", { name: "New message" }).click();
//   await page.waitForLoadState();
//   await page.getByLabel("Subject").fill(generatedMessage.Subject);
//   await page.getByLabel("Message").fill(generatedMessage.Body);
//   await page.getByRole("button", { name: "Send" }).click();
//   await page.waitForLoadState();
//   await expect(page.locator("h2.px-1.ellipsis")).toHaveText(
//     generatedMessage.Subject
//   );
//   await expect(page.locator(".message")).toHaveText(generatedMessage.Body);
// });

// test.describe.serial("Messaging UI regression", async () => {
//   const chromiumBrowser = await chromium.launch();
//   const chromiumContext = await chromiumBrowser.newContext();
//   const parentOneTab = await chromiumContext.newPage();
//   const parentTwoTab = await chromiumContext.newPage();

//   test("Send message to co-parent", async () => {
// await parentOneTab.goto(QaUrl + "/login");

// await parentOneTab.waitForLoadState("domcontentloaded");

// await parentOneTab.getByLabel("Email").fill("tptesting350@gmail.com");
// await parentOneTab.getByLabel("Password").fill("0plmNKO(((");
// await parentOneTab.getByRole("button", { name: "Sign In" }).click();

// await parentOneTab.waitForLoadState("domcontentloaded");
// await expect(parentOneTab.locator("h1")).toContainText("Messaging with");

// //Create new message
// await parentOneTab.getByRole("button", { name: "New message" }).click();
// await parentOneTab.waitForLoadState("domcontentloaded");
// await parentOneTab.getByLabel("Subject").fill(generatedMessage.Subject);
// await parentOneTab.getByLabel("Message").fill(generatedMessage.Body);
// await parentOneTab.getByRole("button", { name: "Send" }).click();
// await parentOneTab.waitForLoadState("domcontentloaded");
// await expect(parentOneTab.locator("h2.px-1.ellipsis")).toHaveText(
//   generatedMessage.Subject
// );
// await expect(parentOneTab.locator(".message")).toHaveText(
//   generatedMessage.Body
// );
//   });

//   test("View most recent thread", async () => {
//     await parentOneTab.goto(QaUrl + "/login");
//     await parentOneTab.getByLabel("Email").fill("tptesting350@gmail.com");
//     await parentOneTab.getByLabel("Password").fill("0plmNKO(((");
//     await parentOneTab.getByRole("button", { name: "Sign In" }).click();

//     await parentOneTab.waitForLoadState("domcontentloaded");

//     await expect(parentOneTab.locator("h1.page-title")).toContainText(
//       "Messaging with "
//     );
//     await parentOneTab.locator("li.row:nth-child(1)").click();
//     await parentOneTab.waitForLoadState("domcontentloaded");
//     await expect(parentOneTab.locator("h2.px-1.ellipsis")).toHaveText(
//       generatedMessage.Subject
//     );
//     await expect(parentOneTab.locator("div.message.stack.size-0")).toHaveText(
//       generatedMessage.Body
//     );
//   });

// test("Parent two new message notification", async () => {
//   await parentTwoTab.goto(QaUrl + "/login");
//   await parentTwoTab.getByLabel("Email").fill("tptesting350+1@gmail.com");
//   await parentTwoTab.getByLabel("Password").fill("0plmNKO(");
//   await parentTwoTab.getByRole("button", { name: "Sign In" }).click();
//   await parentTwoTab.waitForLoadState("domcontentloaded");

//   await expect(parentTwoTab.locator("li.row:nth-child(1)")).toHaveText(
//     generatedMessage.Subject
//   );
// });
// });
