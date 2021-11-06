package com.technocredits.orghrm.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pages.LoginPage;

public class LoginTest {
	SoftAssert softAsset = new SoftAssert();
	@BeforeMethod
	public void setup() {
		PredefinedActions.start();
	}
	
	LoginPage loginPage = new LoginPage();
	
	

	public void verifyingLogoDisplay() {
		System.out.println("VERIFY - Logo displayed on Login Page");
		
		boolean isLogoDisplayedCheck = loginPage.isLogoDisplayed();
		softAsset.assertTrue(isLogoDisplayedCheck, "Sorry, Logo was not displayed on Login Page");
	}
	
	public void verifyingLoginPanelDisplay() {		
		System.out.println("VERIFY - Login Panel displayed on Login Page");
		boolean isLoginPanelDisplayedCheck = loginPage.isLoginPanelDisplayed();		
		softAsset.assertTrue(isLoginPanelDisplayedCheck, "LoginPanel was not displayed on Login Page");
	}
	
	
	@Test
	public void validatingLoginDetails() {
		verifyingLogoDisplay();
		verifyingLoginPanelDisplay();
		System.out.println("STEP - Entering Login details.");
		loginPage.enterCredentials("Admin", "nCU5@4JrmA");
		softAsset.assertAll();
		
		System.out.println("Clicking on Login button.");
		loginPage.clickOnLoginButton();
	}
	
	//@Test
	public void validatingLoginWitoutPassword() {
		verifyingLogoDisplay();
		verifyingLoginPanelDisplay();
		System.out.println("STEP - Entering Login details without password.");
		loginPage.enterCredentials("Admin", "");
		softAsset.assertAll();
		
		System.out.println("Clicking on Login button");
		loginPage.clickOnLoginButton();
		
		String expectedErrorMessage = "Password cannot be empty";
		String actualErrorMessage = loginPage.getLoginErrorMessage();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}
	
	@AfterMethod
	public void teardown() {
		PredefinedActions.closeBrowser();
	}
}