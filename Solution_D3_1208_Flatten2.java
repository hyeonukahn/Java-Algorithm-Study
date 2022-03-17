import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1208_Flatten2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		boolean b = true;
		
		int tc_n = 10;
		int[] boxArr;
		int[] boxHArr;
		for (int tc = 1; tc <= tc_n; tc++) {
			int flatN = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			boxArr = new int[100];
			boxHArr = new int[101];
			for (int i = 0; i < boxArr.length; i++) {
				boxArr[i] = Integer.parseInt(st.nextToken());
				boxHArr[boxArr[i]]++;
			}
			
//			System.out.println(Arrays.toString(boxHArr));
			int start = 1;
			int end = 100;
			
			while(start <=50) {
				if(boxHArr[start] == 0) {
					start++;
					continue;
				}
				if(boxHArr[end] == 0) {
					end--;
					continue;
				}
				
			}
			
			
			
			
//			Arrays.sort(boxArr);
			
//			int cntmin = 0;
//			int cntmax = 0;
//			int min1, min2, max2, max1;
//			int filling;
//			while(cntmin<50) {
//				min1 = boxArr[cntmin];
//				min2 = boxArr[cntmin+1];
//				max2 = boxArr[99-cntmax-1];
//				max1 = boxArr[99-cntmax];
//				
//				filling = Math.min((min2-min1), (max1-max2));
//				if(flatN-filling > 0) {
//					flatN -= filling;
//					if((min2-min1) < (max1-max2)) {
//						boxArr[99-cntmax] -= filling;
//						boxArr[cntmin] = min2;
//						cntmin++;
//					} else if((min2-min1) == (max1-max2)) {
//						boxArr[cntmin] = min2;
//						boxArr[99-cntmax] = max2;
//						cntmin++; cntmax++;
//					} else {
//						boxArr[cntmin] += min2;
//						boxArr[99-cntmax] = max2;
//						cntmax++;
//					}
//				}
//				else {
//					boxArr[cntmin] += flatN;
//					boxArr[99-cntmax] -= flatN;
//					break;
//				}
//			}
//			System.out.println(boxArr[99-cntmax]-boxArr[cntmin]);
			
//			sb.append("#"+tc+" "+(boxArr[99-cntmax]-boxArr[cntmin])+"\n");
			
//			while(flatN > 0) {
//				Arrays.sort(boxArr);
//				if(boxArr[99]-boxArr[0] <= 1) {
//					break;
//				}
//				boxArr[0]++;
//				boxArr[99]--;
//				flatN--;
//			}
//			
//			Arrays.sort(boxArr);
			
			sb.append("#"+tc+" "+(boxArr[99]-boxArr[0])+"\n");
			
		}
		System.out.println(sb);
		br.close();	
	}

}
