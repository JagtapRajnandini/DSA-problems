package LinkedList;

public class Singly_LinkedList
{
    public static void main(String[] args)
    {
        // Create an empty linked list
        SinglyLinkedList_withoutTail s = new SinglyLinkedList_withoutTail();

        // Insert elements at the end
        s.addNode(1);
        s.addNode(2);
        s.addNode(4);
        s.addNode(5);

        // Display original linked list
        s.displayLinkedList();

        // Insert element at position 3
        s.insertNode(3, 3);

        // Display updated linked list
        s.displayLinkedList();

        s.searchNode(3);
        s.searchNode(7);

        s.deleteNode(3);
        s.deleteNode(7);
        s.displayLinkedList();

        s.reverseLinkedList();
        s.displayLinkedList();


    }
}

// Represents a single node of the linked list
class Node
{
    int val;      // Data stored in the node
    Node next;    // Reference to the next node

    // Default constructor
    Node(){ }

    // Constructor to create a node with data
    Node(int val){
        this.val = val;
    }

    // Constructor to create a node with data and next reference
    Node(int val, Node next){
        this.val = val;
        this.next = next;
    }
}

// Represents a singly linked list
class SinglyLinkedList_withoutTail
{
    // Points to the first node of the linked list
    Node head;

    // Creates an empty linked list
    SinglyLinkedList_withoutTail()
    {
        head = null;
    }

    // Adds a new node at the end (tail) of the singly linked list.
    // Cases:
    // 1. List is empty -> new node becomes the head.
    // 2. List is non-empty -> traverse to the last node and append the new node.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void addNode(int val)
    {
        Node newNode = new Node(val);

        // If list is empty, new node becomes the head
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            // Traverse to the last node
            Node node = head;
            while(node.next != null)
            {
                node = node.next;
            }

            // Link the new node after the last node
            node.next = newNode;
        }
    }

    // Displays the singly linked list from head to tail.
    // Cases:
    // 1. Empty list -> prints "Empty Linked List !!!!".
    // 2. Non-empty list -> prints all nodes in forward direction.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void displayLinkedList()
    {
        if(head == null)
        {
            System.out.println("Empty Linked List !!!!");
            return;
        }

        // Traverse from head to the last node and print each value
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println();
    }

    // Inserts a new node at the given 1-based position.
    // Cases:
    // 1. Invalid position (position < 1) -> prints "Invalid Position !!!".
    // 2. Empty list:
    //      a. Position 1 -> insert as head.
    //      b. Any other position -> prints "Empty Linked List".
    // 3. Insert at the beginning (position 1) in a non-empty list.
    // 4. Insert in the middle of the list.
    // 5. Insert at the end (position = length + 1).
    // 6. Invalid position (> length + 1) -> prints "Invalid Position !!!".
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void insertNode(int val, int position)
    {
        // Position should be greater than or equal to 1
        if(position < 1)
        {
            System.out.println("Invalid Position !!!");
            return;
        }

        // Case 1: Empty linked list
        if(head == null)
        {
            // Only position 1 is valid in an empty list
            if(position == 1)
            {
                Node newNode = new Node(val);
                head = newNode;

                System.out.println("Value inserted at position " + position);
            }
            else
            {
                System.out.println("Empty Linked List");
            }

            return;
        }

        // Case 2: Insert at the beginning
        else if(position == 1)
        {
            Node newNode = new Node(val);

            newNode.next = head;
            head = newNode;
        }

        // Case 3: Insert at any other valid position
        else
        {
            Node temp = head;
            int i = 1;

            // Move temp to the node just before the required position
            while(temp != null && i < position - 1)
            {
                i++;
                temp = temp.next;
            }

            // Position is beyond the length of the linked list
            if(i != position - 1)
            {
                System.out.println("Invalid Position !!!");
                return;
            }

            Node newNode = new Node(val);

            // Adjust links to insert the new node
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Searches for the given value in the singly linked list.
    // Cases:
    // 1. Value found -> prints "Value found !!!".
    // 2. Value not found -> prints "Value not found !!!".
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void searchNode(int searchVal)
    {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.val==searchVal)
            {
                System.out.println("Value "+searchVal+" found !!!"); return;
            }
            temp=temp.next;
        }

        System.out.println("Value "+searchVal+" not found !!!");
    }

    // Deletes the first occurrence of the given value from the singly linked list.
    // Cases:
    // 1. Empty list -> prints "Empty LinkedList !!!".
    // 2. Delete the head node.
    // 3. Delete a middle node.
    // 4. Delete the last node.
    // 5. Value not found -> prints "Node not found !!!".
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void deleteNode(int deleteVal)
    {
        if(head==null)
        {
            System.out.println("Empty Linkedlist !!!");return;
        }

        Node temp = head;
        Node prev=null;
        while(temp!=null)
        {
            if(temp.val==deleteVal)
            {
                if(temp==head)
                {
                    prev=head;
                    head=head.next;
                    prev.next=null;
                    System.out.println("Node sucessfully deleted !!!");
                    return;
                }

                else
                {
                    prev.next=temp.next;
                    temp.next=null;
                    System.out.println("Node sucessfully deleted !!!");
                    return;
                }

            }
            prev=temp;
            temp=temp.next;
        }

        System.out.println("Node not found !!!");
    }

    // Reverses the singly linked list in-place.
    //
    // Approach:
    // 1. Check if the linked list is empty.
    // 2. Maintain three pointers:
    //      a. prev -> points to the previous node.
    //      b. curr -> points to the current node.
    //      c. temp -> temporarily stores the next node before changing the link.
    // 3. Maintain an additional pointer last, which always stores the current node
    //    before moving to the next one. After the traversal completes, last points
    //    to the original last node, which becomes the new head of the reversed list.
    // 4. For each node:
    //      a. Save the next node in temp.
    //      b. Reverse the current node's next pointer.
    //      c. Move prev and curr one step forward.
    // 5. After all links are reversed, update head to last.
    //
    // Cases:
    // 1. Empty list -> prints "Empty LinkedList !!!".
    // 2. Single-node list -> no visible change.
    // 3. Multiple-node list -> all next pointers are reversed and the original
    //    last node becomes the new head.
    //
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void reverseLinkedList()
    {
        if(head==null)
        {
            System.out.println("Empty Linkedlist  !!!");
            return;
        }
        Node prev=null;
        Node curr=head;
        Node last=curr;

        while(curr!=null)
        {
            last=curr;
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head=last;

    }
}


