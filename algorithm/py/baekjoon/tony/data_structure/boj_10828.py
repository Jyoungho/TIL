import sys


class MyStack:
    stack = []

    def push(self, number: int):
        return self.stack.append(number)

    def pop(self):
        if self.size() == 0:
            return -1

        self.top()
        return self.stack.pop()

    def size(self):
        return len(self.stack)

    def empty(self):
        if self.size() == 0:
            return 1
        else:
            return 0

    def top(self):
        if len(self.stack) == 0:
            return -1
        return self.stack[len(self.stack) - 1]

N = int(sys.stdin.readline())

my_stack = MyStack()

for _ in range(N):
    commandList = sys.stdin.readline().split()
    command = commandList[0]
    if command == 'push':
        my_stack.push(int(commandList[1]))
    elif command == 'top':
        print(my_stack.top())
    elif command == 'size':
        print(my_stack.size())
    elif command == 'empty':
        print(my_stack.empty())
    elif command == 'pop':
        print(my_stack.pop())


