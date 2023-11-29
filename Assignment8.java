
//Description: Using recurtion method instead of lopps to calculate specific tasks.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Assignment8 {

	public static void main(String[] args) {
		try {
         char inputOpt = ' ';
         String inputLine;
         InputStreamReader isr = new InputStreamReader(System.in);
         BufferedReader stdin = new BufferedReader(isr);
         double sum;
         int sumInt;
         do {
                printMenu();
                inputLine = stdin.readLine().trim();
                if (inputLine.isEmpty()) {
                    continue;
                }
                inputOpt = inputLine.charAt(0);
                inputOpt = Character.toUpperCase(inputOpt);

                switch (inputOpt) {

                    case 'A':// Calculate the sum of all elements in an array of doubles
                         System.out.print("Enter numbers (0 to finish): ");
                         double arr[] = parseDoubles(stdin);
                         sum = Sum(arr.length - 1, arr);
                         System.out.println("Sum of elements in array: " + sum);
                         break; 
                        
                    case 'B'://Calculate the sum of all integers between two numbers (including the two numbers)
                         System.out.print("Enter the first number: ");
                         int l = readInteger(stdin);
                         int ll = l;
                         System.out.print("Enter the second number: ");
                         int r = readInteger(stdin);
                         int rr = r;
                         if(l > r){
                           int q = l;
                           l = r;
                           r = q;
                         }
                         sumInt = SumBetween(l, r);
                         System.out.print("The sum of all integers between " + ll + " and " + rr + " is: " + sumInt + "\n");
                         break;
                                          
                    case 'C'://Calculate the prime factorization of an integer
                        System.out.print("Enter an integer to factorize: ");
                        int x = readInteger(stdin);
                        String res = primeFactor(x, 2);
                        System.out.print("The prime factorization of " + x + " is: " + res + "\n");
                        break;
                        
                    case 'D'://Remove all occurrences of a specified substring in a string
                        System.out.print("Please enter string: ");
                        System.out.print("Please enter substring to remove: ");
                        String xx = stdin.readLine(), yy = stdin.readLine();
                        String ans = removeSub(xx, yy, 0);
                        System.out.println("String after substring removal: " + ans);
                        break;

                    case 'E':
                        break;

                    default:
                        System.out.print("Invalid choice. Please choose a char between A and E.\n");
                        break;
                }

            } while (inputOpt != 'E' || inputLine.length() != 1);

		} catch (IOException ex) {
			 System.out.print("IO Exception\n");
		}
	}

	// A: recursive method that calculates the sum of all elements in an array of
	// doubles and returns the sum
   static double Sum(int index, double arr[]){
      if(index == 0){
         return arr[index];
      }
      else{
         return arr[index] + Sum(index - 1, arr);
      }
   }
	// B: recursive method that calculates the sum of all integers between two
	// numbers (including the two numbers) and returns the sum
   static int SumBetween(int l, int r){
      if(l == r){
         return l;
      } 
      else{
         return l + SumBetween(l + 1, r);
      }
   }

	// C: recursive method that calculates the prime factorization of an integer and returns a string as a result

   static String primeFactor(int x, int pr){
      if(x / pr == 1 && x % pr == 0){
         return "" + pr;
      }
      else{
         if(x % pr == 0){
            return pr + "x" + primeFactor(x / pr, pr);
         }
         else{
            return primeFactor(x, pr + 1);
         }
      }
   }

	// D: recursive method that removes all occurrences of a specified substring in a string and returns the result string
   static String removeSub(String x, String y, int ind){
      if(ind + y.length() >= x.length()){
         if(ind < x.length()){
            return x.substring(ind);
         }
         else{
            return "";
         }
      }
      else{
         String z = "" + x.substring(ind,ind + y.length());
         if(y.compareTo(z) == 0){
            return removeSub(x, y, ind + y.length());
         }
         else{
            return x.charAt(ind) + removeSub(x, y, ind + 1);
         }
      }
   }

	// ----------------------------------------------------------------------------------------

	// utility method for parsing doubles from standard input that returns an array of doubles
	public static double[] parseDoubles(BufferedReader reader) {
		String line = "";
		ArrayList<Double> container = new ArrayList<>();
		try {
			line = reader.readLine();
			double num = Double.parseDouble(line);

			while (num != 0) {
				container.add(num);
				line = reader.readLine();
				num = Double.parseDouble(line);
			}

		} catch (IOException ex) {
			System.out.println("IO Exception.");
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, return to main menu.");
		}

		double[] result = new double[container.size()];
		for (int i = 0; i < container.size(); i++) {
			result[i] = container.get(i);
		}
		return result;
	}

	// utility method for parsing integers from standard input (only positive integers allowed)
    public static int readInteger(BufferedReader reader) throws IOException {
        int number = 0;
        try {
            String line = reader.readLine();
            number = Integer.parseInt(line);
        } catch (IOException e) {
            System.out.println("Error reading input. Please try again.");
            number = readInteger(reader);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please try again.");
            number = readInteger(reader);
        }
        if (number <0) {
        	System.out.println("Invalid input. Only positive integers allowed. Please try again.");
        	number = readInteger(reader);
        }
        return number;
    }

	// utility method for printing the menu
	public static void printMenu() {
		System.out.print("\nWhat would you like to do?\n\n");
		System.out.print("A: Calculate the sum of all elements in an array of doubles\n");
		System.out.print("B: Calculate the sum of all integers between two numbers (including the two numbers)\n");
		System.out.print("C: Calculate the prime factorization of an integer\n");
		System.out.print("D: Remove all occurrences of a specified substring in a string\n");
		System.out.print("E: Quit\n\n");
	}
}
