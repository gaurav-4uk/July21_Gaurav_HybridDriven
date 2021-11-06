package com.technocredits.orghrm.testscripts;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.technocredits.orghrm.pages.MenuPage;
import com.technocredits.orghrm.pages.PIM_EmployeeListPage;
import com.technocredits.orghrm.pojo.Employee;

public class PIM_EmployeeListTest extends TestBase{
	MenuPage menuPage;
	
	@BeforeMethod
	public void Login() {
		menuPage = super.setup();
	}
	@Test
	public void verifyAddedEmployee() {
		menuPage.navigateTo("PIM->Employee List");
		PIM_EmployeeListPage empListCheck = new PIM_EmployeeListPage();
		
		List<Employee> empList = empListCheck
			.verifyAddedEmployee("0136")
			.clickOnQuickSearch()
			.getListOfEmployee();
		
		boolean isEmpIDDisplayed=false;
		for(Employee e1 : empList) {
			if(Employee.getEmpID().equals("0136")) {
				isEmpIDDisplayed=true;
				System.out.println("The employee ID "+Employee.getEmpID()+" passed is found in Employee list.");
				break;
			}
			else System.out.println("The employee ID does not exist in database.");
		}
		//Assert.assertEquals(Employee.getEmpID(), "0136");
		Assert.assertTrue(empList.size() == 1);
	}

	@AfterMethod
	public void teardonw() {
		super.teardown();
	}

}
