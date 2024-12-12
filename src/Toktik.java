/**Toktik main program
*
*@ author Pheliswa Nontsanga
*/
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Toktik {    
        static Scanner keyboard = new Scanner(System.in);
        private static BinarySearchTree<Account> bt;
        
        
        /**
        The find user function allows the user to search for an account
        *it asks the user to enter an account name
        *searches for the name in the binary search tree
        *then it displays the specific user's description
        *
        */
        private static void findUser(){
           System.out.print("Enter the account name: ");
           String account = keyboard.nextLine();
           BinaryTreeNode<Account> btn = bt.find(new Account(null,account));
     
           if (btn!= null){
              System.out.print("The profile description is: ");
              System.out.println(btn.data.getDescription());  //returns the account description
          }
          else{
             System.out.println("User not found");
              }
        }
    
        /**
        *The loadData set function loads data about users from a textfile
        *it then loads it into a binary search tree
        *looks for keywords in profile such as create and/or Add
        *if it's create it creates new account object and loads in into the binary search tree
        *if the keyword is add then it adds a post to a user account
        *
        */ 
        private static void loadDataSet() throws IOException{
          try{
            File myFile = new File("dataset.txt");
            BufferedReader line = new BufferedReader(new FileReader(myFile));
            String accDetails;
            while ((accDetails = line.readLine()) != null){
       
              if (accDetails.startsWith("Create")){
                // creates a new account
                int spaceIndex = accDetails.indexOf(" ");
                String accountinfo=accDetails.substring(spaceIndex+1,accDetails.length());
                int spaceIndex2= accountinfo.indexOf(" ");
                String user = accountinfo.substring(0,spaceIndex2);
                String description = accountinfo.substring(spaceIndex2+1,accountinfo.length());
                bt.insert(new Account(description,user));
              }
           
              else if (accDetails.startsWith("Add")){ 
               //extracts the account name, video , number of likes and title from the textfile and add it as a new post
               String videoInfo = accDetails;
               int spaceIndex = videoInfo.indexOf(" ");
               videoInfo =videoInfo.substring(spaceIndex+1,videoInfo.length());
     
               spaceIndex = videoInfo.indexOf(" ");
               String accountName = videoInfo.substring(0,spaceIndex);
               videoInfo = videoInfo.substring(spaceIndex+1,videoInfo.length());  
              
               spaceIndex = videoInfo.indexOf(" ");
               String video = videoInfo.substring(0,(videoInfo.indexOf(" ")+1));
     
               videoInfo = videoInfo.substring(spaceIndex+1,videoInfo.length());
               spaceIndex = videoInfo.indexOf(" ");
               int numLikes = Integer.parseInt(videoInfo.substring(0,spaceIndex));
     
               videoInfo = videoInfo.substring(spaceIndex+1,videoInfo.length());
               spaceIndex = videoInfo.indexOf(" ");
               String title = videoInfo.substring(0,videoInfo.length());          
          
               Account user = bt.find(new Account(accountName)).data;
               if (user != null)
                 user.addPost(title,video,numLikes);
               }
            }
            line.close();
            }  
      
            catch(FileNotFoundException e){     //returns an error message if the file was not found
                System.out.println("Dataset was not found");
             }
        }
           
        /**
        *The deleteUser function deletes a user from the system
        *it ask the user to enter the account name that it wants to delete 
        *it removes the user from the binary search tree
        *
        */
        private static void deleteUser(){
             System.out.println("Enter User Name");
             String user = keyboard.nextLine();
             BinaryTreeNode<Account> btn = bt.find(new Account(null,user));
             if (btn == null){
              System.out.println("The user you entered does not exist");}
             else{             
             BinaryTreeNode<Account> btreenode = bt.delete(new Account(null,user),bt.root);
             if (btreenode != null){
                System.out.println("User " +user +" has been deleted");
                }
             }
       }
             
         
       /**
       *this addUser function adds a new user to the system
       *user enters the account name and description and creates an Account objects
       *it then inserts the user into the binary search tree
       *
       */
       private static void addUser(){
            System.out.println("Enter the account name");
            String user = keyboard.nextLine();
            System.out.println("Enter the profile description");
            String description = keyboard.nextLine();
            bt.insert(new Account(description, user));
            System.out.println("User added");
       }
     
     
       /**
       *this displayPost function displays all post of a certain user based on the accountName that was entered
       *it prompts the user to enter the specific account name that it's looking for
       *then it displays of all the post of that account
       */
       private static void displayPosts(){
            System.out.print("Enter the account name: ");
            String accName = keyboard.nextLine();
            BinaryTreeNode<Account> btn = bt.find(new Account(accName));
     
            if (btn!= null){
              bt.find(new Account(accName)).data.displayPosts();
            }
           else{
             System.out.println("User not found");
           }
       }

        
       /**
       *this addNewPost function allows the user to post a new post
       *adds a new post to the user's posts
       *
       */
       public static void addNewPost(){
        System.out.println("Enter account name");
        String accName = keyboard.nextLine();
        System.out.println("Enter the title");
        String title  = keyboard.nextLine();
        System.out.println("Enter video");
        String clipName =keyboard.nextLine();
       
        BinaryTreeNode<Account> btn = bt.find(new Account(null,accName));
     
          if (btn!= null){
              bt.find(new Account(accName)).data.addPost(title,clipName,0);
          }
          else{
             System.out.println("User not found, post not added");
          }
       }

       

       /**
       *The redeemRewards function allows a user to redeem points from the TokTik app
       *
       */
       public static void reedemRewards() throws IOException{
          Scanner keyboard = new Scanner(System.in);
          System.out.println("Enter your Name");
          ArrayList<String> accountNames = new ArrayList<>();
          ArrayList<Integer> accountPoints = new ArrayList<>();
   
          try{
            File myFile = new File("names.txt");
            BufferedReader line = new BufferedReader(new FileReader(myFile));
            String accDetails;
            while ((accDetails = line.readLine()) != null){
               int spaceIndex = accDetails.indexOf("#");
                String accountname = accDetails.substring(0,spaceIndex);
                int iPoints =Integer.parseInt(accDetails.substring(spaceIndex+1,accDetails.length()));
                accountNames.add(accountname);
                accountPoints.add(iPoints); 
               
            }
            line.close();
          }
             
          catch(FileNotFoundException e){     //returns an error message if the file was not found
                System.out.println("Names.txt was not found");
          }       
          String userName = keyboard.nextLine();
          String existance = " ";
          for (int i=0; i<accountNames.size();i++){
             if (accountNames.get(i).equals(userName)){
                 System.out.println(accountNames.get(i));
                 RedeemSystem user = new RedeemSystem(accountNames.get(i),accountPoints.get(i));
                 user.setPoints(accountPoints.get(i));
                 System.out.println("Enter the number of points that you want to redeem");
                 int numPoints = keyboard.nextInt();
                 user.redeemPoints(numPoints);
                 System.out.println("Points remaining: " +user.getPoints());
                 existance = " " +"yes";
             }
          }
          if(existance == " "){          //checks if the user exist or not
          System.out.println("User not found");
          }
       
       }
                  
         
       public static void main(String[] args) throws Exception{
         bt = new BinarySearchTree<> ();
        
         int iOption  = 0;
        
         do{
          //prompts the user to choose an option from the menu 
          System.out.println("Choose an action from the menu:");
          System.out.println("1. Find the profile description for a given account");
          System.out.println("2. List all accounts");
          System.out.println("3. Create an account");
          System.out.println("4. Delete an account");
          System.out.println("5. Display all posts for a single account");
          System.out.println("6. Add a new post for an account");
          System.out.println("7. Load a file of actions from disk and process this");
          System.out.println("8. Reedem points");
          System.out.println("9. Quit");
          System.out.print("Enter your choice: ");
        
          try {
                iOption =  Integer.parseInt(keyboard.nextLine()) ;
          } catch (Exception e) {
          }
        
          switch (iOption){
          case 1:
            findUser();              //displays the user description based on the account entered
            break;
          case 2:
            bt.inOrder(bt.root);      //displays all accounts in the system
            break;
          case 3:   
             addUser();             //calls the addUser function
             break;
          case 4:     
             deleteUser();                
             break;
          case 5:
             displayPosts();
             break;
          case 6:
             addNewPost();
             break;
         case 7:
             loadDataSet();        //loads the data from the textfile
             System.out.println("Dataset loaded");
             break;
         case 8 : 
             reedemRewards();
             break;
         }  
         
         
         //if (iOption == 9) {
           //System.out.println("Bye!");
           //System.exit(0);
        // }
         //else if ((iOption < 1) | (iOption>9)){        //if the user enters an option that's not there returns an error message
           //System.out.println("Invalid choice");    

         //}
         }while (iOption !=9); 
       }       

}

