package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Q1786 {
	private static String T, P;
	private static int t, p;
	private static int dpP[];
	
	private static void setDpP(){
		int j = 0;
		
		/*
		 * 		A	B	A	B	A	B	C	<< ���ڿ�
		 * 		0
		 * 	1		A	B	A	B	A	B	<< �κй��ڿ�
		 * 			X
		 * 	2			A	B	A	B	A
		 * 				1
		 * 	3				2
		 * 	4					3
		 * 	5						4				
		 *								X	<<while �ݺ������� �ϳ��� ���ư�
		 *
		 * 	X : ���� ��ȭ�� ��� 0���� ���õ�		
		 * */
		
		for (int i = 1; i < p; i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j))
				j = dpP[j - 1];
			
			if(P.charAt(i) == P.charAt(j))
				dpP[i] = ++j;
		}
	}
	
	private static ArrayList<Integer> getResult(){
		ArrayList<Integer> rs = new ArrayList<Integer>();
		
		int j = 0;
		
		for (int i = 0; i < t; i++) {
			while(j > 0 && T.charAt(i) != P.charAt(j))
				j = dpP[j - 1];
			
			if(T.charAt(i) == P.charAt(j)){
				if(j == p - 1){
					rs.add(i - p + 2);	//1 => �ε����� 1���� ����, 1 => ������ġ = ���� �ε��� - (���� - 1)
					j = dpP[j];
				} else {
					j++;
				}
			}
		}
		
		return rs;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = br.readLine();
		P = br.readLine();
		t = T.length();
		p = P.length();
		
		dpP = new int[p];
		setDpP();
		
		ArrayList<Integer> result = getResult();
		
		bw.write(result.size() + "\n");
		for(int i : result)
			bw.write(i + "\n");
		
		br.close();
		bw.close();
	}
}
