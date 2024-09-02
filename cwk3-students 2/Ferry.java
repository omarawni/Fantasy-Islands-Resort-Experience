import java.util.*;
/**
 * A ferry provides a one-way journey between two islands. It
 * has a ferry code and information about both the source and
 * the destination island
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ferry
{
    //fields
    private ArrayList <Pass> passes = new ArrayList <Pass>();
    private String ferrycode;
    private Island destinationisland;
    private Island SourceIsland;
    
    //constructor
    public Ferry (String ferrycodee , Island SourceIsland , Island destinationisland){
        ferrycode = ferrycodee;
        SourceIsland =  SourceIsland;
        destinationisland = destinationisland;
    }
    //accessor
    public String getferrycode(){
        return ferrycode;
    }
    //method to check whether a pass can travel on the ferry
    public boolean traveleligibility(Pass obj){
        boolean eligible = false;
        if(obj.getluxuryRating() < destinationisland.getluxuryrating() ||  destinationisland.getmaxcapacity() == "maximum capacity reached" || obj.getCreditNo() < 3  ||SourceIsland.checkpass(obj)==false){
            eligible = false;
        }else{
            eligible = true;
        }
        return eligible;
    }
    //method to check if the pass is eligible to travel to the destination island
    public String requestingtravel(Pass obj ){
        boolean eligible = traveleligibility(obj);
        String q = "";
        if(eligible == true){
            SourceIsland.leave(obj);
            destinationisland.enter(obj);
            obj.rideferry();
            q = "You are eligible to travel";
        }else{
            q = " You are not eligible to travel";
        }
        return q;
    }
    //method to get all passengers on the ferry
    public String getPassengerlist(){
        String u = "";
        for(Pass i : passes){
            u = u + "" + i.toString() + "" ; 
        }
        return u;
    }
    
    public String toString(){
       String passes = getPassengerlist();
       return passes + "" + ferrycode + "" + destinationisland + "" + SourceIsland;
       
   }
}
