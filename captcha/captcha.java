import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
public class captcha extends Applet implements ActionListener
{
  JTextField ans2;
  String ans3[] = {"existing", "overlooks", "inquiry", "contribute", "tround", "qssae", "3m573", "chisels", "and"};
  JLabel pic;
  JLabel click;
  int n = (int) (Math.random () * 8);
  public void init ()
  {
    
    JLabel title = new JLabel ("Captcha");
    title.setFont (new Font ("Arial Rounded MT Bold", Font.PLAIN, 45));
    JLabel ques = new JLabel ("Are you a human?");
    JLabel ans = new JLabel ("Answer: ");
    ans2 = new JTextField (6);
    JButton enter = new JButton ("Enter");
    enter.addActionListener (this);
    enter.setActionCommand ("enter");
    click = new JLabel ("Click Enter to see if you are human.");
    JButton newc = new JButton ("New Captcha");
    newc.addActionListener (this);
    newc.setActionCommand ("new");
    pic = new JLabel (createImageIcon ("stop.png"));
    
    
    add (title);
    add (ques);
    add (pic);
    add (ans);
    add (ans2);
    add (enter);
    add (click);
    add (newc);
    
    
  }
  
  
  public void actionPerformed (ActionEvent e)
  {
    
    if (e.getActionCommand ().equals ("new"))
    {
      n = (int) (Math.random () * 8);
      pic.setIcon (createImageIcon ("c" + (n + 1) + ".PNG"));
    }
    
    else if (e.getActionCommand ().equals ("enter"))
    {
      if (ans2.getText ().equals (ans3 [n]))
      {
        click.setText ("You got it right! Human!");
        click.setForeground (Color.green);
      }
      else //if (!ans2.getText ().equals (ans3 [n]))
      {
        click.setText ("Incorrect. ALIEN");
        click.setForeground (Color.red);
      }
      
      
    }
  }
  
  
  protected static ImageIcon createImageIcon (String path)
  {
    java.net.URL imgURL = captcha.class.getResource (path);
    if (imgURL != null)
    {
      return new ImageIcon (imgURL);
    }
    
    
    else
    {
      System.err.println ("Couldn't find file: " + path);
      return null;
    }
  }
}