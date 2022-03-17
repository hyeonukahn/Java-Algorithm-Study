import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	
	static int[] selectedN; //재료를 선택하기 위한 배열
	static int diff; //차이값
	static int[][] sArr; //음식 배열을 담기 위한 값
	public static void main(String[] args) throws IOException {
		//입력 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc_n = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= tc_n; tc++) {
			//입력
			int n = Integer.parseInt(br.readLine());
			sArr = new int[n][n];
			diff = Integer.MAX_VALUE;
			selectedN = new int[n/2];
			int[] numArr = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					sArr[i][j] = Integer.parseInt(st.nextToken());
				}
				numArr[i] = i;
			}
			//입력 끝
			
			//모든 가짓수 계산
			combi(0, 0, n, numArr);
			
			//출력append
			sb.append("#"+tc);
			sb.append(" "+diff);
			sb.append("\n");
		}
		System.out.println(sb);
		//출력 완료
		br.close();
	}
	
/*
1
4
0 5 3 8
4 0 4 1
2 5 0 3
7 2 3 0
 */
	
	static void combi(int startP, int cnt, int n, int[] numArr) {
		if(cnt == n/2) { //절반만큼 선택을 완료하였을때
			int[] notSelectedN = new int[n/2]; //선택되지 않은 요소들을 담기
			int cur = 0, ncur = 0;
			for (int i = 0; i < n; i++) {
				if(cur < n/2 && selectedN[cur] == i) {
					cur++;
				} else {
					notSelectedN[ncur] = i;
					ncur++;
				}
			}
			
			//합을 담기 위한 변수
			int selsum = 0; int notselsum = 0;
			
			//선택된 것들의 합 계산
			for (int i : selectedN) {
				for (int j : selectedN) {
					selsum += sArr[i][j];
				}
			}
			//선택되지 않은 것들의 합 계산
			for (int i : notSelectedN) {
				for (int j : notSelectedN) {
					notselsum += sArr[i][j];
				}
			}
			
			//결과 저장
			int res = Math.abs(selsum-notselsum);
			if(res < diff) diff = res;
			return;
		}
		
		//조합 선택
		for (int i = startP; i < n; i++) {
			selectedN[cnt] = numArr[i];
			combi(i+1, cnt+1, n, numArr);
		}
	}
}
