import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_BJ_13334_철로_2 {
	
	static class HoOff implements Comparable<HoOff>{
		int s;
		int d;
		long dist;
		public HoOff(int s, int d) {
			if(s<d) {
				this.s = s;
				this.d = d;
				dist = d-s;
			} else {
				this.s = d;
				this.d = s;
				dist = s-d;
			}
		}
		@Override
		public int compareTo(HoOff o) {
			if(d==o.d) return (s-o.s);
			return (d-o.d);
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		HoOff[] distList = new HoOff[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			distList[i] = new HoOff(s, d);
		}
		long len = Integer.parseInt(br.readLine());
		
		Arrays.sort(distList);
		
		PriorityQueue<Integer> minstart = new PriorityQueue<>();
		int cnt = 0;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if(distList[i].dist > len) {
				continue;
			}
			
			while(!minstart.isEmpty() && minstart.peek() < distList[i].d-len) {
				minstart.poll();
				cnt--;
			}
			
			minstart.add(distList[i].s);
			cnt++;
			
			ans = (cnt>ans)?cnt:ans;
		}
		System.out.println(ans);
		br.close();
	}

}
