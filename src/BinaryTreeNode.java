// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/*this class implements a BinaryTreeNode
*
*@author Hussein Suleman
*@date 26 March 2017
*
*/
public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   
   
   /**
   *the BinaryTreeNodes function creates an instance of the BinaryTreeNode class
   *it is a constructor
   *
   *@param dataType d sets the data  field of the node
   *@param BinaryTreeNode<d> l sets the lefy node to the binary tree node
   *@param BinaryTreeNode<d> r sets the right node of the current node
   *
   */
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
   }
   
   /**
   *the getLeft function returns the left child of the current node
   *
   *@return the left child of the current node
   *
   */
   BinaryTreeNode<dataType> getLeft () { return left; }
   
   
   /**
   *the getRight function returns the right node of the current node
   *
   *@return the right node of the current node
   *
   */
   BinaryTreeNode<dataType> getRight () { return right; }
}
