// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/**
*Binary tree created by Hussein
*implements a binary tree 
*
*@author Hussein Suleman
*@date 26 March 2017
*
*/
public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   
   /**
   *the BinaryTree function is the constructor of the binary tree
   *it sets the root to null
   *
   */
   public BinaryTree ()
   {
      root = null;
   }
   
   /**
   *the getHeight function returns the height of the tree at the root
   *
   *@return height of the tree at the root
   *
   */
   public int getHeight ()
   {
      return getHeight (root);
   } 
     
   
   /**
   *the getHeight function returns the height of the binary tree
   *
   *@return the height of the tree
   *
   */
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   
   /**
   *the getSize function returns the number of nodes in the tree
   *
   *@return number of nodes in the tree
   *
   */
   public int getSize ()
   {
      return getSize (root);
   }   
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   /**
   *the visit function prints out the data contained in the node
   *
   *@param BinaryTreeNode<dataType> node  the node that contains the data
   *
   */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   
   
   /**
   *the preOrder function prints the tree in preOrder
   *
   */
   public void preOrder ()
   {
      preOrder (root);
   }
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }
   
   /**
   *the postOrder function prints the tree in postOrder
   *
   */
   public void postOrder ()
   {
      postOrder (root);
   }
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }
   
   /**
   *the inOrder function prints the tree in inOrder
   *
   */
   public void inOrder ()
   {
      inOrder (root);
   }
   
   /**
   * the inOrder function traverses the tree in order
   *
   *@param BinaryTreeNode<dataType> node keeps track of the current node
   *
   */
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
   
   /**
   *the levelOrder funcion prints the data of the binary tree in level order
   *a queue is used to keep track of the nodes that have to be visited and
   *those that been visited already
   *the root node is added to the queue first then it's right and left child
   *are also added if the node has a right and/or left child
   *it proceeds to the next node in line and adds that one's childeren
   *until all the nodes have been filled up
   *
   */
   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}
