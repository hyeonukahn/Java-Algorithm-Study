import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_D3_1228_암호문1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc_n = 10;
		int n;
		int comN;
		
		int ansLength = 10;
		
		List<Integer> passList = new LinkedList<>();
		
		for (int tc = 1; tc <= tc_n; tc++) {
			passList.clear();
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
//			for (int i = 0; i < n; i++) {
//				passList.add(Integer.parseInt(st.nextToken()));
//			}
			
			for (int i = 0; i < ansLength; i++) {
				passList.add(Integer.parseInt(st.nextToken()));
			}
			comN = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), "I");
			
//			for (int i = 0; i < comN; i++) {
//				StringTokenizer st2 = new StringTokenizer(st.nextToken()," ");
//				int inIdx = Integer.parseInt(st2.nextToken());
//				int inN = Integer.parseInt(st2.nextToken());
//				
//				if(inIdx >= 10) continue;
//				else {
//					System.out.println(inIdx + " "+inN);
	//				for (int j = inIdx; st2.hasMoreTokens() && j < ansLength ; j++) {
	//					passList.add(j, Integer.parseInt(st2.nextToken()));
	//				}
//				}
//			}
			for (int i = 0; i < comN; i++) {
				StringTokenizer st2 = new StringTokenizer(st.nextToken()," ");
				int inIdx = Integer.parseInt(st2.nextToken());
				int inN = Integer.parseInt(st2.nextToken());
				
				for (int j = 0; j < inN && inIdx+j<ansLength; j++) {
					passList.add(inIdx+j, Integer.parseInt(st2.nextToken()));
				}
			}
			
			sb.append("#"+tc+" ");
			
			for (int i = 0; i < ansLength; i++) {
				sb.append(passList.get(i)+" ");
			}
			sb.append("\n");
		}
//		System.out.println(sb);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
