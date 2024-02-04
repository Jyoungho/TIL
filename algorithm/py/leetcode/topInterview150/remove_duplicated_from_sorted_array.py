from typing import List


def removeDuplicates(nums: List[int]) -> int:
    index = 1
    for i in range(len(nums) - 1):
        if nums[i] < nums[i + 1]:
            nums[index] = nums[i + 1]
            index += 1
    return index


if __name__ == '__main__':
    nums = [1, 1, 2]
    k = removeDuplicates(nums)
    print(nums[0:k])

    nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    k = removeDuplicates(nums)
    print(nums[0:k])

    nums = [1, 2]
    k = removeDuplicates(nums)
    print(nums[0:k])
