import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2527_직사각형_3 {
	
	static class Point{
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc_n = 4;
		
		for (int i = 0; i < tc_n; i++) {
			int[] squareN1 = new int[4];
			int[] squareN2 = new int[4];
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 4; j++) {
				squareN1[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < 4; j++) {
				squareN2[j] = Integer.parseInt(st.nextToken());
			}
			
			Point[] s1 = new Point[2];
			s1[0] = new Point(squareN1[0], squareN1[1]);
			s1[1] = new Point(squareN1[2], squareN1[3]);
			
			Point[] s2 = new Point[2];
			s2[0] = new Point(squareN2[0], squareN2[1]);
			s2[1] = new Point(squareN2[2], squareN2[3]);
			
			if(s1[1].x < s2[0].x || s1[1].y < s2[0].y || s2[1].x < s1[0].x || s2[1].y < s1[0].y) {
				sb.append("d\n");
			} else if((s1[1].x == s2[0].x && s1[1].y == s2[0].y) || (s1[0].x == s2[1].x && s1[1].y == s2[0].y) ||
					(s1[0].x == s2[1].x && s1[0].y == s2[1].y) || (s1[1].x == s2[0].x && s1[0].y == s2[1].y)) {
				sb.append("c\n");
			} else if((s1[1].x == s2[0].x) || (s1[1].y == s2[0].y) || (s1[0].x == s2[1].x) || (s1[0].y == s2[1].y)) {
				sb.append("b\n");
			} else {
				sb.append("a\n");
			}
			
		}
		
		System.out.println(sb);
		
		br.close();
	}

}
/*
45 50 600 600 400 450 500 543
30 10 50 60 50 80 80 100
30 60 60 90 60 20 90 50
30 60 60 90 50 90 80 120

a
d
d
b
*/
