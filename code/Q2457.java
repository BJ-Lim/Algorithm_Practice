package olympiad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2457 {
	private static class Date {
		static int lastDay[] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
		int startSerial;
		int endSerial;
		
		public Date(int startMonth, int startDay, int endMonth, int endDay){
			startSerial = convertToSerial(startMonth, startDay);
			endSerial = convertToSerial(endMonth, endDay);
		}
		
		public static int convertToSerial(int month, int day){	//����, �� ��¥�� ����ȭ��
			return lastDay[month - 1] + day;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Date dates[] = new Date[366];
		int N = Integer.parseInt(br.readLine());
		int flowersCounter = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			
			int startSerial = Date.convertToSerial(startMonth, startDay);
			if(dates[startSerial] == null			// ���� ���� ���� �������� �� ����� ����
					|| dates[startSerial].endSerial < Date.convertToSerial(endMonth, endDay))
				dates[startSerial] = new Date(startMonth, startDay, endMonth, endDay);
		}
		
		Date curDate = new Date(1,1,1,2);
		
		//1.1~3.1�� �������� ���� �� ��带 ã��
		for (int i = Date.convertToSerial(1, 1); i <= Date.convertToSerial(3, 1); i++) {
			if(dates[i] != null){
				if(dates[i].endSerial > curDate.endSerial)
					curDate = dates[i];
			}
		}
		
		if(curDate != null){
			while(true){
				int startSerial = curDate.startSerial;
				int endSerial = curDate.endSerial;
				
				for (int i = startSerial; i <= endSerial; i++) {	//���� ��� ����
					if(dates[i] != null){
						if(dates[i].endSerial > curDate.endSerial)
							curDate = dates[i];
					}
				}
				flowersCounter++;
				if(endSerial > Date.convertToSerial(11, 30))		//���� ����� �������� 11�� 30���� �������� ����
					break;
				
				if(startSerial == curDate.startSerial){				//���� ��带 �������� ���ߴٸ� ����
					flowersCounter = 0;
					break;
				}
			}	
		}
		
		bw.write(flowersCounter + "\n");
		
		br.close();
		bw.close();
	}
}
