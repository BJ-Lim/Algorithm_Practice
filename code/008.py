T = int(input())
# �������� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
for test_case in range(1, T + 1):
    N = float(input())
    rs = ''
    
    for i in range(1, 13):
        t = 1.0 / (1 << i)
        if N - t >= 0:
            rs += '1'
            N = N - t
        else:
            rs += '0'
        if N == 0:
            break
            
    if N != 0:
        rs = 'overflow'
        
    print("#{0} {1}".format(test_case, rs))