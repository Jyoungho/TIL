
N, K = map(int, input().split())
square = []
for _ in range (N):
  square.append(list(map(int, input().split())))

x1_arr, x2_arr, y1_arr, y2_arr, z1_arr, z2_arr = [], [], [], [], [], []

print(square)

for i in range(len(square)):
  x1_arr.append(square[i][0])
  x2_arr.append(square[i][3])
  y1_arr.append(square[i][1])
  y2_arr.append(square[i][4])
  z1_arr.append(square[i][3])
  z2_arr.append(square[i][5])

x1_arr.sort()
x2_arr.sort()
y1_arr.sort()
y2_arr.sort()
z1_arr.sort()
z2_arr.sort()

# x1_arr 를 돌면서 x2_arr i 번째보다 작은 x1_arr 를 개수를 개수를 찾는다.
# x1_arr 개수가 작은게 K 개 이상인 인 것들에 모음에 대하여
# y1_arr 와 z1_arr를 반복해서 검사한다 하면서 최종적으로 K 개가 되는 것들에 대한 값을 구한다.

# x1_arr i 번째에서 x2_arr i 번째 값을 가져온다.
# x1_arr 에서 해당 값