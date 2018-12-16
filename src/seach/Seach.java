package seach;

import com.mo.sort.Sort;

/**
 * @author ����
 * @version 2017-11-27 ����9:20:11
 * 
 * 	����
 * 
 */
public class Seach {
	
	//�������в���
	public static int seqSeach(int[] a, int obj) {
		int index = 0;
		for (int i : a) {
			if(i == obj) {
				return index;
			}
			index++;
		}
		return -1;
	}

	//˳�����
	public static int orderSeqSearch(int[] a,int obj) {
		int i = 0;
		int n = a.length;
		while(i < a.length - 1 && obj > a[i]) i++;
		if(obj == a[i]) return i;
		else return -1;
	}
	
	//���ֲ���
	public static int bitSeach(int[] a,int obj) {

		int low = 0;
		int high = a.length - 1;
		int mid;

		while(low <= high) {
			mid = (low + high)/2;
			if(a[mid] == obj) return mid;
			else if (a[mid] < obj) low = mid + 1;
			else high = mid - 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {2,1,999,6,2,8,3,6,7,8,9,7,8,7,6,5,5,4,2,34,5,66,777,6,5,5,41};
		a = Sort.dubbleSortM(a);
		/*System.out.println(seqSeach(a, 41));
		System.out.println(a.length - 1);*/
		System.out.println(orderSeqSearch(a, 100000000));
		System.out.println(bitSeach(a, 777));
	}
	
}
