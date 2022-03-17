import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_BJ_1786_찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] content = br.readLine().toCharArray();
		char[] tomatch = br.readLine().toCharArray();
		
		int clen = content.length;
		int mlen = tomatch.length;
		
		int[] mTable = new int[mlen];
		for (int i=1, j=0; i < mlen; i++) {
			while(j>0 && tomatch[i] != tomatch[j]) {
				j = mTable[j-1];
			}
			
			
			if(tomatch[i] == tomatch[j]) mTable[i] = ++j;
			else mTable[i] = 0;
		}
		
//		System.out.println(Arrays.toString(mTable));
		int cnt = 0;
		ArrayList<Integer> idxList = new ArrayList<>();
		
		for (int i = 0, j=0; i < clen; i++) {
			
			while(j>0 && content[i] != tomatch[j]) j = mTable[j-1];
			
			if(content[i] == tomatch[j]) {
				if(j == mlen-1) {
					cnt++;
					idxList.add(i-mlen+1+1);
					j=mTable[j];
				} else {
					j++;
				}
			}
		}
		sb.append(cnt+"\n");
		for (int i = 0; i < idxList.size(); i++) {
			sb.append(idxList.get(i)+"\n");
		}
		System.out.println(sb);
		
		br.close();
	}

}
