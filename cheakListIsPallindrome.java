package basics;

public class cheakListIsPallindrome {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }
    public static boolean isPallindrome(node head){
        if(head==null){
            return true;
        }
        node hum=new node(100);
        node temp=hum;
        node curr=head;
        while(curr!=null ){
            
            temp.next=new node(curr.data);
            temp=temp.next;
            curr=curr.next;
        }

        node x=reverseList(hum.next);
        node p=head;
        node q=x;
        while(p!=null && q!=null){
            if(p.data!=q.data){
                return false;
            }
         p=p.next;
         q=q.next;
        }
     return true;

        
    }
    public static boolean cheakListIsPallindrome2(node head){
        if (head == null || head.next == null) {
             return true;
        }
        node slow=head;
        node fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        node temp=reverseList(slow.next);
        slow.next=temp;
        node x=head;
        node y=slow.next;
        while(y!=null){
            if(x.data !=y.data){
                return false;
            }
            x=x.next;
            y=y.next;
        }
        return true;

    }
    public static node reverseList(node head){
        node prev=null;
        node curr=head;
        node agla;
        while(curr!=null){
            agla=curr.next;
            curr.next=prev;
            prev=curr;
            curr=agla;
        }
        return prev;
    }
    public static void main(String[]args){
        node a=new node(10);
        a.next=new node(20);
        a.next.next=new node(30);
        a.next.next.next=new node(30);
        a.next.next.next.next=new node(20);
        a.next.next.next.next.next=new node(10);

        boolean x=isPallindrome(a);
        System.out.println(x);
        boolean y=cheakListIsPallindrome2(a);
        System.out.println(y);
        
    }
}
