import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_10817_세_수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> numQ = new PriorityQueue<>();
		while(st.hasMoreTokens()) {
			numQ.add(Integer.parseInt(st.nextToken()));
		}
		numQ.poll();
		System.out.println(numQ.poll());
		br.close();
	}
}
