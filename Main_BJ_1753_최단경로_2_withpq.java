import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_1753_최단경로_2_withpq {
	
	static class Node implements Comparable<Node>{
		int to;
		int weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		
		
		ArrayList<Node>[] nodeList = new ArrayList[v+1];
		for (int i = 1; i <= v; i++) {
			nodeList[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodeList[from].add(new Node(to, weight));
		}
		
		int[] distArr = new int[v+1];
		Arrays.fill(distArr, 987654321);
		boolean[] visited = new boolean[v+1];
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(k, 0));
		
		for (int i = 1; i <= v; i++) {
			if (pq.isEmpty()) {
				break;				
			}
			Node x = pq.poll();
			
			if (visited[x.to]) {
				i--;
				continue;
			}
			visited[x.to] = true;
			distArr[x.to] = x.weight;
			
			for (Node n : nodeList[x.to]) {
				if(!visited[n.to] && n.weight+distArr[x.to] < distArr[n.to]) {
					pq.add(new Node(n.to, n.weight+distArr[x.to]));
				}
			}
		}
		
		for (int i = 1; i <= v; i++) {
			if(distArr[i] == 987654321) {
				sb.append("INF\n");
			} else {
				sb.append(distArr[i]+"\n");
			}
		}
		
		System.out.println(sb);
		
		
		br.close();
	}

}
