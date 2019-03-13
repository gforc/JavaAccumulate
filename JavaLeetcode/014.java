package testjava;



public class S014 {

	public static String compaireStr(String str1,String str2) {
		int i;
		for( i=0 ; i< Integer.min(str1.length(), str2.length());i++) {
			if (str1.charAt(i) != str2.charAt(i)) {	
				break;
			}
		}
		
		if (i-1<0) {
			return "";
		}
		System.out.println(str1.substring(0, i));
		return str1.substring(0, i);
	}
	
	public String longestCommonPrefix(String[] strs) {
		int len=strs.length;
		if (len ==0) {
			return "";
		} else if (len ==1) {
			return strs[0];
		} else if (len == 2) {
			return compaireStr(strs[0],strs[1]);		
		}
		String result = compaireStr(strs[0],strs[1]); 
		for (int i=2;i<strs.length;i++) {
			result = compaireStr(strs[i],result);
			if (result == "") {
				return "";
			}
		}
		
		System.out.println(result);
		return result;
	}
	public static void main(String[] args) {
		String[] a= {"flower","flow","flight"};
		S014 aa=new S014();
		aa.longestCommonPrefix(a);
	}
}
