import { test, expect } from "@playwright/test";
import signIn from "../../composables/signIn";
import getUsersByBrowser from "../../composables/getUsersByBrowser";
import type BrowserUsersInterface from "../../interfaces/BrowserUsersInterface";
import navigateFeature from "../../composables/navigateFeature";

let testUsers: BrowserUsersInterface;
const zendeskTicketDescription = "Test ticket created from UI tests. Browser: ";

test.beforeEach("Navigate to web app", async ({ page, browserName }) => {
  page.goto("/");
  await page.waitForLoadState();

  testUsers = getUsersByBrowser(browserName);
});

test("Submit Zendesk Ticket while signed in", async ({ page, browserName }) => {
  await signIn(page, testUsers.User1);
  await navigateFeature(page, "Contact Us");

  await expect(page.locator("h2.sub-header")).toHaveText("Contact Us");

  const createTicketPromise = page.waitForResponse((res) =>
    res.url().includes("/api/Support/CreateTicket")
  );

  await page.getByLabel("Why are you contacting us?").click();
  await page.locator("li.btn.tertiary.option:last-child").click();
  await page
    .getByLabel("Please explain your issue in more detail")
    .fill(zendeskTicketDescription);
  await page
    .getByLabel("Please explain your issue in more detail")
    .pressSequentially(browserName);
  await page.getByRole("button", { name: "Send" }).click();
  await createTicketPromise;

  await expect(page.locator("p.text-left.mb-3.black")).toContainText(
    "Our support team will respond to you at " +
      testUsers.User1.Email +
      " within two business days"
  );
});
