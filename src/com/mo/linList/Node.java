package com.mo.linList;

public class Node {
	
	Object data;
	Node next;
	
	/**
	 *	����ͷ�ڵ� ��ͷ�ڵ���û�����ݵ�
	 */
	public Node(Node nextval) {
		this.next = nextval; 
	}
	/**
	 * ���������Ľڵ�
	 */
	public Node(Object data,Node next) {
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
	public void setNext(Node node) {
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
