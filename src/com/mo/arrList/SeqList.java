package com.mo.arrList;

import org.junit.Test;

import com.mo.object.List;

/**
 *	����һ������ʵ�ֵ�����
 */
public class SeqList implements List {
	
	final int defaultSize = 10;//����Ĭ�ϴ����ĳ���
	int size;//�����Ԫ�ظ���
	int maxSize;//����ĳ���
	Object[] listArray;
	
	public SeqList() {
		init(defaultSize);
	}

	public SeqList(int maxSize) {
		init(maxSize);
	}

	/**
	 * ��ʼ���������
	 */
	private void init(int arrSize) {
		this.maxSize = arrSize;
		this.size = 0;
		this.listArray = new Object[arrSize];
	}
	
	public void insert(int i, Object obj) throws Exception {
		if(this.size == this.maxSize) {
			throw new Exception("�����Ѿ����ˣ������ٲ��Ԫ����");
		}
		if(i < 0) {
			throw new Exception("����Ĳ�������Ϊ������Ǹ���");
		}
		if(i > this.maxSize) {
			throw new Exception("����Ĳ������ܴ��ڸ�����ĳ���");
		}
		for(int j = size; j > i; j--) {
			listArray[j] = listArray[j-1];
		}
		listArray[i] = obj;
		size++;
	}

	public Object delete(int i) throws Exception {
		if(size == 0) {
			throw new Exception("˳����Ѿ�����");
		}
		if(i < 0) {
			throw new Exception("����Ĳ�������Ϊ������������");
		}
		if(i > maxSize) {
			throw new Exception("����Ĳ������ܴ�����������ֵ");
		}
		Object obj = listArray[i];
		for(int j = i; j < size - 1; j++) {
			listArray[j] = listArray[j+1];
		}
		size--;
		return obj;
	}

	public Object getData(int i) {
		return listArray[i];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) throws Exception {
		SeqList arrList = new SeqList();
		for (int i = 0; i < 10; i++) {
			arrList.insert(i, "Ԫ��" + i);
		}
		System.out.println("size" + arrList.size());
		System.out.println("�Ƿ�Ϊ��" + arrList.isEmpty());
		for(int j = 0; j<10; j++) {
			System.out.print("ȡ��Ԫ��" + arrList.getData(j));
		}
		System.out.println();
		for(int i = 0; i < 10; i++) {
			System.out.print("ɾ��Ԫ��" + arrList.delete(i));
		}
		System.out.println();
		System.out.println("size" + arrList.size());
		System.out.println("�Ƿ�Ϊ��" + arrList.isEmpty());
		
		System.out.println("----------------------");
		
		SeqList seqList = new SeqList();
		for(int i = 0; i < 10; i++) {
			seqList.insert(i, new Integer(i+1));
		}
		seqList.delete(4);
		for(int i = 0; i < seqList.size(); i++) {
			System.out.print(seqList.getData(i));
		}
	}
	
	
	@Test
	public void testA() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
