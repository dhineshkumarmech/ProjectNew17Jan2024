package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
	
	public static WebDriver launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Opera")) {
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		return driver;
		
		//(OR)
		
//		public static WebDriver launchBrowser(String browserName) {
//			switch (browserName) {
//			case "Edge":
//				WebDriverManager.edgedriver().setup();
//				driver=new EdgeDriver();
//				break;
//			case "Firefox":
//				WebDriverManager.firefoxdriver().setup();
//				driver=new FirefoxDriver();
//				break;
//			case "Opera":
//				WebDriverManager.operadriver().setup();
//				driver=new OperaDriver();
//				break;
//			default:
//				System.out.println("Invalid BrowserName");
//				break;
//			}
//			return driver;
		}
		
		public static void maximize() {
			driver.manage().window().maximize();
		}
		
		public static void ImplicitlyWait(long sec) {
			driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
		}
		
		public static void explicitlyWaitClick(WebElement e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(e));
		}
		
		public static void explicitlyWaitWindow(int index) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.numberOfWindowsToBe(index));
		}
		
		public static void explicitlyWaitpresenceOfElementLocated(String xpath) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		}
		
		public static void launchUrl(String Url) {
			driver.get(Url);
		}
		
		public static void sendKeys(WebElement e, String value) {
			e.sendKeys(value);
		}
		
		public static void sendKeysEnter(WebElement e, String value, Keys key) {
			e.sendKeys(value);
		}
		public static void btnClick(WebElement e) {
		   e.click();
		}
		
		public static void clear(WebElement e) {
			e.clear();
		}
		
		public static void quitBrowser() {
			driver.quit();
		}
		
		public static String GetCurrentUrl() {
			String Url = driver.getCurrentUrl();
			return Url;
		}
		
		public static String GetTitle() {
			return driver.getTitle();
		}
		
		public static String getAttribute(WebElement e) {
			String at = e.getAttribute("value");
			return at;			
		}
		
		public static String getText(WebElement e) {
			String text = e.getText();
			return text;	
		}
		
		public static void moveToElement(WebElement target) {
			Actions a=new Actions(driver);
			a.moveToElement(target).perform();
		}
		
		public static void dragAndDrop(WebElement source, WebElement target) {
			Actions a=new Actions(driver);
			a.dragAndDrop(source, target).perform();
		}
		
		public static void selectByIndex(WebElement e, int index) {
			Select s=new Select(e);
			s.selectByIndex(index);
		}
		
		public static void selectByValue(WebElement e, String value) {
			Select s=new Select(e);
			s.selectByValue(value);
		}
		
		public static void selectByVisibleText(WebElement e, String text) {
			Select s=new Select(e);
			s.selectByVisibleText(text);
		}
		
		public static WebElement findElement(String locatorname, String loc) {
			WebElement e =null;
			if (locatorname.equals("id")) {
				e = driver.findElement(By.id(loc));
			} else if (locatorname.equals("name")) {
				e = driver.findElement(By.name(loc));
			} else if (locatorname.equals("xpath")) {
				e = driver.findElement(By.xpath(loc));
			}
			return e;
			
		}
		
		
		public static List<WebElement> findElements(String locatorName, String loc) {
			List<WebElement> e = null;
			if(locatorName.equalsIgnoreCase("id")) {
				e = driver.findElements(By.id(loc));
			} else if(locatorName.equalsIgnoreCase("name")) {
				e = driver.findElements(By.name(loc));
			} else if(locatorName.equalsIgnoreCase("className")) {
				e = driver.findElements(By.className(loc));	
			} else if(locatorName.equalsIgnoreCase("xpath")) {
				e = driver.findElements(By.xpath(loc));
			} else if(locatorName.equalsIgnoreCase("linkText")) {
				e = driver.findElements(By.linkText(loc));
			} else if(locatorName.equalsIgnoreCase("partialLinkText")) {
				e = driver.findElements(By.partialLinkText(loc));
			} else if(locatorName.equalsIgnoreCase("cssSelector")) {
				e = driver.findElements(By.cssSelector(loc));
			} else if(locatorName.equalsIgnoreCase("tagName")){
				e = driver.findElements(By.tagName(loc));
			}
			return e;
		}
		
		
		public static void getWindowHandle() {
			driver.getWindowHandle();
		}
		
		public static void getWindowHandles() {
			driver.getWindowHandles();
		}
		
		public static void switchToWindows(int index) {
			List<String> li = new ArrayList<String>();
			li.addAll(driver.getWindowHandles());
			driver.switchTo().window(li.get(index));
		}
		
		public static void windowHandlesNextPage() {
			String parentId = driver.getWindowHandle();
			Set<String> allIds = driver.getWindowHandles();
			for (String eachId : allIds) {  
				if(!parentId.equals(eachId)) { 
					driver.switchTo().window(eachId);
				}
			}
		}
		
		public static void screenshot(String name) throws IOException {
			TakesScreenshot tk=(TakesScreenshot)driver;
			File src = tk.getScreenshotAs(OutputType.FILE);
			
			File des=new File("C:\\Users\\Divya.B\\eclipse-workspace\\MavenProject\\src\\test\\resources\\ScreenShot"+name+".png");
			FileUtils.copyFile(src, des);
		}
		
		public static void JavascriptExecutor(String name,WebElement element) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('value','"+name+"')",element);
		}
		
		public static void scrollDown(WebElement e) {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)",e);
		}
		
//		public static String Excel(String name, String sheet, String sheetname, int rowno, int cellno) throws IOException {
//			File f=new File("C:\\Users\\Divya.B\\eclipse-workspace\\MavenProject\\src\\test\\resources\\"+name+"."+sheet+"");
//			FileInputStream fi=new FileInputStream(f);
//			Workbook w=new XSSFWorkbook(fi);
//			Sheet s = w.getSheet(sheetname);
//			Row r = s.getRow(rowno);
//			Cell c = r.getCell(cellno);
//	
//			int cellType = c.getCellType();
//			
//			String value = null;
//			
//					if(cellType==1) {
//						value = c.getStringCellValue();				
//					} else {
//						if(DateUtil.isCellDateFormatted(c)) {
//							Date date = c.getDateCellValue();
//							SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-YYYY");
//							value = sdf.format(date);
//						} else {
//							double db = c.getNumericCellValue();
//							long ln=(long)db;
//							value = String.valueOf(ln);
//						}					
//					}
//			return value;
//		}
		
		public static void startAndEndTime() {
			Date d=new Date();
		}
		
		public static void sleep(long millis) throws InterruptedException {
			Thread.sleep(millis);
		}
		
		public static void isSelect(WebElement e) {
			e.isSelected();
		}
		
		public static void isDisplayed(WebElement e) {
			e.isDisplayed();
		}
		
		public static void isEnabled(WebElement e) {
			e.isEnabled();
		}
}
