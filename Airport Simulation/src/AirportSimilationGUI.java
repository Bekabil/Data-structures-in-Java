/*
 * Name:		Bekabil Tolassa
 * Class:		ICS 141
 * Date:		October 15, 2014
 * Project:	    Airport Simulation System
 * Program description: this program is an airport simulation trial system.
 * various of results are expected to indicate the difference on having both one and two run ways 
 * as we change arrival and depart rate time. The trial is to see if advantageous for departing or landing planes. 
 * Two trials will be sufficient as we change the input. In both experiments, number of landing planes may increase. 
 * However, number of planes departing using both one and two run ways may shows continues decline. 
 * An optimal values for landing and departing planes will be our focus as we reach 0.55 for arrival rate. 
 * By contrast, departing planes may decrease as we increase the arrival rate. 
 * Optimal value for departing planes stays at 100 in one run way, and changes to 150 with 2 run ways. 
 * This is because the second run way allows more planes depart. 
 * Landing planes waiting time in both cases are small rate, where as waiting time for departing planes 
 * increases until it reaches close to 300 and starts fluctuating. 
 * Again, having changing the departure rates, our experiment shows the highest advantage 
 * to landing planes in both one and two run ways experiment.
 *
 */
//imports classes from java AWT
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//imports class ButtonGroup to group radio buttons
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
//import classes from javax swing
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SpringLayout;
/**
 * class ICS 240
 * @author Bekabil Tolass
 *
 */
//class AirportSimilationGUI
public class AirportSimilationGUI extends JFrame {
	
	//create private data fields, labels and text fields, radio buttons,
    //scroll pane, combo boxe, menu bar, menu, and menu items.
    private JLabel jlblArrivalProb = new JLabel("Arrival Probability:");
    private JTextField jtxtArrivalProb = new JTextField(3);
    

    private JLabel jlblDepartureProb = new JLabel("Departure Probability:");
    private JTextField jtxtDepartureProb = new JTextField(4);

    private JLabel jlblLandingTime = new JLabel("Landing Time:");
    private JTextField jtxtLandingTime = new JTextField(3);
    
    
    private JLabel jlblTakeOffTime = new JLabel("Take off Time:");
    private JTextField jtxtTakeOffTime = new JTextField(3);
    
    private JLabel jlblOutOfFuelTime = new JLabel("Out of Fuel Time:");
    private JTextField jtxtOutOfFuelTime = new JTextField(3);
    
    private JLabel jlblNumOfRunWay = new JLabel("Number of run ways:");
    private JTextField jtxtNumOfRunWay = new JTextField(3);

    private JLabel jlblTotalTime = new JLabel("Total Time:");
    private JTextField jtxtTotalTime = new JTextField(3);
    
    private JButton jbtnSimilation = new JButton("Start Simulation");

    private JButton jbtnClearReport = new JButton("Clear this Report");
    
    private JButton jbtnClearInput = new JButton("Clear this Input");
    
    private JButton jbtnCountCrashes = new JButton("Number of Crashes");
    
    private JLabel jlblReport = new JLabel("Simulation Report");
    
    

    private JMenuBar reportMenuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem saveMenuItems = new JMenuItem("Save");
    private JMenuItem loadMenuItems = new JMenuItem("Load");

    
    
    //text area is created to be used for outputs
    private JTextArea jtxtReoprtOutput = new JTextArea(4, 4);
    
    //jscrollPane is type JScrollPane
    //jtxtSalesOutput is passed to constructor
    private JScrollPane jscrollPane = new JScrollPane(jtxtReoprtOutput);

