
package security;

import java.util.Date;


public class GenerateToken {
    public static long tokenGeneration ()
    {
 
        Date date= new Date();
 
        long time = date.getTime();
        long t = (long) time;
        t = t * 34567;
        return t;
 
 
    }
}
