import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_12865_평범한배낭_2 {
	static int ans = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Thing[] things = new Thing[n];
		
		int[][] arrDp = new int[n][k+1];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			Thing t = new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			things[i] = t;			
		}
		Arrays.sort(things, new Comparator<Thing>() {
			@Override
			public int compare(Thing o1, Thing o2) {
				return -(o1.weight-o2.weight);
			}
		});
		
		for (int i = 0; i <= k; i++) {
			if(things[0].weight <= i) {
				arrDp[0][i] = things[0].value;
			}
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= k; j++) {
				arrDp[i][j] = arrDp[i-1][j];
				if(things[i].weight <= j) {
					arrDp[i][j] = Math.max(things[i].value,arrDp[i][j]);
					arrDp[i][j] = Math.max(things[i].value+arrDp[i-1][j-things[i].weight], arrDp[i][j]);
				}
			}
		}
		
//		for (int i = 0; i < arrDp.length; i++) {
//			System.out.println(Arrays.toString(arrDp[i]));
//		}
		int ans = 0;
//		for (int i = 0; i < arrDp.length; i++) {
//			for (int j = 0; j < arrDp[i].length; j++) {
//				if(arrDp[i][j])
//			}
//		}
		System.out.println(arrDp[n-1][k]);
		
		br.close();
	}
	
	static class Thing{
		int weight;
		int value;
		public Thing(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}
		@Override
		public String toString() {
			return "Thing [weight=" + weight + ", value=" + value + "]";
		}
		
	}
}
