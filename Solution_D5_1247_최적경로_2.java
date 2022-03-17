import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로_2 {
	static int ans; // 답 저장 공간
	static boolean[] isSelected; //선택된 사람인지 확인
	static int[][] selectedP; //선택된 사람 배열
	static int comx, comy, homex, homey; //회사와 집 좌표
	
	public static void main(String[] args) throws IOException {
		//입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//테스트케이스 개수
		int tc_n = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= tc_n; tc++) {
			//답은 최소를 찾는것이므로 가장 큰값 초기화
			ans = Integer.MAX_VALUE;
			int n = Integer.parseInt(br.readLine());
			int[][] customor = new int[n][2];
			isSelected = new boolean[n];
			selectedP = new int[n][2];
			
			st = new StringTokenizer(br.readLine());
			comx = Integer.parseInt(st.nextToken());
			comy = Integer.parseInt(st.nextToken());
			homex = Integer.parseInt(st.nextToken());
			homey = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < n; i++) {
				customor[i][0] = Integer.parseInt(st.nextToken());
				customor[i][1] = Integer.parseInt(st.nextToken());
			} //입력 완료
			
			//순열로 모든 경우의 수 탐색, 고객수 만큼(nPn)
			permuAndFind(0, 0, n, customor);
			
			//출력하기 위한 append
			sb.append("#"+tc).append(" ");
			sb.append(ans+"\n");
		}
		//출력
		System.out.println(sb);
		br.close();
	}
	
	static void permuAndFind(int cnt, int partsum, int n, int[][] customor) {
		int tmp=0;
		//모두 고른 경우
		if(cnt == n) {
			int sum = 0;
			//회사에서 첫번째 고객까지의 거리
			sum += Math.abs(comx-selectedP[0][0])+Math.abs(comy-selectedP[0][1]);
			//고객과 고객 사이 거리
			for (int i = 0; i < n-1; i++) {
				sum += Math.abs(selectedP[i][0]-selectedP[i+1][0])+Math.abs(selectedP[i][1]-selectedP[i+1][1]);
			}
			//마지막 고객과 집 사이의 거리
			sum += Math.abs(homex-selectedP[n-1][0])+Math.abs(homey-selectedP[n-1][1]);
			
			//최소인지 비교
			if(sum < ans) {
				ans = sum;
			}
			return;
		}
		
		//순열 코드, 고른 사람이면 통과, 고른 후 다음 사람 고르기 위한 재귀
		for (int i = 0; i < n; i++) {
			if(isSelected[i]) continue;
			if(cnt>0) {
				tmp = Math.abs(selectedP[cnt][0]-selectedP[cnt-1][0])+Math.abs(selectedP[cnt][1]-selectedP[cnt-1][1]);
			}
			partsum += tmp;
			if(partsum>ans) return;
			selectedP[cnt][0] = customor[i][0];
			selectedP[cnt][1] = customor[i][1];
			isSelected[i] = true;
			permuAndFind(cnt+1, partsum, n, customor);
			partsum -= tmp;
			isSelected[i] = false;			
		}
	}
}
