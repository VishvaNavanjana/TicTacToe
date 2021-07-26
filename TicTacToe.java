
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe extends JPanel implements ActionListener{

	private JButton [][] buttons = new JButton [3][3];
	private boolean Player1=true; //this is use to check who is the current player
	
	public TicTacToe() {
		// set the panel size 
		super(new BorderLayout());
		setPreferredSize(new Dimension(300,300));
		setLayout(new GridLayout(3,3));
		setButtons();
	}
	
	//method to set buttons in the panel
	public void setButtons() {
		
		//buttons = new JButton [3][3];
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				buttons[i][j]=new JButton();
				buttons[i][j].setText("");
				buttons[i][j].addActionListener(this);
				add(buttons[i][j]);
			}
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton clickedButton = (JButton)e.getSource();
		
		//set the text of button according to the player
		if(Player1) {
			clickedButton.setText("1");
			Player1=false;//change the player
			boolean check = checkWin("1");
			if(check) {
				JOptionPane.showMessageDialog(null, "Player 1 won");
			}
		} 
		else {
			clickedButton.setText("2");
			Player1=true;//change the player
			boolean check = checkWin("2");
			if(check) {
				JOptionPane.showMessageDialog(null, "Player 2 won");
			}
		}
		//disable the button
		clickedButton.setEnabled(false);
		
		
	}
	
	

	
	
	//check if the current player is a winner or not
	public boolean checkWin(String player) {
		
		//checking through rows
		for(int i=0;i<3;i++) {
			
			int count=0;
			
			for(int j=0;j<3;j++) {
					
				//if all buttons in row set to player then final count is 3
				//otherwise it set to 0
				if(buttons[i][j].getText()==player) {
					count++;
				}
				else {
					count=0;
				}
				
				if(count==3) return true;
		    }
		}
		
		//checking through columns
		for(int j=0;j<3;j++) {
			
			int count=0;
			
			for(int i=0;i<3;i++) {		
						
				//if all buttons in column set to player then final count is 3
				//otherwise it set to 0
				if(buttons[i][j].getText()==player) {
					count++;
				}
				else {
					count=0;
				}
				
				if(count==3) return true;
				
			}
		}
		
		
		//check through diagonals
		if(buttons[0][0].getText()==player && buttons[1][1].getText()==player && buttons[2][2].getText()==player) {
			return true;
		}
		else if(buttons[0][2].getText()==player && buttons[1][1].getText()==player && buttons[2][0].getText()==player) {
			return true;
		}
		
		return false;
		
	 }
		
		
	
	
	
	public static void main(String[] args) 
    {
		//Create and set up the window.
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new TicTacToe();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
}