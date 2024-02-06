from typing import List


def majority_element(nums: List[int]) -> int:
    nums_count_map = {}
    for num in nums:
        if nums_count_map.get(num):
            nums_count_map[num] += 1
        else:
            nums_count_map[num] = 1

    max_count = 0
    majority_element = None
    for key in nums_count_map:
        if nums_count_map[key] > max_count:
            max_count = nums_count_map[key]
            majority_element = key

    return majority_element

if __name__ == '__main__':
    key = majority_element([2,2,1,1,1,2,2])
    print(key)

    key = majority_element([3,2,3])
    print(key)

    key = majority_element([1])
    print(key)

