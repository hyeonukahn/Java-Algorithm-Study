import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BJ_11650_좌표정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Point[] pointList = new Point[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			pointList[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(pointList);
		
//		Arrays.sort(pointList, new Comparator<Point>() {
//			@Override
//			public int compare(Point o1, Point o2) {
//				if(o1.x==o2.x) return o1.y-o2.y;
//				return o1.x-o2.x;
//			}
//		});
		
		for (int i = 0; i < n; i++) {
			sb.append(pointList[i].x+" ");
			sb.append(pointList[i].y+"\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	static class Point implements Comparable<Point>{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Point o) {
			if(this.x==o.x) return this.y-o.y;
			return this.x-o.x;
		}
	}
}
