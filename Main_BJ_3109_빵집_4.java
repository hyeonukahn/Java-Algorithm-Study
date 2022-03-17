import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_3109_빵집_4 {
	static char[][] arrPipe;
	static int ansh;
	static boolean[] chkans;
	static int[] currlist;
	static int[] curclist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		arrPipe = new char[r][c];
		chkans = new boolean[r];
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			arrPipe[i] = str.toCharArray();
		}
		
		int x = Math.max(r, c);

		for (int i = 0; i < r; i++) {
			currlist = new int[x];
			curclist = new int[x];
			currlist[0] = i;
			curclist[0] = 0;
			findPath(i, 0, r, c, i);
		}

		System.out.println(ansh);
		br.close();
	}

	private static void findPath(int curr, int curc, int r,	int c, int wall) {
		if (curc == c - 1) {
			if (!chkans[currlist[0]]) {
				for (int i = 0; i < r; i++) {
					arrPipe[currlist[i]][curclist[i]] = 'x';
				}
				ansh++;
				chkans[currlist[0]] = true;
			}
			return;
		}
		
		if(chkans[currlist[0]]) return;

		if (curr - 1 >= wall && arrPipe[curr - 1][curc + 1] == '.') {
			currlist[curc+1] = curr-1;
			curclist[curc+1] = curc+1;
			findPath(curr - 1, curc + 1, r, c, wall);
			if(chkans[currlist[0]]) return;
		}
		if (arrPipe[curr][curc + 1] == '.') {
			currlist[curc+1] = curr;
			curclist[curc+1] = curc+1;
			findPath(curr, curc + 1, r, c, wall);
			if(chkans[currlist[0]]) return;
		}
		if (curr + 1 < r && arrPipe[curr + 1][curc + 1] == '.') {
			currlist[curc+1] = curr+1;
			curclist[curc+1] = curc+1;
			findPath(curr + 1, curc + 1, r, c, wall);
			if(chkans[currlist[0]]) return;
		}
	}
}
