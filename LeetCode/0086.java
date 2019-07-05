/**
https://blog.csdn.net/mine_song/article/details/70545448

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 以一个数为分割，那么就新建两个容器，一个在左侧，一个在右侧，最后拼接。
 * }
 */
class Solution {
    	/**
	 * 思路是将list按X分成两段
	 * 小于的连接p
	 * 大于的连接q
	 * 最后合并p和q即可
	 */
	public ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode p = null;
		ListNode headP = null;
		ListNode q = null;
		ListNode headQ = null;
		while (head != null) {
 
			if (head.val < x) {
				if (p == null) {
					p = head;
					headP = p;
				} else {
					p.next = head;
					p = p.next;
				}
 
			} else {
				if (q == null) {
					q = head;
					headQ = q;
				} else {
					q.next = head;
					q = q.next;
				}
			}
			head = head.next;
		}
		if (q != null)
			q.next = null;
		if (p == null)
			return headQ;
 
		p.next = headQ;
		return headP;
 
	}
}
