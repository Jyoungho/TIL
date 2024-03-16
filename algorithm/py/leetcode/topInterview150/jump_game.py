from typing import List


def canJump(nums: List[int]) -> bool:
    gas = 0
    for num in nums:
        if gas < 0:
            return False
        elif num > gas:
            gas = num
        gas -= 1

    return True

if __name__ == '__main__':
    print(canJump([2, 3, 1, 1, 4]))
    print(canJump([3, 2, 1, 0, 4]))
    print(canJump([2]))
    print(canJump([0]))
