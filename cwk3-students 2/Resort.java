import java.util.*;

/**This class implements the FIRE interface
 *
 * @author A.A.Marczyk 
 * @version 05/11/22
 **/
public class Resort implements FIRE   // do not change this header
{

    private String location;
    // Other fields (including collections)
    public ArrayList <Pass> passes = new ArrayList <Pass>();
    public ArrayList <Island> Islands = new ArrayList <Island>();
    public ArrayList <Ferry> ferries = new ArrayList <Ferry>();
    /** constructor
     * Some code has been provided 
     */
    public Resort(String loc) 
    {
        location = loc;
        loadIslandsAndFerries();
        loadPasses();
        addpasstoisland(1000 , "base");
        addpasstoisland(1001 , "base");
        addpasstoisland(1002 , "base");
        addpasstoisland(1003 , "base");
        addpasstoisland(1004 , "base");
        addpasstoisland(1005 , "base");
        addpasstoisland(1006 , "base");
        addpasstoisland(1007 , "base");
        addpasstoisland(1008 , "base");
        
        addpasstoisland(0000 , "base");
        addpasstoisland(7890 , "base");
        addpasstoisland(3 , "base");
        // Ensure all passes are added to Base Island
        // you may do this here or in one of the above method
    }
    
    /**
     * Returns information about the resort including its location/name and all
     * passes currently on each island, or "No passes" (if no pass on that island
     * @return all of the details of all islands including location 
     * and all passes currently on each island, or "No passes" if island has no passes
     */
    public String toString()
    {
        String s = "Resort details: \n"+ "Resort location: " + location + '\n' + "The islands and their passes are" +
        '\n' + getAllPassesOnAllIslands() ;
        
        return s;
        
    }

    /**Returns a String representation of all the passes on all islands
     * with "No passes" if there are no passes on an island
     * @return a String representation of all passes on all islands
     **/
    public String getAllPassesOnAllIslands()
    {
        String s = "\nLocation of Passes\n";
        
        
        for(Island p: Islands){
            
            if( p.passes.size() != 0 ){
                for ( int x= 0 ; x<= Islands.size () -1 ; x++){
                    
                } s = s + "The passes on the " + p.getislandname() + '\n' + "Island are" + '\n' + getAllPassesOnIsland(p.getislandname()) + '\n' + '\n' ;
            }
            s = s+p.getallpasses();
        }
        return s;
    } 
 
    
    /**Returns the name of the island which contains the specified pass or "Not found"
     * @param cd -the id of the pass
     * @return the name of the Island which contains the pass, or "Not found"
     **/
    public String findPassLocation(int cd)
    {
        String a = "";
        for (Island w: Islands){
            for(Pass P:passes){
                if(w.checkpass(P) == true){
                    a = w.getislandname();
                    break;
                    
                }else{
                    a = "not found";
                }
            }
        }
        return a;
        
    }
    
    /**Returns details of the pass with the specified id or "Not found"
     * @param cd - the id of the pass
     * @return the details of the pass, or "Not found"
     **/
    public String viewAPass(int cd)
    {
        String a = "";
        for (Pass P : passes){
            if(P.getpassId()==cd){
                a = P.toString();
            }else{
                a = "id not found";
            }
        }
        
        
        return a;
    }
    
    /** Given the name of a island, returns the island id number
     * or -1 if island does not exist
     * @param isl is the name of island
     * @return id number of island
     */
    public int getIslandNumber(String isl)
    {
        String a = "";
        for(Island I : Islands){
            if(isl == I.getislandname()){
                a = a + I.getislandid();
                return I.getislandid();
            }
        }
        return -1;
    }
                
