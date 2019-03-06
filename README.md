# selenium报错，找不到元素
1. 定位中填写的keyword or path 有错
2. 没有等待足够时间（添加等待时间，或是加长等待时间）
3. 元素设置为不可见（需要利用java script修改value见下文）


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

# Xpath 模糊定位
  
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

# Xpath 添加变量
```
pageNum -=1;
browser.findElement(By.xpath("//*[@id=\"page\"]/a["+ pageNum +"]/span[2]")).click();
```

# 下拉浏览器滚动条

## 利用键盘事件实现
```
WebElement webElement = webDriver.findElement(By.cssSelector("body"));
                webElement.click(); // 有的时候必须点击一下，下拉才能生效（有的网站是这样，原因未找到）
#小幅度下拉
                webElement.sendKeys(Keys.PAGE_DOWN);
#或者直接下拉到底
              webElement.sendKeys(Keys.END);
```

## 利用javaScript实现

```
#下拉到页面底部
((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
#上拉到页面顶端
((JavascriptExecutor) webDriver).executeScript("window.scrollTo(document.body.scrollHeight,0)");

```
或
```
#下拉到页面1000位置
((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0,1000)");
#上拉到页面顶端 0,0位置
((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0,0)");
```  
例子
```
public class SeleniumTest {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "D:/tool/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://m.weibo.cn/");
        Thread.sleep(1000);

        for (int i = 0; i < 10; i++) {
            System.out.println("sleep 1s");
            Thread.sleep(1000);
            ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0,"+(i * 500)+")");
        }
    }
}
```

# 隐藏控件定位
```
WebDriver browser = new ChromeDriver();
browser.get(url);

String js = "document.getElementById(\"q1_2\").style.display=\"block\"";
((JavascriptExecutor) browser).executeScript(js);    
```
### 说明：
1. 当浏览器载入 HTML 文档, 它就会成为 Document 对象。
  Document 对象是 HTML 文档的根节点。
  Document 对象使我们可以从脚本中对 HTML 页面中的所有元素进行访问。
2. document有多种获取网页元素的办法：
  document.getElementsByClassName()	返回文档中所有指定类名的元素集合，作为 NodeList 对象。
  document.getElementById()	返回对拥有指定 id 的第一个对象的引用。
  document.getElementsByName()	返回带有指定名称的对象集合。
  document.getElementsByTagName()	返回带有指定标签名的对象集合。
  document.querySelector()	返回文档中匹配指定的CSS选择器的第一元素
  document.querySelectorAll()	document.querySelectorAll() 是 HTML5中引入的新方法，返回文档中匹配的CSS选择器的所有元素节点列表
