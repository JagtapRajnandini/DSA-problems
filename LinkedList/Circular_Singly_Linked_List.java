package LinkedList;
class Circular_Singly_Linked_list
{
    public static void main(String[] args)
    {
        CSLL c=new CSLL();
        c.addNode(1);
        c.addNode(2);
        c.addNode(3);
        c.addNode(4);

        c.displayLL();

        c.insertNode(3, 3);
        c.displayLL();

        c.deleteNode(3);
        c.displayLL();

        c.reverseLL();
        c.displayLL();

    }
}

class CSLL
{
    class Node
    {
        int val;
        Node next;

        Node(){}

        Node(int val)
        {
            this.val=val;
        }

        Node(int val, Node next)
        {
            this.val=val;
            this.next=next;
        }
    }

    Node head;

    CSLL()
    {
        head=null;
    }

    /*
 * Approach:
 * - Create a new node with the given value.
 * - If the circular linked list is empty, make the new node the head
 *   and point its next to itself to maintain circularity.
 * - Otherwise, traverse the list until the last node
 *   (whose next points to the head).
 * - Link the last node to the new node and make the new node's next
 *   point to the head, preserving the circular structure.
 *
 * Time Complexity: O(n)
 * - In the worst case, the entire list is traversed to reach the last node.
 *
 * Space Complexity: O(1)
 * - Only a constant amount of extra space is used.
 */
    void addNode(int val)
    {
        Node newNode=new Node(val);

        if(head==null)
        {
            head=newNode;
            head.next=head;
        }

        else
        {
            Node curr=head;
            while(curr.next!=head)
            {
                curr=curr.next;
            }

            curr.next=newNode;
            newNode.next=head;
        }

    }


    /*
 * Approach:
 * - If the circular linked list is empty, return immediately.
 * - Otherwise, start traversing from the head.
 * - Use a do-while loop to visit and print each node exactly once.
 * - Continue traversal until the current node becomes the head again,
 *   indicating that a full cycle has been completed.
 *
 * Time Complexity: O(n)
 * - Each node is visited exactly once.
 *
 * Space Complexity: O(1)
 * - Only one traversal pointer is used.
 */
    void displayLL()
    {
        Node curr=head;

        if(head==null)
        {
            return;
        }
        do
        {
            System.out.print(curr.val+"-->");
            curr=curr.next;
        }
        while(curr!=head);
        System.out.print("(head)"+head.val);

        System.out.println();
    }


    /*
 * Approach:
 * - Validate the given position. If the position is less than or equal to 0,
 *   display an error message and terminate.
 * - If the circular linked list is empty, insert the new node only if the
 *   position is 1; otherwise, report that insertion is not possible.
 * - If inserting at the beginning (position 1), traverse to the last node,
 *   update the head to the new node, and reconnect the last node to the new head
 *   to preserve the circular structure.
 * - Otherwise, traverse the list until the node just before the required position.
 * - Insert the new node by updating the links between the previous node and
 *   the next node.
 * - If the specified position is beyond the valid range of the list,
 *   display an "Invalid Position" message.
 *
 * Time Complexity: O(n)
 * - In the worst case, the list is traversed once to reach the required position
 *   or to locate the last node during insertion at the beginning.
 *
 * Space Complexity: O(1)
 * - Only a constant amount of extra space is used.
 */
    void insertNode(int val, int position)
    {
        if(position<=0)
        {
            System.out.println("Invalid position !!!");
            return;
        }
        if(head==null)
        {
            if(position==1)
            {
                Node newNode=new Node(val);
                head=newNode;
                head.next=head;
                return;
            }

            else
            {
                System.out.println("Empty Linked list !!!");
                return;
            }
        }

        
        int i=0;
        Node curr=head;
        Node newNode=new Node(val);
        if(position==1)
                {
                    Node temp=head;
                    while(temp.next!=head)
                    {
                        temp=temp.next;
                    }

                    newNode.next=head;
                    head=newNode;
                    temp.next=head;
                    return;
                }

        
        do
        {
            i++;
            
            if(i==position-1)
            {
                if(curr.next==head  )
                {
                curr.next=newNode;
                newNode.next=head;
                return;
                }

                newNode.next=curr.next;
                curr.next=newNode;
                return;
            }
            curr=curr.next;
        }

        while(curr!=head);

        System.out.println("Invalid Position !!!");
        
        

    }


    /*
 * Approach:
 * - If the circular linked list is empty, display an appropriate message.
 * - Traverse the list to locate the last node, which is required when
 *   deleting the head node.
 * - If the node to be deleted is the head:
 *   - If it is the only node, make the list empty.
 *   - Otherwise, update the last node to point to the new head and
 *     move the head to the next node.
 * - If the node is not the head, traverse the list while maintaining
 *   both current and previous pointers.
 * - When the node with the given value is found, bypass it by updating
 *   the previous node's next pointer and disconnect the deleted node.
 * - If the value is not present in the list, display an appropriate message.
 *
 * Time Complexity: O(n)
 * - In the worst case, the list is traversed once to locate the node.
 *
 * Space Complexity: O(1)
 * - Only a constant amount of extra space is used.
 */
    void deleteNode(int val)
    {
        if(head==null)
        {
            System.out.println("Empty Linked list !!!");
            return;
        }

        Node curr=head;
        while(curr.next!=head)
        {
            curr=curr.next;
        }

        Node prev=curr;
        curr=head;

        if(head.val==val)
        {
            if(head.next==head)
            {
                head=null;
                return;
            }
            else
            {
                prev.next=curr.next;
                head=curr.next;
                curr.next=null;
                return;
            }
            
        }   

        do
        {

            if(curr.val==val)
            {
                
                    prev.next=curr.next;
                    curr.next=null;
                    return;
                
                
            }
            prev=curr;
            curr=curr.next;

        }

        while(curr!=head);

        System.out.println("Value not found in Linked list !!!");
    }


    /*
 * Approach:
 * - If the circular linked list is empty or contains only one node,
 *   no reversal is required.
 * - Traverse the list to locate the last node and initialize the
 *   previous pointer with it. This ensures the circular link is
 *   maintained while reversing the pointers.
 * - Starting from the head, reverse the direction of each link
 *   using three pointers: current, previous, and next (temporary).
 * - The 'last' pointer keeps track of the most recently processed node.
 *   After the reversal is complete, this node becomes the new head
 *   of the circular linked list.
 * - Finally, reconnect the old head (which is now the last node)
 *   to the new head and update the head reference.
 *
 * Time Complexity: O(n)
 * - The list is traversed once to find the last node and once to
 *   reverse the links.
 *
 * Space Complexity: O(1)
 * - Only a constant amount of extra space is used.
 */
    void reverseLL()
    {
        if(head==null || head.next==head)return;
        Node curr=head;
        Node last=curr;
        Node prev=null;
        while(curr.next!=head)
        {
            curr=curr.next;
        }

        prev=curr;
        curr=head;
        do
        {
            Node temp=curr.next;
            last=curr;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        while(curr!=head);

        head.next=last;
        head=last;
    }
}