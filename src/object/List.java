package object;

/**
 *  �̱߳�-->˳���ĳ������ݽṹ
 */
public interface List {
	/**
	 * ����
	 */
	void insert(int i, Object obj)throws Exception;
	/**
	 * ɾ��
	 */
	Object delete(int i)throws Exception;
	/**
	 * ȡ����Ԫ��
	 */
	Object getData(int i)throws Exception;
	/**
	 * ��Ԫ�ظ���
	 */
	int size();
	/**
	 * �Ƿ��
	 */
	boolean isEmpty();
}
