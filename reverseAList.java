package basics;

public class reverseAList {
    public static class node {
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }
    public static node reverseListByRecursion(node head){
        if(head==null || head.next==null){
            return head;
        }
        node newHead=reverseListByRecursion(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;

    }
    public static void printList(node head){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }   
    public static void main(String[] args) {
        node a=new node(0);
        node b=new node(7);
        node c=new node(3);
        node d=new node(41);
        node e=new node(51);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;

        System.out.println("Original list:");
        printList(a);

        node reversedHead=reverseListByRecursion(a);

        System.out.println("Reversed list:");
        printList(reversedHead);
    }
    
}