// Represents a singly linked list
class SinglyLinkedList_withTail
{
    // Points to the first node of the linked list
    Node head;
    Node tail;

    // Creates an empty linked list
    SinglyLinkedList_withTail()
    {
        head = null;
        tail=null;
    }

    // Adds a new node at the end (tail) of the singly linked list.
    // Cases:
    // 1. List is empty -> new node becomes the head.
    // 2. List is non-empty -> traverse to the last node and append the new node.
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    void addNode(int val)
    {
        Node newNode = new Node(val);

        // If list is empty, new node becomes the head
        if(head == null)
        {
            head = newNode;
            tail=head;
        }
        else
        {
            tail.next = newNode;
            tail=newNode;
        }
    }

    // Displays the singly linked list from head to tail.
    // Cases:
    // 1. Empty list -> prints "Empty Linked List !!!!".
    // 2. Non-empty list -> prints all nodes in forward direction.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void displayLinkedList()
    {
        if(head == null)
        {
            System.out.println("Empty Linked List !!!!");
            return;
        }

        // Traverse from head to the last node and print each value
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println();
    }

    // Inserts a new node at the given 1-based position.
    // Cases:
    // 1. Invalid position (position < 1) -> prints "Invalid Position !!!".
    // 2. Empty list:
    //      a. Position 1 -> insert as head.
    //      b. Any other position -> prints "Empty Linked List".
    // 3. Insert at the beginning (position 1) in a non-empty list.
    // 4. Insert in the middle of the list.
    // 5. Insert at the end (position = length + 1).
    // 6. Invalid position (> length + 1) -> prints "Invalid Position !!!".
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void insertNode(int val, int position)
    {
        // Position should be greater than or equal to 1
        if(position < 1)
        {
            System.out.println("Invalid Position !!!");
            return;
        }

        // Case 1: Empty linked list
        if(head == null)
        {
            // Only position 1 is valid in an empty list
            if(position == 1)
            {
                Node newNode = new Node(val);
                head = newNode;
                tail=head;

                System.out.println("Value inserted at position " + position);
            }
            else
            {
                System.out.println("Empty Linked List");
            }

            return;
        }

        // Case 2: Insert at the beginning
        else if(position == 1)
        {
            Node newNode = new Node(val);

            newNode.next = head;
            head = newNode;
        }

        // Case 3: Insert at any other valid position
        else
        {
            Node temp = head;
            int i = 1;

            // Move temp to the node just before the required position
            while(temp != null && i < position - 1)
            {
                i++;
                temp = temp.next;
            }

            // Position is beyond the length of the linked list
            if(i != position - 1)
            {
                System.out.println("Invalid Position !!!");
                return;
            }
            Node newNode = new Node(val);
            if(temp.next==null)
            {
               temp.next=newNode;
               tail=newNode; 
            }

            else
            {
                // Adjust links to insert the new node
                newNode.next = temp.next;
                temp.next = newNode;
            }
            
        }
    }

    // Searches for the given value in the singly linked list.
    // Cases:
    // 1. Value found -> prints "Value found !!!".
    // 2. Value not found -> prints "Value not found !!!".
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void searchNode(int searchVal)
    {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.val==searchVal)
            {
                System.out.println("Value "+searchVal+" found !!!"); return;
            }
            temp=temp.next;
        }

        System.out.println("Value "+searchVal+" not found !!!");
    }

    // Deletes the first occurrence of the given value from the singly linked list.
    // Cases:
    // 1. Empty list -> prints "Empty LinkedList !!!".
    // 2. Delete the head node.
    // 3. Delete a middle node.
    // 4. Delete the last node.
    // 5. Value not found -> prints "Node not found !!!".
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void deleteNode(int deleteVal)
    {
        if(head==null)
        {
            System.out.println("Empty Linkedlist !!!");return;
        }

        Node temp = head;
        Node prev=null;
        while(temp!=null)
        {
            if(temp.val==deleteVal)
            {
                if(temp==head)
                {
                    if(head.next==null)
                    {
                        head=null;
                        tail=head;
                    }
                    else
                    {
                         prev=head;
                        head=head.next;
                        prev.next=null;
                    }
                   
                    System.out.println("Node sucessfully deleted !!!");
                    return;
                }
                else if(temp==tail)
                {
                    prev.next=null;
                    tail=prev;
                    System.out.println("Node sucessfully deleted !!!");
                    return;
                }
                else
                {
                    prev.next=temp.next;
                    temp.next=null;
                    System.out.println("Node sucessfully deleted !!!");
                    return;
                }
            }
            prev=temp;
            temp=temp.next;
        }

        System.out.println("Node not found !!!");
    }

    // Reverses the singly linked list in-place.
    // Cases:
    // 1. Empty list -> no change.
    // 2. Single-node list -> no change.
    // 3. Multiple-node list -> reverse all next pointers and update head.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    void reverseLinkedList()
    {

    }
}
