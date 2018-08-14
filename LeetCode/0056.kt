import java.util.*

class Interval(var start: Int = 0, var end: Int = 0)

internal class Solution {
    fun merge(intervals: List<Interval>): List<Interval> {
        if (intervals.size <= 1)
            return intervals

        // Sort by ascending starting point using an anonymous Comparator
        var nums = intervals.sortedBy { it.start }//kotlin在这里一定要赋值给nums,这一步很关键，一定要排序

        val result = LinkedList<Interval>()
        var start = nums[0].start
        var end = nums[0].end

        for (interval in nums) {
            if (interval.start <= end)
            // Overlapping nums, move the end if needed
                end = Math.max(end, interval.end)
            else {                     // Disjoint nums, add the previous one and reset bounds
                result.add(Interval(start, end))
                start = interval.start
                end = interval.end
            }
        }

        // Add the last interval
        result.add(Interval(start, end))
        return result
    }
}
