package LinkedList;

public class Doubly_LinkedList 
{
    public static void main(String[] args)
    {
        DLL_without_tail d =new DLL_without_tail();

    }
}

class Node
{
    int val;
    Node prev;
    Node next;

    Node(){}

    Node(int val)
    {
        this.val=val;
    }

    Node(int val, Node prev, Node next)
    {
        this.val=val;
        this.prev=prev;
        this.next=next;
    }
}

class DLL_without_tail
{ 
    Node head;

    DLL_without_tail(){}


    // Adds a new node at the end (tail) of the doubly linked list.
    // Cases:
    // 1. List is empty -> new node becomes the head.
    // 2. List is non-empty -> traverse to the last node and append the new node.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void addNode(int val)
    {
        Node newNode=new Node(val);
        if(head==null)
        {
            head=newNode;
        }
        else
        {
            Node temp =head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.prev=temp;
        }
    }


    // Inserts a new node at the given 1-based position.
    // Cases:
    // 1. Empty list:
    //      - Position 1 -> insert as head.
    //      - Any other position -> invalid.
    // 2. Insert at the beginning (position 1) in a non-empty list.
    // 3. Insert in the middle of the list.
    // 4. Insert at the end (position = length + 1).
    // 5. Invalid position (> length + 1 or <= 0).
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void insertNode(int i, int val)
    {
        if(i <= 0)
        {
            System.out.println("Invalid position !!!");
            return;
        }
        Node temp=head;
        int j=0;
        Node newNode=new Node(val);
        if(head==null )
        {
            if(i==1)
            {
                head=newNode;
            }

            else
            {
                System.out.println("Invalid position !!!");
            }

            return;
        }
        if(i==1)
        {
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            return;
        }
        while(temp!=null)
        {   j++;
            if(j==i-1)
            {
                newNode.next=temp.next;
                newNode.prev=temp;
                if(temp.next != null)
                {
                    temp.next.prev = newNode;
                }
                temp.next=newNode;

                return;
            }
            temp=temp.next;
        }
        System.out.println("Invalid position !!!");
    }


