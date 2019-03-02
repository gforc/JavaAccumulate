# maximize() and findElements（）
browser.manage().window().maximize() 和 browser.findElements 同时存在时，必须按照下面的顺序写代码，browser.findElements定位不到任何元素。
```  
WebDriver browser = new ChromeDriver();   --------------- 1
browser.manage().window().maximize();    ---------------- 2
browser.get("https://www.baidu.com");     --------------- 3
List<WebElement> search_result = browser.findElements(By.xpath("//div/div/h3"));

```  
2 和 3 的顺序千万不能颠倒


# 多窗口切换
## 两个窗口之间切换

```
String search_handle = driver.getWindowHandle();//获得当前窗口
Set<String> handles = driver.getWindowHandles();//获得所有窗口句柄
for(String handle : handles){  //判断是否为注册窗口， 并操作注册窗口上的元素
  if (handle.equals(search_handle)==false){ 
    driver.switchTo().window(handle); //切换到注册页面

```
## 多个窗口直接切换
必须要把set 转化成 list
```
Set<String> winHandels = driver.getWindowHandles(); // 得到当前窗口的set集合
List<String> it = new ArrayList<String>(winHandels); // 将set集合存入list对象
driver.switchTo().window(it.get(3)); // 利用it.get(n)切换到任意窗口
Thread.sleep(1000);
String url=driver.getCurrentUrl(); //获取新窗口的url
System.out.println(url);
driver.switchTo().window(it.get(0)); // 返回至原页面


```
## 隐藏空间定位
待添加
