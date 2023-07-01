input_value = [0 for i in range(8)]
polygonal_vertices = [0 for i in range(8)]
visited = [0 for i in range(8)]

global result
result = 0

def check_concave_angle():
    for i in range(8):
        first_point = i
        second_point = (i + 1) % 8
        third_point = (i + 2) % 8
        if (polygonal_vertices[first_point] * polygonal_vertices[third_point] * (2 ** 0.5) >
         polygonal_vertices[second_point] * (polygonal_vertices[first_point] + polygonal_vertices[third_point])):
            return 0
    return 1

def DFS(cnt: int):
    global result
    if (cnt == 8):
        result += check_concave_angle()
        return
    
    for i in range(8):
        if visited[i]: continue
        visited[i] = 1
        polygonal_vertices[cnt] = input_value[i]
        DFS(cnt + 1)
        visited[i] = 0

def main():
    DFS(0)
    print(result)

input_value = list(map(int, input().split()))
main()        
    