import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_6808_규영_안영_카드게임2 {
	static boolean[] isSelected = new boolean[9];
	static int[] selectedCards = new int[9];
	static int[] guCard;
	static int wincnt, losecnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc_n = Integer.parseInt(br.readLine());
		
		int[] inCard = new int[9];
		
		for (int tc = 1; tc <= tc_n; tc++) {
			st = new StringTokenizer(br.readLine());
			boolean[] allCard = new boolean[19];
			guCard = new int[9];
			for (int i = 0; i < 9; i++) {
				guCard[i] = Integer.parseInt(st.nextToken());
				allCard[guCard[i]] = true;
			}
			int cnt=0;
			for (int i = 1; i < allCard.length; i++) {
				if(!allCard[i]) {
					inCard[cnt] = i;
					cnt++;
				}
			}
			wincnt=0;losecnt=0;

			getPermu(0, inCard);
			sb.append("#"+tc+" ").append(wincnt).append(" ").append(losecnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	static void getPermu(int cnt, int[] inCard) {
		if(cnt == inCard.length) {
			int inScore=0, guScore=0;
			for (int i = 0; i < selectedCards.length; i++) {
				if(selectedCards[i] < guCard[i]) {
					guScore += guCard[i]+selectedCards[i];
				} else {
					inScore += guCard[i]+selectedCards[i];
				}
			}
			if(guScore > inScore) wincnt++;
			else if(guScore < inScore)losecnt++;
			return;
		}
		
		for (int i = 0; i < inCard.length; i++) {
			if(isSelected[i]) continue;
			selectedCards[cnt] = inCard[i];
			isSelected[i] = true;
			getPermu(cnt+1, inCard);
			isSelected[i] = false;
		}
	}
	
}
