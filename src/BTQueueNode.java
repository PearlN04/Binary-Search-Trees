// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/**
*this class implements a binary tree queue node
*
*@author Hussein Suleman
*@date 26 March 2017
*
*/
public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
   
   /**
   *the BTQueueNode is the constructor for the BTQueueNode class
   *it sets the node the variable to be n and next to be nxt
   *
   *@param BinaryTreeNode<dataType>n sets the node variable
   *@param BTQueueNode<dataType> nxt sets the next node in the queue
   *
   */
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
