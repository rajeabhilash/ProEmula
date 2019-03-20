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
public class MicroClock extends Thread {
    public javax.swing.JLabel LB_Date_Time;
    public MicroClock(javax.swing.JLabel Date_Time_Label)
    {
        LB_Date_Time = Date_Time_Label;
    }
    @Override
    public void run()
    {
        while(true)
        {
            LB_Date_Time.setText(new java.text.SimpleDateFormat("hh:mm:ss").format(new java.util.Date(System.currentTimeMillis())));
        }
    }
}