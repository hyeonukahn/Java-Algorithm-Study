import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_BJ_15666_N_M_12 {
	static int[] selArr;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<int[]> selArrs = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] numArr = new int[n];
		selArr = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numArr);
		
		combination(0, 0, n, m, numArr);
		System.out.println(sb);
		
		br.close();
	}
	
	static void combination(int cnt, int start, int n, int m, int[] numArr) {
		if(cnt == m) {
			for (int i = 0; i < selArrs.size(); i++) {
				if(Arrays.equals(selArrs.get(i), selArr)) return;
			}
			selArrs.add(selArr.clone());
			for (int i = 0; i < m; i++) {
				sb.append(selArr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < n; i++) {
			selArr[cnt] = numArr[i];
			combination(cnt+1, i, n, m, numArr);
		}
	}

}
