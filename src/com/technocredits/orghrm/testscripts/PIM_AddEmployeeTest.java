package com.technocredits.orghrm.testscripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orghrm.pages.MenuPage;
import com.technocredits.orghrm.pages.PIM_AddEmployeePage;

public class PIM_AddEmployeeTest extends TestBase{

	private MenuPage menuPage;
	
	@BeforeMethod
	public void setUp() {
		menuPage = super.setup();
	}
	
	@Test
	public void verifyAddEmployeeTest() {
		menuPage.navigateTo("PIM->Add Employee");
		PIM_AddEmployeePage pim_AddEmployeePage = new PIM_AddEmployeePage();
		pim_AddEmployeePage
			.setEmpFirstName("Gaurav")
			.setEmpMiddleName("M")
			.setEmpLastName("Kothadia")
			.setEmployeeLocation("London Office")
			.clickOnNext()
			.setHobbies("Reading")
			.clickOnNext()
			.setWorkShift("Twilight")
			.setEffectiveFrom("12")
			.setRegion("Region-1")
			.setFTE("1")
			.setTemperoryDepartment("Sub unit-1")
			.clickOnSave();
	}
	
	
	
	
	public void teardown() {
		super.teardown();
	}
}
