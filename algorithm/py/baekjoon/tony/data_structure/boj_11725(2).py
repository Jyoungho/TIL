import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def dfs(parent_node):
    visited[parent_node] = 1
    for node in graph[parent_node]:
        if not visited[node]:
            parent[node] = parent_node
            dfs(node)

if __name__ == '__main__':
    n = int(input())

    graph = [[] for _ in range(n + 1)]
    visited = [0] * (n + 1)
    parent = [0] * (n + 1)

    for _ in range(n -1):
        a, b = map(int, input().split())
        graph[a].append(b)
        graph[b].append(a)

    for i in range(n + 1):
        graph[i].sort()

    dfs(1)

    print(*parent[2:], sep='\n')