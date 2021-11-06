package com.technocredits.orghrm.pages;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.technocredits.orghrm.base.PredefinedActions;

public class DashboardPage extends PredefinedActions{
	
	public String getPageHeaderTile() {
		return driver.getTitle();
	}
	
	public String getPageTitle() {
		return driver.findElement(By.xpath("//li[@class='page-title']")).getText();
	}
	
	public int getTotalWidgets() {
		return driver.findElements(By.xpath("//div[@id='widget.id']")).size();
	}
	
	public List<String> getAllWidgetsText(){
		return getTextOfAllElements("//div[@class='widget-header']/span[2]");
	}
	
	/*public String getWidgetTextBasedOnIndex(int index){
		List<String> widgetsList = getAllWidgetsText();
		return widgetsList.get(index);
	}
	*/
}
