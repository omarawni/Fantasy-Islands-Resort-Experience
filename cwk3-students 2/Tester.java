
import java.util.*;
/**
 * Write a description of class Tester here.
 * 
 * @author 
 * @version 
 */
public class Tester 
{   
    private void doTest()
    {
        FIRE fortunate = new Resort("Fortunate Islands");
       
        Scanner enter = new Scanner(System.in);
        Island a = new Island (1 , 3 , 100 , "ok");
        Island d =  new Island (2 , 4 ,101 , "no");
        Pass b = new Pass (1029 , 2 , 10 , 4 , "abd");
        Pass e = new Pass (1030 , 4 , 9 , 5 ,"aaa");
        Ferry c = new Ferry ("po" , a , d);
        
        // Write all of your tests here
        
        
        //Island class tests
        
        
        //islandname method testing -- will print  as the island name.
        System.out.println(" island a's name is" + a.getislandname());
        
        //will print 1 as the island id
        System.out.println(" island a's id is" + a.getislandid());
        
        //will print 3 as the luxury rating
        System.out.println(" island a's luxury rating is" + a.getluxuryrating());
        
        //will print 100 as the capacity
        System.out.println(" island a's capacity is" + a.getcapacity());
        
        //will put pass b into island a
        a.enter(b);
        System.out.println("The pass will be added to the island");
        
        //will put pass e into island a
        a.enter(e);
        System.out.println("The pass will be added to the island");
        
        //will print all passes on the island (b and e)
        System.out.println("the passes on the island are" + a.getallpasses());
        
        //will remove pass e from island a
        a.leave(e); 
        
        //will only print pass b
        System.out.println("the passes on the island are" + a.getallpasses());
        
        //will print the maximum capacity of island a
        System.out.println(" island a's max capacity is" + a.getmaxcapacity());
        
        //will print the details of pass b
        System.out.println(" the details of the pass is" + a.getonepass(1029));
        
        
        //will print true since b is on the island
        System.out.println(" the status of the pass is" + a.checkpass(b));
        
        //will print false since pass e was removed from the island
        System.out.println(" the status of the pass is" + a.checkpass(e));
        
        
        
        //Ferry class tests
        
        
        //will print the ferry code
        System.out.println("the ferry code is" + c.getferrycode());
        
        //will print "false" because luxury rating of pass b is 2 and island is 4
        System.out.println(c.traveleligibility(b));
        
        //will print "you are  not eligible to travel" since luxury rating is lower 
        System.out.println(c.requestingtravel(b));
        
        //will print "true" because luxury rating of pass e is 4 and island is 4
        System.out.println(c.traveleligibility(e));
        
        //will print "you are eligible to travel" since luxury rating is the same 
        System.out.println(c.requestingtravel(e));
        
        //will get all passengers on the ferry which are e
        System.out.println("this is the list of passenger on the ferry"+ c.getPassengerlist());
        
        
        
        
        //resort class
        
        
        //will print all passes on all islands which is pass e on island d
        fortunate.getAllPassesOnAllIslands();
        
        //will return island d since pass e is there
        fortunate.findPassLocation(1030);
        
        //will return not found since pass b is not there
        fortunate.findPassLocation(1029);
        
        //will return all details of pass e
        fortunate.viewAPass(1030);
        
        //will return all details of pass b
        fortunate.viewAPass(1030);
        
        //will return the id of island d which is 2
        fortunate.getIslandNumber("no");
        
        //will return all passes on island d which is pass e
        fortunate.getAllPassesOnIsland("no");
        
        //will return true since pass e is allowed to travel on the ferry
        fortunate.canTravel(1030 , "po");
        
        //will return false since pass b is not allowed to travel on the ferry
        fortunate.canTravel(1029 , "po");
        
        //will return the result of a pass requesting to travel on the ferry
        fortunate.travel(1030 , "po");
        
        //will add 5 credits to pass e
        fortunate.topUpCredits(1030 , 5);
        //pass e will have 14 credits
        System.out.println( "pass e's credits are" + e.getCreditNo());
        
        //will convert pass e's journey points to one credit
        fortunate.convertPoints(1030);
        //pass e will have 15 credits now
        System.out.println( "pass e's credits are" + e.getCreditNo());
    }
    
    // No need to change this
    public static void main(String[] args)
    {
        Tester xx = new Tester();
        xx.doTest();
    }
}
