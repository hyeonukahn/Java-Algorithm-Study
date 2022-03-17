import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_2564_경비원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int storeN = Integer.parseInt(br.readLine());
		int[][] storelist = new int[storeN][2];
		int[] player = new int[2];
		
		
		for (int i = 0; i < storeN; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp = Integer.parseInt(st.nextToken());
			storelist[i][1] = Integer.parseInt(st.nextToken());
			switch (tmp) {
			case 1:
				storelist[i][0] = 0;
				break;
			case 2:
				storelist[i][0] = 2;
				break;
			case 3:
				storelist[i][0] = 3;
				storelist[i][1] = y - storelist[i][1];
				break;
			case 4:
				storelist[i][0] = 1;
				storelist[i][1] = y - storelist[i][1];
				break;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int tmp = Integer.parseInt(st.nextToken());
		player[1] = Integer.parseInt(st.nextToken());
		switch (tmp) {
		case 1:
			player[0] = 0;
			break;
		case 2:
			player[0] = 2;
			break;
		case 3:
			player[0] = 3;
			player[1] = y - player[1];
			break;
		case 4:
			player[0] = 1;
			player[1] = y - player[1];
			break;
		}
		
		
		int ans = 0;
		switch(player[0]) {
		case 0:
			for (int i = 0; i < storeN; i++) {
				if(player[0] == storelist[i][0]) {
					ans += Math.abs(player[1]-storelist[i][1]);
				} else if((player[0]+1)%4 == storelist[i][0]) {
					ans += x-player[1]+y-storelist[i][1];
				} else if(player[0] == (storelist[i][0]+1)%4) {
					ans += player[1]+y-storelist[i][1];
				} else {
					ans += Math.min(player[1]+storelist[i][1], x-player[1]+x-storelist[i][1])+y;
				}
			}
			break;
		
		case 1:
			for (int i = 0; i < storeN; i++) {
				if(player[0] == storelist[i][0]) {
					ans += Math.abs(player[1]-storelist[i][1]);
				} else if((player[0]+1)%4 == storelist[i][0]) {
					ans += player[1]+x-storelist[i][1];
				} else if(player[0] == (storelist[i][0]+1)%4) {
					ans += y-player[1]+x-storelist[i][1];
				} else {
					ans += Math.min(player[1]+storelist[i][1], y-player[1]+y-storelist[i][1])+x;
				}
			}
			break;
		
		case 2:
			for (int i = 0; i < storeN; i++) {
				if(player[0] == storelist[i][0]) {
					ans += Math.abs(player[1]-storelist[i][1]);
				} else if((player[0]+1)%4 == storelist[i][0]) {
					ans += player[1]+storelist[i][1];
				} else if(player[0] == (storelist[i][0]+1)%4) {
					ans += x-player[1]+storelist[i][1];
				} else {
					ans += Math.min(player[1]+storelist[i][1], x-player[1]+x-storelist[i][1])+y;
				}
			}
			break;
			
		case 3:
			for (int i = 0; i < storeN; i++) {
				if(player[0] == storelist[i][0]) {
					ans += Math.abs(player[1]-storelist[i][1]);
				} else if((player[0]+1)%4 == storelist[i][0]) {
					ans += y-player[1]+storelist[i][1];
				} else if(player[0] == (storelist[i][0]+1)%4) {
					ans += player[1]+storelist[i][1];
				} else {
					ans += Math.min(player[1]+storelist[i][1], y-player[1]+y-storelist[i][1])+x;
				}
			}
			break;
			
		}
		
		System.out.println(ans);
		
		br.close();		
	}

}
