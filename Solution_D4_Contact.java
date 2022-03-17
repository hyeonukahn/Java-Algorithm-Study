import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_Contact {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc_n = 10;
		
		for (int tc = 1; tc <= tc_n; tc++) {
			Map<Integer, ArrayList<Integer>> neighborList = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int stnum = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				if(neighborList.containsKey(from)) {
					neighborList.get(from).add(to);
				} else {
					ArrayList<Integer> arr = new ArrayList<>();
					arr.add(to);
					neighborList.put(from, arr);
				}
			}
			
			Queue<Integer> bfsQ = new ArrayDeque<>();
			Queue<Integer> bfsVal = new ArrayDeque<>();
			
			ArrayList<Integer> visited = new ArrayList<>();
			ArrayList<Integer> visitedVal = new ArrayList<>();
			
			
			bfsQ.add(stnum);
			bfsVal.add(0);
			while(!bfsQ.isEmpty()) {
				int x = bfsQ.poll();
				int val = bfsVal.poll();
				
				if(!visited.contains(x)) {
					visited.add(x);
					visitedVal.add(val);
					
					if(neighborList.get(x) != null) {
						for (int i : neighborList.get(x)) {
							bfsQ.add(i);
							bfsVal.add(val+1);									
						}
					}
				}
			}
			int endEdge = visitedVal.size()-1;
			int maxvalue = visitedVal.get(endEdge);
			int maxp = 0;
			for (int i = endEdge; i >= 0; i--) {
				if(visitedVal.get(i) != maxvalue) {
					break;
				} else {
					if(visited.get(i)>maxp) {
						maxp = visited.get(i);
					}
				}
			}
			
			sb.append("#"+tc);
			sb.append(" "+maxp);
			sb.append("\n");
		}
		System.out.println(sb);
		
		br.close();
	}
}
