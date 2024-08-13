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
    public ListNode reverse(ListNode head)
    {
        ListNode p=head,q=null,r=null;
        while(p!=null)
        {
            r=q;
            q=p;
            p=p.next;
            q.next=r;
        }
        return q;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null ||left==right){return head;}
        ListNode strev=head;
        ListNode prev=head;
        ListNode temp=head;
        for(int i=1;i<right;i++)
        {
            if(i+1==left){prev=temp;}
            if(i==left){strev=temp;}
           temp=temp.next;
        }
        ListNode s2=temp.next;
        temp.next=null;
        if(left!=1)
        {
        prev.next= reverse(strev);
        }
        else
        {
            prev=reverse(strev);
            head=prev;
        }
        while(prev.next!=null)
        {
            prev=prev.next;
        }
        prev.next=s2;
        return head;
        
    }
}