package com.mo.string;

/**
 *	���ӣ�����Ӵ���ɾ���Ӵ��ĳ�Ա�������ı�ԭ������Ĵ�ֵ
 */
public class MyStringBuffer {
	
	private char[] value;
	private int count;
	
	public MyStringBuffer(String str) {
		char[] charArray = str.toCharArray();
		this.value = charArray;
		this.count = charArray.length;
	}

	//�������������ڴ�ռ�
	private void expandCapacity(int newCapacity) {
		char[] newValue = new char[newCapacity];
		arrayCopy(this.value, 0, newValue, 0, this.count);
		value = newValue;
	}
	
	//��������Ԫ��
	public static void arrayCopy(char[] src,int srcPos,char[] dst,int dstPos,int length) {
		for(int i = 0; i < length; i++) {
			dst[dstPos] = src[srcPos];
			dstPos++;
			srcPos++;
		}
	}
	
	public MyStringBuffer concat(MyStringBuffer str) {
		int length = str.length();
		char[] array = str.toArray();
		expandCapacity(this.count + length);
		arrayCopy(array, 0, this.value, count, length);
		count = count + length;
		return this;
	}
	
	public char[] toArray() {
		return value;
	}
	
	public int length() {
		return count;
	}
	
	public void myPrint() {
		for(int i = 0; i < count; i++) {
			System.out.print(value[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		MyStringBuffer m1 = new MyStringBuffer("abcde");
		MyStringBuffer m2 = new MyStringBuffer("fdhij");
		MyStringBuffer m3 = m1.concat(m2);
		m3.myPrint();
		m1.myPrint();
		m2.myPrint();      
	}
	
}
