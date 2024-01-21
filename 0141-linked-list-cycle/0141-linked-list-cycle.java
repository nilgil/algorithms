/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Map<ListNode, Boolean> map = new HashMap<>();
        while (head.next != null) {
            if (map.containsKey(head.next)) {
                return true;
            }
            map.put(head.next, true);
            head = head.next;
        }
        return false;
    }
}