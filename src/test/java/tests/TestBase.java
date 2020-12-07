package tests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static com.codeborne.selenide.Selenide.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class TestBase {
	
	public static Properties prop = new Properties();
	public static Logger logger;
		
	public TestBase() {
		
		try {
			logger=Logger.getLogger("Test"); //Added logger
			PropertyConfigurator.configure("Log4j.properties");
			FileInputStream file = new FileInputStream("./src/test/resources/demoQA.properties");
			prop.load(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
				
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initilizeDemoqa() throws InterruptedException {
		open(prop.getProperty("demoQaUrl"));
		Thread.sleep(5000);
	}
}

