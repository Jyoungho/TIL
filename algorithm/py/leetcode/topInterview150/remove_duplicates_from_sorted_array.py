from typing import List


def remove_duplicates(nums: List[int]) -> int:
    index = 1
    duplicated_count = 1

    for i in range(1, len(nums)):
        if nums[i] == nums[i - 1]:
            duplicated_count += 1
        else:
            duplicated_count = 1

        if duplicated_count <= 2:
            nums[index] = nums[i]
            index += 1

    return index


if __name__ == '__main__':
    nums = [0, 0, 1, 1, 1, 1, 2, 3, 3]
    print(remove_duplicates(nums))
