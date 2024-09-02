import java.util.*;
/**
 * Write a description of class PassTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PassTester
{
    public static void main(String[] args)
    {
       
       
        
        // write your tests here
        
       Pass first = new Pass (123456 , 3 , 5 , 5 , "adham" );
       
       //prnting the details of the pass
        System.out.println("your pass id is" + "" + first.getpassId());
        System.out.println("your luxury rating is" + "" + first.getluxuryRating());
        System.out.println("your credit numbers are" + "" + first.getCreditNo());
        //adding 22 credits
        first.addcredit(22);
        //deducitng 2 credits
        first.deductcredit(2);
        first.rideferry();
        first.convertjourney();
        first.rideferry();
        first.rideferry();
        first.rideferry();
        first.rideferry();
        first.convertjourney();
        first.resetJourneyPoints();
    }
}
