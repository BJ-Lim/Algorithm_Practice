package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q2217 {
	private static final int MAX_VALUE = 10000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int histogram[] = new int[MAX_VALUE + 1];
		int maxWeightSum = 0;
		
		//inputs
		for (int i = 0; i < N; i++)
			histogram[Integer.parseInt(br.readLine())]++;
		
		//histogram = �ڿ������� histogram�� ���������� ����
		for (int i = MAX_VALUE - 1; i > 0; i--)
			histogram[i] += histogram[i + 1];
			
		for (int i = 1; i <= MAX_VALUE; i++)
			maxWeightSum = Math.max(maxWeightSum, histogram[i] * i);
		
		bw.write(maxWeightSum + "\n");
		
		br.close();
		bw.close();
	}
}
