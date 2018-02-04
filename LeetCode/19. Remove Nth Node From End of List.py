class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        fast = slow = ListNode(0)
        fast.next = slow.next = head
        
        for _ in range(n):
            fast = fast.next
        
        if not fast.next:
            return head.next
        while fast.next:
            fast = fast.next
            slow = slow.next
        slow.next = slow.next.next
        return head