    //manageTicketSold is an instance of Manager
    private StartSimulation airportSimulation; 

    
    //constructor
    public AirportSimilationGUI() {
    	jtxtArrivalProb.setMaximumSize(new Dimension(20,10));
    	jtxtArrivalProb.setMinimumSize(new Dimension(20,10));
    	jtxtArrivalProb.setPreferredSize(new Dimension(20,10));
    	airportSimulation = new StartSimulation();
        //create JPanel groupPanel
        //JPanel groupPanel = new JPanel(new GridLayout(2, 1));

        //create JPanel itemsPanel
        JPanel itemsPanel = new JPanel();
        
        JPanel btnPanel = new JPanel();
        //create JPanel salesPanel
        JPanel reportPanel = new JPanel(new BorderLayout());
        itemsPanel.setLayout(new GridLayout(9, 2, 5, 5));
        
        //set back ground color for menu and menu bar
        reportMenuBar.setBackground(Color.BLACK);
        fileMenu.setForeground(Color.WHITE);
        saveMenuItems.setBackground(Color.WHITE);
        loadMenuItems.setBackground(Color.WHITE);

        //items are added to menu
        fileMenu.add(saveMenuItems);
        fileMenu.add(loadMenuItems);

        //menu is added to menu bar
        reportMenuBar.add(fileMenu);


        //place menu bar on the frame
        setJMenuBar(reportMenuBar);


        itemsPanel.add(jlblArrivalProb);
        itemsPanel.add(jtxtArrivalProb);

        itemsPanel.add(jlblDepartureProb);
        itemsPanel.add(jtxtDepartureProb);
        
        itemsPanel.add(jlblLandingTime);
        itemsPanel.add(jtxtLandingTime);
        
        itemsPanel.add(jlblTakeOffTime);
        itemsPanel.add(jtxtTakeOffTime);
        
        itemsPanel.add(jlblOutOfFuelTime);
        itemsPanel.add(jtxtOutOfFuelTime);
        
       itemsPanel.add(jlblTakeOffTime);
        itemsPanel.add(jtxtTakeOffTime);

        itemsPanel.add(jlblNumOfRunWay);
        itemsPanel.add(jtxtNumOfRunWay);

        itemsPanel.add(jlblTotalTime);
        itemsPanel.add(jtxtTotalTime);
               
        itemsPanel.add(jbtnSimilation);
        itemsPanel.add(jbtnCountCrashes);
        itemsPanel.add(jbtnClearInput);	
        itemsPanel.add(jbtnClearReport);
        
       //add itemPanel on to salesPanel and place it in north 
        reportPanel.add(itemsPanel, BorderLayout.NORTH);

        //add jscrollPane to reportPanel and place it in the center	
        //jscrollPane is holding jtxtSalesOutput area  
        
        reportPanel.add(jscrollPane, BorderLayout.CENTER);

        //add roportPanel to the frame.
        add(reportPanel);

        //text area for output is not editable.
        jtxtReoprtOutput.setEditable(false);

        //create listener object of type PressedButtonListener to use it for save menu items.
        PressedButtonListener jmenuSaveListener = new PressedButtonListener();

        //create listener object of type PressedButtonListener to use it for load menu items.
        PressedButtonListener jmenuLoadListener = new PressedButtonListener();

        //create listener object of type PressedButtonListener to use it for combo box.
       // PressedButtonListener jcboListener = new PressedButtonListener();

        //create listener object of type PressedButtonListener to use it for submit button.
        PressedButtonListener startSimilationButtonListener = new PressedButtonListener();

        //create listener object of type PressedButtonListener to use it for list all sales button.
        PressedButtonListener clearReportButtonListener = new PressedButtonListener();

        /////
      //create listener object of type PressedButtonListener to use it for list all sales button.
        PressedButtonListener clearInputButtonListener = new PressedButtonListener();
        
      //create listener object of type PressedButtonListener to use it for list all sales button.
        PressedButtonListener crashCounterButtonListener = new PressedButtonListener();
        //register listener onto saveMenuItems combo box
        saveMenuItems.addActionListener(jmenuSaveListener);

        //register listener onto loadMenuItems combo box
        loadMenuItems.addActionListener(jmenuLoadListener);

        //register listener onto jbtnSubmit button
        jbtnSimilation.addActionListener(startSimilationButtonListener);
        
      //register listener onto jbtnSubmit button
        jbtnClearReport.addActionListener(clearReportButtonListener);
        
        
      //register listener onto jbtnSubmit button
        jbtnClearInput.addActionListener(clearInputButtonListener);
        
      //register listener onto jbtnSubmit button
        jbtnCountCrashes.addActionListener(crashCounterButtonListener);
    }

