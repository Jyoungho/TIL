from typing import List


def removeDuplicates(nums: List[int]) -> int:
    index = 1
    occurrences = 1

    for i in range(1, len(nums)):
        if nums[i] == nums[i - 1]:
            occurrences += 1
        else:
            occurrences = 1

        if occurrences <= 2:
            nums[index] = nums[i]
            index += 1

    return index

if __name__ == '__main__':
    nums = [1, 1, 1, 2, 2, 3]
    k = removeDuplicates(nums)
    print(nums[:k])
