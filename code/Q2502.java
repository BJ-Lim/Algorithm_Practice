package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());	//�Ѿ�� �� ��
		int K = Integer.parseInt(st.nextToken());	//���� ����
		int a = 1;	//A�� ���
		int b = 1;	//B�� ���

		for (int i = 4; i <= D; i++) {
			int temp = b;
			b = a + b;
			a = temp;
		}
		
		for (int B = 1; b * B <= K; B++) {
			for (int A = 1; A <= B; A++) {
				if(a * A + b * B == K){
					bw.write(A + "\n" + B + "\n");
					bw.close();
					br.close();
					return;
				}
			}
		}
	}
}
