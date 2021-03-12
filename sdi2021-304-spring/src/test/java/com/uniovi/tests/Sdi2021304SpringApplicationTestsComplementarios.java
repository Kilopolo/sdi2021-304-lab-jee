
package com.uniovi.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_PrivateView;
import com.uniovi.tests.pageobjects.PO_Properties;
import com.uniovi.tests.pageobjects.PO_RegisterView;
import com.uniovi.tests.pageobjects.PO_RegisterViewProf;
import com.uniovi.tests.pageobjects.PO_View;

//import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@SpringBootTest
public class Sdi2021304SpringApplicationTestsComplementarios {

	// En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens
	// automáticas)):
	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox65\\firefox.exe";
//	static String Geckdriver024 = "H:\\OneDrive\\OneDrive - Universidad de Oviedo\\Uni\\3Curso\\2ºSemestre\\Sistemas Distribuidos e Internet\\Laboratorio\\lab5\\PL-SDI-Sesión5-material\\geckodriver024win64.exe";
	static String Geckdriver024 = "C:\\geckodriver024win64.exe";
	// En MACOSX (Debe ser la versión 65.0.1 y desactivar las actualizacioens
	// automáticas):
	// static String PathFirefox65 =
	// "/Applications/Firefox.app/Contents/MacOS/firefox-bin";
	// static String Geckdriver024 = "/Users/delacal/selenium/geckodriver024mac";
	// Común a Windows y a MACOSX
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	// Antes de cada prueba se navega al URL home de la aplicación
	@BeforeEach
	public void setUp() {
		navigateUrl(Sdi2021304SpringApplicationTestsComplementarios.URL,"");
	}

	private void navigateUrl(String URL,String pag) {
		driver.navigate().to(URL+pag);
		new WebDriverWait(driver, 2);
	}

	// Después de cada prueba se borran las cookies del navegador
	@AfterEach
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	// Antes de la primera prueba
	@BeforeClass
	static public void begin() {
	}

	// Al finalizar la última prueba
	@AfterClass
	static public void end() {
		// Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}

	@Test
	public void PruebaConexion() {

		System.out.println(driver.getCurrentUrl());
		System.out.println();

		WebElement prueba = driver.findElement(By.id("prueba"));//// *[@id="prueba"] SIvCob
//		WebElement SIvCob= driver.findElement(By.id("SIvCob"));////*[@id="prueba"] SIvCob
//		WebElement emailAddressField = driver.findElement(withTagName("input").above(passwordField));
		System.out.println("-------------------");
		System.out.println(prueba.getText());
		assertEquals(prueba.getText(), "Lorem ipsum dolor sit amet, consectetur adipiscing");

//		WebElement we = driver.getTitle();

	}

	
//	[Prueba1] Registro de profesores con datos válidos
	@Test
	public void PR01() {
		PO_PrivateView.login(driver, "admin", "123456", "Gestión de Profesores");
		navigateUrl(Sdi2021304SpringApplicationTestsComplementarios.URL, "/prof/add");

		// Rellenamos el formulario.
		PO_RegisterViewProf.fillForm(driver, "99999990B", "Josefo", "Per");//,"ROLE_PROFESSOR"
		
	}
//	[Prueba2] Registro de profesores con datos inválidos (nombre y categoría inválidos).
	@Test
	public void PR02() {
		PO_PrivateView.login(driver, "admin", "123456", "Gestión de Profesores");
		navigateUrl(Sdi2021304SpringApplicationTestsComplementarios.URL, "/prof/add");
		
		Random r = new Random();
		int dniNum = 0;
		PO_RegisterViewProf.fillForm(driver, "99999993D", "Josefo", "Perez");
		navigateUrl(Sdi2021304SpringApplicationTestsComplementarios.URL, "/prof/add");
		PO_RegisterViewProf.fillForm(driver, "99999993D", "Josefo", "Perez");
		PO_View.getP();
		// COmprobamos el error de DNI repetido.
		PO_RegisterViewProf.checkKey(driver, "Error.prof.edit.dni.unique", PO_Properties.getSPANISH());
		dniNum = r.nextInt(10000000);
		// Rellenamos el formulario.
		PO_RegisterViewProf.fillForm(driver, "9990B", "Jose", "Perez");
		// COmprobamos el error de Nombre corto .
		PO_RegisterViewProf.checkKey(driver, "Error.prof.edit.dni.length", PO_Properties.getSPANISH());
	}
//	[Prueba3] Verificar que solo los usuarios autorizados pueden dar de alta un	profesor.
	@Test
	public void PR03() {
		PO_PrivateView.login(driver, "admin", "123456", "Gestión de Profesores");
		navigateUrl(Sdi2021304SpringApplicationTestsComplementarios.URL, "/prof/add");
		
		
		
		
	}
}