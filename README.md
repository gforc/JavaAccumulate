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

## Xpath 添加变量
```  
# encoding:utf-8
from selenium import webdriver
import time
driver = webdriver.Firefox()
driver.get("http://www.baidu.com")

# 下面这一段使用的是python中变量的方法，简单吧！
def enter(var):
    driver.find_element_by_xpath("//input[@id = '%s']" % var).send_keys("haha")
enter('kw')
time.sleep(3)

#下面这一段使用的好像是一种固定格式，在JS中有看到
def enter1(var1):
    driver.find_element_by_xpath("//input[@id = '" + var1 + "']").click()
enter1('su')
time.sleep(3)
driver.quit()
```  
## 隐藏空间定位
待添加
