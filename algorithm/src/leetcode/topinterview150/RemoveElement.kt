package leetcode.topinterview150

fun removeElement(nums: IntArray, `val`: Int): Int {
    var index = 0
    for (j in nums.indices) {
        if (nums[j] != `val`) {
            nums[index] = nums[j]
            index++
        }
    }
    return index
}

fun main() {
    val nums = intArrayOf(3, 2, 2, 3)
    val `val` = 3
    println(removeElement(nums, `val`))
    println(nums.contentToString())
}