    /**Returns a String representation of all passes on a specified island
     * @param isl - the name of the island
     * @return a String representation of all passes on specified island
     **/
    public String getAllPassesOnIsland(String isl)
    {
        String s = "\nPasses on \n";
        
            for(Island w: Islands){
                if(w.getislandname() == isl){
                    for(int x = 0 ; x < w.passes.size() ; x++){
                        Pass p = w.passes.get(x);
                        s = s + p.toString();
                    }
                    
                    
                    
                }else{
                    s = "not found";
                }
            
        }
        
        return s;
    } 

    
     /**Returns true if a Pass is allowed to journey using a ferry, false otherwise
     * A journey can be made if:  
     * the rating of the pass >= the rating of the destination island
     * AND the destination island is not full
     * AND the pass has sufficient credits (a journey costs 3 credits)
     * AND the pass is currently in the source island 
     * AND the pass id and ferry code represent objects in the system
     * @param cdId is the id of the pass requesting the move
     * @param ferCode is the code of the ferry journey by which the pass wants to move
     * @return true if the pass is allowed on the ferry journey, false otherwise 
     **/
    public boolean canTravel(int cdId, String ferCode)
    {   
        String a = "";
        boolean eligible = false;
        for (Ferry F : ferries){        
        for (Pass P : passes){
            if (F.getferrycode() == ferCode){
                if (P.getpassId() == cdId){
                   eligible = F.traveleligibility(P);
                }
                
            }
          }     
    
        }
        return eligible;
           
        

    }     

    /**Returns the result of a pass requesting to journey by Ferry.
     * A journey will be successful if:  
     * the luxury rating of the pass  >= the luxury rating of the destination island
     * AND the destination island is not full
     * AND the pass has sufficient credits
     * AND the pass is currently in the source island
     * AND both the pass id and the ferry code is on the system
     * If the ferry journey can be made, the pass is removed from the source island,
     * added to the destination island and a suitable message returned. Pass 
     * information should be updated (A journey costs 3 credits and journey points incremented by 1)
     * If the ferry journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pPassId is the id of the pass requesting the move
     * @param ferCode is the code of the ferry by which the pass wants to travel
     * @return a String giving the result of the request 
     **/
    public String travel(int pPassId, String ferCode )
    {   //other checks optional
        String s = "";
        
        boolean eligible = canTravel (pPassId, ferCode);
        if (eligible == true){
        for (Ferry f : ferries){
        for (Pass P : passes){
                if (P.getpassId() == pPassId && f.getferrycode() == ferCode){
                  s = f.requestingtravel(P);
                  break;
                }
                break;
            }
        break;

        }     
        } else {
            s = "Guest is not illegible for this ferry ride";
        }
        

        return s;

        
    } 
         
    /** Allows credits to be added to a pass.
     *  @param id the id of the pass toping up their credits
     *  @param creds the number of credits to be added to pass 
     */
    public void topUpCredits(int id, int creds)
    {
        for (Pass p : passes){
                if (p.getpassId() == id ){
                  p.addcredit(creds);
                  break;
                }
            }
    }
    
    /** Converts a pass's journey points into credits
     * @param id the id of the pass whose points are to be converted
     */
    public void convertPoints(int id)  
    {
        for (Pass p : passes){
                if (p.getpassId() == id ){
                  p.convertjourney();
                  break;
                }
            }
   
    } 

    //***************private methods**************
    private void loadPasses()
    {
    Pass Lynn = new Pass (1000 , 5 , 10 , 0 , "Lynn");
    Pass May = new Pass (1001 , 3 , 10 , 0 , "May");
    Pass Nils = new Pass (1002 , 10 , 10 , 0 , "Nils");
    Pass Olek = new Pass (1003 , 1 , 10 , 0 , "Olek");
    Pass Pan = new Pass (1004 , 3 , 10 , 0 , "Pan");
    Pass Quin = new Pass (1005 , 1 , 10 , 0 , "Quin");
    Pass Raj = new Pass (1006 , 4 , 10 , 0 , "Raj");
    Pass Sol = new Pass (1007 , 7 , 10 , 0 , "Sol");
    Pass Tel = new Pass (1008 , 6 , 10 , 0 , "Tel");
    //Tourist pass
    TouristPass Omar = new TouristPass ("Egyptian" , 0000 , 6 , 10 , 5 , "Omar"); 
    
    //Business pass
    BusinessPass Michael = new BusinessPass (7890 , 7 , 30 , 0 , "Michael");
    
    //EmployeePass
    EmployeePass Khaled = new EmployeePass ( 3, "ferrymanager" , 4567 , "Khaled");
    
    
    passes.add(Lynn);
    passes.add(May);
    passes.add(Nils);
    passes.add(Olek);
    passes.add(Pan);
    passes.add(Quin);
    passes.add(Raj);
    passes.add(Sol);
    passes.add(Tel);
    passes.add(Omar);
    passes.add(Michael);
    passes.add(Khaled);
    
    }
    
