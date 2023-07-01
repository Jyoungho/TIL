N, K = map(int, input().split())
S = list(map(int, input().split()))

right = 0
max_length = 0
now_length = 0
odd_num_cnt = 0

for left in range(N):

  while (odd_num_cnt <= K and right < N):
    if S[right] % 2 == 1:
      odd_num_cnt += 1
    else:
      now_length += 1

    right += 1

    if left == 0 and right == N:
      max_length = now_length
      break

  if odd_num_cnt == K + 1:
    max_length = max(max_length, now_length)

  if S[left] % 2 == 1:
    odd_num_cnt -= 1
  else:
    now_length -= 1

print(max_length)
    