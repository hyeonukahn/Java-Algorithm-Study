import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_BJ_11725_트리부모찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int nodeN = Integer.parseInt(br.readLine());
		int[] numTree = new int[nodeN+1];
		Map<Integer, ArrayList> neighborMap = new HashMap<Integer, ArrayList>();
		
		for (int i = 1; i < nodeN; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			if (!neighborMap.containsKey(n1)) {
				ArrayList<Integer> valList = new ArrayList<>();
				valList.add(n2);
				neighborMap.put(n1, valList);
			} else {
				neighborMap.get(n1).add(n2);
			}
			if (!neighborMap.containsKey(n2)) {
				ArrayList<Integer> valList = new ArrayList<>();
				valList.add(n1);
				neighborMap.put(n2, valList);
			} else {
				neighborMap.get(n2).add(n1);
			}
		}
		
		numTree[1] = -1;
		Queue<Integer> keyQue = new ArrayDeque<>();
		keyQue.add(1);
		while(!keyQue.isEmpty()) {
			int x = keyQue.poll();
			ArrayList<Integer> putInVal = neighborMap.get(x);
			
			for (Integer intNum : putInVal) {
				if(numTree[intNum] == 0) {
					numTree[intNum] = x;
					keyQue.add(intNum);
				}
			}
		}
		
		for (int i = 2; i <= nodeN; i++) {
			sb.append(numTree[i]).append("\n");
		}
		
		System.out.println(sb);
		
		br.close();		
	}

}
