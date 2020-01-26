package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2805 {
	private static final int TREE_HEIGHT_MAX = 1000000000;
	private static int N;	//���� ��
	private static int M;	//���� ���������� ������ ����
	private static int trees[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		//inputs
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		trees = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			trees[i] = Integer.parseInt(st.nextToken());
		
		//algorithm
		int low = 0;					//L
		int high = TREE_HEIGHT_MAX;		//R
		int mid = 0;					//M
		
		//�� ���������� (Ž���� < arr[0])�� ��츦 ������� �ʾƵ�, ������ ��ü�� ������ �����ϰ� �־���
		while(low <= high){
			mid = (low + high) / 2;
			long sum = 0;
			
			for (int i = 0; i < N; i++)
				sum += ((trees[i] <= mid) ? 0: trees[i] - mid);
			
			if(sum == M){			//���� Ž���� ������ ���. �� �̿� ���� ��� Ž�� ����
				high = mid;			//Ž�� ���н� high(R)�� ����ϹǷ�, ����� high�� ����
				break;
			} else if(sum > M){
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		bw.write(high + "\n");		//����� R��° �ε��� ���. �� ���������� �ε����� �ٷ� ���
		
		br.close();
		bw.close();
	}
}
