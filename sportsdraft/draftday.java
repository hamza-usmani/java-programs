import java.awt.*;
import hsa.Console;
import java.io.IOException;
import java.io.FileOutputStream;

public class draftday
{
    static Console c;

    public static void main (String[] args)
    {
 c = new Console ();
 menu ();
    }


    public static void menu ()
    {
 int cont = 0;
 int name[] = new int [10];
 c.println ("***** MENU *****\n(1) Enter Blue Jay Data\n(2) Display possible Draft Choices\n(3) Exit Program");
 int chosen = c.readInt ();
 if (chosen == 1)
 {
     bjdata ();
     cont = 1;
 }
 else if (chosen == 2)
 {
     draft (cont, name);
 }
 else
     System.exit (0);
    }


    public static void bjdata ()
    {
 String name[] = new String [10];
 int age[] = new int [10];
 String pos[] = new String [10];
 double avg[] = new double [10];

 for (int i = 0 ; i < 10 ; i++)
 {
     c.println ("Player Number " + (i + 1) + " Information\nWhat is the player's name?");
     name [i] = c.readLine ();
     c.println ("Good. Next, how old is he?");
     age [i] = c.readInt ();
     c.println ("What is his position as a player?");
     pos [i] = c.readLine ();
     c.println ("Lastly, what is his batting average?");
     avg [i] = c.readDouble ();
 }
 c.println ("Thank you. We will proceed to printing array.");
 back ();
    }


    public static void draft (int next, int name[])
    {
 c.println ("You must enter data first, by choosing option 1.");
 back ();

    }


    public static void back ()
    {
 c.println ("Press 0 to return to main menu, or any other button to exit."); //ask to go back to menu

 int back = c.readInt (); //read user input
 if (back == 0) //if user chooses yes to go back
 {
     c.clear ();
     menu ();
 } //clear console
 else
     System.exit (0); //else, exit program

    }


   
}
