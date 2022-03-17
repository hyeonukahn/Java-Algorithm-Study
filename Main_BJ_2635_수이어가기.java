import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_2635_수이어가기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
//		int[] ansArr = new int[n+1];
		ArrayList<Integer> numList = new ArrayList<>();
		int maxcnt = 0;
		int maxnum = 0;
		
		for (int i = 1; i <= n; i++) {
			int cnt = 2;
			int first = n;
			int second = i;
			while(first - second >= 0) {
				int x = first - second;
				cnt++;
				first = second;
				second = x;
			}
			if(maxcnt < cnt) {
				maxcnt = cnt;
				maxnum = i;
			}
		}
		
		int first = n;
		int second = maxnum;
		numList.add(first);
		numList.add(second);
		while(first - second >= 0) {
			int x = first - second;
			first = second;
			second = x;
			numList.add(second);
		}
		
//		System.out.println(numList.size());
		sb.append(maxcnt+"\n");
		for (Integer i : numList) {
//			System.out.print(i+" ");
			sb.append(i+" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
		br.close();
	}

}
