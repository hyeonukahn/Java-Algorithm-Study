import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_2116_주사위쌓기 {
	
	static class Dice{
		int[] dicenum;
		int bottomidx, topidx;

		public Dice(int[] dicenum) {
			this.dicenum = dicenum.clone();
		}

		@Override
		public String toString() {
			return "Dice [dicenum=" + Arrays.toString(dicenum) + ", bottomidx=" + bottomidx + ", topidx=" + topidx
					+ "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		Dice[] dicelist = new Dice[n];
		
		for (int i = 0; i < n; i++) {
			int[] tmpdice = new int[6];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				tmpdice[j] = Integer.parseInt(st.nextToken());
			}
			dicelist[i] = new Dice(tmpdice);
		}
		
//		System.out.println(Arrays.toString(dicelist));
		
		int ans = 0;
		for (int i = 0; i < 6; i++) {
			int sum = 0;
			dicelist[0].bottomidx = i;
			dicelist[0].topidx = findtop(dicelist[0].bottomidx);
			
			for (int j = 0; j < 6; j++) {
				if(dicelist[0].bottomidx != j && dicelist[0].topidx != j) {
					if(dicelist[0].dicenum[j] > sum) {
						sum = dicelist[0].dicenum[j];
					}
				}
			}
//			System.out.print(sum+" ");
			
			for (int j = 1; j < n; j++) {
				for (int j2 = 0; j2 < 6; j2++) {
					if(dicelist[j].dicenum[j2] == dicelist[j-1].dicenum[dicelist[j-1].topidx]) {
						dicelist[j].bottomidx = j2;
						dicelist[j].topidx = findtop(dicelist[j].bottomidx);
					}
				}
				
				int tmp = 0;
				for (int j2 = 0; j2 < 6; j2++) {
					if(dicelist[j].bottomidx != j2 && dicelist[j].topidx != j2) {
						if(dicelist[j].dicenum[j2] > tmp) {
							tmp = dicelist[j].dicenum[j2];
						}
					}
				}
//				System.out.print(tmp+" ");
				sum += tmp;
			}
			
//			System.out.println(sum);
			
			if(ans < sum) {
				ans = sum;
			}
		}
		
		System.out.println(ans);		
		br.close();
	}
	
	static int findtop(int bottomidx) {
		int topidx=-1;
		switch (bottomidx) {
		case 0:
			topidx = 5;
			break;
		case 1:
			topidx = 3;
			break;
		case 2:
			topidx = 4;
			break;
		case 3:
			topidx = 1;
			break;
		case 4:
			topidx = 2;
			break;
		case 5:
			topidx = 0;
			break;
		}
		return topidx;
	}
}
