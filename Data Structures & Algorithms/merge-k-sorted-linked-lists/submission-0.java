/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
  ArrayList<Integer> arr = new ArrayList<>();

        // Store all values
        for (ListNode head : lists) {

            while (head != null) {

                arr.add(head.val);

                head = head.next;
            }
        }

        // Sort values
        Collections.sort(arr);

        // Create new linked list
        ListNode dummy = new ListNode(0);

        ListNode temp = dummy;

        for (int num : arr) {

            temp.next = new ListNode(num);

            temp = temp.next;
        }

        return dummy.next;
    }
}
