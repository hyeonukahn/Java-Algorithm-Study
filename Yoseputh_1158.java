import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Yoseputh_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int k = sc.nextInt();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Integer> intArr = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			intArr.add(i);
		}

		StringBuffer sb = new StringBuffer();
		sb.append("<");

		int popValue;
		int i = 1;
		int alpha = 0;
		int size = intArr.size();
		while (size > 1) {
			if (i * (k-1) - alpha < size) {
				popValue = intArr.remove(i * (k-1) - alpha);
				i++;
				size--;
				sb.append(popValue).append(", ");
			} else {
				alpha += size;
			}
		}
//		while(!(intArr.isEmpty())) {
//			if(i*k-i-alpha < intArr.size()) {
//				popValue = intArr.remove(i*k-i-alpha);
//				i++;
//				sb.append(popValue).append(", ");
////				ansArr.add(popValue);
//			}
//			else {
//				alpha += intArr.size();
//			}
//		}
		sb.append(intArr.remove(0)).append(">");
		System.out.println(sb);
//		System.out.print("<");
//		for (int j = 0; j < ansArr.size()-1; j++) {
//			System.out.print(ansArr.get(j)+", ");
//		}
//		System.out.print(ansArr.get(ansArr.size()-1)+">");
//		sc.close();
	}

}
