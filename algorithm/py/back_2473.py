import sys

n = int(input())
array = list(map(int, input().split()))

array.sort()
min_ph = sys.maxsize
result = list()

for i in range(n - 2):
    left = i + 1
    right = n - 1
    while left < right:
        total = array[i] + array[left] + array[right]
        if abs(total) < min_ph:
            min_ph = abs(total)
            result = [array[i], array[left], array[right]]
        if total < 0:
            left += 1
        elif total > 0:
            right -= 1
        else:
            print(*result)
            sys.exit(0)

print(*result)
