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


    /*
 * ================================================================
 * BFS / LEVEL-ORDER TRAVERSAL OF BINARY TREE
 * ================================================================
 */
 /* BFS = Breadth-First Search.
 * In a Binary Tree, BFS visits nodes:
 *      LEVEL BY LEVEL
 *      LEFT → RIGHT
 * Example:
 *              1
 *            /   \
 *           2     3
 *          / \   / \
 *         4   5 6   7
 * BFS / Level-Order:
 *      1 → 2 → 3 → 4 → 5 → 6 → 7
 * ================================================================
 * WHY DO WE USE A QUEUE?
 * ================================================================
 * BFS uses a Queue because Queue follows FIFO:
 *      First In → First Out
 * This makes the tree get processed level by level.
 * Example:
 *      Start:
 *          Queue = [1]
 *      Process 1:
 *          Queue = [2, 3]
 *      Process 2:
 *          Queue = [3, 4, 5]
 *      Process 3:
 *          Queue = [4, 5, 6, 7]
 * Therefore, nodes are processed:
 *      1 → 2 → 3 → 4 → 5 → 6 → 7
 * ================================================================
 * CODE LOGIC
 * ================================================================
 * 1. If the tree is empty, there is nothing to traverse.
 *      if(root == null)
 *          return;
 * 2. Create a Queue to store nodes waiting to be processed.
 *      Queue<Node> q = new LinkedList<>();
 * 3. Add the root to the Queue.
 *      q.offer(root);
 *      Queue:
 *          [1]
 * 4. Continue while the Queue is not empty.
 *      while(!q.isEmpty())
 * 5. Remove the FRONT node from the Queue.
 *      Node curr = q.poll();
 *      poll() = removes and returns the front element.
 * 6. Process/print the current node.
 *      System.out.print(curr.val + " ");
 * 7. Add the LEFT child if it exists.
 *      if(curr.left != null)
 *          q.offer(curr.left);
 * 8. Add the RIGHT child if it exists.
 *      if(curr.right != null)
 *          q.offer(curr.right);
 * 9. Repeat until the Queue becomes empty.
 * ================================================================
 * DRY RUN
 * ================================================================
 * Tree:
 *              1
 *            /   \
 *           2     3
 *          / \   / \
 *         4   5 6   7
 * Initial:
 *      Queue = [1]
 * ------------------------------------------------
 * Process 1
 *      Print: 1
 *      Add 2 and 3
 *      Queue = [2, 3]
 * ------------------------------------------------
 * Process 2
 *      Print: 2
 *      Add 4 and 5
 *      Queue = [3, 4, 5]
 * ------------------------------------------------
 * Process 3
 *      Print: 3
 *      Add 6 and 7
 *      Queue = [4, 5, 6, 7]
 * ------------------------------------------------
 * Process 4
 *      Print: 4
 *      No children
 *      Queue = [5, 6, 7]
 * ------------------------------------------------
 * Process 5
 *      Print: 5
 *      Queue = [6, 7]
 * ------------------------------------------------
 * Process 6
 *      Print: 6
 *      Queue = [7]
 * ------------------------------------------------
 * Process 7
 *      Print: 7
 *      Queue = []
 * Queue is empty → traversal ends.
 * Final output:
 *      1 2 3 4 5 6 7
 * ================================================================
 * IMPORTANT DIFFERENCE FROM DFS
 * ================================================================
 * DFS:
 *      Goes deep into a branch first.
 *      Uses:
 *          Recursion / Stack
 *      Traversals:
 *          Inorder
 *          Preorder
 *          Postorder
 * BFS:
 *      Goes level by level.
 *      Uses:
 *          Queue
 *      Traversal:
 *          Level-Order
 * ================================================================
 * TIME COMPLEXITY
 * ================================================================
 * Every node is visited exactly once.
 *      Time = O(n)
 * where n = number of nodes.
 * ================================================================
 * SPACE COMPLEXITY
 * ================================================================
 * The Queue stores nodes waiting to be processed.
 *      Space = O(w)
 * where w = maximum width of the tree.
 * Worst case:
 *      O(n)
 * Therefore:
 *      Worst-case Auxiliary Space = O(n)
 * ================================================================
 * MEMORY TRICK
 * ================================================================
 *      BFS = LEVEL BY LEVEL
 *          ↓
 *       USE QUEUE
 *          ↓
 *       FIFO
 *          ↓
 *      LEFT → RIGHT
 * Key idea:
 *      "Remove one node from the Queue,
 *       process it, then add its left and
 *       right children to the Queue."
 * ================================================================
 */
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


/*Searching in Binary Tree
 * Approach:
 * Use DFS to search the binary tree.
 * Check the current node, then recursively search
 * the left and right subtrees.
 *
 * Time: O(n)
 * Space: O(h), where h is the height of the tree.
 */
    boolean searchNode(Node root, int val)
    {
        if(root==null)return false;
        if(root.val==val)return true;
        return searchNode(root.left, val) || searchNode(root.right, val);
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

        System.out.println("\n"+t.searchNode(t.root, 3));
        System.out.println(t.searchNode(t.root, 10));


    }
}
