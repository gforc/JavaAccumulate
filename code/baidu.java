import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class test001 {
	WebDriver browser;
	
	public test001() {
		browser = new ChromeDriver();		
	}
	
	public void OpenWebSite(String url) {
		
		browser.manage().window().maximize();
		browser.get(url);
		
	}
	
	public void SearchKeyWorkd(String key) {
		WebElement search_text = browser.findElement(By.id("kw"));
		WebElement search_button = browser.findElement(By.id("su"));
		
		search_text.clear();
		search_text.sendKeys(key);
		search_button.click();
		
		browser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		
	}

	public void Paging(int pageNum) {
		
		String current_pageNum = browser.findElement(By.xpath("//*[@id='page']/strong/span[2]")).getText();
		if (Integer.valueOf(current_pageNum) == pageNum) {
			return ;
		} 

		if (current_pageNum.equals("1")) {
			pageNum -=1;
			browser.findElement(By.xpath("//*[@id=\"page\"]/a["+ pageNum +"]/span[2]")).click();
			
		} else {
			
			browser.findElement(By.xpath("//*[@id=\"page\"]/a["+ pageNum +"]/span[2]")).click();
			
		}
		browser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	}
	
	public void showSearchResult() throws InterruptedException {
		List<WebElement> result = browser.findElements(By.xpath("//*[@id='content_left']/div/h3/a"));
		String PageNum = browser.findElement(By.xpath("//*[@id='page']/strong/span[2]")).getText();
		System.out.printf("this is the result for page %s : \n", PageNum);
		for(WebElement item : result) {
			
			System.out.println(item.getText());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		Thread.sleep(2000);
	}
	
	public void closeWebsite(WebDriver browser) {
		browser.quit();
	}



	public static void main(String[] args) throws InterruptedException {
		String url = "https://www.baidu.com";
		String key = "software test";
		test001 aa = new test001();
		
		aa.OpenWebSite(url);
		aa.SearchKeyWorkd(key);
		Thread.sleep(2000);
		aa.showSearchResult();
		Thread.sleep(2000);
		aa.Paging(2);
		Thread.sleep(2000);
		aa.showSearchResult();
		
	}
		
}
