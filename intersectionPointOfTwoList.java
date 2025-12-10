package basics;

public class intersectionPointOfTwoList {
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
    public static int findlength(node head){
        node temp=head;
        int length=0;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }
    public static node intersectionPoint(node head1, node head2){
        int l1=findlength(head1);
        int l2=findlength(head2);
        node temp1=head1;
        node temp2=head2;
        int x=Math.abs(l1-l2);
         for(int i=0; i<x; i++){
            if(l1<l2){
                temp2=temp2.next;
            } else {
                temp1=temp1.next;
            }
         }
            while(temp1!=null && temp2!=null){
                if(temp1==temp2){
                    return temp1;
                }
                temp1=temp1.next;
                temp2=temp2.next;
            }
            return null;
    }
    public static void main(String[] args) {
        node a=new node(3);
        node b=new node(6);
        node c=new node(9);
        node d=new node(15);
        node e=new node(30);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;

        
        node q=new node(1);
        node r=new node(0);

    
        q.next=r;
        r.next=d; // Creating intersection at node with data 15

        printlist(a);
        printlist(q);
        node intersectionNode=intersectionPoint(a, q);
        if(intersectionNode!=null){
            System.out.println("Intersection point data: "+intersectionNode.data);
        } else {
            System.out.println("No intersection point found.");
        }

        
    }
}
