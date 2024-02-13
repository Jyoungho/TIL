from typing import List


def rotate(nums: List[int], k: int) -> None:
    temp = list(nums)
    rotate_time = k % len(nums)
    for i in range(len(nums)):
        nums[i] = temp[i - rotate_time]


if __name__ == '__main__':
    nums = [1, 2, 3, 4, 5, 6, 7]
    k = 3
    rotate(nums, k)
    print(nums)

    nums = [-1, -100, 3, 99]
    k = 2
    rotate(nums,k)
    print(nums)

    nums = [-1]
    k = 2
    rotate(nums, k)
    print(nums)
