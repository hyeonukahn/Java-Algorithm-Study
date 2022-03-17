import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_9229_한빈이와_Spot_Mart {
	public static void main(String[] args) throws IOException {
		//입출력을 위한 BufferedReader와 StringBuilder, split를 위한 StringTokenizer
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n, m; //과자의 개수, 최대 들수 있는 중량
		int max; // 들수있는 최댓값 저장
		int f, s; // 첫번째 과자, 두번째 과자
		
		int[] snackArr; //과자의 무게 배열
//		List<Integer> snackArr = new ArrayList<>();
		
		int tc_n = Integer.parseInt(br.readLine()); // 테스트케이스 개수
		
		for (int tc = 1; tc <= tc_n; tc++) {
			max = -1; //최댓값 -1로 초기화(불가능한 경우 -1로 출력)
			st = new StringTokenizer(br.readLine());
			
			//n, m값 입력
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			//과자의 무게 배열 입력
			st = new StringTokenizer(br.readLine());
			snackArr = new int[n];
			for (int i = 0; i < n; i++) {
				snackArr[i] = Integer.parseInt(st.nextToken());
			}
//			for (int i = 0; i < n; i++) {
//				snackArr.add(Integer.parseInt(st.nextToken()));
//			}
			
			//과자 2개를 선택하여 제한 무게를 넘지 않는 최대 무게를 구한다.
			for (int i = 0; i < n; i++) {
				f = snackArr[i];
				for (int j = i+1; j < n; j++) {
					s = snackArr[j];
					if(f+s<=m && max < f+s) {
						max = f+s;
					}
				}
			}
			
//			snackArr.sort(null);
//			for (int i = 0; i < n; i++) {
//				f = snackArr.get(i);
//				if(f>m/2 || max == m) break;
//				for (int j = i+1; j < n; j++) {
//					s = snackArr.get(j);
//					if(f+s<=m && max < f+s) {
//						max = f+s;
//					}
//				}
//			}
//			
//			snackArr.clear();
			
			//출력을 위한 StringBuilder
			sb.append("#"+tc+" "+max);
			sb.append("\n");
		}
		//출력
		System.out.println(sb);
		br.close();
		
	}

}
