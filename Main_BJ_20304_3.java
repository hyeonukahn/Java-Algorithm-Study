import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_20304_3 {
	
	static class Node{
		int val;
		Node link;
		
		public Node(int val, Node link) {
			this.val = val;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[] pArr = new int[m]; 
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		for (int i = 0; i < m; i++) { 
			pArr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		Node[] adjList = new Node[n+1];
		int len = Integer.toBinaryString(n).length();
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < len; j++) {
				if((i^(1<<j)) <= n) {
					adjList[i] = new Node(i^(1<<j), adjList[i]);
				}
			}
		}
		
		int ans = bfs(n, m, pArr, adjList);
		System.out.println(ans);
		br.close();
	}
/*
10
2
3 4
 */
	
	static int bfs(int n, int m, int[] pArr, Node[] adjList) {
		Queue<Integer> q = new ArrayDeque<>();
		int[] visitedVal = new int[n+1];
		for (int i = 0; i < m; i++) {
			q.add(pArr[i]);
			visitedVal[pArr[i]] = 1;
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
				for (Node temp = adjList[x] ; temp != null; temp = temp.link) {
					if(visitedVal[temp.val] == 0) {
						visitedVal[temp.val] = visitedVal[x]+1;
						q.add(temp.val);
					}
				}
		}
		
		int ans=0;
		for (int i = 0; i <= n; i++) {
			if(visitedVal[i] > ans) {
				ans = visitedVal[i];
			}
		}
		return --ans;
	}
}
