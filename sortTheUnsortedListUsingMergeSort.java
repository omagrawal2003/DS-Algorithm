package basics;

public class sortTheUnsortedListUsingMergeSort {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data=data;
        }
    }
    public static class mergeSortLinkedList{
        public static node mergeSort(node head){
            if(head==null || head.next==null){
                return head;
            }
            node mid=getMiddle(head);
            node right=mid.next;
            mid.next=null;

            node leftsorted=mergeSort(head);
            node rightsorted=mergeSort(right);
            return merge(leftsorted, rightsorted);
        }
        public static node merge(node left, node right){
            if(left==null)return right;
            if(right==null)return left;
            node mergedHead=new node(100);
            node x=mergedHead;
            node tempA=left;
            node tempB=right;
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


        public static node getMiddle(node head){
            if(head==null){
                return head;
            }
            node slow=head;
            node fast=head.next;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
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
            node a=new node(38);
            a.next=new node(27);
            a.next.next=new node(43);    
            a.next.next.next=new node(3);
            a.next.next.next.next=new node(9);
            a.next.next.next.next.next=new node(82);
            a.next.next.next.next.next.next=new node(10);

            node b=new node(25);
            b.next=new node(356);
            b.next.next=new node(4);    
            b.next.next.next=new node(31);
            b.next.next.next.next=new node(19);
            b.next.next.next.next.next=new node(32);
            b.next.next.next.next.next.next=new node(1000);

            System.out.println("Original list A:");
            printList(a);
            System.out.println("Original list B:");
            printList(b);

            node sortedHeadA=mergeSort(a);
            node sortedHeadB=mergeSort(b);

            System.out.println("Sorted list A:");
            printList(sortedHeadA);
            System.out.println("Sorted list B:");
            printList(sortedHeadB);
            node x=merge(sortedHeadA, sortedHeadB);
            System.out.println("Merged sorted list:");
            printList(x);
        }
    }
}
