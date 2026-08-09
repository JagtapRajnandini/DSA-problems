package Trees;
import java.util.Queue;
import java.util.LinkedList;
class Tree
{
    Tree(){}
    class Node
    {
        int val;
        Node left;
        Node right;

        Node()
        {

        }

        Node (int val)
        {
            this.val=val;
        }
    }

    Node root;

/*
 * ================================================================
 * INSERTION IN A NORMAL BINARY TREE
 * ================================================================
 */
/* Approach:
 * ----------
 * We insert a new node at the FIRST AVAILABLE POSITION
 * while moving level by level from LEFT to RIGHT.
 * This is called:
 *      Level-Order Insertion
 * and it uses:
 *      BFS (Breadth-First Search) + Queue
 * Example:
 * --------
 * Suppose the tree is:
 *
 *                 1
 *               /   \
 *              2     3
 *             / \
 *            4   5
 * Now we want to insert 6.
 * We check nodes level by level:
 *
 *                 1
 *               /   \
 *              2     3
 *             / \   /
 *            4   5 6
 * Why is 6 inserted as the left child of 3?
 * -------------------------------------------
 * Because insertion must happen at the FIRST AVAILABLE
 * position when going:
 *          LEFT → RIGHT
 *          LEVEL → LEVEL
 * STEP 1:
 * -------
 * Put the root into the Queue.
 *                 1
 *               /   \
 *              2     3
 *             / \
 *            4   5
 * Queue:
 *      [1]
 * STEP 2:
 * -------
 * Remove 1 from the Queue using poll().
 *      poll() removes and returns the FRONT element.
 * Queue:
 *      []
 * Check node 1:
 *      1.left  → 2  (not null)
 *      1.right → 3  (not null)
 * Since both children exist, put them into the Queue.
 * Queue:
 *      [2, 3]
 * STEP 3:
 * -------
 * Remove 2.
 * Queue:
 *      [3]
 * Check node 2:
 *      2.left  → 4  (not null)
 *      2.right → 5  (not null)
 * Both children exist, so add them to Queue.
 * Queue:
 *      [3, 4, 5]
 * STEP 4:
 * -------
 * Remove 3.
 * Queue:
 *      [4, 5]
 * Check node 3:
 *      3.left → null
 * We found the FIRST EMPTY position.
 * Therefore:
 *      3.left = newNode;
 * and immediately RETURN.
 * Final tree:
 *                 1
 *               /   \
 *              2     3
 *             / \   /
 *            4   5 6
 * ================================================================
 * WHY DO WE USE A QUEUE?
 * ================================================================
 * A Queue follows FIFO:
 *      First In → First Out
 * Example:
 *      Queue: [2, 3, 4, 5]
 *               ↑
 *            comes out first
 * poll() removes 2 first.
 * Then:
 *      3
 *      4
 *      5
 * come out in that order.
 * This naturally gives us:
 *      LEVEL 0 → LEVEL 1 → LEVEL 2 → ...
 * and within each level:
 *      LEFT → RIGHT
 * Therefore, a Queue is perfect for level-order insertion.
 * ================================================================
 * CODE LOGIC
 * ================================================================
 * 1. Create the new node.
 *      Node newNode = new Node(val);
 * 2. If the tree is empty:
 *      if(root == null)
 *      {
 *          root = newNode;
 *          return;
 *      }
 * The new node becomes the root.
 * 3. Create a Queue.
 *      Queue<Node> q = new LinkedList<>();
 * 4. Put the root into the Queue.
 *      q.offer(root);
 * 5. Continue while the Queue contains nodes.
 *      while(!q.isEmpty())
 * 6. Remove the front node.
 *      Node curr = q.poll();
 * 7. Check the LEFT child first.
 *      if(curr.left == null)
 *      {
 *          curr.left = newNode;
 *          return;
 *      }
 * If left already exists, put it into the Queue:
 *      q.offer(curr.left);
 * 8. Then check the RIGHT child.
 *      if(curr.right == null)
 *      {
 *          curr.right = newNode;
 *          return;
 *      }
 * If right already exists, put it into the Queue:
 *      q.offer(curr.right);
 * 9. Repeat until an empty position is found.
 * ================================================================
 * IMPORTANT:
 * ================================================================
 * We RETURN immediately after inserting the new node.
 * Why?
 * Because we only want to insert the element ONCE.
 * Example:
 *      if(curr.left == null)
 *      {
 *          curr.left = newNode;
 *          return;              ← stop insertion
 *      }
 * ================================================================
 * WHY NOT USE DFS / RECURSION HERE?
 * ================================================================
 * DFS explores one branch deeply before moving to another branch.
 * Example:
 *                 1
 *               /   \
 *              2     3
 *             /
 *            4
 * DFS could go:
 *      1 → 2 → 4
 * But we want insertion in LEVEL ORDER:
 *      1 → 2 → 3 → 4
 * Therefore BFS + Queue is the natural and simpler approach.
 * ================================================================
 * TIME COMPLEXITY
 * ================================================================
 * In the worst case, we may have to visit almost every node
 * before finding the first empty position.
 * Therefore:
 *      Time = O(n)
 * where n = number of nodes in the tree.
 * Why O(n)?
 * Because in the worst case we may check:
 *      1 → 2 → 3 → 4 → ... → n
 * ================================================================
 * SPACE COMPLEXITY
 * ================================================================
 * We use a Queue to store nodes that still need to be checked.
 * In the worst case, the Queue can contain O(n) nodes.
 * Therefore:
 *      Auxiliary Space = O(n)
 * For a balanced tree, the queue usually contains nodes from
 * one or two levels, so the practical space can be O(width).
 * More precisely:
 *      Space = O(w)
 * where w = maximum width of the tree.
 * Since w can be O(n) in the worst case:
 *      Worst-case Space = O(n)
 * ================================================================
 * FINAL SUMMARY
 * ================================================================
 * Normal Binary Tree Insertion:
 *      First available position
 *              ↓
 *      Level by level
 *              ↓
 *      Left to Right
 *              ↓
 *             BFS
 *              ↓
 *            Queue
 * Time Complexity:
 *      O(n)
 * Space Complexity:
 *      O(n) worst case
 * Key idea to remember:
 *      "Use a Queue to process the tree level by level
 *       and insert the new node at the first NULL child."

 * ================================================================
 */
    void insert(int val)
    {
        Node newNode = new Node(val);
        Queue<Node> q = new LinkedList<>();
        if(root==null)
        {
            root=newNode;
            return;
        }
        q.offer(root);
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            if(curr.left==null)
            {
                curr.left=newNode;
                return;
            }
            else
            {
                q.offer(curr.left);
            }
            if(curr.right==null)
            {
              curr.right=newNode;
                return;
            }
            else
            {
                q.offer(curr.right);
            }
        }
        
       
    }

