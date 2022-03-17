import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_BJ_2628_종이자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int comN = Integer.parseInt(br.readLine());
		ArrayList<Integer> cutW = new ArrayList<>();
		ArrayList<Integer> cutH = new ArrayList<>();
		cutW.add(0);
		cutW.add(h);
		cutH.add(0);
		cutH.add(w);
		
		for (int i = 0; i < comN; i++) {
			st = new StringTokenizer(br.readLine());
			int com = Integer.parseInt(st.nextToken());
			if(com == 0) {
				cutW.add(Integer.parseInt(st.nextToken()));
			} else {
				cutH.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		Collections.sort(cutW);
		Collections.sort(cutH);
		
		int ans = 0;
		int area = 0;
		for (int i = 0; i < cutW.size()-1; i++) {
			for (int j = 0; j < cutH.size()-1; j++) {
				area = (cutW.get(i+1)-cutW.get(i))*(cutH.get(j+1)-cutH.get(j));
				if(area > ans) {
					ans = area;
				}
			}
		}
		
		System.out.println(ans);
		
		br.close();
	}

}
