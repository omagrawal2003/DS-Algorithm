package basics;

public class deleteMiddleElement {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }
    public static void printlist(node head){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static node deleteMiddle(node head){
        if(head==null || head.next==null){
            return null; // List is empty or has only one element
        }
        node slow=head;
        node fast=head;
        node temp=null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            temp=slow;
            slow=slow.next;
        }
        // 'slow' is now pointing to the middle node

        temp.next=slow.next; // Delete the middle node
        return head;
    }
    public static void main(String[] args) {
        node a=new node(1);
        node b=new node(2);
        node c=new node(3);
        node d=new node(4);
        node e=new node(5);
        node f=new node(6);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        System.out.println("Original list:");
        printlist(a);
        
        a=deleteMiddle(a);
        System.out.println("List after deleting middle element:");
        printlist(a);
    }
}
