

/*Model
 * The Model component corresponds to all the game related logic
 * checking the winner happens here
 */

import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Model  {
	
	    //detect player
		private int  player; 
		// draw for check draw condition
		private int draw;
		
		//create array for player 1
	    private int[][] mat1={{0, 0, 0},
	    					 {0, 0, 0},
	    					 {0, 0, 0}}; 
	   //create array for player 2
	    private int[][] mat2={{0, 0, 0}, 
	    					  {0, 0, 0},
	    					  {0, 0, 0}}; 

	    public Model() {
	        this.draw = 0;
	        this.player = 0;
	    }
	  
	    void clickButton(JButton button, int n) {
	        int setRow;
	        int setColoum;
	        //identifying clicked button
	        if (n % 3 == 0) {
	            setColoum = 2;
	            setRow = n / 3 - 1;
	        } else {
	            setColoum = n % 3 - 1;
	            setRow = n / 3;
	        }
	       
	        //Player 1
	        if (this.player % 2 == 0) {
	        	//set button text to 1
	            button.setText("1");
	            
	            //when clicked a button corresponding matrix element mark as 1
	            this.mat1[setRow][setColoum] = 1; 
	            //check whether player 1 wins or not
	            int val = this.winner(this.mat1);
	            
	            if (val == 0) {
	                this.player++; //count for detect player
	                this.draw++; //count for draw
	            }
	            else {
	            	//set message when player 1 wins
	                gameMsg("Player 1 Wins !!!"); 
	                
	            }
	        } 
	        //player 2
	        else {
	            button.setText("2");//set button text to 2
	            this.mat2[setRow][setColoum] = 1;
	            int arr = this.winner(this.mat2); //check whether player 2 wins or not 
	            if (arr == 0) {
	                this.player++;  
	                this.draw++; 
	            } 
	            else if (arr == 1) {
	                gameMsg("Player 2 Wins !!!"); //set message when player 2 wins
	            }
	        }
	      //set message when game is draw
	        if (this.draw == 9) {
	            gameMsg("Game is draw !!!"); 
	        }
	    }

	    //check winner
	    private int winner(int[][] mat) {
	    	//row check
	        if (checkSumArray(mat, 0, 0) == 3 || checkSumArray(mat, 1, 0) == 3 || checkSumArray(mat, 2, 0) == 3) { 
	            return 1;
	        } 
	       //column check
	        else if (checkSumArray(mat, 0, 1) == 3 || checkSumArray(mat, 1, 1) == 3 || checkSumArray(mat, 2, 1) == 3) { 
	            return 1;
	        } 
	       //main diagonal check
	        else if (checkSumArray(mat, 1, 2) == 3) { 
	            return 1;
	        }
	        //secondary diagonal check
	        else if (checkSumArray(mat, 1, 3) == 3) {
	            return 1;
	        }
	        return 0;
	    }

	    private int checkSumArray(int[][] mat, int n, int c) {
	        int sum = 0;
	        int arr = 0;
	        //c=0 row constant
	        //c=1 column constant
	        //c=2 main diagonal
	        //c=3 secondary diagonal
	        switch (c) {
	            case 0:
	                for (int i = 0; i < 3; i++) {
	                    sum += mat[n][i];
	                }   break;
	            case 1:
	                for (int i = 0; i < 3; i++) {
	                    sum += mat[i][n];
	                }   break;
	            default:
	                for (int i = 0; i < 3; i++) {
	                    for (int j = 0; j < 3; j++) {
	                        if (i == j) {
	                            sum += mat[i][j];
	                            arr += mat[i][2 - j];
	                        }
	                    }
	                }   break;
	        }
	        if (c == 3) {
	            return arr;
	        }
	        return sum;
	    }
	    
	  //message to display winner or draw
	     public void gameMsg(String str) {
	        JOptionPane.showMessageDialog(null, str, "Message", JOptionPane.INFORMATION_MESSAGE);
	        //ask play again
	        int toReturn = JOptionPane.showConfirmDialog(null, "Do You Like to Play Again?", "Choose", JOptionPane.YES_NO_OPTION);
	        
	        if (toReturn == JOptionPane.YES_OPTION) {
	            this.resetGame(); //reset for play again the game
	        } else {
	            System.exit(0); //exit from the system
	        }
	    }

	  //reset all game variables 
	    public void resetGame() { 
	        this.draw = 0;
	        this.player = 0;
	        
	        Controller.resetButton();//reset buttons
	        //set all element 0 in mat1 and mat2 
	        for (int i = 0; i < 3; i++) {      
	            for (int j = 0; j < 3; j++) {
	                this.mat1[i][j] = 0;
	                this.mat2[i][j] = 0;
	            }
	        }
	    }
	    
	     
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
