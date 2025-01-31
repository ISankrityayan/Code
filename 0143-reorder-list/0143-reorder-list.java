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
    public void reorderList(ListNode head) {
        ArrayList<Integer>li=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            li.add(temp.val);
            temp=temp.next;
        }
        temp=head;
        int i=0;
        int j=li.size()-1;
        while(i<=j){
            temp.val=li.get(i);
            temp=temp.next;
            if(i<j){
                temp.val=li.get(j);
                temp=temp.next;
            }
            i++;
            j--;
        }
    }
}