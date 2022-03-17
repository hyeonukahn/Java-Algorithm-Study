import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_D4_1223_계산기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc_n = 10;
		String calcStr;
		char ch;
		int sum;
		List<Character> numList = new ArrayList<>();
		Stack<Character> calcStack = new Stack<>();
		Stack<Integer> sumStack = new Stack<>();
		for (int tc = 1; tc <= tc_n; tc++) {
			int n = Integer.parseInt(br.readLine());
			sum = 0;
			calcStr = br.readLine();
			for (int i = 0; i < n; i++) {
				ch = calcStr.charAt(i);
				if(ch == '+') {
					if (calcStack.isEmpty()) {
						calcStack.add(ch);
					} else {
						while(!calcStack.isEmpty() && calcStack.peek() != '(') {
							numList.add(calcStack.pop());
						}
						calcStack.add(ch);
					}

				} else if(ch == '*'){
					if (calcStack.isEmpty()) {
						calcStack.add(ch);
					} else {
						while(!calcStack.isEmpty() && calcStack.peek() != '+' && calcStack.peek() != '(') {
							numList.add(calcStack.pop());
						}
						calcStack.add(ch);
					}
				} else if(ch == '(') {
					calcStack.add(ch);
				} else if(ch == ')') {
					while(!calcStack.isEmpty() && calcStack.peek() != '(') {
						numList.add(calcStack.pop());
					}
					calcStack.pop();
				}
				else {
					numList.add(ch);
				}
			}
			
			while(!calcStack.isEmpty()) {
				numList.add(calcStack.pop());
			}
//			System.out.println(numList);
//			System.out.println(numList.size());
			
			for (int c : numList) {
				int tmp;
				if(c == '*') {
					tmp = sumStack.pop();
					sumStack.add((sumStack.pop()) * tmp);
				} else if(c == '+') {
					tmp = sumStack.pop();
					sumStack.add((sumStack.pop()) + tmp);
				} else {
					sumStack.add(c-'0');
				}
			}
			
			sb.append("#"+tc+" ");
			sb.append(sumStack.pop());
			sb.append("\n");
			numList.clear();
			calcStack.clear();
			sumStack.clear();
		}
		System.out.println(sb);
		br.close();
	}
}
