package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ConferenceRoom {

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N;
		int start[];
		int end[];
		int curTime = 0;
		int rs = 0;

		/*
		 * inputs
		 */
		N = Integer.parseInt(br.readLine());
		start = new int[N];
		end = new int[N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			start[i] = Integer.parseInt(str.split(" ")[0]);
			end[i] = Integer.parseInt(str.split(" ")[1]);
		}

		quickSort(end, start);

		for (int i = 0; i < N; i++) {
			if (start[i] < curTime)
				continue;
			
			int minIndex = i;
			for (int j = i; j < N; j++) {
				if (end[i] != end[j])
					break;
				if (start[j] < start[i]){
					minIndex = j;
				}
					
			}
			int temp = start[minIndex];
			start[minIndex] = start[i];
			start[i] = temp;
			
			curTime = end[i];
			rs++;
		}
		

		bw.write(rs + "\n");
		bw.flush();
	}

	private static void quickSort(int[] start, int[] end) { // quick ����
		internalQuickSort(start, end, 0, start.length - 1);
	}

	private static void internalQuickSort(int[] start, int[] end, int left, int right) { // quick����
																							// ����
																							// �޼ҵ�.
																							// ��͸�
																							// �̿�
		if (left > right) // �����ε����� �� ū ��� ����
			return;
		int p = partition(start, end, left, right); // p�� ��Ƽ���� ���� �ڿ� ���� �Ǻ��� �ε���
		internalQuickSort(start, end, left, p - 1); // �պκ�
		internalQuickSort(start, end, p + 1, right); // �޺κ�
	}

	private static int partition(int start[], int end[], int left, int right) {
		int tmp = start[left]; // pivot�� �߰����� �ٲ㼭 ��� O(nlogn)�� �ǵ��� ��
		start[left] = start[(left + right) / 2];
		start[(left + right) / 2] = tmp;
		tmp = end[left];
		end[left] = end[(left + right) / 2];
		end[(left + right) / 2] = tmp;

		int pivot = start[left]; // �� ���� ���Ұ��� pivot���� ����

		int p = left; // p�� �� ��Ƽ���� ��� �ε���

		for (int i = left + 1; i <= right; i++) { // a[i+1] ~ a[j]�� �ִ� ��� ���Ҹ�
													// �˻��Ͽ�
			if (start[i] < pivot) { // a[k]�� pivot���� ������
				p++; // p�� 1 �������� a[k]�� p�ε��� ���� ������ ���Եǰ� ��
				int temp = start[p]; // a[p] �� a[k] ��ġ ��ȯ
				start[p] = start[i];
				start[i] = temp;
				temp = end[p];
				end[p] = end[i];
				end[i] = temp;
			}
		}

		int temp = start[left]; // a[i]�� a[p]��ġ ��ȯ
		start[left] = start[p];
		start[p] = temp;
		temp = end[left];
		end[left] = end[p];
		end[p] = temp;

		return p;
	}

}
