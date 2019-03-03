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

## Xpath 模糊定位
  
f、部分属性值匹配（和CSS选择器类似）
```  
WebElement ele = driver.findElement(By.xpath("//input[start-with(@id,'fuck')]"));//匹配id以fuck开头的元素，id='fuckyou'
WebElement ele = driver.findElement(By.xpath("//input[ends-with(@id,'fuck')]"));//匹配id以fuck结尾的元素，id='youfuck'
WebElement ele = driver.findElement(By.xpath("//input[contains(@id,'fuck')]"));//匹配id中含有fuck的元素，id='youfuckyou'
```  
g、使用任意值来匹配属性及元素
```
WebElement ele = driver.findElement(By.xpath("//input[@*='fuck']"));//匹配所有input元素中含有属性的值为fuck的元素

```  

## Xpath 添加变量
```
pageNum -=1;
browser.findElement(By.xpath("//*[@id=\"page\"]/a["+ pageNum +"]/span[2]")).click();
```

## 隐藏空间定位
待添加
