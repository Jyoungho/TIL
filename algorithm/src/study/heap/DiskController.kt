package study.heap

import java.util.*

data class Job(val requestTime: Int, val duration: Int)

class DiskController {
    fun solution(jobs: Array<IntArray>): Int {
        val jobList = jobs.map { Job(it[0], it[1]) }.sortedBy { it.requestTime }
        val pq = PriorityQueue<Job>(compareBy {it.duration} )
        var currentTime = 0
        var totalTime = 0
        var index = 0
        val jobCount = jobList.size

        while (index < jobCount || pq.isNotEmpty()) {
            while (index < jobCount && jobList[index].requestTime <= currentTime) {
                pq.offer(jobList[index])
                index++
            }

            if (pq.isNotEmpty()) {
                val job = pq.poll()
                currentTime += job.duration
                totalTime += currentTime - job.requestTime
            } else {
                currentTime = jobList[index].requestTime
            }

        }
        return totalTime / jobCount
    }
}

fun main() {
    val diskController = DiskController()
    val jobs = arrayOf(
        intArrayOf(0, 3),
        intArrayOf(1, 9),
        intArrayOf(2, 6)
    )
    println(diskController.solution(jobs)) // Output: 9
}