package study.heap

import java.util.PriorityQueue
import kotlin.math.max

val minHeap = PriorityQueue<Int>(compareBy { it })
val maxHeap = PriorityQueue<Int>(compareByDescending { it })

class Solution {
    fun solution(operations: Array<String>): IntArray {
        val answer = intArrayOf()
        // operations 를 분석해서 실행하는 함수

        operate(operations)

        if (minHeap.isEmpty() || maxHeap.isEmpty()) {
            return intArrayOf(0, 0)
        }
        val min = minHeap.poll()
        val max = maxHeap.poll()

        if (min == null || max == null) {
            return intArrayOf(0, 0)
        }

        return if (max  <= min) {
            intArrayOf(0, 0)
        } else {
            intArrayOf(max, min)
        }
    }
}

fun operate(operations: Array<String>) {
    operations.map {
        println("maxHeap: $maxHeap, minHeap: $minHeap")
        val (op, value) = it.split(" ")
        when (op) {
            "I" -> {
                val num = value.toInt()
                minHeap.offer(num)
                maxHeap.offer(num)
            }
            "D" -> {
                if (value == "1" && maxHeap.isNotEmpty()) {
                    maxHeap.poll()
                } else if (value == "-1" && minHeap.isNotEmpty()) {
                    minHeap.poll()
                }
            }
        }
    }
}

fun main() {
    val operations = arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1")
    val solution = Solution()
    val result = solution.solution(operations)
    println(result.joinToString(", ")) // Output: [0, 0]
}