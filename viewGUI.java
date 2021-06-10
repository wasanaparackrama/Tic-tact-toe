
/*The View component is used for all the GUI logic of the application.
  */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class viewGUI extends JFrame  {
	Controller c;
	Model m;
	
	// create a frame for TicTacToe
	JFrame frame = new JFrame("Tic Tac Toe");
	//create a panel for the frame
    JPanel panel = new JPanel(); 
  //create a button array
    JButton[] viewBtn = new JButton[9]; 
    
	
	 public viewGUI() {
        //initialize the button array
        for (int i = 0; i < viewBtn.length; i++) {
            viewBtn[i] = new JButton("");
          
        }
        //create object from controller
         c= new Controller(viewBtn);
       //set grid layout
        panel.setLayout(new GridLayout(3, 3, 0, 0));
        //set font for gui
        Font f = new Font("Verdana", Font.PLAIN, 32);
        for (int i = 0; i < viewBtn.length; i++) {
        	//add button to the panel
            panel.add(this.viewBtn[i]); 
           //set dimension of a button
            viewBtn[i].setPreferredSize(new Dimension(150, 150));
            //set background color
            viewBtn[i].setBackground(Color.PINK);
            //set font size
            viewBtn[i].setFont(f);
        }
        
        frame.add(panel); //add panel to the frame
        frame.setLocation(512, 150); //set frame location
        c.actionPerformed(); //set button action listeners
    }


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new viewGUI().setVisible(true);
            }
        });

    }

    @Override
    public void setVisible(boolean b) {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

	
	
	
	
	
	
	
	
	
	
	

}
