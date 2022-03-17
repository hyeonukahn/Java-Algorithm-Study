import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_BJ_1991_트리순회 {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		char[][] inputChar = new char[n][3];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < inputChar[i].length; j++) {
				inputChar[i][j] = st.nextToken().charAt(0);
			}
		}
		
		MyTreeNode[] mytree = new MyTreeNode[n];
		for (int i = 0; i < inputChar.length; i++) {
			mytree[i] = new MyTreeNode(inputChar[i][0]);
		}
		for (int i = 0; i < mytree.length; i++) {
			for (int j = 0; j < mytree.length; j++) {
				if(inputChar[i][1]==mytree[j].data) {
					mytree[i].lnode = mytree[j];
				}
				else if(inputChar[i][2]==mytree[j].data) {
					mytree[i].rnode = mytree[j];
				}
			}
		}
		
		preOrder(mytree[0]);
		sb.append("\n");
		inOrder(mytree[0]);
		sb.append("\n");
		postOrder(mytree[0]);
		sb.append("\n");
		
		System.out.println(sb);
		
//		System.out.println(Arrays.toString(mytree));
//		mytree[i] = new MyTreeNode(st.nextToken().charAt(0));
		br.close();
	}
	
	static void preOrder(MyTreeNode root) {
		if(root == null) return;
		sb.append(root.data);
		preOrder(root.lnode);
		preOrder(root.rnode);
	}
	static void inOrder(MyTreeNode root) {
		if(root == null) return;
		inOrder(root.lnode);
		sb.append(root.data);
		inOrder(root.rnode);
	}
	static void postOrder(MyTreeNode root) {
		if(root == null) return;
		postOrder(root.lnode);
		postOrder(root.rnode);
		sb.append(root.data);
	}
	
}

class MyTreeNode{
	char data;
	MyTreeNode lnode;
	MyTreeNode rnode;
	
	public MyTreeNode(char data) {
		this.data = data;
	}

	@Override
	public String toString() {
		if(lnode == null && rnode == null) {
			return "MyTreeNode [data=" + data + ", lnode="  + ", rnode=" + "]\n";
		}
		else if(lnode == null && rnode != null) {
			return "MyTreeNode [data=" + data + ", lnode="  + ", rnode=" + rnode.data + "]\n";
		} else if(lnode != null && rnode == null) {
			return "MyTreeNode [data=" + data + ", lnode=" + lnode.data + ", rnode=" + "]\n";
		} else {
			return "MyTreeNode [data=" + data + ", lnode=" + lnode.data + ", rnode=" + rnode.data+ "]\n";
		}
	}
	
	
}
