package com.technocredits.orghrm.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.orghrm.base.PredefinedActions;
import com.technocredits.orghrm.pojo.Employee;

public class PIM_EmployeeListPage extends PredefinedActions {
	
	public PIM_EmployeeListPage verifyAddedEmployee(String name) {
		System.out.println("Step - clicking on Employee List menu.");
		driver.findElement(By.xpath("//span[@class='left-menu-title' and text()='Employee List']")).click();
		System.out.println("Step - entering the name of employee.");
		driver.findElement(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")).sendKeys(name);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//table[@id='employeeListTable']/tbody/tr")));
		return this;
	}

	public PIM_EmployeeListPage clickOnQuickSearch() {
		System.out.println("Step - clicking on quick search.");
		//WebDriverWait wait = new WebDriverWait(driver, 40);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='employee_name_quick_filter_employee_list_value']")));
		driver.findElement(By.xpath("//i[@id='quick_search_icon']")).click();
		return this;
	}
	
	public List<Employee> getListOfEmployee() {
				
		int numofEmployeeRecords = driver.findElements(By.xpath("//table[@id='employeeListTable']/tbody/tr")).size();
		List<Employee> list = new ArrayList();
		try {
			for(int row=1; row<=numofEmployeeRecords; row++) {
				Employee a1 = new Employee();
				a1.setEmpID(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+row+"]/td[2]")).getText());
				a1.setEmpName(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+row+"]/td[3]")).getText());
				a1.setJobTitle(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+row+"]/td[4]")).getText());
				a1.setEmpStatus(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+row+"]/td[5]")).getText());
				a1.setSubUnit(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+row+"]/td[6]")).getText());
				a1.setCostCenter(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+row+"]/td[7]")).getText());
				a1.setLocation(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+row+"]/td[8]")).getText());
				a1.setSupervisor(driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr["+row+"]/td[9]")).getText());
				list.add(a1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
