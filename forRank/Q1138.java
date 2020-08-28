package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q1138 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int bigger[] = new int[N + 1];
		int order[] = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			bigger[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(order[j] == 0){			//�ڱ⺸�� ���� ����� �տ� ������ ��
					if(bigger[i] == 0){		//ū��� ���� ������Ű�� �״��
						order[j] = i;
						break;
					} else {				//���� ����Ű�� ū����� �� �ڸ��� ���ܳ���
						bigger[i]--;
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			bw.write(order[i] + " ");
		}
		bw.write("\n");
		
		br.close();
		bw.close();
	}
}
