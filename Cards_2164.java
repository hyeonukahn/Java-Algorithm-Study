import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Scanner;

public class Cards_2164 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = sc.nextInt();
		int n = Integer.parseInt(br.readLine());
		
//		Queue<Integer> intQue = new LinkedList<>();
		Queue<Integer> intQue = new ArrayDeque<>();
		
		for (int i = 1; i <= n; i++) {
			intQue.add(i);
		}
		int a;		
		while(intQue.size() > 1) {
			intQue.poll();
			a = intQue.poll();
			intQue.add(a);
		}
		System.out.println(intQue.peek());				
//		sc.close();
		br.close();
	}
}
