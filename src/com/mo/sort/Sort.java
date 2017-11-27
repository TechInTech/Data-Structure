package com.mo.sort;

/**
 * @author ����
 * @version 2017-11-26 ����9:43:54
 * 
 * 	 ����	
 * 
 */
public class Sort {
	
	//ֱ�Ӳ�������
	public static int[] insertSort(int[] a) {
		
		//ȡ��temp��������ǰ�������Ԫ�ض��Ƚ�һ��
		int temp;
		
		//һ�����鹲�ж��ٸ�temp����Ϊ����ĵ�һ��Ԫ�ؿ���ֱ�Ӻ͵ڶ������бȽϣ�����ֱ���õڶ�����Ϊtemp 
		for(int i = 0; i < a.length - 1; i++) {
			temp = a[i + 1];
			int j = i;
			//��temp����ǰ�������Ԫ�رȽ�һ��
			while(j > -1 && temp <= a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			//��temp�Ž�
			a[j + 1] = temp;
		}
		return a;
	}

	//ѡ���� �� --->ֱ������
	public static int[] selectSort(int[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			//������С��Ԫ��
			int small = i;
			for(int j = i + 1; j < a.length; j++) {
				//�жϺ����Ԫ���Ƿ���С�ڵ�small��
				if(a[small] > a[j]) {
					//�еĻ��ͼ�ס�����±꣬���Ϊ��С
					small = j;
				}
			}
			int temp = a[i];
			a[i] = a[small];
			a[small] = temp;
		}
		return a;
	}
	
	//ð������
	public static int[] dubbleSortM(int[] a){
		
		int count = 0;//�ܽ�������
		
		int j = a.length - 1;//��Ҫ�����Ĵ�����ÿ��ð��һ����Ҫ�����Ĵ�������һ
		
		for(int k = 0; k < a.length; k++) {
			for(int i = 0; i < j; i++) {
				if(a[i] > a[i + 1]) {
					count++;
					int temp = a[i];
					a[i] = a[i + 1];
					a[i + 1] = temp;
				}
			}
			j--;
		}
		System.out.println("��������" + count + "��");
		return a;
	}

	//��������
	public static int[] quickSort(int[] a, int low, int high) {
		
		int i = low;//������ߵ�ֵ
		int j = high;//�����ұߵ�ֵ
		int temp = low;//����Ǳ�׼Ԫ�أ��������Աȵ�
		
		//һ����ѭ�����ȶԱ��ұߣ�������ֱ�tempС����ת��ȥ�Ա���ߡ��������ν��棬������ٽ�������i < j
		while(i <  j) {
			//�Ա��ұߣ�������������whileѭ����˵���ұ���Ԫ�ر�tempС�ˣ�Ҫ���н���
			while(i < j && temp <= a[j]) j--; 
			if(i < j) {
				//��ʱ����Ϊa[i]�е�ֵ��temp�и����ˣ����ԾͿ��԰Ѹո��Ǹ�  a[j](��tempС����) �ŵ�a[i]��
				a[i] = a[j];
				//������һ�д���a[i]�Ѿ����Ԫ���ˣ�iָ����һ���� --ע��:���ʱ��a[j]�е�Ԫ���Ѿ��ŵ�a[i]���ˣ�����  a[j] ���Է�Ԫ����
				i++;
			}

			/**
			 * �Ա���ߡ���ʱ��a[j]�ǿ��Է�Ԫ�صģ���a[i]��ȡ����temp���Ԫ�طŵ�a[j]��λ����
			 * 	����������while��˵��������a[i]��temp��ģ���Ҫ�ƶ����ұ�a[j]��λ��
			 */
			while(i < j && temp > a[i]) i++;
			if(i < j) {
				//��a[i]��Ԫ���ƶ���a[j]�У�a[i]��λ�ÿ��Է�Ԫ����(����temp)����ʱ���������ұ�����temp���Ԫ�طŵ�a[i]
				a[j] = a[i];
				//��ʱ��a[j]�Ѿ����Ԫ���ˣ���Ҫ�ƶ���ǰһλ
				j--;
			}
			
			a[i] = temp;
		}
		
		//һ����ѭ������ ��һ��  tmep ��ȫ����Ԫ�رȶ���ɡ����õݹ�  ��   temp�������ߵ�  ���������ͬ���ķ����������� 
		if(i > low) quickSort(a, low, i - 1);
		if(i < high) quickSort(a, i + 1, high);
		
		return a;
	}
	
	public static void main(String[] args) {
		int[] a = {2,1,7,6,2,8,3,6,7,8,9,7,8,7,6,5,5,4,2,34,5,66,777,6,5,5,41};
		/*int[] insertSort = insertSort(a);
		for (int i : insertSort) {
			System.out.print(i + " ");
		}*/
		
		System.out.println();
		
		/*int[] selectSort = insertSort(a);
		for (int i : selectSort) {
			System.out.print(i + " ");
		}*/
		
		System.out.println();
		
		/*int[] dubble = dubbleSortM(a);
		for (int i : dubble) {
			System.out.print(i + " ");
		}*/
		
		int[] quickSort = quickSort(a, 0, a.length - 1);
		for (int i : quickSort) {
			System.out.print(i + " ");
		}
		
	}

}
