from collections import deque


# def solution(priorities, location):
#     answer = 0
#     enumerated_priorities = deque(enumerate(priorities))
#     execute_count = 0
#     while len(enumerated_priorities) != 0:
#         first = enumerated_priorities.popleft()
#         changed = False
#         for index, p in enumerated_priorities:
#             if p > first[1]:
#                 enumerated_priorities.append(first)
#                 changed = True
#                 break
#
#         if changed is False:
#             execute_count += 1
#
#         if changed is False and location == first[0]:
#             return execute_count
#
#     return answer

def solution(priorities, location):
    queue = deque(enumerate(priorities))
    execute_count = 0

    while queue:
        index, priority = queue.popleft()

        if any(p > priority for _, p in queue):
            queue.append((index, priority))
            continue

        execute_count += 1
        if index == location:
            return execute_count

if __name__ == "__main__":
    print(solution([2, 1, 3, 2], 2))  # 1
    print(solution([1, 1, 9, 1, 1, 1], 0))  # 5