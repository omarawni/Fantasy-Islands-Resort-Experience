
/**
 * Write a description of class EmployeePass here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EmployeePass extends Pass
{
    private int empnum;
    private String jobdescription;

    /**
     * Constructor for objects of class EmployeePass
     */
    public EmployeePass(int empnum , String jobd , int passId , String name)
    {
        super (passId , 10 , 0 , 0 ,name);
        empnum = empnum;
        jobdescription = jobd;
    }
    public int getemployeenumber(){
        return empnum;
    }
    public String getjobdesc(){
        return jobdescription;
    }
    
    public void rideferry(){
        int Journeyscore = getjourneypoints();
        Journeyscore = Journeyscore + 1;
    }
    
    public String toString(){
        return getpassId() + ""  + " " + getluxuryRating() + "" + getemployeenumber() + "" + getjobdesc();
    }
}
