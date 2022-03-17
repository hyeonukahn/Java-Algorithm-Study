import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Deque_10866 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Deque<Integer> intQueue = new LinkedList<>();
		Deque<Integer> intQueue = new ArrayDeque<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(bf.readLine());
		String comIn;
		String com;
		int numIn;
		StringBuilder out = new StringBuilder();
		int size = 0;

		for (int i = 0; i < n; i++) {
			comIn = bf.readLine();
			st = new StringTokenizer(comIn);
			com = st.nextToken();
			switch (com) {
			case "push_front":
				size++;
				numIn = Integer.parseInt(st.nextToken());
				intQueue.addFirst(numIn);
				break;
			case "push_back":
				size++;
				numIn = Integer.parseInt(st.nextToken());
				intQueue.add(numIn);
				break;
			case "pop_front":
				if(size == 0) {
					out.append("-1");
				}
				else {
					out.append(intQueue.poll());
					size--;
				}
				out.append("\n");
				break;
			case "pop_back":
				if(size == 0) {
					out.append("-1");
				}
				else {
					out.append(intQueue.pollLast());
					size--;
				}
				out.append("\n");
				break;
			case "size":
				out.append(size);
				out.append("\n");
				break;
			case "empty":
				if(size == 0) {
					out.append(1);
				}
				else {
					out.append(0);
				}
				out.append("\n");
				break;
			case "front":
				if(size == 0) {
					out.append("-1");
				}
				else {
					out.append(intQueue.peek());
				}
				out.append("\n");
				break;
			case "back":
				if(size == 0) {
					out.append("-1");
				}
				else {
					out.append(intQueue.getLast());
				}
				out.append("\n");
				break;
			}
		}
		System.out.println(out);

		bf.close();
	}
}