/*
 * ================================================================
 * INORDER TRAVERSAL - DFS
 * ================================================================
 */
 /* Inorder follows:
 *      LEFT → ROOT → RIGHT
 * Example:
 *             1
 *            / \
 *           2   3
 *          / \
 *         4   5
 * Inorder:
 *      4 → 2 → 5 → 1 → 3
 * HOW IT WORKS:
 * 1. Go to the LEFT subtree.
 * 2. Process/print the ROOT.
 * 3. Go to the RIGHT subtree.
 * Code pattern:
 *      traverse(left)
 *      process(root)
 *      traverse(right)
 * RECURSION:
 *      if(root == null)
 *          return;
 * The null check is the BASE CASE.
 * It stops recursion when there is no node.
 * IMPORTANT:
 * Inorder traversal of a BST produces values in
 * SORTED ASCENDING ORDER.
 * Example BST:
 *             5
 *            / \
 *           3   8
 *          / \
 *         1   4
 * Inorder:
 *      1 → 3 → 4 → 5 → 8
 * COMPLEXITY:
 * Time  = O(n)
 * Space = O(h) auxiliary space due to recursion
 * h = height of tree
 * Balanced tree  → O(log n)
 * Skewed tree    → O(n)
 * MEMORY TRICK:
 *      INORDER = ROOT comes IN THE MIDDLE
 *      LEFT → ROOT → RIGHT
 * ================================================================
 */
    void  traverseDFS_inorder(Node root)//Left → Root → Right
    {
        if(root==null)return;
        traverseDFS_inorder(root.left);
        System.out.print(root.val+"-");
        traverseDFS_inorder(root.right);
    }

