package recursion;

/**
 * @author ����
 * @version 2017-11-26 ����9:57:15
 * 
 * 	�ݹ��㷨
 */
public class A {

	public static int count = 0;
	
	//��׳�
	public static long fact(int i) throws Exception {
		int x;
		long y;
		if(i < 0) throw new Exception();
		if(i == 0) return 1;
		else {
			return y = i * fact(i - 1);
		}
	}
	
	//�۰���ҷ�
	public static int bSearch(int[] arr,int x,int low,int higth) throws Exception {
		if(low > higth) return -1;
		if(low < 0) return -1;
		int mid = (low + higth) / 2;
		if(x == arr[mid]){
			return mid;
		}else if(x < arr[mid]) {
			return bSearch(arr, x, low, mid - 1);
		}else {
			return bSearch(arr, x, mid + 1, higth);
		}
	}
	
	//��ŵ���ĵݹ飬���������
	public static void hanoi(int n,char from,char to,char helper) {
		//�ݹ��������
		if(n == 1) {
			move(from, to);
			return;
		}
		//��from�е�(n-1)���ƶ���helper�С�����to
		hanoi(n - 1, from, helper, to);
		//��from�еĵ�n���ƶ�to��
		move(from, to);
		//��helper�е�(n-1)���ƶ���to������from��
		hanoi(n - 1, helper, to, from);
	}
	//�ƶ�����
	private static void move(char from,char to) {
		++count;
		System.out.println(from + "-->" + to);
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
//		System.out.println(fact(3));
//		int[] arr = {4,5,6,7,8,9};
//		towers(20, 'A', 'B', 'C');
//		System.out.p rintln(bSearch(arr, 4, 0, arr.length - 1));
		hanoi(20, 'A', 'C', 'B');
		System.out.println(count);
	}
	
} 