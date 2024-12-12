// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/**
*this class implements a binary tree queue
*
*@author Hussein Suleman
*@date 26 March 2017
*
*/
public class BTQueue<dataType>
{   
   BTQueueNode<dataType> head;
   BTQueueNode<dataType> tail;
   
   /**
   *the BTQueue function is a constuctor for the BTQueue class
   *
   *
   *@return a reference to a a new BTQueue object
   *
   */  
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   
   /**
   *the getNext function returns the next node
   *
   *
   *@return the next node in the queue
   *
   */
   public BinaryTreeNode<dataType> getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode<dataType> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   
   
   /**
   *the enQueue function adds a node to the end of the queue
   *
   *@param BinaryTreeNode<dataType>node is the node that is being added to the queue
   *
   */
   public void enQueue ( BinaryTreeNode<dataType> node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode<dataType> (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode<dataType> (node, null);
         tail = tail.next;
      }   
   }   
}
