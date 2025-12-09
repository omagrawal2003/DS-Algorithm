package basics;
public class leetcode237{
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }
    public static void deleteNode(node n){
        n.data=n.next.data;
        n.next=n.next.next;
    }
    public static void printList(node head){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        node a=new node(1);
        node b=new node(2);
        node c=new node(3);
        node d=new node(4);
        node e=new node(5);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;

        System.out.println("Original list:");
        printList(a);

        deleteNode(c);

        System.out.println("List after deleting node with value 3:");
        printList(a);
    }
}