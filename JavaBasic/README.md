
# 类型转换
```
String s = "123456789";
//(1)Integer.parseInt(str)		
int n = Integer.parseInt(s);


//(2)Integer.valueOf(str).intValue()
int n1 = Integer.valueOf(s).intValue();
int n2 = Integer.valueOf(s);


char[] cc = s.toCharArray();
```

# 不同数据类型的输出

# 数组输出


```
    String s = "123456789";
		char[] cc = s.toCharArray();
		System.out.println(cc[1]);
		System.out.println("!!!!!!:" + Arrays.toString(cc));
```
