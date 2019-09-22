package sort;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Quick {
	public static void main(String[] args) {
		/*
		 * definition
		 * */
		Scanner scan = new Scanner(System.in);
		BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N;
		int arr[];
		
		/*
		 * inputs
		 * */
		N = scan.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		/*
		 * algorithm
		 * */
		quickSort(arr);
	
		for (int i = 0; i < N; i++) {
//			System.out.println(arr[i]);
			try {
				bf.write(arr[i] + "\n");
				bf.flush();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void quickSort(int[] arr){		//quick ����
		internalQuickSort(arr, 0, arr.length-1);
	}
	
	private static void internalQuickSort(int[] arr, int left, int right){		//quick���� ���� �޼ҵ�. ��͸� �̿�
		if(left > right)						//�����ε����� �� ū ��� ����
			return ;
		int p = partition(arr,left,right);			//p�� ��Ƽ���� ���� �ڿ� ���� �Ǻ��� �ε���
		internalQuickSort(arr, left, p-1);		//�պκ�
		internalQuickSort(arr, p+1, right);		//�޺κ�
	}
	
	private static int partition(int arr[], int left, int right){
		int tmp = arr[left];					//pivot�� �߰����� �ٲ㼭 ��� O(nlogn)�� �ǵ��� ��
		arr[left] = arr[(left + right) / 2];
		arr[(left + right) / 2] = tmp;
		int pivot = arr[left];		//�� ���� ���Ұ��� pivot���� ����
		
		
		int p = left;			//p�� �� ��Ƽ���� ��� �ε���
		
		for(int i=left+1;i<=right;i++){	//a[i+1] ~ a[j]�� �ִ� ��� ���Ҹ� �˻��Ͽ�
			if(arr[i] < pivot){		//a[k]�� pivot���� ������ 
				p++;				//p�� 1 �������� a[k]�� p�ε��� ���� ������ ���Եǰ� ��
				int temp = arr[p];	//a[p] �� a[k] ��ġ ��ȯ
				arr[p] = arr[i];
				arr[i] = temp;
			}
		}
				
		int temp = arr[left];		//a[i]�� a[p]��ġ ��ȯ
		arr[left] = arr[p];
		arr[p] = temp;
		
		return p;
	}
}


