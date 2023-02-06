import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.lang.Math;


public class Calculator3 implements ActionListener{

    
    public double total = 0;
    public int totalint = 0;
    public String totalString = "";
    public String lastSignPressed = "";

    public boolean divZero = false;

    public boolean eqPressed = false;

    protected static JButton button1, button2, button3, button4, button5, button6, 
    button7, button8, button9, button0, buttonadd, buttonsub, buttonmul, buttondiv,
    buttonparleft, buttonparright, buttonexp, buttoneq, buttonclr, buttonBckSpc;

    protected static JTextField outIn;

    public Calculator3()
    {
        //JFrame
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");

        //no layout panel
        JPanel panel = new JPanel();

        button1 = new JButton("1");
        button1.setBounds(5,40,100,100);
        button1.addActionListener(this);

        button2 = new JButton("2");
        button2.setBounds(115,40,100,100);
        button2.addActionListener(this);
        
        button3 = new JButton("3");
        button3.setBounds(225,40,100,100);
        button3.addActionListener(this);

        button4 = new JButton("4");
        button4.setBounds(5,155,100,100);
        button4.addActionListener(this);

        button5 = new JButton("5");
        button5.setBounds(115,155,100,100);
        button5.addActionListener(this);

        button6 = new JButton("6");
        button6.setBounds(225,155,100,100);
        button6.addActionListener(this);

        button7 = new JButton("7");
        button7.setBounds(5,265,100,100);
        button7.addActionListener(this);

        button8 = new JButton("8");
        button8.setBounds(115,265,100,100);
        button8.addActionListener(this);

        button9 = new JButton("9");
        button9.setBounds(225,265,100,100);
        button9.addActionListener(this);

        buttonadd = new JButton("+");
        buttonadd.setBounds(335,40,100,100);
        buttonadd.addActionListener(this);

        buttonsub = new JButton("-");
        buttonsub.setBounds(335,155,100,100);
        buttonsub.addActionListener(this);

        buttonmul = new JButton("*");
        buttonmul.setBounds(335,265,100,100);
        buttonmul.addActionListener(this);

        buttondiv = new JButton("/");
        buttondiv.setBounds(335,375,100,100);
        buttondiv.addActionListener(this);

        button0 = new JButton("0");
        button0.setBounds(5,375,100,100);
        button0.addActionListener(this);

        buttonparleft = new JButton("(");
        buttonparleft.setBounds(115,375,100,100);
        buttonparleft.addActionListener(this);

        buttonparright = new JButton(")");
        buttonparright.setBounds(225,375,100,100);
        buttonparright.addActionListener(this);

        buttonexp = new JButton("^");
        buttonexp.setBounds(225,485,100,100);
        buttonexp.addActionListener(this);

        buttoneq = new JButton("=");
        buttoneq.setBounds(335,485,100,100);
        buttoneq.addActionListener(this);

        buttonclr = new JButton("Clear");
        buttonclr.setBounds(5,485,100,100);
        buttonclr.addActionListener(this);

        buttonBckSpc= new JButton("Backspace");
        buttonBckSpc.setBounds(115,485,100,100);
        buttonBckSpc.addActionListener(this);
        //textfield

        outIn = new JTextField("Press Any Button To Start!");
        outIn.setBounds(135,10,300,20);


        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);
        frame.add(button7);
        frame.add(button8);
        frame.add(button9);
        frame.add(button0);

        frame.add(buttonadd);
        frame.add(buttonsub);
        frame.add(buttonmul);
        frame.add(buttondiv);
        frame.add(buttonparleft);
        frame.add(buttonparright);
        frame.add(buttonexp);
        frame.add(buttoneq);
        frame.add(buttonclr);
        frame.add(buttonBckSpc);

        frame.add(panel);
        frame.add(outIn);
    

