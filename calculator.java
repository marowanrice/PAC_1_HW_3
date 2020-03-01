// Lab 3: Calculator
// Rowan Rice
// September 25, 2019

// The program below is a simple calculator that performs only 4 operatrions
// including multiplying, dividing, adding, subtracting. 
// The program also allows the user to end the program or clear the buffer 
// at any time (aka whenever the program asks for an input).

import java.util.Scanner;

public class calculator
{
	// define all constant variables:

	// special operators and zero
		public static final String CLEAR = "c";
		public static final String END = "x";
		public static final double ZERO = 0.0;

	// regular operators
		public static final String MULT = "*";
		public static final String DIV = "/";
		public static final String ADD = "+";
		public static final String SUB = "-";
	
	public static void main (String [] args)
	{
		Scanner input = new Scanner(System.in); 

		// print out instructions:
		System.out.println("Welcome to Calculator!");
		System.out.println("Enter \"x\" at any time to exit");
		System.out.println("Enter \"c\" at any time to clear buffer to 0.0");

		System.out.println("Give me a number: ");

		String firstInput = input.next();

		String specialOp = firstInput;

		double buffer = ZERO;

		double answer = ZERO;

		// first case is if user enters "c" at first opportunity
		if (specialOp.equals(CLEAR))
		{
			buffer = ZERO;
			answer = buffer;
			System.out.println("Answer: " + answer);
		}

		// second case is if user enters "x" at first opportunity
		else if (specialOp.equals(END))
		{
			System.out.println("Going so soon?");
		}

		// if user doesn't end or clear, take in the number
		else
		{
			buffer = Double.parseDouble(firstInput);
		}

		// introduce some variables so calculator can calculate!
		boolean validOp = true; // will keep track if operator is valid
		String operator;
		boolean checkOperator;
		String secondEntry;
		double secondNum;

		// loop to start the calculator if user hasn't ended program
		while (!specialOp.equals(END))
		{
			System.out.println("Give me an operator: ");

			validOp = true;
			checkOperator = false;

			// bring in operator
			operator = input.next();

			// determine if operator entered is *, /, +, -
			if (operator.equals(MULT) || operator.equals(DIV) ||
				operator.equals(SUB) || operator.equals(ADD))
			{
				checkOperator = true;
			}

			// if the operator entered isn't *, /, +, -, then check for 
			// special operators or an error
			if (checkOperator == false)
			{
				switch (operator) // deals with special operators
				{
					case END:
					{
						specialOp = END;
						break;
					}

					case CLEAR:
					{
						buffer = ZERO;
						answer = buffer;
						System.out.println("Answer: " + answer);
						break;
					}

					default: // all valid cases accounted for; throw error
					{
						System.out.println("Error: unknown operator");
						break;
					}
				}
				
				// determine for all operators that are not 
				// math that there shouldn't be math performed; 
				// skip the next section of the loop and go back to the top
				// of the while loop to ask for an operator again

				validOp = false; 
			}

			// continue loop if operator was valid and get second number
			if (validOp == true)
			{
				System.out.println("Give me another number: ");

				// assume a number or END or CLEAR will be entered
				secondEntry = input.next();

				if (secondEntry.equals(END))
				{
					specialOp = END; // will end while loop so program ends
				}

				else if (secondEntry.equals(CLEAR))
				{
					buffer = ZERO;
					answer = buffer;
					System.out.println("Answer: " + answer); 
					// go to start of loop to ask for an operator
				}
				
				// if end or clear not entered, perform calculation
				else
				{
					secondNum = Double.parseDouble(secondEntry);

					// catch division by zero error
					if ((secondNum == ZERO) && (operator.equals(DIV)))
					{
						System.out.println("Error: dividing by zero");
						// exits calc section and asks for another operator
					}

					// now that all errors caught, do the math
					else
					{
						switch (operator)
						{
							case MULT:
								answer = secondNum * buffer;
								break;
							
							case DIV:
								answer = buffer / secondNum;
								break;

							case SUB:
								answer = buffer - secondNum;
								break;

							case ADD:
								answer = buffer + secondNum;
								break;

							default:
								answer = buffer;
								break;
						}

						System.out.println("Answer: " + answer);
						
						// set buffer to answer so loop can start again
						// with this answer as the first operand (number)
						buffer = answer;
					}
				}
			}

		}

		System.out.println("Thanks for calculating!");
	}
}