    private void loadIslandsAndFerries()
    {
        //Islands
       Island base = new Island (0 , 0 , 100 , "base"); 
       Island Yorkie = new Island (1 , 1 , 100 , "Yorkie"); 
       Island Bounty = new Island (2 , 3 , 10 , "Bounty"); 
       Island Twirl = new Island (3 , 5 , 2 , "Twirl"); 
       Island Aero = new Island (4, 1 , 1 , "Aero"); 
       
       Islands.add(base);
       Islands.add(Yorkie);
       Islands.add(Bounty);
       Islands.add(Twirl);
       Islands.add(Aero);
       

       
       
       
       //Ferries
       Ferry ABC1 = new Ferry ("ABC1" , Yorkie , base);
       Ferry BCD2 = new Ferry ("BCD2" , base , Yorkie);
       Ferry HJK7 = new Ferry ("HJK7" , Yorkie , Aero);
       Ferry GHJ6 = new Ferry ("GHJ6" , Aero , Yorkie);
       Ferry EFG5 = new Ferry ("EFG5" , Yorkie , Twirl);
       Ferry JKL8 = new Ferry ("JKL8" , Twirl , Bounty);
       Ferry DEF4 = new Ferry ("DEF4" , Yorkie , Bounty);
       Ferry CDE3 = new Ferry ("CDE3" , Bounty , Yorkie);
       
       ferries.add(ABC1);
       ferries.add(BCD2);
       ferries.add(HJK7);
       ferries.add(GHJ6);
       ferries.add(EFG5);
       ferries.add(JKL8);
       ferries.add(DEF4);
       ferries.add(CDE3);
    }
  
    /** Returns the pass with the pass id specified by the parameter
     * @param id pass id
     * @return the pass with the specified name
     **/
    private Pass getPass(int id)
    {
        int place = 0;
        for (int j = 0; j< passes.size(); j++){
        if (passes.get(j).getpassId () == id){
            place = j;
        } 
    }
     return passes.get(place);
        
    }
    
    
    /** Returns the island with the name specified by the parameter
     * @param islandName the island name
     * @return the island with the specified name
     **/
    private Island getIsland(String islandName)
    {
        int place = 0;
        for (int i = 0; i< Islands.size(); i++){
            if (Islands.get(i).getislandname()== islandName){
                place = i;
            } 
            
        }
        return Islands.get(place);
        
    }
    
    /** Returns the ferry with the ferry code specified by the parameter
     * @param fer the ferry code
     * @return the island with the specified name
     **/
    private Ferry getFerry(String fer)
    {
       int place = 0;
        for (int f = 0; f< ferries.size(); f++){
        if (ferries.get(f).getferrycode()== fer){
            place = f;
        } 
    }
    return ferries.get(place);
        
    }
    
    private void addpasstoisland(int pn , String isn){
        Pass p = getPass(pn);
        Island i = getIsland(isn);
        i.enter(p);
    }
    
    private String listallislands(){
        String o = "";
        for(int i =0; i<Islands.size(); i++){
            Island I = Islands.get(i);
            o = o + I.toString();
        }return o;
    }
    

}