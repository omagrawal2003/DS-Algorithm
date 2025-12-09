package basics;

public class FindNthByTwoPointer {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }   
    public static node NthFromLast(node head, int n){
        node first=head;
        node second=head;
        for(int i=0;i<n;i++){
            if(first==null){
                return null; // n is greater than the length of the list
            }
            first=first.next;
        }
        while(first!=null){
            first=first.next;
            second=second.next;
        }
        return second;
    }
    public static void main(String[]arge){
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

        node n=NthFromLast(a, 3);
        System.out.println("3rd node from last is: " + n.data);
    }
}
