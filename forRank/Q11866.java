package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			ll.addLast(i);
		}
		
		int index = 0;
		
		bw.write("<");
		while(ll.size() > 1){
			index += (K - 1);	//ù��°�� N��° ���̹Ƿ� 1�� ���ְ�, �������� ���粨�� �������Ƿ� 1�� ����
			index %= ll.size();
			
			bw.write(ll.remove(index) + ", ");
		}
		bw.write(ll.removeFirst() + ">\n");		
		
		br.close();
		bw.close();
	}
}
