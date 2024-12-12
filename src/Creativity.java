public class Rewards{
 private int points;
 private String username;
 
 public Rewards(String username,int points){
  this.username = username;
  this.points = points; 
  }
  
 public void setPoints(int points){
  this.points = points;
  }
  
 public void earnPoints(int quantity){
  this.points = this.points + quantity;
  }
  
 public void getPoints(){
  return this.points;}
  
 public void redeemPoints(int numPoints){
  if (numPoints < this.points){
   this.points = this.points - numPoints;
   System.out.println("Redeemed " +numPoints +"points. ");
   System.out.println( this.points + " left.");}
  else{
   System.out.println("Not enough points to redeem. ");
   System.out.println("You have " +numPoints +"points");
   System.out.println("Find out ways to redeem points to redeem points on our app");
   System.out.println("Tiktok referrel points - invite friends using the unique referral link from your Profile");
   System.out.println("Toktik coins");
   System.out.println("         You need to have a minimum of 1000 follows in order for you to be able to go live");
   System.out.println("         Earn gifts and convert them to points and reedem them");
   }   
   }
   
 
   
 
   
   }