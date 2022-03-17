import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_5639_이진검색트리_2 {
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		ArrayList<Integer> treeDataList = new ArrayList<>();
		while((str = br.readLine()) != null) {
			if(str.equals("")) break;
			int dataIn = Integer.parseInt(str);
			treeDataList.add(dataIn);			
		}
		
		int treeNum = treeDataList.size();
		myBinTreeN root = new myBinTreeN(treeDataList.get(0));
		
		for (int i = 1; i < treeNum; i++) {
			myBinTreeN node = new myBinTreeN(treeDataList.get(i));
			insertTree(node, root);
		}
		
		postOrder(root);
		
		System.out.println(sb);
		
		br.close();
	}
	
	static void insertTree(myBinTreeN node, myBinTreeN root) {
		if(node.data>root.data) {
			if(root.rnode == null) {
				root.rnode = node;
			} else {
				insertTree(node, root.rnode);
			}
		} else {
			if(root.lnode == null ) {
				root.lnode = node;
			}
			else {
				insertTree(node, root.lnode);
			}
		}
}
	
	static void postOrder(myBinTreeN root) {
		if(root == null) return;
		postOrder(root.lnode);
		postOrder(root.rnode);
		sb.append(root.data+"\n");
	}
	
	static class myBinTreeN{
		int data;
		myBinTreeN lnode;
		myBinTreeN rnode;
		
		public myBinTreeN(int data) {
			this.data = data;
		}
	}
}

