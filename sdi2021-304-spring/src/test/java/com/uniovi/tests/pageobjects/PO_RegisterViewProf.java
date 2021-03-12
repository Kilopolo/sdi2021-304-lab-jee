package com.uniovi.tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_RegisterViewProf extends PO_NavView {
	static public void fillForm(WebDriver driver, String dnip, String namep, String lastnamep//, String rolep //, String passwordp, String passwordconfp
			) {
		WebElement dni = driver.findElement(By.name("dni"));
		dni.click();
		dni.clear();
		dni.sendKeys(dnip);
		WebElement name = driver.findElement(By.name("name"));
		name.click();
		name.clear();
		name.sendKeys(namep);
		WebElement lastname = driver.findElement(By.name("lastName"));
		lastname.click();
		lastname.clear();
		lastname.sendKeys(lastnamep);
//		WebElement role = driver.findElement(By.name("role"));
//		lastname.click();
//		lastname.clear();
//		lastname.sendKeys(rolep);
//		WebElement password = driver.findElement(By.name("password"));
//		password.click();
//		password.clear();
//		password.sendKeys(passwordp);
//		WebElement passwordConfirm = driver.findElement(By.name("passwordConfirm"));
//		passwordConfirm.click();
//		passwordConfirm.clear();
//		passwordConfirm.sendKeys(passwordconfp);
		// Pulsar el boton de Alta.
		By boton = By.className("btn");
		driver.findElement(boton).click();
	}
}
