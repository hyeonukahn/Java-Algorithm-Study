import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1504_특정한최단경로_2 {
	
	static class Edge implements Comparable<Edge>{
		int to;
		int weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight-o.weight;
		}
		
	}
	
	static final int BIGVAL = 200000001;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge>[] edgeList = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) {
			edgeList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList[from].add(new Edge(to, weight));
			edgeList[to].add(new Edge(from, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int res1 = 0;
		int res2 = 0;
		
		int s_v1 = dijkstra(1, v1, n, edgeList);
		int v1_v2 = dijkstra(v1, v2, n, edgeList);
		int v2_d = dijkstra(v2, n, n, edgeList);
		
		res1 = s_v1+v1_v2+v2_d;
		
		int s_v2 = dijkstra(1, v2, n, edgeList);
		int v2_v1 = dijkstra(v2, v1, n, edgeList);
		int v1_d = dijkstra(v1, n, n, edgeList);
		
		res2 = s_v2+v2_v1+v1_d;
		
		int ans = Math.min(res1, res2);
		
		if(ans >= BIGVAL) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
		
		br.close();
	}
	
	static int dijkstra(int s, int d, int n, ArrayList<Edge>[] edgeList) {
		PriorityQueue<Edge> q = new PriorityQueue<>();
		boolean[] isvisited = new boolean[n+1];
		int[] distArr = new int[n+1];
		Arrays.fill(distArr, BIGVAL);
		distArr[s] = 0;
		
		q.add(new Edge(s, 0));
		
		
		while(!q.isEmpty()) {
			Edge x = q.poll();
			
			if(isvisited[x.to]) continue;
			
			isvisited[x.to] = true;
			distArr[x.to] = x.weight;
			if(x.to == d) break;
			
			for (Edge node : edgeList[x.to]) {
				if(!isvisited[node.to] && node.weight+distArr[x.to] < distArr[node.to]) {
					int nweight = node.weight+distArr[x.to];
					q.add(new Edge(node.to, nweight));
				}
			}
		}
		
		return distArr[d];
	}

}
