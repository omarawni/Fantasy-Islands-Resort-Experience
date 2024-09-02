import java.util.*;
/**
 * An island is part of a FIRE resort.Each island has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(passes) who can be on the  
 * island at any one time. Each island must maintain a list of all people (passes)
 * currently on the island. These lists are updated whenever passes enter or leave 
 * an island,so that it is always possible to say which passes are on the island 
 * 
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Island 
{
    //fields
    public ArrayList <Pass> passes = new ArrayList <Pass>();
    private int IslandId;
    private String IslandName;
    private int IslandLuxuryRating;
    private int capacity;
    
    //constructor
    public Island ( int islandidd , int ILR , int IC , String islandname ){
        IslandId = islandidd;
        IslandLuxuryRating = ILR;
        capacity = IC;
        IslandName = islandname;
        
    }
    //accessors
    public int getislandid(){
        return IslandId;
    }
    
    public String getislandname(){
        return IslandName;
    }
    
    public int getluxuryrating(){
        return IslandLuxuryRating;
    }
    
    public int getcapacity(){
        return capacity;
    }
    //mutator to add the pass to the island
    public void enter(Pass object){
        passes.add(object);
        
    }
    //method to get the maximum capacity
    public String getmaxcapacity(){
        if(passes.size()>=capacity){
            String s = "maximum capacity reached";
            return s;
        }
        else{
            String a = "capacity available";
            return a;
        }
    }
    //mutator that removes a pass from the island once it leaves
    public void leave(Pass object){
        for (int i = 0; i<= passes.size();i++){
            if(passes.get(i) == object){
                passes.remove (i);
            }
        }
    }
    //method to get all passes on the island
    public String getallpasses(){
        String k = "";
        
        for (Pass d: passes){
            k = k +  d.toString();
        }
        return k;
    }
    //method to give one pass on the island when you give its id
    public String getonepass(int passId){
        String x = "";
        for (Pass d: passes){
            if (d.getpassId() == passId){
                x = d.toString();
            }
        }
        return x;
    }
    //method to check if a certain pass is on the island
    public boolean checkpass(Pass obj){
        boolean Passonisland = true;
        for (Pass d: passes){
            if(d == obj){
                Passonisland = true;
            }else{
                Passonisland = false;
            }
        }
        return Passonisland;
    }
    
    public String toString(){
       return getislandid() + "  " + getluxuryrating() + "  " + getcapacity() + "  " + getislandname() + "  " + getallpasses();
       
   }
}
