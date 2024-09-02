
/**
 * Write a description of class TouristPass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TouristPass extends Pass
{
    // instance variables - replace the example below with your own
    private String citizenship;

    /**
     * Constructor for objects of class TouristPass
     */
    public TouristPass(String cs , int id , int lr , int cn ,int jp ,  String name)
    {
        super ( id , lr , cn ,jp ,  name);
        citizenship = cs;
    }

    public String getcitizenship(){
        return citizenship;
    }
    
    public void rideferry(){
        int credit = getCreditNo();
        credit = credit-4;
    }
    
    public String toString(){
        return getpassId() + "" + getCreditNo() + " " + getluxuryRating() + "" + getjourneypoints() + "" + getname() + citizenship;
    }
}
