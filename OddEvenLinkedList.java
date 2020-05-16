//Given a singly linked list, group all odd nodes together followed by the even nodes. 
//Please note here we are talking about the node number and not the value in the nodes.
//
//You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
//
//Example 1:
//
//Input: 1->2->3->4->5->NULL
//Output: 1->3->5->2->4->NULL
//Example 2:
//
//Input: 2->1->3->5->6->4->7->NULL
//Output: 2->3->6->7->1->5->4->NULL
//Note:
//
//The relative order inside both the even and odd groups should remain as it was in the input.
//The first node is considered odd, the second node even and so on ...
//

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
    public ListNode oddEvenList(ListNode head) {
        
        ListNode cur = null;
        ListNode odd = head;
        ListNode even = null;
        ListNode evenHead = null;
        if(head!=null)
        {
            even = head.next;
            evenHead = head.next;
        }
        
        if(head!=null && head.next !=null)
            cur = head.next.next;
        
        while(cur!=null && odd!=null && even!=null)
        {
            odd.next = cur;
            even.next = cur.next;
            
            if(cur.next != null)
                cur = cur.next.next;
            
            odd = odd.next;
            if(even!=null)
                even = even.next;
        }
        
        if(odd!=null)
            odd.next = evenHead;
        
        return head;
        
    }
}
