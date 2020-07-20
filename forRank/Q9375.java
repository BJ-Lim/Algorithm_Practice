package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q9375 {
	private static class FashionPerson{
		HashMap<String, Integer> hm;
		private int sum;
		
		public FashionPerson(){
			this.hm = new HashMap<String, Integer>();
			sum = 1;
		}
		
		public void add(String name){
			if(hm.containsKey(name)){
				hm.put(name, hm.get(name) + 1);
			} else {
				hm.put(name, 1);
			}
		}
		
		public int getCase(){
			//�������� �ʴ� ���� �ϳ��� ������ ����
			for(int value : hm.values()){
				sum *= (value + 1);
			}
			
			//��� �������� �ʴ� ���� ����
			return sum - 1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			FashionPerson fp = new FashionPerson();
			int n = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				fp.add(st.nextToken());
			}
			
			bw.write(fp.getCase() + "\n");
		}
		
		br.close();
		bw.close();
	}
}
