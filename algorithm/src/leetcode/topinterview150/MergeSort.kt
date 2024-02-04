package leetcode.topinterview150


fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {
    var i = m + n - 1  // index for nums1 -> nums1.size - 1
    var first = m - 1  // index for nums1
    var second = n - 1 // index for nums2

    while (second >= 0)
        nums1[i--] = if (first >= 0 && nums2[second] <= nums1[first]) nums1[first--]
        else nums2[second--]

    return nums1;
}

fun main() {
    println("[" + merge(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3).joinToString { it.toString() } + "]")
}