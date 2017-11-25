package com.mo.queue;

import com.mo.linList.Node;

/**
 * ���У��б�ʵ�� 
 */
public class LinQueue implements Queue {

	private Node front;//��ͷ
	private Node rear;//��β
	private int count;//������
	
	public LinQueue() {
		front = rear = null;
		count = 0;
	}
	
	public void append(Object obj) throws Exception {
		Node newNode = new Node(obj,null);
		if(rear != null) {
			//�ڱ����Ķ�β�����µĶ�β
			rear.setNext(newNode);
		}
		//���л�û��Ԫ��
		if(front == null) {
			front = newNode;
		}
		//���õ�ǰ��β
		rear = newNode;
		count++;
	}
	public Object delete() throws Exception {
		if(count == 0) throw new Exception();
		Object obj = front.getData();
		front = (Node)front.getNext();
		count--;
		return obj;
	}
	
	public Object getFront() throws Exception {
		return front.getData();
	}
	public boolean isEmpty() {
		return count == 0;
	}
	
	public static void main(String[] args) throws Exception {
		LinQueue linQueue = new LinQueue();
		for(int i = 0; i < 10; i++) {
			//���
			linQueue.append(i + 1);
		}
		System.out.println("�Ӷ���ȡԪ��" + linQueue.getFront());
		System.out.println("�Ӷ���ȡԪ��" + linQueue.getFront());
		while(!linQueue.isEmpty()) {
			//����
			System.out.print(linQueue.delete());
		}
	}
	
}
