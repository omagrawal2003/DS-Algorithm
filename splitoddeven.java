package basics;

public class splitoddeven {
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
    public static node splitOddEven(node head){
        if(head==null ){ 
            return head;
        }
        node temp=head;
        node even=new node(100); // dummy node for odd indexed list
        node odd =new node(200); // dummy node for even indexed list
        node even1=even;
        node odd1=odd;

        while(temp!=null){
            if(temp.data%2==0){
                even1.next=temp;
                even1=even1.next;
                temp=temp.next;
            }
            else{
                odd1.next=temp;
                odd1=odd1.next;
                temp=temp.next;
            }
        }
        
       
        even1.next=null;
        odd1.next=even.next;
        

       return odd.next;
     }
     public static node oddEvenWithoutDummy(node head){
        if(head==null){
            return head;
        }
        node temp=head;
        node oddHead=null;
        node oddTail=null;  
        node evenHead=null;
        node evenTail=null;
        while(temp!=null){
            if(temp.data%2!=0){ // odd
                if(oddHead==null){
                    oddHead=temp;
                    oddTail=temp;
                }
                else{
                    oddTail.next=temp;
                    oddTail=oddTail.next;
                }
            }
            else{ // even
                if(evenHead==null){
                    evenHead=temp;
                    evenTail=temp;
                }
                else{
                    evenTail.next=temp;
                    evenTail=evenTail.next;
                }
            }
            temp=temp.next;
        }
        if(oddTail!=null){
            oddTail.next=null;
        }   
        if(evenTail!=null){
            evenTail.next=null;
        }
        if(oddHead==null){
            return evenHead;
        }
        oddTail.next=evenHead;
        return oddHead;

        
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

        node splitLists=splitOddEven(a);
        System.out.println("Odd indexed list:");
        printlist(splitLists);
        
    }
}
