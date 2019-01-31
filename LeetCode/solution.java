package LeetCode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
//        while (head!=null &&head.val==val){
//            ListNode delNode=head;
//            head=head.next;
//            delNode.next=null;
//        }
//
//        if (head==null)
//            return null;
//
//        ListNode prev=head;
//        while (prev.next!=null){
//            if (prev.next.val==val){
//                ListNode delNode=prev.next;
//                prev.next=delNode.next;
//                prev.next=null;
//            }else {
//                prev=prev.next;
//            }
//        }
//        return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next=head;

        ListNode prev=dummyHead;
        while (prev.next!=null){
            if (prev.next.val==val){
                ListNode delNode=prev.next;
                prev.next=delNode.next;
                delNode.next=null;
            }else {
                prev=prev.next;
            }
        }

        return dummyHead.next;
    }

    public void deleteNode(ListNode node) {

        node.val=node.next.val;
        node.next=node.next.next;

    }

    public ListNode middleNode(ListNode head) {
//        int count=0;
//        ListNode tmp_head=head;
//        while (tmp_head.next!=null){
//            count+=1;
//            tmp_head=tmp_head.next;
//        }
//
//
//        int middle=(int)count/2+1;
//
//        for (int i=0;i<middle-1;i++){
//            head=head.next;
//        }
//        return head;

        //使用快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (slow!=null&&fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static void main(String[] args){
        System.out.println((int) 5/2+1);
    }
}

