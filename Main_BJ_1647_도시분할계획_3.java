import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1647_도시분할계획_3 {
	
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] adjList = new ArrayList[n+1];
		
		for (int i = 1; i <= n; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			adjList[from].add(new Node(to, weight));
			adjList[to].add(new Node(from, weight));
		}
		
		boolean[] isvisited = new boolean[n+1];
		int[] mindist = new int[n+1];
		Arrays.fill(mindist, 987654321);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int res = 0;
		int lastval = 0;
		pq.add(new Node(1, 0));
		mindist[1] = 0;
		
		for(int i = 0; i < n; i++) {
			Node x = pq.poll();
			
			if(isvisited[x.to]) {
				i--;
				continue;
			}
			
			isvisited[x.to] = true;
			res += x.weight;
			
			for (Node node : adjList[x.to]) {
				if(!isvisited[node.to] && node.weight < mindist[node.to]) {
					mindist[node.to] = node.weight;
					pq.add(node);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if(lastval < mindist[i]) {
				lastval = mindist[i];
			}
		}
		
		
		System.out.println(res-lastval);
		
		br.close();
	}

}
