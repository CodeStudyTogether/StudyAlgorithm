/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int = 0) {
 *     var next: ListNode? = null
 * }
 */
//转自：https://leetcode.com/problems/rotate-list/discuss/22715/Share-my-java-solution-with-explanation
class Solution {
    fun rotateRight(head: ListNode?, n: Int): ListNode? {
        if (head == null || head!!.next == null) return head
        val dummy = ListNode(0)
        dummy.next = head
        var fast = dummy
        var slow = dummy

        var i: Int
        i = 0
        while (fast.next != null) {
            //Get the total length
            fast = fast.next
            i++
        }

        for (j in i - n % i downTo 1)
        //Get the i-n%i th node
            slow = slow.next

        fast.next = dummy.next //Do the rotation
        dummy.next = slow.next
        slow.next = null

        return dummy.next
    }
}
