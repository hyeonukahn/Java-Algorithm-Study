import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
//import java.util.Scanner;
import java.util.Stack;

public class Paranth_9012 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(bf.readLine());
		String str;
//		Stack<Character> chStack = new Stack<>();
		Deque<Character> chStack = new ArrayDeque<>();
		char ch;
		boolean chk = true;
		
		for (int i = 0; i < n; i++) {
			chk = true;
//			str = sc.next();
			str = bf.readLine();
			for (int j = 0; j < str.length(); j++) {
				ch = str.charAt(j);
				if(ch == '(') {
					chStack.add(ch);
				}
				else {
					if(chStack.isEmpty()) {
						chk = false;
						break;
					}
					else if(chStack.peekLast() != '(') {
						chk = false;
						break;
					}
					else {
						chStack.pollLast();
					}
				}
			}
			if(chk && chStack.isEmpty()) {
				sb.append("YES\n");
//				System.out.println("YES");
			}
			else {
				chStack.clear();
				sb.append("NO\n");
//				System.out.println("NO");
			}
		}
		System.out.println(sb);
//		sc.close();
		bf.close();
	}
}
