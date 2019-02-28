# maximize() and findElements（）
browser.manage().window().maximize() 和 browser.findElements 同时存在时，必须按照下面的顺序写代码，browser.findElements定位不到任何元素。
```  
		WebDriver browser = new ChromeDriver();   --------------- 1
		browser.manage().window().maximize();    ---------------- 2
		browser.get("https://www.baidu.com");     --------------- 3
    List<WebElement> search_result = browser.findElements(By.xpath("//div/div/h3"));

```  
2 和 3 的顺序千万不能颠倒
