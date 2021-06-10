

/*Controllers act as an interface between Model and View components */

import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Controller {
	
	//creating a integer array to store 9 buttons
	 private static int[] click={0,0,0,
			 					0,0,0,
			 					0,0,0};
	//creating button array
	private static JButton []button;
	
	
	Model m=new Model();
	
	//initializing button array
	public Controller(JButton []button) {
		
		Controller.button = button;
	}
	
	//initialize action listeners for buttons
	
	public void actionPerformed() {
		for (int i = 0; i < this.button.length; i++) {
            int value = i;
            JButton temp=button[i];
            temp.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                	
                	
                	//when click[i]=0 only
                    if (click[value] == 0) {  
                        click[value] = 1;
                      //perform the action
                        m.clickButton(temp, value + 1);
                    }
                }
            });
        }
    }
	//Method to reset all the buttons
	public static void resetButton() {
        for (int i = 0; i < Controller.button.length; i++) { 
        	//set all button text to null
           Controller.button[i].setText(""); 
           //set button state array to zero
           Controller.click[i] = 0;
       }
   }
   
	
		
	
	}
