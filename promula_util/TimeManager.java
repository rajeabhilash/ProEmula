/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promula_util;

/**
 *
 * @author Raje Abhilash Mohite
 */
public class TimeManager {
    public TimeManager()
    {
        
    }
    public String addTime(String addTimeTo, String addTimeFrom)
    {
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
        return SHRS+":"+SMIN+":"+SSEC;
    }
    public String addTime(String getTime, int getSeconds)
    {
        int HRS,MIN,SEC;
        int getSec = getSeconds;
        String SHRS,SMIN,SSEC;
        HRS = Integer.parseInt(getTime.substring(0, 2));             
        MIN = Integer.parseInt(getTime.substring(3, 5));
        SEC = Integer.parseInt(getTime.substring(6, 8));
        boolean loopIt = false;
        do
        {
            SEC = SEC + getSec;
            if(SEC>59)
            {
                getSec = SEC - 60;
                SEC = 0;
                MIN = MIN+1;
                loopIt = true;
                if(MIN>59)
                {
                    HRS = HRS + 1;
                    MIN = 0;
                }               
            }
            else
            {
                loopIt = false;
            }            
        }while(loopIt);
        
        if(HRS<=9)
        {
            SHRS= "0"+String.valueOf(HRS);
        }
        else
        {
            SHRS = String.valueOf(HRS);
        }
        if(MIN<=9)
        {
            SMIN = "0"+String.valueOf(MIN);
        }
        else
        {
            SMIN = String.valueOf(MIN);
        }
        if(SEC<=9)
        {
            SSEC = "0"+String.valueOf(SEC);
        }
        else
        {
            SSEC = String.valueOf(SEC);
        }
        
        return SHRS+":"+SMIN+":"+SSEC;
    }
    public String reduceTime(String getTime)
    {
        //getTime = 00:00:00 AM
        int HRS,MIN,SEC;
        String SHRS,SMIN,SSEC;
        HRS = Integer.parseInt(getTime.substring(0, 2));             
        MIN = Integer.parseInt(getTime.substring(3, 5));
        SEC = Integer.parseInt(getTime.substring(6, 8));
        
        if(SEC>0)
        {
            SEC = SEC - 1;
        }
        else
        {
            if(MIN>0)
            {
                MIN = MIN - 1;
                SEC = 59;
            }
            else
            {
                if(HRS>0)
                {
                    HRS = HRS - 1;
                    MIN = 59;
                    SEC = 59;
                }
            }
        }
        if(HRS<=9)
        {
            SHRS= "0"+String.valueOf(HRS);
        }
        else
        {
            SHRS = String.valueOf(HRS);
        }
        if(MIN<=9)
        {
            SMIN = "0"+String.valueOf(MIN);
        }
        else
        {
            SMIN = String.valueOf(MIN);
        }
        if(SEC<=9)
        {
            SSEC = "0"+String.valueOf(SEC);
        }
        else
        {
            SSEC = String.valueOf(SEC);
        }
        //getTime = SHRS+":"+SMIN+":"+SSEC;
        return SHRS+":"+SMIN+":"+SSEC;       
    }
}

9975954557
9665011117
7350011117

