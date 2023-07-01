import sys

N = int(sys.stdin.readline().rstrip())

for _ in range(N):
    ps = sys.stdin.readline().rstrip()

    p_depth = 0
    is_wrong = False
    for i in range(len(ps)):
        if ps[i] == '(':
            p_depth += 1
        elif ps[i] == ')':
            p_depth -= 1
        else:
            raise Exception('잘못된 값이 입력되었습니다.')

        if p_depth < 0:
            is_wrong = True

    if p_depth != 0:
        is_wrong = True

    if is_wrong:
        print('NO')
    else:
        print('YES')

