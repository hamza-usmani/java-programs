import java.awt.*;//importing all of the neccessary libraries
import hsa.Console;

public class mathgames
{
    static Console c;

    public static void main (String[] args)
    {
 c = new Console ();
 char cont = 'y'; //the continue variable is y for default
 while (cont == 'y') //while the continue variable is yes or 'y'
 {
     int chosen = menu (); //display the menu
     if (chosen == 1)//if user chooses option 1
     {
  c.clear ();
  single ();//single game method
     }
     else if (chosen == 2)//if user chooses option 2
     {
  c.clear ();
  doubl ();//double game method
     }
     else if (chosen==3)
     {
  cont = 'n';
  System.exit (0);//exit program
     }
 }
    }


    public static int menu ()  //menu method
    {
 c.println ("\nWhat would you like to do in this program. Will you Play Game 1, or Game 2?"); //print all of the choices of the calculator
 c.println ("\n(1) The Single Random Number Guessing Game");
 c.println ("(2) The Double Number Multiplication Game");
 c.println ("(3) Exit the Program");
 int choice = c.readInt (); //read the user's selected option
 return choice; //return the selected option
    }


    public static void single ()
    {
 int counter = 0;
 int num1 = (int) (Math.random () * 20 + 1);//random number between 1 and 20

 c.println ("*****Single Number Guessing Game*****\nGuess what number I'm thinking of? It's between 1 and 20!");
 int guess = c.readInt ();//read user input
 while (guess != num1)
 {
     if (guess > num1)
  c.println ("Too high! Try lower.");
     else if (guess < num1)
  c.println ("Too low! Try higher.");
     guess = c.readInt ();
     counter++;//add 1 to counter
 }

 if (guess == num1)
     c.println ("You got it! It took you " + (counter + 1) + " tries to guess my number.");//print out number of tries

 back ();//prompt to continue
    }


    public static void doubl ()
    {
 c.println ("*****Double Number Multiplication Game*****");
 int num1 = (int) (Math.random () * 12 + 1);//declare 2 random numbers between 1 and 12
 int num2 = (int) (Math.random () * 12 + 1);
 int answer = num1 * num2;
 c.println ("Time to begin: What is the answer to: " + num1 + " x " + num2 + "\n");//ask multiplication question
 int user = c.readInt ();

 if (user != answer)//if user answers wrong
     c.println ("Incorrect! The actual answer is " + answer);
 else if (user == answer)//if user answer is right
     c.println ("Correct! You are very smart!");
 back ();//prompt to go back to menu

    }


    public static void back ()
    {
 c.println ("Press 0 to return to main menu, or any other button to exit.");//ask to go back to menu

 int back = c.readInt ();//read user input
 if (back == 0)//if user chooses yes to go back

     c.clear ();//clear console
 else
     System.exit (0);//else, exit program

    }
}


