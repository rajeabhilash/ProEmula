/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promula_util;

import java.awt.Color;
import java.awt.event.MouseEvent;

/**
 *
 * @author rajea
 */
public class Humpu extends javax.swing.JPanel implements Runnable, java.awt.event.MouseMotionListener{
    protected int xVal,yVal;
    protected int xPos,yPos;
    protected String PanelName;
    public Humpu(String getForWhat)
    {
        PanelName = getForWhat;
        xVal = 1;        
        yVal = getHeight();
        xPos = yPos = 0;
        addMouseMotionListener(this);
       //run();
    }
    @Override
    public void paintComponent(java.awt.Graphics pen)
    {
        java.awt.Graphics2D pencil = (java.awt.Graphics2D) pen;
        setBackground(new java.awt.Color(0,0,0,0));
        switch(PanelName)
        {
            case "HEAD" : setForeground(new java.awt.Color(0,254,254,25));
                          pen.fillRoundRect(0, 0, xVal, getHeight(), 0, 0);
                          break;
            case "CONTROLLER" : setForeground(new java.awt.Color(254,254,0,10));
                          pen.fillRoundRect(0, 0, xVal, getHeight(), 0, 0);
                          break;
            case "QUEUE": setForeground(new java.awt.Color(254,0,204,10));
                          pen.fillRoundRect(0, 0, xVal, getHeight(), 0, 0);
                          break;
            case "PROCESSOR" :setForeground(new java.awt.Color(254,254,254,10));
                          pen.fillRoundRect(0, 0, xVal, getHeight(), 0, 0);
                          break;
            case "COMPLETED" :setForeground(new java.awt.Color(0,254,254,15));
                          pen.fillRoundRect(0, 0, xVal, getHeight(),0,0);
                          break;
            case "SIMULA" : setForeground(new java.awt.Color(0,254,51,10));
                          pen.fillRoundRect(0, 0, xVal, getHeight(), 0, 0);
                          break;
            default : break;
        }       
       this.validate();
    }
    
    @Override
    public void run() {
        /*
        boolean rev;
        rev = false;
        xVal = 1;
        System.out.print("Run Started...\nHeight = "+getHeight()+"\nWidth = "+getWidth());
            try
            {
                double Timer = 10L;
                System.out.println("Entering in Loop");
                while(xVal<getWidth())
                {
                    xVal=xVal+20;
                    //yVal = yVal + 1;
                    Thread.sleep(100);
                    System.out.println(xVal);        
                    repaint();
                }           
                
            }
            catch(Exception e)
            {
                
            }
        */
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {    
            }
}
