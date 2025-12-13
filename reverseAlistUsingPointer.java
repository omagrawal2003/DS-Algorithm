package basics;

public class reverseAlistUsingPointer {
    static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }
    public static node reverseAlistUsingPointer(node head){
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
    public static void printlist(node head){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        node a=new node(0);
        a.next=new node(7);
        a.next.next=new node(3);
        a.next.next.next=new node(41);
        a.next.next.next.next=new node(51);

        
        System.out.println("original list is:");
        printlist(a);
        System.out.println("reverse list is :");
        node x=reverseAlistUsingPointer(a);
        printlist(x);
    }
}