        frame.setSize(455,650);
        frame.setResizable(false);
        frame.setVisible(true);
    }
   

    public static void main(String[] args) {
    

        Calculator3 calc = new Calculator3();
    
    }

    public double equationHandler(double left, double right, char symbol)
    {
        //System.out.println(symbol);
        double total = 0;
        if(symbol == '+')
        {
            total = left + right;
        }
        if(symbol == '-')
        {
            total = left - right;
        }
        if(symbol == '*')
        {
            total = left * right;
        }
        if(symbol == '/')
        {
            total = left / right;
        }
        if(symbol == '^')
        {
            total = Math.pow(left, right);
        }


        return total;
    }

    public int symbolCounter(char[] equation)
    {
        int total=0;

        for(int i = 0; i < equation.length; i++)
        {
            if(equation[i] == '*' || equation[i] == '/' || equation[i] == '+' || equation[i] == '-' || equation[i] == '^')
            {
                total++;
            }
        }
        return total;
    }

    public int firstSymbolFinder(char[] equation)
    {
        int location=0;

        for(int i = 0; i < equation.length; i++)
        {
            if(equation[i] == '^')
            {
                location = i;
                return location;
            }
        }

        for(int j = 0; j < equation.length; j++)
        {
            if(equation[j] == '*' || equation[j] == '/')
            {
                location = j;
                return location;
            }
        }
        
        for(int x = 0; x < equation.length; x++)
        {
            if(equation[x] == '+' || equation[x] == '-')
            {
                location = x;
                return location;
            }
        }

        return location;
    }

    public char[] stringToCharArray(String s)
    {
        char[] c = new char[s.length()];
        for(int i = 0; i < s.length(); i++)
        {
            c[i] = s.charAt(i);
            //System.out.println(c[i]);    
        }
        return c;
    }

    public String charArrayToString(char[] c)
    {
        String s = "";
        for(int i = 0; i < c.length; i++)
        {
            s = s + c[i];
            //System.out.println(c[i]);    
        }
        return s;
    }

    public double algebraMachine(String math_String)
    {
        double finaltotal = 0;

        //int end = 0;                    //begining of current parentheses
        int symbolBreak = 0;
        //int start = 0;                  //ending of current parentheses

        //String math_String = ""; //inner parentheses equation string
        char[] math_char;      //inner parentheses equation char array

        int symbolLocation = 0;       //location of first math symbol according to pemdas
        int symbolcount = 0;          //number of symbols in equation
        Boolean stringEnd = false;    //check for if reached end of equation

        String left = "";   //left side of current math calc
        String right = "";  //right side of current math calc

        int leftSymbolLocation = 0;   //left side detecting symbols to the left of current sub calculation

        double partotal = 0;
        boolean containsSym = true;


        math_char = stringToCharArray(math_String);
        symbolcount = symbolCounter(math_char);
        while(symbolcount > 0)
        {
            left = "";
            right = "";
            leftSymbolLocation = 0;
            symbolcount = symbolCounter(math_char);
            
            
            //System.out.println(symbolcount);

            if(symbolcount == 0)
            {
                containsSym = true;
            }
            if(symbolcount > 0)
            {
                symbolLocation = firstSymbolFinder(math_char);

                //System.out.println(symbolLocation);
                for(int l = 0; l < symbolLocation; l++)
                {
                    
                    if(math_char[l] == '*' || math_char[l] == '/' || math_char[l] == '+' || math_char[l] == '-' || math_char[l] == '^')
                    {
                        leftSymbolLocation = l;
                    }
                    


                }
                //System.out.println(leftSymbolLocation);
                if(leftSymbolLocation == 0)
                {
                    for(int q = 0; q < symbolLocation; q++)
                    {
                        left = left + math_char[q];
                    }
                }
                if(leftSymbolLocation > 0)
                {
                    for(int q = leftSymbolLocation+1; q < symbolLocation; q++)
                    {
                        left = left + math_char[q];
                    }
                }


                //System.out.println(leftSymbolLocation);

                for(int r = symbolLocation+1; r < math_char.length; r++)
                {
                    
                    if(math_char[r] == '*' || math_char[r] == '/' || math_char[r] == '+' || math_char[r] == '-' || math_char[r] == '^')
                    {
                        symbolBreak = r;
                        break;
                    }
                    else
                    {
                       right = right + math_char[r];
                    }
                    if(r == math_char.length-1)
                    {
                        symbolBreak = r;
                        //stringEnd = true;
                        break;
                        
                    }
                }   
                //System.out.println(symbolBreak);
                //System.out.println(math_char[symbolBreak]);
                //System.out.println(left);
                partotal = equationHandler(Double.parseDouble(left),Double.parseDouble(right),math_char[symbolLocation]);
                //System.out.println(right);

                //System.out.println(partotal);
                if(symbolcount > 0)
                {
                    math_String = "";
                    String tempString = "";
                    if(leftSymbolLocation == 0)
                    {
                        //math_String = math_String + partotal;
                        for(int g = 0; g < math_char.length; g++)
                        {
                            if(symbolBreak == math_char.length-1)
                            {
                                math_String =  math_String + partotal;
                                //tempString = "";
                            }
                            else
                            {
                                if(g == symbolBreak-1)
                                {
                                math_String = partotal + math_String;
                                //math_String = math_String+tempString;
                                //tempString = "";
                                }
                                if(g >= symbolBreak)
                                {
                                tempString = tempString + math_char[g];
                                //math_String = math_String + math_char[g];
                                }
                            }
                            
                        }
                        math_String = math_String+tempString;
                    }

                    if(leftSymbolLocation > 0)
                    {
                        for(int g = 0; g < math_char.length; g++)
                        {
                            //System.out.println(math_char[g]);
                            if(g <= leftSymbolLocation)
                            {
                                //math_String = math_String + math_char[g];
                                tempString = tempString + math_char[g];
                                
                            }
                            if(symbolBreak == math_char.length-1)
                            {
                                if(g == symbolBreak-1)
                                {
                                math_String =  math_String + partotal;
                                math_String = tempString+math_String;
                                tempString = "";
                                }

                            }
                            else
                            {
                                if(g == symbolBreak-1)
                                {
                                math_String =  math_String + partotal;
                                math_String = tempString+math_String;
                                tempString = "";
                                }
                                if(g >= symbolBreak)
                                {
                                tempString = tempString + math_char[g];
                                //math_String = math_String + math_char[g];
                                }
                            }
                
                            
                        }
                        math_String = math_String+tempString;
                    }
                }

                if(stringEnd == false)
                {

                }

        
                math_char = stringToCharArray(math_String);
                
                
            }   



        }
        System.out.println(math_String);
        
        return partotal;
    }


    public double mathHandler(String s)
    {
          double total=0;
          double partotal = 0;
          boolean containsSym = true;

          char[] c = stringToCharArray(s);

          int end = 0;                    //begining of current parentheses
          int start = 0;                  //ending of current parentheses
          String parentheses_String = ""; //inner parentheses equation string


            while(containsSym == true)
            {
                for(int j = 0; j < c.length; j++)
                {
        
                    if(c[j] == '(')
                    {
                        start = j;
                        for(int p = j; p < c.length; p++)
                        {
                            if(c[p] == ')')
                            {
                                end = p;

                                for(int pl = start+1; pl < end; pl++)
                                {
                                    parentheses_String = parentheses_String + c[pl];
                                }
                                //partotal = algebraMachine(parentheses_String);
                                break;


                             
                            }


                        }


                    }
             
                    
                }

                if(symbolCounter(c) == 0)
                {
                    containsSym = false;
                        //return total;
                }
                if(symbolCounter(c) > 0)
                {
                    containsSym = true;
                        //break;
                }
                break;
            }
            //System.out.println(s);
            
            total = algebraMachine(parentheses_String);
            return total;
            //return 0;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

       if(e.getSource() == button1)
       {
          if(eqPressed == true)
          {
               totalString = "";
               totalString = totalString + "1";
               outIn.setText(totalString);
               eqPressed = false;

          }
          else
          {
               totalString = totalString + "1";
               outIn.setText(totalString);
          }
       }

       if(e.getSource() == button2)
       {
          if(eqPressed == true)
          {
               totalString = "";
               totalString = totalString + "2";
               outIn.setText(totalString);
               eqPressed = false;

          }
          else
          {
               totalString = totalString + "2";
               outIn.setText(totalString);
          }
       }

       if(e.getSource() == button3)
       {
          if(eqPressed == true)
          {
               totalString = "";
               totalString = totalString + "3";
               outIn.setText(totalString);
               eqPressed = false;

          }
          else
          {
               totalString = totalString + "3";
               outIn.setText(totalString);
          }
       }

       if(e.getSource() == button4)
       {
          if(eqPressed == true)
          {
               totalString = "";
               totalString = totalString + "4";
               outIn.setText(totalString);
               eqPressed = false;

          }
          else
          {
               totalString = totalString + "4";
               outIn.setText(totalString);
          }
       }

       if(e.getSource() == button5)
       {
          if(eqPressed == true)
          {
               totalString = "";
               totalString = totalString + "5";
               outIn.setText(totalString);
               eqPressed = false;

          }
          else
          {
               totalString = totalString + "5";
               outIn.setText(totalString);
          }
       }

       if(e.getSource() == button6)
       {
          if(eqPressed == true)
          {
               totalString = "";
               totalString = totalString + "6";
               outIn.setText(totalString);
               eqPressed = false;

          }
          else
          {
               totalString = totalString + "6";
               outIn.setText(totalString);
          }
       }

       if(e.getSource() == button7)
       {
          if(eqPressed == true)
          {
               totalString = "";
               totalString = totalString + "7";
               outIn.setText(totalString);
               eqPressed = false;

          }
          else
          {
               totalString = totalString + "7";
               outIn.setText(totalString);
          }
       }

       if(e.getSource() == button8)
       {
          if(eqPressed == true)
          {
               totalString = "";
               totalString = totalString + "8";
               outIn.setText(totalString);
               eqPressed = false;

          }
          else
          {
               totalString = totalString + "8";
               outIn.setText(totalString);
          }
       }

       if(e.getSource() == button9)
       {
          if(eqPressed == true)
          {
               totalString = "";
               totalString = totalString + "9";
               outIn.setText(totalString);
               eqPressed = false;

          }
          else
          {
               totalString = totalString + "9";
               outIn.setText(totalString);
          }
       }

       if(e.getSource() == button0)
       {
          if(eqPressed == true)
          {
               totalString = "";
               totalString = totalString + "0";
               outIn.setText(totalString);
               eqPressed = false;

          }
          else
          {
               totalString = totalString + "0";
               outIn.setText(totalString);
          }
       }

       if(e.getSource() == buttonadd)
       {

               totalString = totalString + "+";
               outIn.setText(totalString);
               eqPressed = false;

       }

       if(e.getSource() == buttonsub)
       {

               totalString = totalString + "-";
               outIn.setText(totalString);
               eqPressed = false;
       }

       if(e.getSource() == buttonmul)
       {

               totalString = totalString + "*";
               outIn.setText(totalString);
               eqPressed = false;


       }

       if(e.getSource() == buttondiv)
       {

               totalString = totalString + "/";
               outIn.setText(totalString);
               eqPressed = false;
       }

       if(e.getSource() == buttonexp)
       {

               totalString = totalString + "^";
               outIn.setText(totalString);
               eqPressed = false;
       }

       if(e.getSource() == buttonclr)
       {
            totalString = "";
            outIn.setText(totalString);
       }

       if(e.getSource() == buttonparleft)
       {
          if(eqPressed == true)
          {
               totalString = "";
               totalString = totalString + "(";
               outIn.setText(totalString);
               eqPressed = false;

          }
          else
          {
               totalString = totalString + "(";
               outIn.setText(totalString);
          }

            
       }

       if(e.getSource() == buttonparright)
       {
          if(eqPressed == true)
          {
               totalString = "";
               totalString = totalString + ")";
               outIn.setText(totalString);
               eqPressed = false;

          }
          else
          {
               totalString = totalString + ")";
               outIn.setText(totalString);
          }

            
       }


       if(e.getSource() == buttonBckSpc)
       {
            //totalString = "";
            char[] temp = stringToCharArray(totalString);
            char[] temp2 = new char[temp.length-1];
            for(int i = 0; i < temp.length-1; i++)
            {
                 temp2[i] = temp[i];
            }
            totalString = charArrayToString(temp2);
            outIn.setText(totalString);
       }

       if(e.getSource() == buttoneq)
       {
          
          eqPressed = true;
          total = mathHandler(totalString);

          totalString = total+"";

          if(divZero == true)
          {
               divZero = false;
               outIn.setText("Cant Divide By Zero");

          }
          else
          {
               outIn.setText(totalString);
          }


       }


        
        
    }




}

