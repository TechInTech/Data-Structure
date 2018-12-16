package vector;

/**
 * @author ����
 * @version 2017-11-25 ����8:00:59
 * 
 * δ��
 * 
 */
public class MyVector {

	private Object[] elementData;//����Ԫ��
	private int elementCount;//Ԫ�ظ���
	
	//���캯��
	public MyVector() {
		this(10);
	}
	
	public MyVector(int size) {
		elementData = new Object[size];
		elementCount = 0; 
	}
	
	//��������
	public void ensureCapacity() throws Exception {
		Object[] newarr = new Object[elementData.length*2];
		arrayCopy(elementData, 0, newarr, 0, elementCount);
		this.elementData = newarr;
	}
	
	//��������
	private static void arrayCopy(Object[] src,int srcPos,Object[] dst,int dstPos,int length) throws Exception {
		if(srcPos < 0 || dstPos < 0 || dst.length - dstPos < length) throw new Exception(); 
		for(int i = 0; i < length; i++) {
			dst[dstPos++] = src[srcPos++];
		}
	}
	
	public void add(int index,Object obj) throws Exception {
		if(elementCount >= elementData.length) {
			ensureCapacity();
		}
		for(int i = 0; i < elementCount - index; i++) {
			elementData[elementCount] = elementData[elementCount - 1];
		}
		elementData[elementCount] = obj;
		elementData[elementCount] = obj;
		elementCount++;
	}
	
	public void add(Object obj) throws Exception {
		add(elementCount, obj);
	}
	
	//���ã����ر����õ�Ԫ��
	public Object set(int index,Object obj) {
		Object oldobj = elementData[index];
		elementData[index] = obj;
		return oldobj;
	}
	
	public Object get(int index) {
		return elementData[index];
	}
	
	public int getSize() {
		return elementCount;
	}
	
	public void myPrint() {
		for(int i = 0; i < elementCount; i++) {
			System.out.print(elementData[i].toString() + " ");
		}
		System.out.println();
	}
	
	
	/*----------------------���·�����Ϊ�˹���  ����  �������ķ���-----------------------------------*/

	//����
	public int indexOf(Object obj) {
		if(elementCount == 0) {
			return -1;
		}else {
			for(int i = 0; i < elementCount; i++) {
				if(elementData[i].equals(obj)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	//�Ƿ����
	public boolean contain(Object obj) {
		for(int i = 0; i < elementCount; i++) {
			if(elementData[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}
	
	//ɾ��Ԫ��
	public Object remove(Object obj) {
		for(int i = 0; i < elementCount; i++) {
			if(elementData[i].equals(obj)) {
				Object oldObj = elementData[i];
				int k = elementCount - i;
				//�������Ԫ���ƶ���ǰ��
				for(int j = 0; j < k; j++) {
					elementData[i] = elementData[i + 1];
					i++;
				}
				elementCount--;//Ԫ�صĸ�����һ
				return oldObj;
			}
		}
		return null;
	}
	
	//ɾ����index��Ԫ��
	public Object remove(int index) throws Exception {
		if(index < 0 || index >= elementCount) throw new Exception();
		Object oldObj = elementData[index];
		int removeCount = elementCount - index;
		for(int i = 0; i < removeCount ; i++) {
			//�������Ԫ���Ƶ�ǰ��
			elementData[index] = elementData[(index + 1)];
			index++;
		}
		elementData[elementCount - 1] = null;
		elementCount--;
		return oldObj;
	}
 	
	
	public static void main(String[] args) throws Exception {
		MyVector myVector = new MyVector();
		for(int i = 0; i < 8; i++) {
			myVector.add(new Integer(i + 1));
		}
		System.out.println("����" + myVector.getSize());
		myVector.myPrint();
		System.out.println("��ɾ����Ԫ��Ϊ" + myVector.remove(new Integer(3)));
		myVector.myPrint();
		System.out.println("����" + myVector.getSize());
		System.out.println("��ɾ����Ԫ��Ϊ" + myVector.remove(1));
		myVector.myPrint();
		System.out.println("����" + myVector.getSize());
		
		System.out.println("end");
		myVector.set(0, new Integer(9));
		System.out.println(myVector.get(0));
		//���Բ���ָ��Ԫ�ص��±� �� �����ǲ��ǰ���Ԫ��
		System.out.println(myVector.indexOf(new Integer(3)));
		System.out.println(myVector.contain(new Integer(18)));
		
		System.out.println(myVector.getSize());
		//����ɾ��Ԫ��
		System.out.println(myVector.remove(new Integer(3)));
		System.out.println(myVector.getSize());
		myVector.myPrint();
	}
	
}
