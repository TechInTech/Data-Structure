package linList;

import com.mo.linList.Node;
import com.mo.object.List;

public class LinList implements List {

	private Node head;//ͷ�ڵ�
	private Node current;//��ǰ�Ľڵ�
	private int size;//��ǰԪ�صĸ���

	public LinList() {
		head = current = new Node(null);
		size = 0;
	}

	//��λ-->�����ȥ��ɾ����Ҫ��λ��ǰһ���ڵ�
	public void location(int i) throws Exception {
		if(i < -1 || i > size - 1) throw new Exception();
		//�������±�Ϊ��Ĳ��Ԫ�أ�ֱ��return���У����ǵ�ǰ�Ľڵ���head���ͻ�ֱ����head�ĺ�����в��
		if(i == -1) return;
		current = head.next;
		int j = 0;
		while((current.next != null) && j < i) {
			current = current.next;
			j++;
		}
		//��������Ѿ��Ƕ�λ�ɹ��ˣ�current�Ľڵ����������iֵ��λ����(�����i�Ǳ���±꣬���㿪ʼ��)
	}

	public void insert(int i, Object obj) throws Exception {
		//��Ϊ���ǿ��Բ嵽��������һ��Ԫ�أ����������ǲ�ͬ��һ�ģ�ɾ���Ļ��Ͳ�һ���ˣ���Ϊ������һ���±�Ϊsize��Ԫ��
		if(i < 0 || i > size) throw new Exception();
		location(i - 1);
		Node node = new Node(obj,current.next);
		current.setNext(node);
		size++;
	}

	public Object delete(int i) throws Exception {
		if(i < 0 || i > size - 1) throw new Exception();
		//ɾ�������Ƕ�λ��current����һλ��
		location(i - 1);
		//�����current��Ҫɾ��Ԫ�ص���һ���ڵ㣬��Ϊ�������λ��Ҫɾ����Ԫ�صĻ���Ҫ������һ���ڵ㣬��������ǵ���������ȡ����һ���ڵ�
		Object delObj = current.next.getData();
		current.setNext(current.next.next);
		size--;
		return delObj;
	}

	public Object getData(int i) throws Exception {
		if(i < -1 || i > size - 1) throw new Exception();
		location(i);
		return current.getData();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) throws Exception {
		com.mo.linList.LinList linList = new com.mo.linList.LinList();
		for(int i = 0; i < 10; i++) {
			linList.insert(i, i + 1);
		}
		linList.delete(4);
		for(int i = 0; i < linList.size(); i++) {
			System.out.print(linList.getData(i));
		}
	}

}
