/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package processor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
/**
 *
 * @author Raje Abhilash Mohite
 */
public class ProcessHandler extends Thread{
    
    protected JLabel 
            _nextProcess,
            _processName,
            _processProfit,
            _processTime,
            _processArrived,
            _processExecution;
    protected JLabel        
            _totalProcessExecuted,
            _totalProcessTime,
            _totalProcessProfit;
    protected JLabel
            _TimeClock,
            _Percentage;
    protected JProgressBar
            _ProgressBar;
    
    protected java.util.ArrayList<Process> processes;
    protected int process_Count;
    protected int tProcess,tTime,tProfit;
    protected javax.swing.JPanel ProcessQueuePanel;
    protected javax.swing.JPanel executedPanel;
    protected promula_util.TimeManager timeManage;
    String TTE,ECO;
    int negTime;
    public ProcessHandler(javax.swing.JPanel processQueue,javax.swing.JPanel CompletedPanel)
    {      
        processes =  new java.util.ArrayList(50);
        ProcessQueuePanel = processQueue;
        executedPanel = CompletedPanel;
        process_Count = 1;      
        timeManage = new promula_util.TimeManager();
        TTE = "00:00:00";
        //ECO = "00:00:00";
    }
    public void getElementsDetails(JLabel getNextProcessName,JLabel getProcessName, JLabel getProcessProfit, JLabel getProcessTime, JLabel getArrivedTime, JLabel getExecutionOn)
    {
        this._nextProcess = getNextProcessName;
        this._processName = getProcessName;
        this._processProfit = getProcessProfit;
        this._processTime = getProcessTime;
        this._processArrived = getArrivedTime;
        this._processExecution = getExecutionOn;
    }
    
    public void getRuntimeElement(JLabel getTimerClock,JLabel getProcessPercentage, JProgressBar getProcessProgressBar)
    {
        this._TimeClock = getTimerClock;
        this._Percentage = getProcessPercentage;
        this._ProgressBar = getProcessProgressBar;
    }
    
    public void getStatistics(JLabel getProcessExecuted,JLabel getTimeTaken,JLabel getProfitObtained)
    {
        this._totalProcessExecuted = getProcessExecuted;
        this._totalProcessTime = getTimeTaken;
        this._totalProcessProfit = getProfitObtained;
    }
    
    public void addProcess(String processName, int processProfit, int processTime)
    {
        Process NewProcess = new Process(processName,processProfit,processTime,process_Count);
        processes.add(NewProcess);        
        process_Count = process_Count + 1;
        GreedySort();        
        updateProcessQueue();
        adjustProcessQueue();
    }
    
    public void GreedySort()
    {
        for(int i=0;i<processes.size();i++)
        {
            for(int j=i;j<processes.size();j++)
            {
                if((processes.get(i).processProfit/processes.get(i).processTime)<(processes.get(j).processProfit/processes.get(j).processTime))
                {                   
                    Process temp;
                    temp = processes.get(i);
                    processes.set(i, processes.get(j));
                    processes.set(j, temp);
                }
            }
        }
    }
                
    public void updateProcessQueue()
    {
        ProcessQueuePanel.removeAll();
        
        TTE = timeManage.addTime("00:00:00", negTime);
         for(int i=0;i<processes.size();i++)
         {
             ProcessQueuePanel.setLayout(new javax.swing.BoxLayout(ProcessQueuePanel, javax.swing.BoxLayout.PAGE_AXIS));
             TTE = timeManage.addTime(TTE, processes.get(i).processTime);
             processes.get(i).updateTimeToExecute(TTE);
             processes.get(i).updateTimeOfCompletion(timeManage.addTime(processes.get(i).ArrivalTime, TTE));
             ProcessQueuePanel.add(processes.get(i));
            
        }
    }    
    public void adjustProcessQueue()
    {
        if(!processes.isEmpty())
        this._nextProcess.setText(processes.get(0).processName);
    }
    
    @Override()
    public void run()
    {
        try {
        while(true)
        {            
            if(!processes.isEmpty())
            {
                boolean  loopIt = false;
                Process executeThis = processes.get(0);
                processes.remove(0);
                adjustProcessQueue();
                updateProcessQueue();
                tProcess = tProcess + 1;                
                tTime = tTime + executeThis.processTime;
                tProfit = tProfit + executeThis.processProfit;
                this._totalProcessExecuted.setText(tProcess+" Processes.");
                this._totalProcessProfit.setText(tProfit+" Points.");
                this._totalProcessTime.setText(tTime+" Seconds.");
                this._processName.setText(executeThis.processName);
                this._processProfit.setText(executeThis.processProfit+" Points");
                this._processTime.setText(executeThis.processTime+" Seconds");
                this._processArrived.setText(executeThis.ArrivalTime);
                this._processExecution.setText(executeThis.Completing_on);
                negTime = executeThis.processTime;
                do
                {
                    this._TimeClock.setText(""+negTime);
                    Thread.sleep(1000);
                    negTime = negTime - 1;
                    this._Percentage.setText(100-(negTime*100)/executeThis.processTime+" %");
                    this._ProgressBar.setValue(100-(negTime*100)/executeThis.processTime);
                    if(negTime>0)
                    {
                        loopIt = true;
                    }
                    else
                    {
                        loopIt = false;
                    }
                }while(loopIt);   
                executedPanel.setLayout(new javax.swing.BoxLayout(executedPanel, javax.swing.BoxLayout.PAGE_AXIS));
                executedPanel.add(new CompletedProcess(executeThis.processName,executeThis.processProfit,executeThis.processTime,tProcess,executeThis.ArrivalTime,new java.text.SimpleDateFormat("hh:mm:ss a").format(new java.util.Date(System.currentTimeMillis()))));
                voce.SpeechInterface.synthesize(executeThis.processName+" is Executed Suceesfully in "+executeThis.processTime+"Seconds");
                this._nextProcess.setText("");
            }
            else
            {
                this._processName.setText("Add Process to Execute");
                this._nextProcess.setText("");
                this._processProfit.setText("0000 Points.");
                this._processTime.setText("000 Seconds");
                this._processArrived.setText("00:00:00 PM");
                this._processExecution.setText("00:00:00 PM");
                this._Percentage.setText("00%");
                this._TimeClock.setText("00");
                this._ProgressBar.setValue(0);
            }
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
