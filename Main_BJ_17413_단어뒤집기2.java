import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_17413_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] chArr = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		StringBuilder sbsub = new StringBuilder();
		boolean isin = false;
		for (int i = 0; i < chArr.length; i++) {
			if(chArr[i] == '<') {
				isin = true;
				sb.append(sbsub.reverse());
				sbsub = new StringBuilder();
				sbsub.append(chArr[i]);
			} else if(chArr[i] == '>') {
				isin = false;
				sb.append(sbsub);
				sb.append(chArr[i]);
				sbsub = new StringBuilder();
			} else if(chArr[i] == ' '){
				if(isin) {
					sb.append(sbsub);
				} else {
					sb.append(sbsub.reverse());
				}
				sbsub = new StringBuilder();
				sb.append(chArr[i]);
			} else {
				sbsub.append(chArr[i]);
			}
		}
		
		sb.append(sbsub.reverse());
		
		System.out.println(sb);
		br.close();
	}

}
