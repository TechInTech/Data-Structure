package com.mo.stack;

public class SeqStack implements Stack {
	
	private final static int defaultSize = 10;//Ĭ�ϴ����������С
	private int top;//ջ����Ԫ�ص��±�
	private Object[] stack;//ջ����
	private int maxStackSize;//���������
	
	public SeqStack() {
		init(defaultSize);
	}
	public SeqStack(int size) {
		init(size);
	}
	private void init(int size) {
		stack = new Object[size];
		top = 0;
		maxStackSize = size;
	}
	public void push(Object obj) throws Exception {
		if(top == maxStackSize) throw new Exception();
		stack[top] = obj;
		top++;
	}
	public Object pop() throws Exception {
		if(top == 0) throw new Exception();
		Object obj = stack[top - 1];
		top--;
		return obj;
	}
	public Object getTop() throws Exception {
		if(top < 0) throw new Exception();
		return stack[top - 1];
	}
	public boolean isEmpty() {
		return top == 0;
	}
	public static void main(String[] args) throws Exception {
		SeqStack seqStack = new SeqStack();
		for(int i = 0; i < 10; i++) {
			seqStack.push(i);
		}
		while(!seqStack.isEmpty()) {
			System.out.print(seqStack.pop());
		}
	}
}