    // Displays the list from head to tail.
    // Case:
    // 1. Empty list -> prints END.
    // 2. Non-empty list -> prints all nodes in forward direction.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void displayDLL()
    {
        if(head==null)
        {
            System.out.println("Empty Linked list !!!");
            return;
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.val+"-->");
            temp=temp.next;
        }
        System.out.println("END");
    }


    // Displays the list from tail to head.
    // Cases:
    // 1. Empty list -> prints "Empty LinkedList !!!".
    // 2. Non-empty list:
    //      a. Traverse to the last node.
    //      b. Traverse backward using prev pointers and print each node.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void displayReverseDLL()
    {
        if(head==null)
        {
            System.out.println("Empty Linkedlist !!!");
            return;
        }

        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        while(temp!=null)
        {
            
            System.out.print(temp.val);
            if(temp.prev != null)
            {
                System.out.print("<--");
            }

            temp=temp.prev;
        }
        System.out.println();
    }


    // Deletes the node at the given 1-based position.
    // Cases:
    // 1. Empty list -> prints "Empty LinkedList !!!".
    // 2. Delete the head node:
    //      a. List has only one node -> head becomes null.
    //      b. List has multiple nodes -> move head to the next node.
    // 3. Delete a middle node -> update both prev and next pointers.
    // 4. Delete the last node -> update the previous node's next pointer.
    // 5. Invalid position (> length or <= 0) -> prints "Invalid position !!!".
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void deleteNode(int i)
    {
        if(i <= 0)
        {
            System.out.println("Invalid position !!!");
            return;
        }

        if(head==null)
        {
            System.out.println("Empty linkedlisrt !!!");
            return;
        }
        if(i==1)
        {
            if(head.next == null)
            {
                head = null;
            }
            else
            {
                head = head.next;
                head.prev = null;
            }
            return;
        }
        int j=0;
       
        Node temp=head;
        while(temp!=null)
        {
            j++;
            if(j==i)
            {
                temp.prev.next=temp.next;
                if(temp.next != null)
                {
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp=temp.next;
        }

        System.out.println("Invalid position !!!");

    }


    // Reverses the doubly linked list in-place.
    // Cases:
    // 1. Empty list -> no change.
    // 2. Single-node list -> no change.
    // 3. Multiple-node list:
    //      a. Traverse the list and swap the next and prev pointers of each node.
    //      b. Update head to the original last node.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void reverseDLL()
{
    if(head == null || head.next == null)
    {
        return;
    }

    Node temp = head;
    Node last = null;

    while(temp != null)
    {
        last = temp;

        Node node = temp.next;
        temp.next = temp.prev;
        temp.prev = node;

        temp = temp.prev;
    }

    head = last;
}

}



class DLL_with_tail
{ 
    Node head;

    DLL_with_tail(){}


    // Adds a new node at the end (tail) of the doubly linked list.
    // Cases:
    // 1. List is empty -> new node becomes the head.
    // 2. List is non-empty -> traverse to the last node and append the new node.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void addNode(int val)
    {
        Node newNode=new Node(val);
        if(head==null)
        {
            head=newNode;
        }
        else
        {
            Node temp =head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.prev=temp;
        }
    }


    // Inserts a new node at the given 1-based position.
    // Cases:
    // 1. Empty list:
    //      - Position 1 -> insert as head.
    //      - Any other position -> invalid.
    // 2. Insert at the beginning (position 1) in a non-empty list.
    // 3. Insert in the middle of the list.
    // 4. Insert at the end (position = length + 1).
    // 5. Invalid position (> length + 1 or <= 0).
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void insertNode(int i, int val)
    {
        if(i <= 0)
        {
            System.out.println("Invalid position !!!");
            return;
        }
        Node temp=head;
        int j=0;
        Node newNode=new Node(val);
        if(head==null )
        {
            if(i==1)
            {
                head=newNode;
            }

            else
            {
                System.out.println("Invalid position !!!");
            }

            return;
        }
        if(i==1)
        {
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
            return;
        }
        while(temp!=null)
        {   j++;
            if(j==i-1)
            {
                newNode.next=temp.next;
                newNode.prev=temp;
                if(temp.next != null)
                {
                    temp.next.prev = newNode;
                }
                temp.next=newNode;

                return;
            }
            temp=temp.next;
        }
        System.out.println("Invalid position !!!");
    }


    // Displays the list from head to tail.
    // Case:
    // 1. Empty list -> prints END.
    // 2. Non-empty list -> prints all nodes in forward direction.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void displayDLL()
    {
        if(head==null)
        {
            System.out.println("Empty Linked list !!!");
            return;
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.val+"-->");
            temp=temp.next;
        }
        System.out.println("END");
    }


    // Displays the list from tail to head.
    // Cases:
    // 1. Empty list -> prints "Empty LinkedList !!!".
    // 2. Non-empty list:
    //      a. Traverse to the last node.
    //      b. Traverse backward using prev pointers and print each node.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void displayReverseDLL()
    {
        if(head==null)
        {
            System.out.println("Empty Linkedlist !!!");
            return;
        }

        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        while(temp!=null)
        {
            
            System.out.print(temp.val);
            if(temp.prev != null)
            {
                System.out.print("<--");
            }

            temp=temp.prev;
        }
        System.out.println();
    }


    // Deletes the node at the given 1-based position.
    // Cases:
    // 1. Empty list -> prints "Empty LinkedList !!!".
    // 2. Delete the head node:
    //      a. List has only one node -> head becomes null.
    //      b. List has multiple nodes -> move head to the next node.
    // 3. Delete a middle node -> update both prev and next pointers.
    // 4. Delete the last node -> update the previous node's next pointer.
    // 5. Invalid position (> length or <= 0) -> prints "Invalid position !!!".
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void deleteNode(int i)
    {
        if(i <= 0)
        {
            System.out.println("Invalid position !!!");
            return;
        }

        if(head==null)
        {
            System.out.println("Empty linkedlisrt !!!");
            return;
        }
        if(i==1)
        {
            if(head.next == null)
            {
                head = null;
            }
            else
            {
                head = head.next;
                head.prev = null;
            }
            return;
        }
        int j=0;
       
        Node temp=head;
        while(temp!=null)
        {
            j++;
            if(j==i)
            {
                temp.prev.next=temp.next;
                if(temp.next != null)
                {
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp=temp.next;
        }

        System.out.println("Invalid position !!!");

    }


    // Reverses the doubly linked list in-place.
    // Cases:
    // 1. Empty list -> no change.
    // 2. Single-node list -> no change.
    // 3. Multiple-node list:
    //      a. Traverse the list and swap the next and prev pointers of each node.
    //      b. Update head to the original last node.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void reverseDLL()
{
    if(head == null || head.next == null)
    {
        return;
    }

    Node temp = head;
    Node last = null;

    while(temp != null)
    {
        last = temp;

        Node node = temp.next;
        temp.next = temp.prev;
        temp.prev = node;

        temp = temp.prev;
    }

    head = last;
}

}
