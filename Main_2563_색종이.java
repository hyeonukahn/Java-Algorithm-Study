import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2563_색종이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		Point[] points = new Point[n];
		int[][] dowhaghi = new int[101][101];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int x1, y1;
		
		for (int i = 0; i < points.length; i++) {
			x1 = points[i].x;
			y1 = points[i].y;
			for (int j = x1; j < x1+10; j++) {
				for (int k = y1; k < y1+10; k++) {
					dowhaghi[j][k] = 1;
				}
			}
		}
		
		int cnt=0;
		for (int j = 1; j < dowhaghi.length; j++) {
			for (int k = 1; k < dowhaghi.length; k++) {
				if(dowhaghi[j][k] == 1) cnt++;
			}
		}
		
		System.out.println(cnt);
		br.close();
	}
}

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	@Override
	public String toString() {
		
		return "[x="+x+", y="+y+"]";
	}
}
