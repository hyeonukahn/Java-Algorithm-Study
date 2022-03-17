import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_2304_창고다각형 {
	
	static class Poll implements Comparable<Poll>{
		int x, h;

		public Poll(int x, int h) {
			super();
			this.x = x;
			this.h = h;
		}

		@Override
		public int compareTo(Poll o) {
			return x-o.x;
		}

		@Override
		public String toString() {
			return "Poll [x=" + x + ", h=" + h + "]";
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		Poll[] pollArr = new Poll[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			pollArr[i] = new Poll(x, h);
		}
		
		Arrays.sort(pollArr);
		
		Stack<Poll> stackP = new Stack<>();
		int ans = 0;
		for (int i = 0; i < pollArr.length; i++) {
			if(stackP.isEmpty()) {
				stackP.add(pollArr[i]);
			} else {
				Poll lastP = null;
				while(!stackP.isEmpty() && pollArr[i].h > stackP.peek().h) {
					lastP = stackP.pop();
				}
				if(stackP.isEmpty()) {
					ans += lastP.h * (pollArr[i].x-lastP.x);
				}
				stackP.add(pollArr[i]);
			}
		}
		
		while(!stackP.isEmpty()) {
			if(stackP.size() == 1) {
				ans += stackP.pop().h;
				break;
			} else {
				Poll popPoll = stackP.pop();
				ans += popPoll.h*(popPoll.x-stackP.peek().x);
			}
		}
		
		System.out.println(ans);
		
		br.close();
	}
}

/*
7
2 4
11 4
15 8
4 6
5 3
8 10
13 6
*/
/*
8
2 4
11 4
15 8
4 6
5 3
8 10
13 6
14 3
*/
