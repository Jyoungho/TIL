import sys

N, K = map(int, sys.stdin.readline().split())

yo_circle = [i + 1 for i in range(N)]
result = []

start_point = 0

for _ in range(N):
    start_point += K - 1
    while start_point >= len(yo_circle):
        start_point = start_point - len(yo_circle)

    result.append(str(yo_circle.pop(start_point)))

print('<' + ', '.join(result) + '>')