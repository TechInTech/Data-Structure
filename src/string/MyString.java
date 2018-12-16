package string;

/**
 *	���ݴ��ĳ����������ͣ�Ӧ�������ֹ��ܵĴ�:
 *		һ��Ҫ����:�κζԴ������ӣ������Ӵ���ɾ���Ӵ����� ���� ���ı�ԭ������ֵ��
 *		��һ��Ҫ����: �κζԴ������ӣ������Ӵ���ɾ���Ӵ����� ���� �ı�ԭ������ֵ
 *
 *	java�У�String���ǵ�һ�ֹ��ܵ��࣬StringBuffer���ǵڶ��й��ܵ���
 *
 *	JDK�Ĵ���
 *		String���StringBuffer�඼�ǻ����ַ�����ʵ�ֵģ�
 *		��ͬ���ǣ�String��Ĵ�һ��������������ֵ���޷��ı�ģ�����һ��״̬���ɱ�Ķ���
 *			��StringBuffer��Ĵ������󣬴���ֵ�ǿ��Ըı�ģ����StringBuffer��Ķ���ĳ����ǿ��Ըı��
 */
public class MyString {
	
	private char[] value;//�ַ�����
	private int count;//�ַ�����

	public MyString() {
		value = new char[0];
	}

	//�Դ�������value�ַ�����ָ���ȡ  value[offset] ��   value[offset+count]
	public MyString(char[] value,int offset,int count) {
		if(offset < 0) throw new StringIndexOutOfBoundsException();
		if(count > value.length - offset) throw new StringIndexOutOfBoundsException();
		if(count < 0) throw new StringIndexOutOfBoundsException();
		//����һ���յ��ַ�����
		this.value = new char[count];
		this.count = count;
		//���յ��ַ���������
		arrayCopy(value, offset, this.value, 0, count);
	}
	
	public MyString(char[] arr) {
		this.count = arr.length;
		//����һ���յ��ַ�����
		this.value = new char[count];
		//��������������arr���ŵ�this.value�У���Ϊ��ʱ��this.value���ǿյ�
		arrayCopy(arr, 0, this.value, 0, count);
	}
	
	public MyString(String str) {
		char[] charArray = str.toCharArray();
		this.value = charArray;
		count = this.value.length;
	}
	
	/**
	 * �������� 
	 * @param src ԭ����
	 * @param srcPos ��ԭ�����srcPos�±꿪ʼ���ƣ�����length������
	 * @param dst Ŀ������
	 * @param dstPos ��Ŀ�������dstPos�±꿪ʼ����ԭ�����Ԫ�أ�����length������
	 * @param length Ҫ����ԭ����ĳ���
	 */
	static void arrayCopy(char[] src,int srcPos,char[] dst,int dstPos,int length) {
		//�����Ƿ�ֹ����Խ��
		if(src.length - srcPos < length && dst.length - dstPos < length) throw new StringIndexOutOfBoundsException();
		for(int i = 0;i < length;i++) { 
			dst[dstPos] = src[srcPos];
			srcPos++;
			dstPos++;
		}
	}
	
	//ȡ�ַ�
	public char charAt(int index) {
		if(index < 0 || index > this.value.length) throw new StringIndexOutOfBoundsException();
		return this.value[index];
	}
	
	//ȡ���ĳ���
	public int length() {
		return count;
	}
	
	//ȡ�Ӵ�
	public MyString subString(int begin, int end) {
		if(begin < 0 || end < 0 || end < begin || end > this.value.length) throw new StringIndexOutOfBoundsException();
		return new MyString(value,begin,end - begin);
	}
	
	//ȡ�Ӵ�����beginһֱ������
	public MyString subString(int begin) {
		return subString(begin, count);
	}
	
	//�����ַ���
	public MyString concat(MyString str) {
		int length = str.length();
		char[] array = str.toArray();
		//����һ���յ��ַ�����
		char[] newchar = new char[(length+count)];
		//���ַ���������
		arrayCopy(this.value, 0, newchar, 0, count);
		arrayCopy(array, 0, newchar, count, length);
		return new MyString(newchar);
	}

	//����Ӵ��������ӵ��ַ���str��ԭ�����ַ���posλ�����
	public MyString insert(MyString str, int pos) {
		if(pos < 0 || pos > count) throw new StringIndexOutOfBoundsException();
		if(pos != 0) {
			MyString s1 = this.subString(0, pos);
			MyString s2 = this.subString(pos);
			MyString c1 = s1.concat(str);
			MyString c2 = c1.concat(s2);
			return c2;
		}else {
			return this.concat(str);
		}
	}

	//ɾ���Ӵ�
	public MyString delete(int begin, int end) {
		if(end < begin || begin < 0 || end > count ) throw new StringIndexOutOfBoundsException();
		if(begin == 0 && end == 0) {
			return new MyString();
		}else {
			MyString s1 = this.subString(0, begin);
			MyString s2 = this.subString(end);
			return s1.concat(s2);
		}
	}
	
	//��ӡ�ַ���
	public void myPrint() {
		for(int i = 0; i < count; i++) {
			System.out.print(value[i]);
		}
		System.out.println();
	}
	
	public char[] toArray() {
		//����һ���յ��ַ�����
		char[] buf = new char[count];
		//������һ���Ͱ��½����ַ�����������
		arrayCopy(this.value, 0,buf ,0, count);
		return buf;
	}
	
	public static void main(String[] args) {
		char[] s1 = {'a','b','c','d','e','g'};
		char[] s2 = {'a','b','c','d','e','g','a','b','c','d','g','a','b','g','a','b'};
		
		MyString m1 = new MyString();
		m1.myPrint();

		MyString m2 = new MyString(s1);
		m2.myPrint();
		
		System.out.println("-------------");
	
		MyString m3 = new MyString(s2, 2, 7);
		m3.myPrint();
		System.out.println(m3.charAt(2));
		System.out.println(m3.length());
		System.out.println("end");

		System.out.println("-------------");
		
		MyString m4 = new MyString(s2);
		m4.myPrint();
		m4.subString((m4.length() - 3)).myPrint();
		
		m4.subString(0, 3).myPrint();
		
		System.out.println("------------------");
		
		MyString m5 = m4.subString(m4.length() - 3);
		MyString m6 = m4.subString(m4.length() - 4);
		m5.myPrint();
		m6.myPrint();
		MyString m7 = m5.insert(m6, 1);
		m7.delete(1, 3).myPrint();
	}
	
}
