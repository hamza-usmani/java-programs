 //---- IBIO - Below are simplified input and output methods ----
  static void output(String info)
  {  System.out.println(info); }
  static void output(double info)
  {  System.out.println(info);  }
  static void output(long info)
  {  System.out.println(info); }
  static int inputInt(String Prompt)
  {  int result=0;
	 try{result=Integer.parseInt(input(Prompt).trim());}
	 catch (Exception e){result = 0;}
	 return result;
  }
  static double inputDouble(String Prompt)
  {  double result=0;
	 try{result=Double.valueOf(input(Prompt).trim()).doubleValue();}
	 catch (Exception e){result = 0;}
	 return result;
  }
  static String input(String prompt)
  {  String inputLine = "";
	 System.out.print(prompt);
	 try{ java.io.InputStreamReader sys = 
				  new java.io.InputStreamReader(System.in);
		  java.io.BufferedReader inBuffer = 
				  new java.io.BufferedReader(sys);
		  inputLine = inBuffer.readLine();
		 }
	 catch (Exception e)
		 { String err = e.toString();
		   System.out.println(err);
	 }
	 return inputLine;
  }
  static String input()
  { return input("");  }
  
static int inputInt()
{ return inputInt(""); }
   
static double inputDouble()
{ return inputDouble(""); }

