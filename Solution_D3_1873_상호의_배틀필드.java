import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의_배틀필드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//입력과 출력을 위한 bufferedreader와 stringbuilder, string split를 위한 stringtokenizer 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc_n = Integer.parseInt(br.readLine()); // test case의 개수를 입력받는다
		int h, w; // 높이와 너비 선언
		char[][] battleMap; // field를 저장할 char배열
		int n; // 명령어 개수
		String moveset; // 탱크의 움직임 명령어
		String str; //임사 string
		
		int curX = 0, curY = 0; // 탱크의 현재 위치 선언
		char[] tankD = {'^','v','<','>'};
		
		
		for(int tc = 1; tc <= tc_n; tc++) { // 각 테스트 케이스 시작
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken()); //battle Map의 높이와 너비 가져오기
			
			battleMap = new char[h][];
			
			for (int i = 0; i < battleMap.length; i++) { // battleMap 입력받기
				str = br.readLine();
				for (int j = 0; j < tankD.length; j++) {
					if(str.contains(Character.toString(tankD[j]))) {
						curX = i;
						curY = str.indexOf(Character.toString(tankD[j]));
					}
				} // for j end
				battleMap[i] = str.toCharArray();
			} //for i end
			
			n = Integer.parseInt(br.readLine()); // 움직임 횟수를 입력받는다
			moveset = br.readLine(); // 움직일 명령어 스트링을 입력받는다.
			
			for (int i = 0; i < n; i++) { //명령어 하나씩 읽어들이기
				switch (moveset.charAt(i)) { // 명령어의 종류에 따라서 탱크의 행동을 결정
				case 'U':
					battleMap[curX][curY] = tankD[0];
					if(curX-1>=0 && battleMap[curX-1][curY] == '.') {
						battleMap[curX-1][curY] = tankD[0];
						battleMap[curX][curY] = '.';
						curX -= 1;
					}
					break; // case U end
				case 'D':
					battleMap[curX][curY] = tankD[1];
					if(curX+1<h && battleMap[curX+1][curY] == '.') {
						battleMap[curX+1][curY] = tankD[1];
						battleMap[curX][curY] = '.';
						curX += 1;
					}
					break; // case D end
				case 'L':
					battleMap[curX][curY] = tankD[2];
					if(curY-1>=0 && battleMap[curX][curY-1] == '.') {
						battleMap[curX][curY-1] = tankD[2];
						battleMap[curX][curY] = '.';
						curY -= 1;
					}
					break; // case L end
				case 'R':
					battleMap[curX][curY] = tankD[3];
					if(curY+1<w && battleMap[curX][curY+1] == '.') {
						battleMap[curX][curY+1] = tankD[3];
						battleMap[curX][curY] = '.';
						curY += 1;
					}
					break; // case R end
				case 'S':
					switch (battleMap[curX][curY]) {
					case '^':
						for (int j = curX; j >= 0 ; j--) {
							if(battleMap[j][curY] == '*') {
								battleMap[j][curY] = '.';
								break;
							}
							else if(battleMap[j][curY] == '#') {
								break;
							}
						} // for end
						break; // case ^ end 
					case 'v':
						for (int j = curX; j < h; j++) {
							if(battleMap[j][curY] == '*') {
								battleMap[j][curY] = '.';
								break;
							}
							else if(battleMap[j][curY] == '#') {
								break;
							}
						} // for end
						break; // case v end
					case '<':
						for (int j = curY; j >= 0 ; j--) {
							if(battleMap[curX][j] == '*') {
								battleMap[curX][j] = '.';
								break;
							}
							else if(battleMap[curX][j] == '#') {
								break;
							}
						} // for end
						break; // case < end
					case '>':
						for (int j = curY; j < w ; j++) {
							if(battleMap[curX][j] == '*') {
								battleMap[curX][j] = '.';
								break;
							}
							else if(battleMap[curX][j] == '#') {
								break;
							}
						} // for end
						break; // case > end

					default:
						break;
					} // shoot switch end
					break; // case S end
				default:
					break;
				} // switch 명령어 end
				
			} // 명령어 for end
			
			//출력을 위한 스트링 빌더 제작
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < battleMap.length; i++) {
				sb.append(battleMap[i]);
				sb.append("\n");
			} // for end
			
//			System.out.println(curX+" "+curY);
//			for (int i = 0; i < battleMap.length; i++) {
//				System.out.println(Arrays.toString(battleMap[i]));
//			}
//			System.out.println(moveset);
//			System.out.println(h+" "+w+" "+n);
		} // for tc end
		
		System.out.println(sb);
		br.close();		
	} // main end

} // class end
