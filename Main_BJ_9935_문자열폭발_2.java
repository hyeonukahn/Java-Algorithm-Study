import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_BJ_9935_문자열폭발_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
//		Stack<Character> chkstr = new Stack<>();
		ArrayDeque<Character> chkstr = new ArrayDeque<>();
		
		int bombcnt = 0;
		int bombcur = 0;
		int len = str.length();
		int bomblen = bomb.length();
		if(bomblen == 1) {
			for (int i = 0; i < len; i++) {
				char ch = str.charAt(i);
				chkstr.add(ch);
				if(ch == bomb.charAt(0)) {
					chkstr.pollLast();
				}
			}
		} else {
			for (int i = 0; i < len; i++) {
				char ch = str.charAt(i);
				chkstr.add(ch);
				if(ch == bomb.charAt(0)) {
					bombcnt++;
					bombcur = 1;
				} else if(ch == bomb.charAt(bombcur)) {
					bombcur++;
					if(bombcur == bomblen) {
						for (int j = 0; j < bomblen; j++) {
							chkstr.pollLast();
						}
						bombcnt--;
						if(bombcnt == 0) {
							bombcur = 0;
						}else {
							bombcur = bomb.indexOf(chkstr.peekLast())+1;
						}
					}
				} else {
					bombcnt = 0;
					bombcur = 0;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		
		while(!chkstr.isEmpty()) {
			sb.append(chkstr.pollLast());
		}
		sb.reverse();
		if(sb.length()==0) {
			sb.append("FRULA");
		}
		
		System.out.println(sb);
		
		br.close();
	}
}
