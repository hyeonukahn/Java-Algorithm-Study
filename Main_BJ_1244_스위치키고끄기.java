import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1244_스위치키고끄기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] switchArr = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			switchArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int stN = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < stN; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int click = Integer.parseInt(st.nextToken());
			
			switch (gender) {
			case 1:
				for (int j = click; j <= n; j += click) {
					switchArr[j] = changeSwitch(j, switchArr);
				}
				break;
				
			case 2:
				switchArr[click] = changeSwitch(click, switchArr);
				for (int j = click+1, k = click-1; 0 < k && j <= n; j++, k--) {
					if(switchArr[j] == switchArr[k]) {
						switchArr[j] = changeSwitch(j, switchArr);
						switchArr[k] = changeSwitch(k, switchArr);
					} else {
						break;
					}
				}
				break;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			sb.append(switchArr[i]+" ");
			if(i%20 == 0) {
				sb.setLength(sb.length()-1);
				sb.append("\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}

	public static int changeSwitch(int i, int[] switchArr) {
		if(switchArr[i] == 0) return 1;
		else return 0;
	}

}
