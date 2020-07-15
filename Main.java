//Gregory Pierre || EMPLID: 15239799 || CISC 3130- TY2- Fall 2019
import java.util.Stack;
import java.util.Scanner;
import java.util.*;
import java.io.File;
public class Main {
  //Program reads the text file to determine if the data type is a Palindrome
    public static void main(String[]args) throws Exception{ 
      
        Stack <Character> stack = new Stack<Character>();        
        //Scanner reads a text file to determine if the data type is a Palindrome
        File file = new File("text.txt");
        Scanner scanner = new Scanner(file);

        //While loop to iterate each line
          while(scanner.hasNextLine()){
          String line = scanner.nextLine();
            for(int i = 0; i <= line.length()-1;i++){
            //pushes each character from a line to a stack 
            stack.push(Character.toLowerCase(line.charAt(i)));
            System.out.print(line.charAt(i));
            }
            //Copy of the stack to be used to compared to the original 
            Stack stack_copy = (Stack)stack.clone();
            //isPalindrome method to determine if the data from the text file is a Palindrome
            boolean checker = isPalindrome(stack,reverse(stack_copy));

                System.out.print(" "+checker);
                if(checker == true){System.out.print(" is a palindrome");}
                if(checker == false){System.out.print(" is not a palindrome");}
                System.out.println("");

                stack.removeAllElements();
                stack_copy.removeAllElements();
            }
          
        }
       //isPalindrome method 
      public static boolean isPalindrome(Stack stack, Stack newstack){
        //compares each character in the stack to determine if they're equal
        //If the length of the data type is equal to the number of indexes then it'll return true
        //If not then it'll return false
        int count = 0;
        for(int i = 0; i <= stack.size()-1; i++){
          if(stack.elementAt(i) == newstack.elementAt(i)){count++;}
          if(stack.size() == count){return true;}
        }
          return false;     
   }
   //Method that reverses the stack
    public static Stack reverse(Stack stack){
        Stack<Character> revstack = new Stack<Character>();
        while(!stack.isEmpty()){revstack.push(stack.pop().toString().charAt(0));}
        return revstack;
    }  
}
