
/**
 * Write a description of class BusinessPass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BusinessPass extends Pass
{
    private int loyaltypoints;
    
public BusinessPass(int id , int lr , int cn ,int jp ,  String name )
{
        super ( id , lr , 30 ,jp ,  name);
        loyaltypoints = 20;
}

public int getloyaltypoints(){
    return loyaltypoints;
}

    public void loyaltytocredits(){
        int credits = getCreditNo();
        if (loyaltypoints == 5){
       credits++;
    }
    
}

public void rideferry(){
        int credits = getCreditNo();
        credits = credits-3;
        loyaltypoints = loyaltypoints + 2;
    }
    
public String toString(){
        return getpassId() + "" + getCreditNo() + " " + getluxuryRating() + "" + getjourneypoints() + "" + getname() + "" + getloyaltypoints();
}
}
