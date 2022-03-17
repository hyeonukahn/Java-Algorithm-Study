import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Pair{
	long x;
	int y;
	
	public Pair(long x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
}

public class Main_BJ_16953_AB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		int cnt = -1;
		
		Queue<Pair> q = new ArrayDeque<>();
		Queue<Pair> v = new ArrayDeque<>();
		
		q.add(new Pair(a, 0));
		
//		Queue<Long> q = new ArrayDeque<>();
//		Queue<Integer> qv = new ArrayDeque<>();
//		Queue<Long> v = new ArrayDeque<>();
//		Queue<Integer> vv = new ArrayDeque<>();
		
//		Map<Long, Integer> mapItem = new HashMap<>();
		
//		q.add(new int[] {a, 0});
//		q.add(a);
//		qv.add(0);
//		
		while(!(q.isEmpty())) {
			Pair p = q.poll();
			if(p.x == b) {
				cnt = p.y+1;
				break;
			}
			
			if(!(v.contains(p))&&p.x<=b) {
				v.add(p);
				q.add(new Pair(10*p.x+1, p.y+1));
				q.add(new Pair(2*p.x, p.y+1));
			}
			if(p.y > 30) break;
		}
//		while(!(qv.isEmpty())) {
////			int[] x = q.poll();
//			long x = q.poll();
//			int val = qv.poll();
//			if(x == b) {
//				cnt = val+1;
//				break;
//			}
//			
//			if(!(v.contains(x))&&x<=b) {
////				System.out.println(x);
//				v.add(x);
//				vv.add(val);
//				val++;
//				q.add(x*10+1);
//				qv.add(val);
//				q.add(x*2);
//				qv.add(val);
//			}
////			System.out.println();
////			System.out.println(q);
////			System.out.println(qv);
////			System.out.println("===============");
////			System.out.println(v);
////			System.out.println(vv);
////			System.out.println();
//		}
		System.out.println(cnt);
		
//		sc.close();
	}
}
