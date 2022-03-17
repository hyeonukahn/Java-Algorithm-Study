import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2527_직사각형 {
	
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

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
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
			
			Point[] square_1 = new Point[4];
			square_1[0] = new Point(squareN1[0], squareN1[1]);
			square_1[1] = new Point(squareN1[2], squareN1[1]);
			square_1[2] = new Point(squareN1[2], squareN1[3]);
			square_1[3] = new Point(squareN1[0], squareN1[3]);
			
			Point[] square_2 = new Point[4];
			square_2[0] = new Point(squareN2[0], squareN2[1]);
			square_2[1] = new Point(squareN2[2], squareN2[1]);
			square_2[2] = new Point(squareN2[2], squareN2[3]);
			square_2[3] = new Point(squareN2[0], squareN2[3]);
			
			if(square_1[0].equals(square_2[2]) ||
					square_1[1].equals(square_2[3])||
					square_1[2].equals(square_2[0])||
					square_1[3].equals(square_2[1])) {
				sb.append("c\n");
			} else if(square_1[2].x < square_2[0].x ||
					square_1[2].y < square_2[0].y ||
					square_1[0].x > square_2[2].x ||
					square_1[0].y > square_2[2].y) {
				sb.append("d\n");
			} else if((square_1[2].y == square_2[0].y && square_1[3].x < square_2[0].x && square_2[0].x < square_1[2].x) || 
					(square_1[0].y == square_2[2].y && square_1[0].x < square_2[2].x && square_2[2].x < square_1[1].x) ||
					(square_1[2].x == square_2[0].x && square_1[1].y < square_2[0].y && square_2[0].y < square_1[2].y) ||
					(square_1[0].x == square_2[2].x && square_1[0].y < square_2[2].y && square_2[2].y < square_1[3].y)) {
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
