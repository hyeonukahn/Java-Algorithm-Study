import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_BJ_13910_개업_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> wackArr = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < m; i++) {
			wackArr.add(Integer.parseInt(st.nextToken()));
		}
		
		Set<Integer> oneCookList = new HashSet<>();
		oneCookList.addAll(wackArr);
		for (int i = 0; i < m-1; i++) {
			for (int j = i+1; j < m; j++) {
				oneCookList.add(wackArr.get(i)+wackArr.get(j));
			}
		}
		
		Integer[] cookList;
		cookList = oneCookList.toArray(new Integer[0]);
		
		Arrays.sort(cookList);
		
		int oneCookM = oneCookList.size();
		
		int[] cookN = new int[n+1];
		
		Arrays.fill(cookN, n+1);
		
		for (int i = 0; i < oneCookM; i++) {
			if(cookList[i] <= n) {
				cookN[cookList[i]] = 1;
			} else {
				break;
			}
		}
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < oneCookM; j++) {
				if(i-cookList[j] > 0) {
					cookN[i] = Math.min(cookN[i], cookN[i-cookList[j]]+1);
				} else {
					break;
				}
			}
		}
		
		
		if(cookN[n]>n) {
			System.out.println(-1);
		} else {
			System.out.println(cookN[n]);
		}
		
		br.close();
	}

}
