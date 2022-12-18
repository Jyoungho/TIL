
points = []
points_map = {}


def main():
    result = 0
    N = int(input())
    for i in range(N):
        x, y = map(int, input().split())
        points.append((x, y))
        if points_map.get(x) is None:
            points_map[x] = set()
        points_map[x].add(y)

    for i in range(N):
        for j in range(i+1, N):
            if points[i][0] != points[j][0] and points[i][1] != points[j][1]:
                if points[j][1] in points_map.get(points[i][0]) and points[i][1] in points_map.get(points[j][0]):
                    result += 1

    print(int(result/2))

main()

