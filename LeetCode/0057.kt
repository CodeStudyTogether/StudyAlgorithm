//这一题是一个直线思维
import java.util.*

class Interval(var start: Int = 0, var end: Int = 0)

internal class Solution {
    fun insert(intervals: List<Interval>, newInterval: Interval): List<Interval> {
        var newInterval = newInterval
        val result = LinkedList<Interval>()
        var i = 0
        // add all the intervals ending before newInterval starts
        while (i < intervals.size && intervals[i].end < newInterval.start)
            result.add(intervals[i++])
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size && intervals[i].start <= newInterval.end) {
            newInterval = Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals[i].start),
                    Math.max(newInterval.end, intervals[i].end))
            i++
        }
        result.add(newInterval) // add the union of intervals we got
        // add all the rest
        while (i < intervals.size) result.add(intervals[i++])
        return result
    }
}
