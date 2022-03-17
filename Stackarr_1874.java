import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Stackarr_1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		Stack<Integer> st = new Stack<>();
		Deque<Integer> st = new ArrayDeque<>();
		
		int n = Integer.parseInt(br.readLine());
		int[] numArr = new int[n];
		int cur = 0;
		int stNum = 1;
		
		for (int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		
		while(stNum<=n+1) {
			if(!(st.isEmpty()) && st.peekLast() == numArr[cur]) {
				sb.append("-\n");
//				st.pop();
				st.pollLast();
				cur++;
				continue;
			}
			st.addLast(stNum);
			sb.append("+\n");
			stNum++;
		}
//		while(stNum<=n+1) {
//			if(!(st.isEmpty()) && st.peek() == numArr[cur]) {
//				sb.append("-\n");
//				st.pop();
//				cur++;
//				continue;
//			}
//			st.add(stNum);
//			sb.append("+\n");
//			stNum++;
//		}
		if(cur != numArr.length) {
			System.out.println("NO");
		}
		else {
			sb.setLength(sb.length()-2);
			System.out.println(sb);
		}
		
	}
}


