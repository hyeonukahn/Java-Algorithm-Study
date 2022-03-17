import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_1753_최단경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());

		int[][] inEdge = new int[e][3];

		Map<Integer, HashMap<Integer, Integer>> vList = new HashMap<>();

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			inEdge[i][0] = Integer.parseInt(st.nextToken());
			inEdge[i][1] = Integer.parseInt(st.nextToken());
			inEdge[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(inEdge, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0])
					return o1[0] - o2[0];
				else if (o1[1] != o2[1])
					return o1[1] - o2[1];
				return -(o1[2] - o2[2]);
			}
		});

		for (int i = 0; i < e; i++) {
			int key = inEdge[i][0];
			if (!vList.containsKey(key)) {
				HashMap<Integer, Integer> val = new HashMap<>();
				val.put(inEdge[i][1], inEdge[i][2]);
				vList.put(key, val);
			} else {
				vList.get(key).put(inEdge[i][1], inEdge[i][2]);
			}
		}

//		PriorityQueue<HashMap<Integer, Integer>> willVisit = new PriorityQueue<>(new Comparator<HashMap<Integer,Integer>>() {
//
//			@Override
//			public int compare(HashMap<Integer, Integer> o1, HashMap<Integer, Integer> o2) {
//				return o1.g
//			}
//		}));
//		Queue<HashMap<Integer, Integer>> willVisit = new ArrayDeque<>();
		PriorityQueue<int[]> willVisit = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2]-o2[2];
			}
		});
		
		int[] visitVal = new int[v + 1];
		Arrays.fill(visitVal, 987654321);
		willVisit.add(new int[] {k, 0, 0});
//		visitVal[k] = 0;
//		HashMap<Integer, Integer> first = vList.get(k); 
//		for (int i : first.keySet()) {
//			willVisit.add(new int[] {i, first.get(i), first.get(i)});
//		}

		while (!willVisit.isEmpty()) {
			int[] x = willVisit.poll();
//			HashMap<Integer, Integer> nextMap = vList.get(x[1]);
			
			if(x[2] < visitVal[x[0]]) {
				visitVal[x[0]] = x[2];
				HashMap<Integer, Integer> nextMap = vList.get(x[0]);
				if(nextMap != null) {
					for (int i : nextMap.keySet()) {
						willVisit.add(new int[] {i, nextMap.get(i), nextMap.get(i)+x[2]});
					}
				}
			}
		}
		
		for (int i = 1; i < visitVal.length; i++) {
			if (visitVal[i] == 987654321) {
				sb.append("INF\n");
			} else {
				sb.append(visitVal[i] + "\n");
			}
		}

		System.out.println(sb);

		br.close();
	}

}
