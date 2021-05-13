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
        if (lists == null || lists.length == 0) {
            return null;
        }
        int last = lists.length - 1;
        //if last become zero, then return forst merged array
        while(last != 0) {
            int i = 0;
            int j = last;
            while (i < j) {
                //Merging two lists from left and right part to the left one
                lists[i] = mergeTwoLists(lists[i], lists[j]);
                i++;
                j--;
                if (i >= j) {
                    //reach the end, set the end of array to the half of previous last
                    last = j;
                }
            }
        }
        return lists[0];
    }
    
    //Method to merge two lists in a single one
    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        ListNode listNode = null;
        if (listNode1 == null) {
            return listNode2;
        } else if (listNode2 == null) {
            return listNode1;
        }
        if (listNode1.val <= listNode2.val) {
            listNode = listNode1;
            listNode.next = mergeTwoLists(listNode1.next, listNode2);
        } else {
            listNode = listNode2;
            listNode.next = mergeTwoLists(listNode1, listNode2.next);
        }
        return listNode;
    }
    
}
