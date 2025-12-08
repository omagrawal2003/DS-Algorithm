
import java.util.Stack;

public class Braces2{
	public static boolean isBalance(String str){
		Stack<Character> sc=new Stack<>();
		for(int i=0; i<str.length(); i++){
			char ch=str.charAt(i);
			if(ch == '{'){
			sc.push(ch);
			}
			else if(ch=='}') {
				if(sc.isEmpty()) return false;
			sc.pop();
			}
		}
	return sc.isEmpty();
		
}

public static void main(String[]args){
	System.out.println(isBalance("{}{}"));
	System.out.println(isBalance("{}{{"));
	System.out.println(isBalance("{}{{}}"));
}
		}

