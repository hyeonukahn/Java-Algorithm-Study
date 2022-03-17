import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_BJ_2999_비밀이메일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chstr = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		
		int len = chstr.length;
		int r=0, c=0;
		for (int i = 1; i <= Math.sqrt(len); i++) {
			if(len%i == 0) {
				r = i;
				c = len/r;
			}
		}
		char[][] chMat = new char[r][c];
		int cnt = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				chMat[j][i]	= chstr[cnt];
				cnt++;
			}
		}
		
//		for (int i = 0; i < chMat.length; i++) {
//			System.out.println(Arrays.toString(chMat[i]));
//		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append(chMat[i][j]);
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
}
