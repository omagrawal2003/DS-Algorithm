package basics;

public class findNodeWherecycleBegin {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
           
         }
    }
    public static node findCycleBegin(node head){
        node slow = head;
        node fast = head;
        node temp=null;

        // Detect cycle using Floyd's Tortoise and Hare algorithm
        while(fast != null && fast.next != null){
           fast=fast.next.next;
           temp=slow;
           slow=slow.next;
            if(slow == fast){
                return temp;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        node a = new node(1);
        node b = new node(2);
        node c= new node(3);
        node d= new node(4);
        
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=b; // Creating a cycle for testing

        node cycleBeginNode = findCycleBegin(a);
        if(cycleBeginNode != null){
            System.out.println("Cycle begins at node with data: " + cycleBeginNode.data);
        } else {
            System.out.println("No cycle in the linked list.");
        }
    }
}
