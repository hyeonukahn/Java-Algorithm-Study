import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_BJ_3052_나머지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[10];
		for (int i = 0; i < 10; i++) {
			num[i] = Integer.parseInt(br.readLine());			
		}
		
		Set<Integer> numset = new HashSet<>();
		
		for (int i = 0; i < 10; i++) {
			numset.add(num[i]%42);
		}
		
		System.out.println(numset.size());
		
		br.close();
	}

}
