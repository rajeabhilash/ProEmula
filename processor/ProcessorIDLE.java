package processor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rajea
 */ 
public class ProcessorIDLE extends Thread{
    int HRS;
    int MIN;
    int SEC;
    String H,M,S;
    protected javax.swing.JLabel TIMER;
    protected javax.swing.JLabel LHRS,LMIN,LSEC;
    public ProcessorIDLE(javax.swing.JLabel getTimer)
    {
        HRS = 0;
        MIN = 0;
        SEC = 0;
        TIMER = getTimer;
    }
    @Override
    public void run()
    {
        while(true)
        {
            try
            {                
                if(SEC>59)
                {
                    SEC = 0;
                    MIN = MIN + 1;
                }
                if(MIN>59)
                {
                    MIN = 0;
                    HRS = HRS + 1;
                }
                if(SEC>9)
                {
                    S = String.valueOf(SEC);
                }
                else
                {
                    S = "0"+String.valueOf(SEC);
                }
                if(MIN>9)
                {
                    M = String.valueOf(MIN);
                }
                else
                {
                    M = "0"+String.valueOf(MIN);
                }
                if(HRS>9)
                {
                    H = String.valueOf(HRS);
                }
                else
                {
                    H = "0"+String.valueOf(HRS);
                }            
                TIMER.setText(H+":"+M+":"+S);
                Thread.sleep(1000);
                SEC = SEC+1;
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
