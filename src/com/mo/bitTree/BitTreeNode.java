package com.mo.bitTree;

/**
 * @author ����
 * @version 2017-11-26 ����2:52:32
 * 
 * 	�������ڵ��ࡣһ���������һ���ڵ�
 * 
 */
public class BitTreeNode {
	
	private BitTreeNode leftChild;//���ӽڵ���������
	private BitTreeNode rigthChild;//�Һ��ӽڵ���������
	private Object data;//����Ԫ��
	
	//���ڴ�����ͷ�ڵ��
	public BitTreeNode() {
		leftChild = null;
		rigthChild = null;
	}
	
	//���ڴ�������ͷ�ڵ��
	public BitTreeNode(Object data,BitTreeNode leftChild,BitTreeNode rigthChild) {
		this.leftChild = leftChild;
		this.rigthChild = rigthChild;
		this.data = data;
	}
	
	public BitTreeNode getLeft() {
		return leftChild;
	}
	public BitTreeNode getRight() {
		return rigthChild;
	}
	public Object getData() {
		return data;
	}
	
}