/* 
 * ================================================================
 * PREORDER TRAVERSAL - DFS
 * ================================================================
 */ 
/* Preorder follows:
 *      ROOT → LEFT → RIGHT
 * Example:
 *             1
 *            / \
 *           2   3
 *          / \
 *         4   5
 * Preorder:
 *      1 → 2 → 4 → 5 → 3
 * HOW IT WORKS:
 * 1. Process/print the ROOT.
 * 2. Go to the LEFT subtree.
 * 3. Go to the RIGHT subtree.
 * Code pattern:
 *      process(root)
 *      traverse(left)
 *      traverse(right)
 * RECURSION:
 *      if(root == null)
 *          return;
 * The null check is the BASE CASE.
 * The root is processed BEFORE its children.
 * COMPLEXITY:
 * Time  = O(n)
 * Space = O(h) auxiliary space due to recursion
 * h = height of tree
 * Balanced tree  → O(log n)
 * Skewed tree    → O(n)
 * MEMORY TRICK:
 *      PREORDER = ROOT comes FIRST
 *      ROOT → LEFT → RIGHT
 * ================================================================
 */
    void  traverseDFS_preorder(Node root)//Root → Left → Right
    {
        if(root==null)return;
        System.out.print(root.val+"-");
        traverseDFS_preorder(root.left);
        traverseDFS_preorder(root.right);
    }

/*
 * ================================================================
 * POSTORDER TRAVERSAL - DFS
 * ================================================================
*/
/* Postorder follows:
 *      LEFT → RIGHT → ROOT
 * Example:
 *             1
 *            / \
 *           2   3
 *          / \
 *         4   5
 * Postorder.
 *      4 → 5 → 2 → 3 → 1
 * HOW IT WORKS:
 * 1. Go to the LEFT subtree.
 * 2. Go to the RIGHT subtree.
 * 3. Process/print the ROOT.
 * Code pattern:
 *      traverse(left)
 *      traverse(right)
 *      process(root)
 * RECURSION:
 *      if(root == null)
 *          return;
 * The null check is the BASE CASE.
 * The root is processed AFTER both children.
 * COMPLEXITY:
 * Time  = O(n)
 * Space = O(h) auxiliary space due to recursion
 * h = height of tree
 * Balanced tree  → O(log n)
 * Skewed tree    → O(n)
 * MEMORY TRICK:
 *      POSTORDER = ROOT comes LAST
 *      LEFT → RIGHT → ROOT
 * ================================================================
 */
    void  traverseDFS_postorder(Node root)//Left → Right → Root
    {
        if(root==null)return;
        traverseDFS_postorder(root.left);
        traverseDFS_postorder(root.right);
        System.out.print(root.val+"-");
    }


    void traversal_BFS(Node root)
    {
        if(root == null)
            return;

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            Node curr = q.poll();
            System.out.print(curr.val + " ");
            if(curr.left != null)
                q.offer(curr.left);
            if(curr.right != null)
                q.offer(curr.right);
        }
    }

}



class BinaryTree
{
    public static void main(String[] args)
    {
        Tree t = new Tree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);

        t.traverseDFS_inorder(t.root);
        System.out.println();
        t.traverseDFS_preorder(t.root);
        System.out.println();
        t.traverseDFS_postorder(t.root);
        System.out.println();

        t.traversal_BFS(t.root);

    }
}
