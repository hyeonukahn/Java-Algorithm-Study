import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_BJ_1918_후위표기식_2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String calcstr = br.readLine();
		ArrayDeque<Character> calStack = new ArrayDeque<>();
		ArrayDeque<Character> endStack = new ArrayDeque<>();
		
		int len = calcstr.length();
		
		for (int i = 0; i < len; i++) {
			char ch = calcstr.charAt(i);
			switch (ch) {
			case '+':
			case '-':
				while(!calStack.isEmpty() && calStack.peekLast() != '(') {
					endStack.add(calStack.pollLast());
					
				}
				calStack.add(ch);
				break;
			case '*':
			case '/':
				while(!calStack.isEmpty() && calStack.peekLast() != '(' && calStack.peekLast() != '+' && calStack.peekLast() != '-') {
					endStack.add(calStack.pollLast());
				}
				calStack.add(ch);
				break;
			case '(':
				calStack.add(ch);
				break;
			case ')':
				char c;
				while((c = calStack.pollLast()) !='(') {
					endStack.add(c);
				}
				break;
			default:
				endStack.add(ch);
				break;
			}
		}
		
		while(!calStack.isEmpty()) {
			endStack.add(calStack.pollLast());
		}
		
		while(!endStack.isEmpty()) {
			sb.append(endStack.poll());
		}
		System.out.println(sb);
		br.close();		
	}

}
