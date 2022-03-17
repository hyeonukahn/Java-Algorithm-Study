import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형_방2 {
	public static void main(String[] args) throws IOException {
		//BufferedReader를 활용하여 입력, StringBuilder를 사용하여 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc_n = Integer.parseInt(br.readLine()); //테스트 케이스 개수 입력
		int n; // 행렬의 크기
		int cnt; // 각 방에서 움직일 수 있는 횟수
		int[][] numArr; // 입력된 행렬을 저장하기 위한 2차원 배열
		int[][] ansArr; // 각 방에서 움직일 수 있는 횟수를 저장하기 위한 2차원 배열

		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { -1, 0, 1, 0 }; // 2차원 배열 4방 탐색

		int max, minnum; // 최대 움직일 수 있는 방과 그 방의 번호(가장 작은 숫자)
		boolean b; // flag

		for (int tc = 1; tc <= tc_n; tc++) {
			max = 0; // 최대값 초기화
			n = Integer.parseInt(br.readLine()); // 행렬의 크기 입력
			minnum = n * n + 1; //최대 입력 가능한 숫자는 n*n
			
			numArr = new int[n][n];
			ansArr = new int[n][n]; // 배열 초기화
			
			for (int i = 0; i < n; i++) { // 2차원 배열 입력
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					numArr[i][j] = Integer.parseInt(st.nextToken());
				} // for i end
			} // for j end(입력)

			int x, y; // 위치를 저장할 x, y 좌표
			for (int i = 0; i < n; i++) { // 배열의 행 탐색
				for (int j = 0; j < n; j++) { // 배열의 열 탐색
					b = true;
					cnt = 1; //flag와 움직일수 있는 방 횟수 초기화
					x = i;
					y = j; //현재 좌표를 저장
					while (b) {
						for (int k = 0; k < dx.length; k++) { // 사방 탐색
							//배열 내인 경우 & 움직일 방이 정확히 숫자가 +1인경우 
							if (0 <= x + dx[k] && x + dx[k] < n && 0 <= y + dy[k] && y + dy[k] < n
									&& numArr[x][y] + 1 == numArr[x + dx[k]][y + dy[k]]) { 
								
								//만약 ansArr가 움직일 방의 cnt를 이미 저장되었다면 그 값을 더해주는것으로 나머지 움직임 파악 가능
								if (ansArr[x + dx[k]][y + dy[k]] != 0) {
									cnt += ansArr[x + dx[k]][y + dy[k]];
									b = false;
									break;
								} //if end
								//움직인 횟수를 더해주고 좌표를 다음 방으로 움직인다.
								cnt++;
								x = x + dx[k];
								y = y + dy[k];
								b = true;
								break;
							} else { //for문이 끝날때까지 코드가 계속 else에 도달했다는 뜻은 4방 탐색 후 움직일 수 있는 방이 없다는 것이다. 
								b = false;
							} //if-else end
						} // for k end (4방 탐색)
					} // while end (더 이상 움직이지 못한 경우)
					
					ansArr[i][j] = cnt; //cnt값을 저장.
					
					// 현재 위치에서 움직인 값(cnt)이 지금까지의 최댓값보다 큰 경우 해당 방 번호와 cnt를 저장
					if (cnt > max) { 
						max = cnt;
						minnum = numArr[i][j];
					} else if (cnt == max) { //cnt가 최댓값과 같은 경우 해당 방 번호와 저장된 방 번호를 비교하여 저장.
						if (minnum > numArr[i][j]) {
							minnum = numArr[i][j];
						}
					} // if-else if end 최대값 조건 함수 완료
				} // for j end
			} // for i end (배열 탐색 완료)

			//출력을 위한 값 append
			sb.append("#" + tc + " " + minnum + " " + max + "\n");
		} // for tc end (testcase 완료)
		//출력
		System.out.println(sb);
		br.close();
	} // main end
} // class end
