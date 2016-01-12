import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
public class Nim extends Applet implements ActionListener
{
    JButton[] a;
    String name, name2;
    JLabel status;
    int row = 10;
    int turn = 1;
    int win = 0;

    public void init ()
    { //a grid to layout the screen nicely
	JLabel title = new JLabel ("THE GAME OF NIM!");
	title.setFont (new Font ("Times New Roman", Font.PLAIN, 48));
	Panel p = new Panel ();
	resize (500, 100);
	//declare a new array of buttons
	a = new JButton [row];
	//initialize each of the buttons in the array
	//with an empty label
	for (int nNum = 0 ; nNum < row ; nNum++)
	{
	    a [nNum] = new JButton ("8");
	    p.add (a [nNum]);
	    //each button will have an action listener
	    a [nNum].addActionListener (this);
	    a [nNum].setBackground (Color.yellow);
	    //each button will send a message with its number
	    a [nNum].setActionCommand ("" + nNum);
	}

	name = JOptionPane.showInputDialog ("Enter name Player 1: ");
	name2 = JOptionPane.showInputDialog ("Enter name Player 2:  ");


	JButton reset = new JButton ("Reset");
	reset.addActionListener (this);
	reset.setActionCommand ("re");

	status = new JLabel ("Welcome! The player to remove the final stones is the loser!");
	add (title);
	add (status);
	add (p);
	add (reset);
    }


    public void actionPerformed (ActionEvent e)
    {

	if (!e.getActionCommand ().equals ("re"))
	{
	    int pos = Integer.parseInt (e.getActionCommand ());
	    int count = Integer.parseInt (a [pos].getText ());
	    String input = "";
	    int count2 = 0;

	    if (count < 1)
		JOptionPane.showMessageDialog (null, "Error", "Error! Already empty!", JOptionPane.WARNING_MESSAGE);

	    else if (count < 9)
	    {


		try
		{
		    input = JOptionPane.showInputDialog ("How many do you want to remove? ");
		    count2 = Integer.parseInt (input);
		}
		catch (NullPointerException w)
		{
		}
		catch (NumberFormatException w)
		{
		}

		if (count2 > 0 && count2 < 9)
		{
		    a [pos].setLabel ((count - count2) + "");
		    if ((count - count2) > 2)
			a [pos].setBackground (Color.yellow);
		    else if ((count - count2) > 0)
			a [pos].setBackground (Color.red);
		    else
		    {
			a [pos].setBackground (Color.white);
			win++;
		    }

		    if (count2 > 0 && input != null)
			turn++;


		    repaint ();
		}
		else
		    JOptionPane.showMessageDialog (null, "Error", "Error! Invalid Input!", JOptionPane.WARNING_MESSAGE);
	    }
	}
	else
	{
	    for (int i = 0 ; i < row ; i++)
	    {
		a [i].setLabel ("8");
		a [i].setBackground (Color.yellow);
	    }

	    status.setText ("Welcome! The person to remove the final stones loses!");
	}

	if (turn % 2 == 0)
	    status.setText (name + "'s turn!");
	else
	    status.setText (name2 + "'s turn!");


	if (win >= 10)
	{
	    if (turn % 2 == 1)
		status.setText (name + " is the winner!");
	    else
		status.setText (name2 + " is the winner!");
	}




    }
}



