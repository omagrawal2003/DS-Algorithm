package basics;

public class removeduplicatesAdjacent {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }
    public static node removeDuplicatesAdjacent(node head){
       if(head==null ){
        return head;
       }
       node temp=head;
       while(temp!=null && temp.next!=null){
        if(temp.data==temp.next.data){
            temp.next=temp.next.next;
            
        }
        else{
            temp=temp.next;
        }
        

       }
         return head;
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
        node a=new node(1);
        node b=new node(1);
        node c=new node(2);
        node d=new node(3);
        node e=new node(3);
        node f=new node(4);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;

        System.out.println("Original list:");
        printList(a);

        node updatedHead=removeDuplicatesAdjacent(a);

        System.out.println("List after removing adjacent duplicates:");
        printList(updatedHead);
    }
}
