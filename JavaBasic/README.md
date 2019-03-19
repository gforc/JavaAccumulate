
# 类型转换
```
String s = "123456789";
//(1) string 转 int		
int n = Integer.parseInt(s);


//(2)int 转 string
int n1 = Integer.valueOf(s).intValue();
int n2 = Integer.valueOf(s);

//(3) string 转 array
char[] cc = s.toCharArray();

/(4) array 转 string
char[] c4 = new char[]{'a','d','s','a','d','s'};
String str= new String(c4);

//(5) array 转 list
String[] strs = {"aa","bb","cc"};
//String数组转List
List<String> strsToList1= Arrays.asList(strs);

//(6) list 转 array
ArrayList<String> list = new ArrayList<String>();
list.add("1");
list.add("2");
list.add("3");
list.add("4");
list.add("5");
String[] array=list.toArray(new String[list.size()]);
```

# 不同数据类型的输出

## 数组输出

```
public class ArrayOutput {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};

		System.out.println("\n----------------------");
		//1\
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);
		}
		System.out.println("\n----------------------");
		//2\
		for(int item:array) {
			System.out.println(item);
		}
		System.out.println("\n----------------------");
		//3\
		System.out.println(Arrays.toString(array)); //直接输出array，输出结果为[1, 2, 3, 4, 5]

	}
}	
```

## ArrayList 输出

```
package com.neuedu.list;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
 
public class ListOutput {
/**
 * 五种输出ArrayList的方法
 * 1、for
 * 2、foreach
 * 3、toString
 * 4、Iteator
 * 5、ListIterator
 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		//1\
		for(int i = 0 ; i<list.size();i++){
			System.out.print(list.get(i));
		}
		System.out.println("\n----------------------");
		//2\
		for (Object object : list) {
			System.out.print(object);
		}
		System.out.println("\n----------------------");
		//3\
		System.out.println(list);//默认调用toString // 直接输出list，输出结果为[1, 2, 3, 4, 5]
		System.out.println("\n----------------------");
		//4、
		Iterator<String> i = list.iterator();
		while(i.hasNext()){
			System.out.print(i.next());
		}
		System.out.println("\n----------------------");
		//5.1\正着输出
		ListIterator<String> li = list.listIterator();
		while(li.hasNext()){
			System.out.print(li.next());
		}
		System.out.println("\n----------------------");
		//5.2\反向输出
		while(li.hasPrevious()){
			System.out.print(li.previous());
		}
		System.out.println("\n----------------------");
	}
}
```  


# 相似方法的区别
## HashSet，ArrayList，LinkedList
### 【HashSet】  
1. HashSet存储不能够存储相同的元素，元素是否相同的判断：重写元素的equals方法。equals方法和hashCode方法必须兼容，如：equals方法判断的是用户的名字name，那么hashCode的返回的hashcode必须是name。hashcode（）；  
2. HashSet存储是无序的，保存的顺序与添加的顺序是不一致的，它不是线性结构，而是散列结构，（通过散列表：散列单元指向链表）。因此，HashSet的查询效率相对比较高。  
3. HashSet不是线程安全的，不是线程同步的。这需要自己实现线程同步：Collections.synchronizedCollection()，方法实现。  

### 【ArrayList】  
1. 不是线程安全的，不是线程同步的。  
2.ArrayList是通过可变大小的数组实现的，允许null在内的所有元素。  
3.ArrayList中存放顺序和添加顺序是一致的。并且可重复元素。  
4.ArrayList适合通过位子来读取元素。  

### 【LinkedList】  
1.不是线程安全的，不是线程同步的。  
2.LinkedList是通过双向循环链表来实现的。  
3.存放顺序和添加顺序是一致的。可添加重复元素。  
4.适合链表头尾操作和插入指定位置元素的操作。  
ArrayList和LinkedList之间的数据传递可通过toArray（）方法。  

## HashMap，Hashtable，TreeMap
### 【HashMap】  
1.非线程安全，不是线程同步。  
2.添加顺序和保存的顺序是不一致的。  
3.必须重写key的equals方法和hashCode方法。  
4.HashMap的实际容量=容量*因子，默认为16*0.75=12.所以考虑到HashMap的添加的效率问题，根据实际情况来设计它的开始的默认的容量。
的操作方法根据api来查找。  
5.添加的值中是允许有null的值存在的。  

### 【Hashtable】  
1.是线程安全的，是线程同步的，在实现线程同步的时候是不需要手动来实现线程同步的。因此相对效率低。  
2.添加的顺序和保存的顺序是不一致的。  
3.添加的值中是不允许有null值存在的。  
 
### 【TreeMap】  
1.非线程安全，不是线程同步的。在必要的情况下必手动实现线程同步。  
2.在元素的添加，删除和定位映射中效率相对hashMap较低。但是在排序方面TreeMap比较实用。  
3.添加的值中允许有null值，但是在输出的时候会报空指针异常。  

# note
1. 两个char 做加减乘除后，结果问int
