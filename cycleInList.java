package basics;

public class cycleInList {
    public static class node{
        int data;
        node next;
        node(int data){
            this.data = data;
           
         }
    }
    public static boolean isCycle(node head){
        node slow = head;
        node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
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

        if(isCycle(a)){
            System.out.println("Cycle detected in the linked list.");
        } else {
            System.out.println("No cycle in the linked list.");
        }
    }
}
