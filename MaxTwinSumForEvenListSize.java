package basics;

public class MaxTwinSumForEvenListSize {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }
    public static int MaxTwinSumForEvenListSize1(node head){
        node slow=head;
        node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        node secondHalves=slow.next;
        slow.next=null;
        node revSecond=reverseList(secondHalves);
        node h=new node(100);
        node tail=h;
        node p1=head;
        node p2=revSecond;
        int maxSum=Integer.MIN_VALUE;
        while(p1!=null && p2!=null){
            int sum= p1.data+p2.data;
            if(sum>maxSum){
                maxSum=sum;
            }
            p1=p1.next;
            p2=p2.next;

        }
        return maxSum;
    }
    public static node reverseList(node head){
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
    public static void printList(node head){
        node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[]args){
        node n1 = new node(2);
        node n2 = new node(4);
        node n3 = new node(52);
        node n4 = new node(23);
        node n5 = new node(25);
        node n6 = new node(15);
        node n7 = new node(26);
        node n8 = new node(35);

        // Connecting nodes
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        System.out.println("original list is:");
        printList(n1);
        System.out.println("after suffix sum is:");
        int sum=MaxTwinSumForEvenListSize1(n1);
        System.out.println(sum);

        

    
    
    }
}
