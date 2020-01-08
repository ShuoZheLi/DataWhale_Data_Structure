public class Day2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// 这个问题本质操作就在于对于各链表中的节点，并在符合小的在前，大的在后的基础上连接上新的链表的最后一个节点
	// 递归本质也是一样的操作，这个问题同时也指出链表递归也可以想树或图递归那样从前向后进行操作。
	// 并非像反转链表那样一直从后向前
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while(l1!=null && l2!=null){
            if(l2.val>l1.val){
                temp.next = l1;
                l1 = l1.next;
            }else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1==null){
            temp.next = l2;
        }else {
            temp.next = l1;
        }
        return head.next;
    }
	
	// 反转链表, 经典的递归使用方式，利用栈先进后出的特性可以在非双指针链表时从后向前操作
	// 迭代的方法就是指针地址的存储以及更新，一遍一遍同样的操作直到 current.next = null
	public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
        ListNode nextNode = current.next;
        current.next = prev;
        prev = current;
        current = nextNode;
        }
        return prev;
    }

	// 本质就是把链表从头到位连起来
	// 利用双指针分别定位到新的尾节点跟新的头节点
	// 由于K值可能大于链表长度，所以需要使用余数操作来定位新头节点
	public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }
        int count = 1;
        ListNode node = head;
        while(node.next != null){
            count++;
            node = node.next;
        }
        node.next = head;
        int newTailIndex = count - k%count -1;
        node = head;
        for(int i=1; i<= newTailIndex; i++){
            node = node.next;
        }
        head = node.next;
        node.next = null;
        return head;
    }
	
	
}

