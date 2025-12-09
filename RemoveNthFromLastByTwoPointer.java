package basics;

public class RemoveNthFromLastByTwoPointer {
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
    public static void removeNthFromLast(node head, int n){
        node fast=head;
        node slow=head;
        for(int i=0; i<=n; i++){
            if(fast==null){
                return; // n is greater than the length of the list
            }
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
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
        printlist(a);
        removeNthFromLast(a, 3);
        System.out.println("List after removing 3rd node from last:");
        printlist(a);
    }
}
