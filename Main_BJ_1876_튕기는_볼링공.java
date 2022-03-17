import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1876_튕기는_볼링공 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double t = Double.parseDouble(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			double tanVal = Math.tan((double) x/180*Math.PI);
			double cosVal = Math.cos((double) x/180*Math.PI);
			double height = 1.05;
			double ballSize = 0.20;
			double pinSize = 0.12;
			boolean isin = false;
			for (int j = 0; j < (int) (t+1)*tanVal+t; j++) {
//				System.out.println((height*j-((pinSize+ballSize)/2)/cosVal)+" "+tanVal*t+" "+(height*j+((pinSize+ballSize)/2)/cosVal));
				if((height-ballSize)*j-((pinSize+ballSize)/2)/cosVal <= tanVal*t && tanVal*t <= (height-ballSize)*j+((pinSize+ballSize)/2)/cosVal) {
					sb.append("yes\n");
					isin = true;
					break;
				}
			}
			
			if(!isin) {
				sb.append("no\n");
			}
			
		}
		System.out.println(sb);
		
		br.close();
	}
}
