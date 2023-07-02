class Node:
    def __init__(self, data=None, prev=None, next=None):
        self.data = data
        self.next = next
        self.prev = prev


class Deque:
    def __init__(self):
        self.head = Node()
        self.tail = Node(prev=self.head)
        self.head.next = self.tail
        self.length = 0

    def ft_push_front(self, X):
        if self.length == 0:
            newNode = Node(X, self.head, self.tail)
            self.head.next = newNode
            self.tail.prev = newNode
            self.length += 1
        else:
            newNode = Node(X, self.head, self.head.next)
            self.head.next = newNode
            newNode.next.prev = newNode
            self.length += 1

    def ft_push_back(self, X):
        if self.length == 0:
            newNode = Node(X, self.head, self.tail)
            self.head.next = newNode
            self.tail.prev = newNode
            self.length += 1
        else:
            newNode = Node(X, self.tail.prev, self.tail)
            self.tail.prev = newNode
            newNode.prev.next = newNode
            self.length += 1

    def ft_size(self):
        return self.length

    def ft_empty(self):
        if self.length == 0:
            return True
        else:
            return False

    def ft_front(self):
        if self.length == 0:
            return -1
        else:
            return self.head.next.data

    def ft_back(self):
        if self.length == 0:
            return -1
        else:
            return self.tail.prev.data

    def ft_pop_front(self):
        if self.length == 0:
            return -1
        else:
            pop_data = self.head.next.data
            self.head.next = self.head.next.next
            self.head.next.prev = self.head
            self.length -= 1
            return pop_data

    def ft_pop_back(self):
        if self.length == 0:
            return -1
        else:
            pop_data = self.tail.prev.data
            self.tail.prev = self.tail.prev.prev
            self.tail.prev.next = self.tail
            self.length -= 1
            return pop_data
