import sys
from collections import deque

N = int(sys.stdin.readline())

cards = deque([i + 1 for i in range(N)])

for _ in range(len(cards)):
    if len(cards) == 1:
        print(cards[0])
        break

    cards.popleft()
    cards.append(cards[0])
    cards.popleft()
