
/**
 * A Pass has an id number, name, a luxury rating,
 * number of credits and journey points
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pass 
{
   //fields
   private int passId;
   private String name;
   private int luxuryRating;
   private int CreditNo;
   private int JourneyPoints;
   
   //constructor
   public Pass ( int Id , int LR , int CN , int JP , String namme  ) {
       passId = Id;
       luxuryRating = LR;
       CreditNo = CN;
       JourneyPoints = JP;
       name = namme;
   }
   //accessors
    public int getpassId(){
       return passId;
   }
   
   public String getname(){
       return name;
   }
   
   public int getluxuryRating(){
       return luxuryRating;
   }
   
   public int getCreditNo(){
       return CreditNo;
   }
   
   public int getjourneypoints(){
       return JourneyPoints;
   }
   
   //methods
  public String addcredit (int amount){
      String y = "credits have been added";
       CreditNo = CreditNo + amount;
       return y;
   } 
   
   public String deductcredit (int amount){
       String y = "";
       if(CreditNo>=amount){
          CreditNo = CreditNo-amount; 
          y = amount + "" + "credits have been deducted,your new balance is" + "" + CreditNo;
        }
       return y;
   } 
   //resets journey points (used when converting journey points)
   public void resetJourneyPoints(){
       JourneyPoints = JourneyPoints - 5;
   }
   //method when riding the ferry
   public void rideferry(){
       deductcredit(3);
       JourneyPoints++;
   }
   //converts journey points to crdit points
   public String convertjourney(){
       String y = "";
       while (JourneyPoints > 5){
       CreditNo ++;
       resetJourneyPoints();
       y = "Journey points converted successfully";
    }
       return y;
   }
   
   public String toString(){
       return '\n' + getpassId() + '\n' + getCreditNo() + '\n' + getluxuryRating() + '\n' + getjourneypoints() + '\n' + getname();
       
   }

}

