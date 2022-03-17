import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_14696_딱지놀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			Integer[] aArr = new Integer[a];
			for (int j = 0; j < a; j++) {
				aArr[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			Integer[] bArr = new Integer[b];
			for (int j = 0; j < b; j++) {
				bArr[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(aArr, Comparator.reverseOrder());
			Arrays.sort(bArr, Comparator.reverseOrder());
			
			int len = Math.min(a, b);
			boolean iswin = false;
			for (int j = 0; j < len; j++) {
				if(aArr[j] < bArr[j]) {
					sb.append("B\n");
					iswin = true;
					break;
				} else if(aArr[j] > bArr[j]) {
					sb.append("A\n");
					iswin = true;
					break;
				}
			}
			
			if(!iswin) {
				if(a<b) sb.append("B\n");
				else if(a>b) sb.append("A\n");
				else sb.append("D\n");
			}
		}
		
		
		System.out.println(sb);
		br.close();
	}

}
