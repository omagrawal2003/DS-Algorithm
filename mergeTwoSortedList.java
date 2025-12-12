package basics;

public class mergeTwoSortedList {
    static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }
    public static node mergeTwoSortedList(node a, node b){
        node tempA=a;
        node tempB=b;
        node mergedHead=new node(100);
        node x=mergedHead;
        if(tempA==null) return tempA;
        if(tempB==null) return tempB;
        while(tempA!=null && tempB!= null){
        if(tempA.data<=tempB.data){
            x.next=tempA;
            tempA=tempA.next;
            x=x.next;
            
        }
        else{
            x.next=tempB;
            tempB=tempB.next;
            x=x.next;
            
        } 
        }
        if(tempA != null) x.next = tempA;
        if(tempB != null) x.next = tempB;

     return mergedHead.next;
}
    
    public static void main (String[]args){
        node a=new node(1);
        a.next=new node(3);
        a.next.next=new node(5);    
        a.next.next.next=new node(8);
        
        node b=new node(2);
        b.next=new node(4); 
        b.next.next=new node(6);
        b.next.next.next=new node(7);;
        node x=mergeTwoSortedList(a, b);
        while(x!=null){
            System.out.print(x.data+" ");
            x=x.next;
        
        }
    }
}
