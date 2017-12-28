package ds.test;

import ds.stack.LinkedStack;
import ds.stack.Stack;

public class BabyCalculator {

	// Using java predefined or built-in data structures are not allowed.
	Stack<Character> stack = new LinkedStack<Character>();
	private int value=0;

	public int murmurAdd(String polynomial) {
		// TODO Implement this method
		// For ease:
		// * int digit = Character.getNumericValue(c);
		// * if (Character.isDigit(c)) {}
			char[] charPol=polynomial.toCharArray();
			int count=0;
			for(int i=0;i<polynomial.length();i++) {
				if(!(Character.isDigit(charPol[i])))
					count++;
			}	// This counts the total number of ( and )s.
			int numOf=count/2;
			if (numOf==0) {
				for(int i=0;i<polynomial.length();i++) {
					stack.push(charPol[i]);
				}
			}
			else {	//The inner of the parenthesis, the later it is stored.
				String[] temp = new String[numOf];
				int tempIndex = 0;
				for(int i=0;i<numOf;i++) {	//NOW I will get rid of the parenthesis
					int num1=0, num2 = 0;	//will become the index of last '(' and first ')'
					charPol=polynomial.toCharArray();
					for(int j=0;j<polynomial.length();j++) {
						if(charPol[j]=='(')
							num1 = j;
						if(charPol[j]==')') {
							num2 = j;
							break;
						}
					}
					temp[tempIndex] = polynomial.substring(num1, num2+1);
					tempIndex++;
					StringBuilder polytemp = new StringBuilder(polynomial);
					polynomial=polytemp.replace(num1, num2+1, "").toString();
				}
				if(polynomial.length()>0) {
					charPol = polynomial.toCharArray();
					for(int i=0;i<polynomial.length();i++) { //leftovers are stored starting from the front.
						stack.push(charPol[i]);	
					}
				}
				for(int i=numOf-1;i>=0;i--) {
					char[] tempChar = temp[i].toCharArray();
					for(int j=0;j<temp[i].length();j++) {
						if(Character.isDigit(tempChar[j])) {
							stack.push(tempChar[j]);
						}		
					}
				}
			}
			System.out.print(value);
			while(!(stack.isEmpty())) {
					Character a = stack.pop();
					value += Character.getNumericValue(a);
					System.out.print("+"+a);
			}
			System.out.println();
			return value;
		}
	
	public int getValue() {
		// TODO Implement this method
		return value;
	}

	public void setValue(int newValue) {
		// TODO Implement this method
		value = newValue;
	}
}
