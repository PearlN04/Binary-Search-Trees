/*This allows a user to redeem points from the Toktik app
*
*@author Pheliswa Nontsanga
*
*/

public class RedeemSystem{
   private int points;
   private String username;
  
   /**
   *constructor for the RedeemSystem class
   *creates an instance of the RedeemSystem
   *@param String username is the name of the user
   *@param int points is the number of points a user has
   *
   */
   public RedeemSystem(String username,int points){
     this.username = username;
     this.points = points; 
   }
  
   /**
   *the setPoints is a setter method for the RedeemSystem class
   *sets the number of points a user has
   *@param int points number of points a user has
   *
   */ 
   public void setPoints(int points){
     this.points = points;
   }
  
   /**
   *the earnPoints add additional points the user has earned to the user's points
   *
   *@param int additionalPoints is the number of points the user has earned
   *
   */
   public void earnPoints(int additionalPoints){
     this.points = this.points + additionalPoints;
   }
  
   /**
   *the getPoints returns the number of points a user has
   *
   */
   public int getPoints(){
      return this.points;
   }
   
   /**
   *the redeemPoints functions allows a user to redeem points
   *it then subtracts the number of points has redeemed from the number of points the user had
   *it prints out the number of points a user has remaining
   *
   *@param int numPoints is the number of points the user wants to redeem
   *
   */
   public void redeemPoints(int numPoints){
      if (numPoints <= this.points){
          this.points = this.points - numPoints;
          System.out.println("Redeemed: " +numPoints +" points. ");}
      else{
          System.out.println("Not enough points to redeem. ");
          System.out.println("Find out ways to earn points");
          System.out.println("1. Tiktok referrel points - invite friends using the unique referral link from your Profile");
          System.out.println("2. Toktik coins");
          System.out.println("         You need to have a minimum of 1000 follows in order for you to be able to go live");
          System.out.println("         Earn gifts and convert them to points and reedem them");
      }   
   }
   
 
}
