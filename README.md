# PAC_1_HW_3
Calculator assignment

GRADE: 10/10

The objective of this assignment is to create a calculator than can perform addition, subtraction, multiplication,
and division. The user will also be able to enter in special characters to either clear the calculator’s buffer or
exit the calculator program.

The program should initially accept 2 operands and a mathematical operator (+, -, *, /) then store the results.
The succeeding steps should only ask for the operator and a new input number. The operator would then be
applied to the previously stored result (the buffer contains the result) and the new input number. The two
special operators will be “c” and “x”, where c will clear the buffer and x will exit the program.

The calculator will be expected to catch (i.e., recover from an error without crashing) division by zero and
unknown operator errors, as shown in the examples below. If either error occurs, the buffer’s value will remain
the same.

Lastly, the running of the program should be continuous by default. In other words, the user should be able to
perform as many calculations as they desire until they decide to exit the program. 

As far as assumptions about the input, it is safe to assume that the user will always pass in a valid numeric
entry for the 1st and 2nd inputs. In other words, your program does not need to catch bad input in the form of a
string or char.

It is not safe to assume however that the first calculation will always be a valid one; the user could clear the
buffer or exit the program at the first opportunity. Also, the user might accidentally divide by zero or enter an
unknown operator during the first calculation. Your program should be able to handle these cases.
