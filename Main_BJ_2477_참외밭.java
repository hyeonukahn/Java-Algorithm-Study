import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BJ_2477_참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int k = Integer.parseInt(br.readLine());
		int[] dir = new int[6];
		int[] len = new int[6];
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxX = 0;
		int maxY = 0;
		int xidx = 0;
		int yidx = 0;
		
		for (int i = 0; i < 6; i++) {
			if(dir[i] == 1 || dir[i] == 2) {
				if(maxX < len[i]) {
					maxX = len[i];
					xidx = i;
				}
			} else {
				if(maxY < len[i]) {
					maxY = len[i];
					yidx = i;
				}
			}
		}
		
		Set<Integer> setNum = new HashSet<>();
		setNum.add(xidx-1);
		setNum.add(xidx);
		setNum.add(xidx+1);
		setNum.add(yidx-1);
		setNum.add(yidx);
		setNum.add(yidx+1);
		
		boolean[] chk = new boolean[6];		
		for (int i : setNum) {
			if(0<=i&&i < 6) {
				chk[i] = true;
			} else if(i<0) {
				chk[6+i] = true;
			} else if(i == 6) {
				chk[0] = true;
			}
		}
//		System.out.println(Arrays.toString(chk));
		
		int subArea = 1;
		for (int i = 0; i < chk.length; i++) {
			if(!chk[i]) {
				subArea *= len[i];
			}
		}
//		System.out.println(subArea);
		
		int area = maxX * maxY - subArea;
		
		System.out.println(area*k);
		
		br.close();
	}
}
