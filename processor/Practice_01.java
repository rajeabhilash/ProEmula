/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processor;

/**
 *
 * @author rajea
 */
public class Practice_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.util.Scanner inp = new java.util.Scanner(System.in);
        String addTimeTo,addTimeFrom;        
        System.out.print("Enter FIRST Time:");
        addTimeTo = inp.next();
        System.out.print("Enter Second Time : ");
        addTimeFrom = inp.next();
        int THRS,TMIN,TSEC;
        int FHRS,FMIN,FSEC;
        String SHRS,SMIN,SSEC;
        THRS = Integer.parseInt(addTimeTo.substring(0, 2));             
        TMIN = Integer.parseInt(addTimeTo.substring(3, 5));
        TSEC = Integer.parseInt(addTimeTo.substring(6, 8));
        
        FHRS = Integer.parseInt(addTimeFrom.substring(0, 2));             
        FMIN = Integer.parseInt(addTimeFrom.substring(3, 5));
        FSEC = Integer.parseInt(addTimeFrom.substring(6, 8));
        
        boolean loopIt = false;
        do
        {
            TSEC = TSEC + FSEC;
            if(TSEC>59)
            {
                FSEC = TSEC - 60;
                TSEC = 0;
                TMIN = TMIN+1;
                loopIt = true;
                if(TMIN>59)
                {
                    THRS = THRS +1;
                    TMIN = 0;
                }
            }
            else
            {
                loopIt = false;
            }
        }while(loopIt);
        
        do
        {
            TMIN = TMIN + FMIN;
            if(TMIN>59)
            {
                FMIN = TMIN-60;
                THRS = THRS+1;
                TMIN = 0;
                loopIt = true;
            }
            else
            {
                loopIt = false;
            }
        }while(loopIt);
        THRS = THRS + FHRS;
        if(THRS<=9)
        {
            SHRS= "0"+String.valueOf(THRS);
        }
        else
        {
            SHRS = String.valueOf(THRS);
        }
        if(TMIN<=9)
        {
            SMIN = "0"+String.valueOf(TMIN);
        }
        else
        {
            SMIN = String.valueOf(TMIN);
        }
        if(TSEC<=9)
        {
            SSEC = "0"+String.valueOf(TSEC);
        }
        else
        {
            SSEC = String.valueOf(TSEC);
        }
        //return SHRS+":"+SMIN+":"+SSEC;
        System.out.println(SHRS+":"+SMIN+":"+SSEC);
    }
    
}
