/**
*
*@author Pheliswa Nontsanga
*@date 10 April 2023
*
*/

public class Account implements Comparable<Account>{
   private String accountDescription;
   private String accountName;
   private BinarySearchTree<Post> post;
  
   /**
   *the Account function is the constructor for the account class
   *
   *
   *@param String accountDescription is the description of the user
   *@param String accountName is the name of the user'account 
   *
   *@return a new user account with the descrption and account name
   */
   public Account(String accountDescription,String accountName){
    this.accountName = accountName;
    this.accountDescription = accountDescription;
    this.post = new BinarySearchTree<>();
   }
   
   
   /**
   *the  Account function is the constructor of the Account class
   *
   *@param String account Name is the account name
   *
   *@return
   */
   public Account(String accountName){
    this.accountName = accountName;
   }
   
       
   /**
   *the getDesciption function returns the description of an account
   *
   *@return account Description
   *
   */ 
   public String getDescription(){
    return accountDescription;
    }
    
   
   /**
   *the getAccountName function returns the account name
   *
   *@return accountName
   *
   */
   public String getAccountName(){
    return accountName;
    }
    
    
   /**
   *the displayPost function displays all post in order
   * 
   */
   public void displayPosts(){
    post.inOrder();
   }
   
   
   /**
   *the toString function returns a string representation of of the account class
   *it returns the accoount name
   *
   *@return account Name
   *
   */
   public String toString(){
    return accountName;
    }
    
   
   /**
   *the addPost function adds a post to a user's list of post
   *
   *@param String title is the title of the post
   *@param String video is the video
   *@param int numLikes is the number of post an account has
   *
   */
   public void addPost(String title,String video, int numLikes){
    post.insert(new Post(title,video,numLikes));
   }


   /**
   *the compareTo method compares one account to another
   *
   *@param differentAccount is different account that will be compared to the current account
   *
   *@return zero if they are equal, a negative number if the current account name is less or comes before the other account name alphabetically
   *
   */
   @Override
   public int compareTo(Account differentAccount){
     return this.accountName.compareTo(differentAccount.getAccountName());
     }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   }