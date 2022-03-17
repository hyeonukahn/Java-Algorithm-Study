import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1759_암호만들기 {
	static StringBuilder sb = new StringBuilder();
	static char[] selectedC;
	static char[] vowels = {'a', 'i', 'e', 'o', 'u'};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		selectedC = new char[L];
		char[] chArr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			chArr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(chArr);
		
		combi(0, 0, L, C, chArr);
		
		System.out.println(sb);		
		br.close();
	}
	
	static boolean chkvowel(int L, char[] chArr) {
		int vowelcnt = 0;
		int constcnt = 0;
		boolean chkvowel;
		for (int i = 0; i < L; i++) {
			chkvowel = false;
			for (int j = 0; j < 5; j++) {
				if(chArr[i] == vowels[j]) {
					chkvowel = true;
					vowelcnt++;
					break;
				}
			}
			if(!chkvowel) constcnt++;
		}
		if(vowelcnt>=1 && constcnt>=2) return true;
		else return false;
	}
	
	static void combi(int startp, int cnt, int L, int C, char[] chArr) {
		if(cnt == L) {
			if(chkvowel(L, selectedC)) {
				sb.append(selectedC);
				sb.append("\n");
			}
			return;
		}
		
		for (int i = startp; i < C; i++) {
			selectedC[cnt] = chArr[i];
			combi(i+1, cnt+1, L, C, chArr);
		}
	}
}
