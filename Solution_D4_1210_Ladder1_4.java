import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1_4 {
	public static void main(String[] args) throws IOException {
		//입출력을 위한 BufferedReader, StringBuilder
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc_n = 10; // testcase 개수 = 10
		int n = 100; // 사다리 배열의 크기 100*100
		for (int tc = 1; tc <= tc_n; tc++) {
			br.readLine(); // 앞의 테스트 케이스 숫자를 읽어서 버림.
			
			ArrayList<Integer> line_list = new ArrayList<>();

			//ladder 행렬 선언 후 입력받기
			int[][] ladderArr = new int[n][n+2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					ladderArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//마지막 행에서 도착점 찾기
			int cur = 0;
			for (int i = 1; i <= n; i++) {
				if(ladderArr[n-1][i] == 2) {
					cur = line_list.size();
					line_list.add(i);
				} else if(ladderArr[n-1][i] == 1) {
					line_list.add(i);
				}
			}
			
			int moves = line_list.get(cur); //시작 열 지점
			
			for (int lines = n-1; lines > 0; lines--) {
				if(ladderArr[lines][moves-1] == 1) {
					moves = line_list.get(--cur);
				}
				else if(ladderArr[lines][moves+1] == 1) {
					moves = line_list.get(++cur);
				}
			}
			
			//출력을 위한 StringBuilder append
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			sb.append(--moves);
			sb.append("\n");
		}
		System.out.print(sb);
		br.close();	
	}

}
