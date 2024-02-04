from typing import List


def removeElement(nums: List[int], val: int) -> int:
    remove_target_index = []
    for i in range(len(nums)):
        if nums[i] == val:
            remove_target_index.append(i)

    while len(remove_target_index) > 0:
        nums.remove(val)
        remove_target_index.pop(0)

    return len(nums)
# test_case1
nums = [3,2,2,3]
removeElement(nums=nums, val=3)

print(nums)

# test_case 2
nums = [0,1,2,2,3,0,4,2]
removeElement(nums=nums, val=2)

print(nums)
