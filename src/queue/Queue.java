package queue;

/**
 * ���еĳ������ݽṹ
 *
 */
public interface Queue {
	/**
	 *	��� 
	 */
	void append(Object obj) throws Exception;
	/**
	 *	���� 
	 */
	Object delete() throws Exception;
	/**
	 * ȡ��ͷ
	 */
	Object getFront() throws Exception;
	/**
	 * �Ƿ�Ϊ��
	 */
	boolean isEmpty();
}
