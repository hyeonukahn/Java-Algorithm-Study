import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BackWriteCalc_1935 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		Stack<Double> st = new Stack<>();
		Deque<Double> st = new ArrayDeque<>();
		
		int n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		char c;
		double calcTmp;
		int[] numArr = new int[n];
		for (int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
//			System.out.println(st.toString());
			switch(c) {
			case '+':
				calcTmp = st.pollLast();
				st.add(st.pollLast()+calcTmp);
				break;
			case '-':
				calcTmp = st.pollLast();
				st.add(st.pollLast()-calcTmp);
				break;
			case '*':
				calcTmp = st.pollLast();
				st.add(st.pollLast()*calcTmp);
				break;
			case '/':
				calcTmp = st.pollLast();
				st.add(st.pollLast()/calcTmp);
				break;
			default:
				st.add((double) numArr[c-'A']);
				break;
			}
		}
		
		
		System.out.printf("%.2f\n",st.pollLast());	
		
	}
}
