package basics;

public class findMiddleElementOfList {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }
    public static int length(node head){
        node temp=head;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    // function to find middle element of linked list
    public static node findMiddle(node head){
        int len=length(head);
        int mid=len/2;
        if(mid%2==0){
            mid=mid-1;
        }
        else{
            mid=mid;
        }
        node temp=head;
        for(int i=0; i<mid; i++){
            temp=temp.next;
        }
        return temp;
    }

    // this is better approach using two pointer
    public static node findMiddleTwoPointer(node head){
        node slow=head;
        node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        node a=new node(1);
        node b=new node(2);
        node c=new node(3);
        node d=new node(4);
        node e=new node(5);
        node f=new node(6);
        //node g=new node(7);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        //f.next=g;

        node middleNode=findMiddle(a);
        node middleNodeByTwoPointer=findMiddleTwoPointer(a);
        System.out.println("Middle element is: "+middleNode.data);
        System.out.println("Middle element by two pointer is: "+middleNodeByTwoPointer.data);
    }
}
