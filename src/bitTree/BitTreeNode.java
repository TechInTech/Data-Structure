package bitTree;

/**
 * @author ����
 * @version 2017-11-26 ����2:52:32
 * 
 * 	�������ڵ��ࡣһ���������һ���ڵ�
 * 
 */
public class BitTreeNode {
	
	private com.mo.bitTree.BitTreeNode leftChild;//���ӽڵ���������
	private com.mo.bitTree.BitTreeNode rigthChild;//�Һ��ӽڵ���������
	private Object data;//����Ԫ��
	
	//���ڴ�����ͷ�ڵ��
	public BitTreeNode() {
		leftChild = null;
		rigthChild = null;
	}
	
	//���ڴ�������ͷ�ڵ��
	public BitTreeNode(Object data, com.mo.bitTree.BitTreeNode leftChild, com.mo.bitTree.BitTreeNode rigthChild) {
		this.leftChild = leftChild;
		this.rigthChild = rigthChild;
		this.data = data;
	}
	
	public com.mo.bitTree.BitTreeNode getLeft() {
		return leftChild;
	}
	public com.mo.bitTree.BitTreeNode getRight() {
		return rigthChild;
	}
	public Object getData() {
		return data;
	}
	
}