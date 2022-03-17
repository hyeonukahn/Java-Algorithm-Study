import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_BJ_5639_이진검색트리 {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner sc = new Scanner(System.in);
		
		String str;
		ArrayList<Integer> treeDataList = new ArrayList<>();
		while((str = br.readLine()) != null) {
			if(str.equals("")) break;
			int dataIn = Integer.parseInt(str);
			treeDataList.add(dataIn);			
		}
		
//		while(sc.hasNextInt()){
//			treeDataList.add(sc.nextInt());
//		}
		
//		System.out.println(treeDataList);
		int treeNum = treeDataList.size();
		myBinTreeN[] myTree = new myBinTreeN[treeNum];
		myBinTreeN root = new myBinTreeN(treeDataList.get(0));
		myTree[0] = root;
		
		myBinTreeN node;
		int cnt = 0;
		for (int i = 0; i < myTree.length; i++) {
			int data = treeDataList.get(i);
			node = new myBinTreeN(data);
			
			if(i==0) {
				root = node;
				myTree[cnt++] = node;
				continue;
			}
			
			if (node.data < root.data) {
				root.lnode = node;
				node.pnode = root;
//				System.out.println(root);
				root = node;
				myTree[cnt++] = node;
//				System.out.println(root);
			} else {
				if(root.pnode == null || node.data < root.pnode.data ) {
					root.rnode = node;
					node.pnode = root;
					root = node;
					myTree[cnt++] = node;
					continue;
				}
				while(root.pnode != null){
					root = root.pnode;
					if(root.pnode != null && node.data < root.pnode.data ) {
						root.rnode = node;
						node.pnode = root;
						root = node;
						myTree[cnt++] = node;
						break;
					}
				}
//				System.out.println("root.pnode"+root.pnode);
				if(root.pnode == null) {
//					System.out.println("chkroot");
					root.rnode = node;
					node.pnode = root;
//					System.out.println(root);
//					System.out.println(node);
					root = node;
					myTree[cnt++] = node;
				}
			}
//			System.out.println("============");
		}
		for (int j = 0; j<myTree.length && myTree[j] != null; j++) {
			System.out.println(myTree[j]);
		}
//		System.out.println(myTree[0]);
		postOrder(myTree[0]);
		
		System.out.println(sb);
		
		
//		String str = br.readLine();
//		
//		
//		int rootn = Integer.parseInt(str);
//		ArrayList<myBinTreeN> myTree = new ArrayList<>();
//		myBinTreeN root = new myBinTreeN(rootn);
//		myTree.add(root);
////		int rootidx = 0;
//				
//		while((str = br.readLine()) != null) {
//			if(str.equals("")) break;
//			int num = Integer.parseInt(str);
//			myBinTreeN nNode = new myBinTreeN(num);
//			System.out.println(root);
//			if(num<rootn) {
//				nNode.pnode = root;
//				root.lnode = nNode;
//				root = nNode;
//				rootn = num;
//			} else {
////				while(root.pnode != null) {
////					if(root.pnode.data > num) {
////						root = root.pnode;
////					}
////				}
////				nNode.pnode = root.lnode;
////				root.lnode.rnode = nNode;
//			}
//		}
//		while(root.pnode != null) {
//			root = root.pnode;
//		}
//		
//		while(root.lnode != null) {
//			System.out.println(root);
//			root = root.lnode;
//		}
//		
//		
//		
		
		br.close();
//		sc.close();
	}
	
	static void postOrder(myBinTreeN root) {
		if(root == null) return;
		postOrder(root.lnode);
		postOrder(root.rnode);
		sb.append(root.data+"\n");
	}
	
	static class myBinTreeN{
		int data;
		myBinTreeN pnode;
		myBinTreeN lnode;
		myBinTreeN rnode;
		
		public myBinTreeN(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			if(lnode != null && rnode != null) {
				return "data : "+data+ " lnode : " + lnode.data + " rnode : " + rnode.data;
			}
			else if(lnode != null && rnode == null) {
				return "data : "+data+ " lnode : " + lnode.data + " rnode : ";
			}
			else if(lnode == null && rnode != null) {
				return "data : "+data+ " lnode : "  + " rnode : " + rnode.data;
			}
			else {
				return "data : "+data;
			}
		}
		
	}
}

