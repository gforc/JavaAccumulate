
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
