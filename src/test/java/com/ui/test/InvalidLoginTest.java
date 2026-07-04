
package com.ui.test;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;

import static com.constants.Env.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pojos.User;
import com.ui.test.TestBase;
import com.ui.utility.LoggerUtility;

@Listeners({ com.ui.listeners.TestListner.class })

public class InvalidLoginTest extends TestBase {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS = "jatinvsharma@gmail.com";
	private static final String INVALID_PASSWORD = "Qwerty1234!";

	@Test(description = "Verify if Proper error message is shown for the user when they enter invalid credentials", groups = {
			"e2e", "sanity" })

	public void logintest() {

		assertEquals(homePage.gotoLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD)
				.getErrorMessage(), "Authentication failed.");

	}
}
