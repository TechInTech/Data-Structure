package stack;

/**
 * 	����ջ�Ľӿڣ�������������
 */
public interface Stack {
	/**
	 *	��ջ 
	 */
	void push(Object obj) throws Exception;
	/**
	 * ��ջ 
	 */
	Object pop() throws Exception;
	/**
	 *	ȡ��ջ��Ԫ�� 
	 */
	Object getTop() throws Exception;
	/**
	 *	ջ�ǲ���Ϊ�� 
	 */
	boolean isEmpty();
}
