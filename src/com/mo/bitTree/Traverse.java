package com.mo.bitTree;

import java.util.Stack;

import com.mo.queue.LinQueue;


/**
 * @author ����
 * @version 2017-11-26 ����3:24:18
 * 
 *   ����������
 *   
 */
public class Traverse {

	//ǰ����������������ʽڵ�Ĳ�����vs.print(t.data);
	public static void preOrder(BitTreeNode t,Visit vs) {
		if(t != null) {
			vs.print(t.getData());
			preOrder(t.getLeft(), vs);
			preOrder(t.getRight(), vs);
		}
	}
	
	//�������������
	public static void inOrder(BitTreeNode t,Visit vs) {
		if(t != null) {
			inOrder(t.getLeft(), vs);
			vs.print(t.getData());
			inOrder(t.getRight(), vs);
		}
	}
	
	//�������������
	public static void postOrder(BitTreeNode t,Visit vs) {
		if(t != null) {
			postOrder(t.getLeft(), vs);
			postOrder(t.getRight(), vs);
			vs.print(t.getData());
		}
	}
	
	//������ʶ�����
	public static void levelOrder(BitTreeNode t,Visit vs) throws Exception {
		LinQueue q = new LinQueue();
		if(t == null) return;
		BitTreeNode curr;
		q.append(t);//�����ڵ��������
		while(! q.isEmpty()) {
			curr = (BitTreeNode) q.delete();//�����еĵ�һ��Ԫ���ó�����Ȼ�������ٷ����������ҽڵ�
			vs.print(curr.getData());//��ӡ�ո�ȡ������Ԫ��
			if(curr.getLeft() != null) {
				q.append(curr.getLeft());//����ڵ��������
			}
			if(curr.getRight() != null) {
				q.append(curr.getRight());//���ҽڵ�������С� --> ���������ҽڵ�һ�����ֵܽڵ�
			}
		} 
	}
	
	//��ӡ������,
	public static void printBitTree(BitTreeNode root,int level) {
		if(root != null) {
			printBitTree(root.getRight(), level + 1);

			if(level != 0) {
				for(int i = 0; i < 6 * (level - 1); i++) {
					System.out.print(" ");
				}
				System.out.print("----");
			}
			System.out.println(root.getData());
			
			printBitTree(root.getLeft(), level + 1);
			
		}
	}
	
	//��������Ԫ��
	public static BitTreeNode search(BitTreeNode t,Object obj) {
		BitTreeNode temp;
		
		if(t == null) return null;
		if(t.getData() == obj) return t;
		
		if(t.getLeft() != null) {
			temp = search(t.getLeft(), obj);
			if(temp != null) return temp; 
		}
		
		if(t.getRight() != null){
			temp = search(t.getRight(), obj);
			if(temp != null) return temp; 
		}
		return null;
	}
	
	//ʹ�÷ǵݹ�ķ���ǰ�����������
	public static void preOrderNoRecur(BitTreeNode root) {
		if(root == null) return;
		Stack<BitTreeNode> stack = new Stack<BitTreeNode>();
		BitTreeNode cur = root;
		stack.push(root);
		while(!stack.isEmpty()) {
			cur = stack.pop();
			System.out.print(cur.getData() + " ");
			if(cur.getRight() != null) stack.push(cur.getRight());
			if(cur.getLeft() != null) stack.push(cur.getLeft());
		}
	}
	
	//ʹ�÷ǵݹ�ĺ������
	public static void postOrderNoRecur(BitTreeNode root) {
		
	}
	
	
	public static void m1(BitTreeNode root) {
		
	}
	
	public static void main(String[] args) throws Exception {
		//����һ�Ŷ��������ֱ𹹽�����������ƴ�ӵ����ڵ���
		BitTreeNode g = new BitTreeNode("g",null,null);
		BitTreeNode d = new BitTreeNode("d",null,g);
		BitTreeNode b = new BitTreeNode("b",d,null);
		
		BitTreeNode e = new BitTreeNode("e",null,null);
		BitTreeNode f = new BitTreeNode("f",null,null);
		BitTreeNode c = new BitTreeNode("c",e,f);
		
		//���ڵ�
		BitTreeNode a = new BitTreeNode("a",b,c);
		//��ӡ������
		Traverse.printBitTree(a, 0);
		//�ֱ� �ȣ��У��󣬲� ����������
		Visit vs = new Visit();
		System.out.print("��");
		Traverse.preOrder(a, vs);
		System.out.println();
		System.out.print("��");
		Traverse.inOrder(a, vs);
		System.out.println();
		System.out.print("�� ");
		Traverse.postOrder(a, vs);
		System.out.println();
		System.out.print("��");
		Traverse.levelOrder(a, vs);
		System.out.println();
		System.out.print("������ֵ");
		BitTreeNode search = Traverse.search(a, "a");
		System.out.println(search.getData());
		System.out.println("ʹ�÷ǵݹ��ǰ�����");
		preOrderNoRecur(a);
	}	
}
