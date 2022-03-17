import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_BJ_2605_줄세우기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] picknumArr = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			picknumArr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		List<Integer> lineArr = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			lineArr.add(picknumArr[i], i);
		}
		Collections.reverse(lineArr);
		
		for (int i : lineArr) {
			sb.append(i+" ");
		}
		
		System.out.println(sb);
		
		br.close();
	}

}
