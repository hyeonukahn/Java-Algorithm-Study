import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_15663_N_M_9 {
	static int[] selArr;
//	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	static ArrayList<int[]> selArrList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] numArr = new int[n];
//		isSelected = new boolean[n];
		selArr = new int[m];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(numArr);
		permu(0, 0, n, m, numArr);
		System.out.println(sb);

		br.close();
	}

	public static void permu(int cnt, int flag, int n, int m, int[] numArr) {
		if (cnt == m) {
			for (int i = 0; i < selArrList.size(); i++) {
				if(Arrays.equals(selArr, selArrList.get(i))) {
					return;
				}
			}
			selArrList.add(selArr.clone());
			for (int i = 0; i < selArr.length; i++) {
				sb.append(selArr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			selArr[cnt] = numArr[i];

//			if (isSelected[i])	continue;
			if ((flag & 1<<i) != 0)	continue;
//			isSelected[i] = true;

			permu(cnt + 1, (flag | 1<<i), n, m, numArr);
//			isSelected[i] = false;
		}

	}
}
