/////////////////////////////////////////////////////////////////////////////////////////////
// �⺻ �����ڵ�� ���� �����ص� ���� �����ϴ�. ��, ����� ���� ����
// �Ʒ� ǥ�� ����� ���� �ʿ�� �����ϼ���.
// ǥ�� �Է� ����
// int a;
// float b, c;
// double d, e, f;
// char g;
// char var[256];
// long long AB;
// scanf(&quot;%d&quot;, &a);                      // int ���� 1�� �Է¹޴� ����
// scanf(&quot;%f %f&quot;, &b, &c);               // float ���� 2�� �Է¹޴� ���� 
// scanf(&quot;%lf %lf %lf&quot;, &d, &e, &f);     // double ���� 3�� �Է¹޴� ����
// scanf(&quot;%c&quot;, &g);                      // char ���� 1�� �Է¹޴� ����
// scanf(&quot;%s&quot;, &var);                    // ���ڿ� 1�� �Է¹޴� ����
// scanf(&quot;%lld&quot;, &AB);                   // long long ���� 1�� �Է¹޴� ����
/////////////////////////////////////////////////////////////////////////////////////////////
// ǥ�� ��� ����
// int a = 0;                            
// float b = 1.0, c = 2.0;               
// double d = 3.0, e = 0.0; f = 1.0;
// char g = &apos;b&apos;;
// char var[256] = &quot;ABCDEFG&quot;;
// long long AB = 12345678901234567L;
// printf(&quot;%d&quot;, a);                      // int ���� 1�� ����ϴ� ����
// printf(&quot;%f %f&quot;, b, c);                // float ���� 2�� ����ϴ� ����
// printf(&quot;%lf %lf %lf&quot;, d, e, f);       // double ���� 3�� ����ϴ� ����
// printf(&quot;%c&quot;, g);                      // char ���� 1�� ����ϴ� ����
// printf(&quot;%s&quot;, var);                    // ���ڿ� 1�� ����ϴ� ����
// printf(&quot;%lld&quot;, AB);                   // long long ���� 1�� ����ϴ� ����
/////////////////////////////////////////////////////////////////////////////////////////////
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
	int test_case;
	int T;
    int histogram[41];
	/* �Ʒ��� freopen �Լ��� input.txt �� read only �������� �� ��,
	������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
	�������� �ۼ��� �ڵ带 �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��,
	freopen �Լ��� �̿��ϸ� ���� scanf �� ������ �� ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�.
	���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �Լ��� ����ϼŵ� �����ϴ�.
	��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� freopen �Լ��� ����ų� �ּ� ó�� �ϼž� �մϴ�.
	*/
	// freopen(&quot;input.txt&quot;, &quot;r&quot;, stdin);
	/* �Ʒ� �ڵ带 �������� ������ �������� ���α׷��� ���� �ð� �ʰ��� ���� ���� �Ǿ��� ��,
	����� ������ ���� ǥ�� ��¿� ��ϵ��� ���� �� �ֽ��ϴ�.
	���� ������ ���� �ݵ�� setbuf(stdout, NULL); �� �����Ͻñ� �ٶ��ϴ�.
	*/
	setbuf(stdout, NULL);
	scanf("%d", &T);
	/*
	���� ���� �׽�Ʈ ���̽��� ó���ϱ� ���� �κ��Դϴ�.
	*/
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int n, m, max;
        scanf("%d %d", &n, &m);
        memset(histogram, 0, 41 * sizeof(int));
        for(int i = 1; i <= n; i++){
         	for(int j = 1; j <= m; j++)
            	   histogram[i+j]++;
        }
        
        max = histogram[2];
        
        for(int i = 3; i <= 40; i++){
        	if( histogram[i] > max)
                max = histogram[i];
        }
        
        printf("#%d",test_case);
        for(int i = 2; i <= 40; i++){
            if( histogram[i] == max )
                printf(" %d", i);
        }
        printf("\n");
	}
	return 0; //��������� �ݵ�� 0�� �����ؾ� �մϴ�.
}