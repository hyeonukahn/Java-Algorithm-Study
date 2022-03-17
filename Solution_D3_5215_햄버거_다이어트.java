import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거_다이어트 {

	static int max;
//	static int[] numbers, numbers2;
	static int n, l;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] hamScore, hamCal;
		int sum_S, sum_C;
//		boolean b = true;

		int tc_n = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= tc_n; tc++) {
			max = 0;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			hamScore = new int[n];
			hamCal = new int[n];
//			numbers = new int[n];
//			numbers2 = new int[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				hamScore[i] = Integer.parseInt(st.nextToken());
				hamCal[i] = Integer.parseInt(st.nextToken());
			}
			sum_C = 0; sum_S=0;
			int idx = 0;
			find(hamScore, hamCal, idx, sum_C, sum_S);
			
			

//			for (int i = 0; i <= n; i++) {
//				combination(0, 0, i, n, l, hamScore, hamCal);
//			}

			sb.append("#" + tc + " " + max + "\n");
		}

		System.out.println(sb);

		br.close();
	}
	
	public static void find(int[] hamScore, int[] hamCal, int idx, int sum_C, int sum_S) {
		if(sum_C > l) return;
		
		if(sum_S > max) max = sum_S;
		
		if(idx == n) return;
		
		find(hamScore, hamCal, idx+1, sum_C, sum_S);
		find(hamScore, hamCal, idx+1, sum_C+hamCal[idx], sum_S+hamScore[idx]);
		
	}
	
	
	
//	public static void combination(int cnt, int start, int R, int N, int l, int[] input1, int[] input2) {
//		
//		if(cnt == R) {
//			return;
//		}
//		
//		for (int i = start; i < N; i++) {
//			numbers[cnt] = input1[i];
//			numbers2[cnt] = input2[i];
//			
//			int sum = 0;
//			int sum2 = 0;
//			
//			for (int j = 0; j<=cnt; j++) {
//				sum += numbers[j];
//			}
//			for (int j = 0; j<=cnt; j++) {
//				sum2 += numbers2[j];
//			}
//			
//			if(sum2<l && sum > max) {
//				max = sum;
//			}
//			combination(cnt+1, i+1, R, N, l, input1, input2);
//		}
//		
//	}

//	public static void combination(int cnt, int start, int sum_S, int sum_C, int n, int l, int[] hamScore,
//			int[] hamCal) {
//
//		if (cnt == n) {
////			System.out.println(max);
//			return;
//		}
////		if(sum_C <= l) {
//		for (int i = start; i < n; i++) {
//			sum_S += hamScore[i];
//			sum_C += hamCal[i];
//			System.out.println(sum_S + " " + sum_C);
//			if(sum_S > max && sum_C <= l) {
//				max = sum_S;
//			}
//			combination(cnt + 1, i + 1, sum_S, sum_C, n, l, hamScore, hamCal);
//		}
////		}
////		else {
////			if(sum_S > max) {
////				sum_S = max;
////			}
////		}
//
//	}

}
