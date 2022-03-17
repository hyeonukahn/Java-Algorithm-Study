import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_D4_7465_창용마을무리개수 {
	
	static int[] pNum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc_n = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= tc_n; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			pNum = new int[n+1];
			for (int i = 1; i <= n; i++) {
				pNum[i] = i;
			}
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			for (int i = 1; i <= n; i++) {
				findSet(i);
			}
			Set<Integer> setNum = new HashSet<>();
			for (int i = 1; i <= n; i++) {
				setNum.add(pNum[i]);
			}
			
			sb.append("#"+tc);
			sb.append(" "+setNum.size());
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	
	static int findSet(int a) {
		if(pNum[a] == a) return a;
		return pNum[a] = findSet(pNum[a]);
	}
	
	static void union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		pNum[bRoot] = aRoot;
	}
	
}
