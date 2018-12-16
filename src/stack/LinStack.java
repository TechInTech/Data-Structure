package stack;

import com.mo.linList.Node;
import com.mo.stack.Stack;

//����ʵ�ֵĶ�ջ
public class LinStack implements Stack{

	private Node head;//ջ��
	private int size;//ջ�е�Ԫ�ظ���
	
	public LinStack() {
		head = null;
		size = 0;
	}
	
	public void push(Object obj) throws Exception {
		Node node = new Node(obj,head);//���׽ڵ����������obj����
		head = node;//��Ϊ��ǰ�ڵ�
		size++;
	}

	public Object pop() throws Exception {
		if(size == 0) throw new Exception();
		Object oldHead = head.getData();//��ȡ�׽ڵ��Ԫ������
		head = (Node)head.getNext();//���������һ��Node��Ϊ��ǰ�ڵ�
		size--;
		return oldHead;
	}

	public Object getTop() throws Exception {
		if(size == 0) throw new Exception();
		return head.getData();
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) throws Exception {
		com.mo.stack.LinStack linStack = new com.mo.stack.LinStack();
		for(int i = 0; i < 10; i++) {
			linStack.push(i+1);
		}
		while(!linStack.isEmpty()) {
			System.out.print(linStack.pop());
		}
	}
	

}
