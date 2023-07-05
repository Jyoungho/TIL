import sys

input = sys.stdin.readline

class Node:
    def __init__(self, data: int):
        self.data = data
        self.child = None
        self.parent = None

    def __str__(self):
        return str(self.data)

def solution():
    is_input = True
    answer = True
    node_dict = dict()
    root = None
    global is_working

    def checkCycle(node: Node):
        cnt = len(node.child)
        for i in node.child:
            cnt += checkCycle(node_dict[i])
        return cnt

    while is_input:
        buf = input().rstrip().split("  ")
        if buf[0] == '':
            continue
        for temp in buf:
            a, b = map(int, temp.split(" "))
            if a == 0 and b == 0:
                is_input = False
                break
            elif a < 0 and b < 0:
                is_working = False
                is_input = False
                break

            if a in node_dict:
                node_dict[a].child.append(b)
            else:
                node_dict[a] = Node(a)
                node_dict[a].child = [b]

            if b in node_dict:
                if node_dict[b].parent == None:
                    node_dict[b].parent = a
                else:
                    answer = False
            else:
                node_dict[b] = Node(b)
                node_dict[b].parent = a
                node_dict[b].child = []

    if len(node_dict) == 0:
        return True

    if answer == False:
        return answer

    for v in node_dict.values():
        if v.parent == None:
            if root == None:
                root = v.data
            else:
                answer = False
                return answer

    if root == None:
        return False

    cycle = 1 + len(node_dict[root].child)
    for i in node_dict[root].child:
        cycle += checkCycle(node_dict[i])
    if cycle != len(node_dict):
        return False

    return answer

if __name__ == "__main__":
    is_working = True
    num = 1

    while is_working:
        check = solution()

        if not is_working:
            break
        if check:
            print(f'Case {str(num)} is a tree')
        else:
            print(f'Case {str(num)} is not a tree')
        num += 1



