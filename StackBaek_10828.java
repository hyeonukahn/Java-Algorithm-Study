import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackBaek_10828 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Stack<Integer> intStack = new Stack<>();
//		Scanner sc = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		int n = sc.nextInt();
		int n = Integer.parseInt(bf.readLine());
		String comIn;
		String com;
		int numIn;
		StringBuilder out = new StringBuilder();
		int size = 0;

		for (int i = 0; i < n; i++) {
//			com = sc.next();
			comIn = bf.readLine();
			st = new StringTokenizer(comIn);
			com = st.nextToken();
			switch (com) {
			case "push":
				size++;
//				numIn = sc.nextInt();
				numIn = Integer.parseInt(st.nextToken());
				intStack.add(numIn);
				break;
			case "pop":
//				if(intStack.isEmpty()) { //
				if(size == 0) {
					out.append("-1");
//					System.out.println(-1);
				}
				else {
					out.append(intStack.pop());
					size--;
//					System.out.println(intStack.pop());					
				}
				out.append("\n");
				break;
			case "size":
				out.append(size);
				out.append("\n");
//				System.out.println(intStack.size());
				break;
			case "empty":
//				if(intStack.isEmpty()) {
				if(size == 0) {
					out.append(1);
//					System.out.println(1);
				}
				else {
					out.append(0);
//					System.out.println(0);					
				}
				out.append("\n");
				break;
			case "top":
//				if(intStack.isEmpty()) {
				if(size == 0) {
					out.append("-1");
//					System.out.println(-1);
				}
				else {
					out.append(intStack.peek());
//					System.out.println(intStack.peek());
				}
				out.append("\n");
				break;
			}
		}
		System.out.println(out);

//		sc.close();
		bf.close();
	}

}
