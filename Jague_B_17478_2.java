import java.util.Scanner;

public class Jague_B_17478_2 {
//	static int NUM;
	static StringBuilder sb;
	static String sbUnder="";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sb = new StringBuilder();
//		NUM = n;
//		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		chatbot(n);
		
		System.out.println(sb);
		sc.close();
	}
//	
//	public static String printUnder(int u) {
//		String res = "";
//		for (int i = 0; i < u; i++) {
//			res += "____";
//		}
//		return res;
//	}
	
	public static void chatbot(int n) {
		String temp = sbUnder;
		sb.append(temp).append("\"재귀함수가 뭔가요?\"\n");
//		System.out.println(printUnder(NUM-n)+"\"재귀함수가 뭔가요?\"");
		if(n>0) {
			sb.append(temp).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			sb.append(temp).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			sb.append(temp).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
//			System.out.println(printUnder(NUM-n)+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
//			System.out.println(printUnder(NUM-n)+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
//			System.out.println(printUnder(NUM-n)+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
			sbUnder+="____";
			chatbot(n-1);
		}
//		 System.out.println(printUnder(NUM-n)+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
		else sb.append(temp).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
		sb.append(temp).append("라고 답변하였지.\n");
//		System.out.println(printUnder(NUM-n)+"라고 답변하였지.");
	}
}
