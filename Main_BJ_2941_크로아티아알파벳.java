import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String[] alphabetList = {"c=","c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for (String alpha : alphabetList) {
			str = str.replace(alpha, "0");
		}
		
//		System.out.println(str);
		
		System.out.println(str.length());
		
		
		br.close();
	}
}
