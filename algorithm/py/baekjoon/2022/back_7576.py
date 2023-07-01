from collections import deque

m, n = map(int, input().split())
matrix = [list(map(int, input().split())) for _ in range(n)]

queue = deque()
dx, dy = [-1, 1 , 0, 0], [0, 0, -1 , 1]

result = 0

for i in range(n):
    for j in range(m):
        if matrix[i][j] == 1:
            queue.append([i, j])

def bfs():
    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0<= nx < n and 0 <= ny <m and matrix[nx][ny] == 0:
                matrix[nx][ny] = matrix[x][y] + 1
                queue.append([nx, ny])

# 탐색 시작
bfs()

for row in matrix:
    for row_col in row:
        if row_col == 0:
            print(-1)
            exit(0)

    # 가장 오래된 시간을 추출
    result = max(result, max(row))

print(result - 1)