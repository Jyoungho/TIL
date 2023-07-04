import heapq
import sys

N = int(sys.stdin.readline().rstrip())
max_heap = []

for _ in range(N):
    input_value = int(sys.stdin.readline().rstrip())

    if input_value == 0:
        if len(max_heap) == 0:
            print(0)
        else:
            print(-heapq.heappop(max_heap))

    else:
        heapq.heappush(max_heap, -input_value)