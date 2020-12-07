package pages;

import org.openqa.selenium.By;
import com.codeborne.selenide.Selenide;

import utilities.Helper;
import utilities.TestData;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

public class DemoqaFormPage {
	
	TestData data= new TestData();
	Helper helperObject= new Helper();
	
	By firstName= By.xpath("//input[@id='firstName']");		
	By lastName= By.xpath("//input[@id='lastName']");
	By mobileNumber= By.xpath("//input[@id='userNumber']");
	By male= By.xpath("//label[@class='custom-control-label' and text()='Male']");
	By female= By.xpath("//label[@class='custom-control-label' and text()='Female']");
	By otherGender= By.xpath("//label[@class='custom-control-label' and text()='Other']");
	By submit= By.id("submit");
	By verifySubmission= By.xpath("//div[@id='example-modal-sizes-title-lg']");
	By fName= By.xpath("(//div[@class='col-md-4 col-sm-6'])[1]");
	
	public void fillForm()
	{
		data.firstName="Ihsan";
		$(firstName).setValue(data.firstName);
		data.lastName="Rehman";
		$(lastName).setValue(data.lastName);
		data.gender ="male";
		
		if(data.gender.equals("male")) {
			$(male).click();
		}
		else if(data.gender.equals("female")) {
			$(female).click();
		}
		else {
			$(otherGender).click();
		}
		
		data.mobileNumber="1234567890";
		$(mobileNumber).setValue(data.mobileNumber);
	}
	
	public void clickSubmit() throws Exception {
		Selenide.executeJavaScript("window.scrollBy(0,5000)");
		$(submit).click();
//		To capture the exact values for color code we used Thread.sleep
		Thread.sleep(5000);			
	}
	
	public void verifyFormSubmit() {
		$(verifySubmission).shouldHave(text("Thanks for submitting the form"));
	}
	public String actuallColorCode(String element) {
				String actualColor=null;
		if(element.equals("firstName")) {
			actualColor=helperObject.getHexColor(firstName);
		}
		else if(element.equals("lastName")) {
			actualColor=helperObject.getHexColor(lastName);
		}
		else if(element.equals("gender")) {
			actualColor=$(male).getCssValue("color");
		}
		else if(element.equals("userNumber")) {
			actualColor=helperObject.getHexColor(mobileNumber);
		}
		return actualColor;
	}
	
	public void closeBrowser() {
		
		Selenide.closeWebDriver();
	}
	
}