    //class PressedButtonListener is responsible to listen for 
    //two buttons click, and perform actions accordingly.
    class PressedButtonListener implements ActionListener {
        
        //overriding method actionPerformed
        @
        Override
        public void actionPerformed(ActionEvent event) {

            //if jbtnSimilation button is pressed
                 	
            if (event.getSource() == jbtnSimilation) {

            	
            	try {
            		airportSimulation = new StartSimulation(Double.parseDouble(jtxtArrivalProb.getText()),
                			
                    		Double.parseDouble(jtxtDepartureProb.getText()),
                    			
                            Integer.parseInt(jtxtLandingTime.getText()), Integer.parseInt(jtxtTakeOffTime.getText()),
                            
                            Integer.parseInt(jtxtOutOfFuelTime.getText()), Integer.parseInt(jtxtNumOfRunWay.getText()),
                            
                            Integer.parseInt(jtxtTotalTime.getText()));
        			
        		    
            		
            		airportSimulation.simulationStarter();
            		
            		
            		
            		jtxtReoprtOutput.append(airportSimulation.getSimilationReport());
        		}
        		catch(NumberFormatException e) {
        			
        			JOptionPane.showMessageDialog(null, 
        					
        					"Please enter valid input:\n" +
        					"for Arrival Probability, double value\n" +
                        	"for Departure Probability double value\n" +
                        	"for Landing Time, integer value\n" +
                        	"for Take OffTime, integer value\n" +
                        	"for Out Of Fuel Time, integer value\n" +
                        	"for number Of RunWay, integer value\n" +
                        	"for Total Time, integer value\n" ,
        					
        					"Airport Simulation System", JOptionPane.INFORMATION_MESSAGE);
        			
        			
        		}
            	            }

            //if jbtnClearInput button is pressed
            if (event.getSource() == jbtnClearInput) {
            	
            	//reset input fields to empty
    			jtxtArrivalProb.setText("");
            	jtxtDepartureProb.setText("");
            	jtxtLandingTime.setText("");
            	jtxtTakeOffTime.setText("");
            	jtxtOutOfFuelTime.setText("");
            	jtxtNumOfRunWay.setText("");
            	jtxtTotalTime.setText("");
                
            }
            //The text area is cleared.      	
            if (event.getSource() == jbtnClearReport) {
            	jtxtReoprtOutput.setText("");
                
            }

            if (event.getSource() == jbtnCountCrashes) {
            	      	JOptionPane.showMessageDialog(null, 
    					
    					"During this session of simulation" +
    							airportSimulation.getNumOfCrashes() + " airplanes are crashed.", 					
    					"Crashed airplanes counter system", JOptionPane.INFORMATION_MESSAGE);
                
            }
            //if menu item save is clicked
            if (event.getSource() == saveMenuItems) {
            	//create fc object 
            	JFileChooser fc= new JFileChooser();
            	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            	fc.showOpenDialog(null);
            	File file= fc.getSelectedFile();
                //call method saveReport() to save state of report
                try {
                	airportSimulation.saveReport(file);
                } catch (FileNotFoundException e) {

                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            //if menu item load is clicked
            if (event.getSource() == loadMenuItems) {

            	JFileChooser fc= new JFileChooser();
            	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            	fc.showOpenDialog(null);
            	File file= fc.getSelectedFile();
                try {

                    jtxtReoprtOutput.setText(airportSimulation.loadReport(file));

                } catch (FileNotFoundException e) {

                    e.printStackTrace();
                } catch (ClassNotFoundException e) {

                    e.printStackTrace();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }


        }


    }

    //main method
    public static void main(String[] args) {

        //create object similationFrame which is type AirportSimilationGUI.
        AirportSimilationGUI similationFrame = new AirportSimilationGUI();
        // give the frame a title
        similationFrame.setTitle("Airport Similation");
        //set the frame size
        //similationFrame.setSize(450, 700);
        
        // center the frame
        similationFrame.setLocationRelativeTo(null);
        //the frame closes when an 'X' button is clicked
        similationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // display the frame
        similationFrame.setBounds(400, 50, 400, 750);
        similationFrame.setResizable(false);
        similationFrame.setVisible(true);
        

    }


}
	


