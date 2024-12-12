import Users from "../variables/users";

function getUsersByBrowser(browserName: string) {
  if (browserName === "firefox") {
    return Users.Firefox;
  } else if (browserName === "webkit") {
    return Users.Webkit;
  } else {
    return Users.Chromium;
  }
}

export default getUsersByBrowser;
