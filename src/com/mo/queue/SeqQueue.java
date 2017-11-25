package com.mo.queue;

/**
 * 	˳��ѭ�����У�����ʵ�֣�
 */
public class SeqQueue implements Queue {

	private final static int DEFAULTSIZE = 10;//Ĭ�ϴ����������С
	private int front;//��ͷ���±� 
	private int rear;//��β���±�
	private int count;//���е�Ԫ�ظ���
	private int maxSize;//�����ܱ�������Ԫ�ظ���
	Object[] data;//���ֶ���Ԫ�ص�����
	
	public SeqQueue() {
		init(DEFAULTSIZE);
	}
	public SeqQueue(int size) {
		init(size);
	}
	
	private void init(int size) {
		maxSize = size;
		data = new Object[size];
		count = 0;
		front = 0;
		rear = 0;
	}
	
	// ��� --> ��һ��Ԫ���ڶ�β��rearҪ��һ��countҪ��һ
	public void append(Object obj) throws Exception {
		if(count == maxSize) throw new Exception();
		data[rear] = obj;
		rear = (rear + 1) % maxSize;
		count++;
	}

	// ���� --> �Ӷ�ͷɾ��һ��Ԫ�أ�frontҪ��һ��count��һ
	public Object delete() throws Exception {
		if(count == 0) throw new Exception();
		Object obj = data[front];
		front = (front + 1) % maxSize;
		count--;
		return obj;
	}

	public Object getFront() throws Exception {
		if(count == 0) throw new Exception();
		return data[front];
	}

	public boolean isEmpty() {
		return count == 0;
	}
	
	public static void main(String[] args) throws Exception {
		SeqQueue seqQueue = new SeqQueue();
		for(int i = 0;i < 10; i++) {
			//���
			seqQueue.append(i + 1);
		}
		while(!seqQueue.isEmpty()) {
			//����
			System.out.print(seqQueue.delete());
		}
	}

}
