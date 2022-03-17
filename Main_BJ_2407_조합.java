import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_2407_조합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		BigInteger answer = new BigInteger("1");
		
		long ans = 1;
		if(m>n/2) {
			m = n-m;
		}
		
//		Queue<Integer> divideQue = new ArrayDeque<>();
//		for (int i = 1; i <= m; i++) {
//			divideQue.add(i);
//		}
		
		int divnum=0;
		int size, cnt;
		for (int i = n; i > n-m ; i--) {
			BigInteger bI = new BigInteger(""+i);
			answer = answer.multiply(bI);
//			ans *= i;
//			ans.multiply();
			
//			cnt = 0;
//			size = divideQue.size();
//			while(!divideQue.isEmpty() && cnt<size) {
//				if (divideQue.isEmpty()) {
//					break;
//				}
//				divnum = divideQue.poll();
//				if(ans%divnum == 0) {
//					ans /= divnum;
//				} else {
//					divideQue.offer(divnum);
//				}
//				cnt++;
//			}

		}
		for (int i = 1; i <= m; i++) {
			BigInteger bI = new BigInteger(""+i);
			answer = answer.divide(bI);
		}
		
		System.out.println(answer);
		
		br.close();
	}

}
