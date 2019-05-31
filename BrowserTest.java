package chromeBrowser;
import java.io.*;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
	public static void main(String[] args) throws IOException, InterruptedException{
		ArrayList<String> urlList = new ArrayList<String>();
		File file = new File("/Users/xristopher/Projects/Misc/urls.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String password;
		String url;
		password = br.readLine();
		while((url = br.readLine()) != null) {
			urlList.add(url);
		}
		br.close();
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/xristopher/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();	
		driver.navigate().to("https://www.youtube.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//paper-button[@aria-label=\"Sign in\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-label=\"Email or phone\"]")).sendKeys("armyofnerds97@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-label=\"Enter your password\"]")).sendKeys(password);
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(3000);
		

	    for(int i = 0; i < urlList.size(); i++) {
	    	driver.navigate().to(urlList.get(i));
	    	Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@aria-label=\"Save\"]")).click();
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//yt-formatted-string[@title=\"Food\"]")).click();
	    }
		
	}
}
