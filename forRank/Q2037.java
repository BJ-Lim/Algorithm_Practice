package forRank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2037 {
	private static final char panel[] = {' ', ' ', 'A', 'D', 'G', 'J', 'M', 'P', 'T', 'W'};	//32 65~
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());	//�ѹ� �����µ� �ɸ��� �ð�
		int w = Integer.parseInt(st.nextToken());	//���� ���� ���� ������ ������� ��ٸ��� �ð�
		String string = br.readLine();
		
		int prevIndex = 0;
		int totalTime = 0;
		
		for (int i = 0; i < string.length(); i++) {
			char cur = string.charAt(i);
			
			for (int j = panel.length - 1; j > 0; j--) {
				if( cur >= panel[j] ){
					if(prevIndex == j && prevIndex != 1)
						totalTime += w;
					prevIndex = j;
					
					int dist = cur - panel[j] + 1;
					
					totalTime += dist * p;
					break;
				}
			}
		}
		
		bw.write(totalTime + "\n");
		
		br.close();
		bw.close();
	}
}
