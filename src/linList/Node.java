package linList;

public class Node {
	
	Object data;
	com.mo.linList.Node next;
	
	/**
	 *	����ͷ�ڵ� ��ͷ�ڵ���û�����ݵ�
	 */
	public Node(com.mo.linList.Node nextval) {
		this.next = nextval; 
	}
	/**
	 * ���������Ľڵ�
	 */
	public Node(Object data, com.mo.linList.Node next) {
		this.data = data;
		this.next = next;
	}
	/**
	 * ��ȡ�ýڵ����һ��
	 */
	public Object getNext() {
		return next;
	}
	/**
	 * ���øýڵ����һ��Node
	 */
	public void setNext(com.mo.linList.Node node) {
		this.next = node;
	}
	/**
	 * ȡ���ýڵ������
	 */
	public Object getData() {
		return data;
	}
	/**
	 *	���øýڵ������
	 */
	public void setData(Object data) {
		this.data = data; 
	}
	public String toString() {
		return data.toString();
	}
}
