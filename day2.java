//  想了很久如何在单个节点上操作，很多很多case但是过于复杂。
//  还是没有看到问题的本质就是简单的对于，以及对剩余节点的处理。看了迭代的思路后恍然大悟。
//  之后看到了递归的思路更想通了。后面又看到了用stack做，与前面迭代与递归相反，其本质就是比谁更小。
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l2.val > l1.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 == null) {
            temp.next = l2;
        } else {
            temp.next = l1;
        }
        return head.next;
    }
}
