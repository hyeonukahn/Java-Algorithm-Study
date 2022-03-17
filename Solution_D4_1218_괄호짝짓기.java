import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_D4_1218_괄호짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
//		Deque<Character> parathStack = new ArrayDeque<Character>();
		
		int tc_n = 10;
		int n;
//		char ch;
		int ans;
		String parathStr;
		for (int tc = 1; tc <= tc_n; tc++) {
//			parathStack = new ArrayDeque<Character>();
//			parathStack.clear();
//			ans = 1;
			n = Integer.parseInt(br.readLine());
			parathStr = br.readLine();			
			
			ans = chkP(parathStr, n);
			
//			for (int i = 0; i < n; i++) {
//				ch = parathStr.charAt(i);
//				
//				switch (ch) {
//				case '(':
//				case '[':
//				case '{':
//				case '<':
//					parathStack.add(ch);
//					break;
//					
//				case ')':
//					if(parathStack.isEmpty() || parathStack.peekLast() != '(') {
//						ans = 0;
//					}
//					else {
//						parathStack.pollLast();
//					}
//					break;
//				case '>':
//					if(parathStack.isEmpty() || parathStack.peekLast() != '<') {
//						ans = 0;
//					}
//					else {
//						parathStack.pollLast();
//					}
//					break;
//				case '}':
//					if(parathStack.isEmpty() || parathStack.peekLast() != '{') {
//						ans = 0;
//					}
//					else {
//						parathStack.pollLast();
//					}
//					break;
//				case ']':
//					if(parathStack.isEmpty() || parathStack.peekLast() != '[') {
//						ans = 0;
//					}
//					else {
//						parathStack.pollLast();
//					}
//					break;
//
//				default:
//					break;
//				}
//				
//				if(ans == 0) break;
//				
//			}
//			if(parathStack.isEmpty()) ans = 1;
//			else ans = 0;
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
		
		br.close();
	}
	
	public static int chkP(String str, int n) {
		Deque<Character> parathStack = new ArrayDeque<Character>();
		char ch;
		for (int i = 0; i < n; i++) {
			ch = str.charAt(i);
			
			switch (ch) {
			case '(':
			case '[':
			case '{':
			case '<':
				parathStack.add(ch);
				break;
				
			case ')':
				if(parathStack.isEmpty() || parathStack.peekLast() != '(') {
					return 0;
				}
				else {
					parathStack.pollLast();
				}
				break;
			case '>':
				if(parathStack.isEmpty() || parathStack.peekLast() != '<') {
					return 0;
				}
				else {
					parathStack.pollLast();
				}
				break;
			case '}':
				if(parathStack.isEmpty() || parathStack.peekLast() != '{') {
					return 0;
				}
				else {
					parathStack.pollLast();
				}
				break;
			case ']':
				if(parathStack.isEmpty() || parathStack.peekLast() != '[') {
					return 0;
				}
				else {
					parathStack.pollLast();
				}
				break;
			}
		}
		
		if(parathStack.isEmpty()) return 1;
		else return 0;
	}
}
