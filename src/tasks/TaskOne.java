package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskOne {

	private static TaskOne a;
	private static TaskOne b;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// taking the first input as string
		System.out.println("please enter the 1st number below");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String numstr1 = br.readLine();

		// taking the second input as string
		System.out.println("please enter the 2nnd number below");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String numstr2 = br2.readLine();
		try {
			a = new TaskOne(numstr1);
			b = new TaskOne(numstr2);
			System.out.println("The sum is " + a.add(b).toString());
		} catch (Exception e) {
			System.out.println(e);

		}

	}

	private int[] digit;

	// constructor adds string input in int array
	public TaskOne(String str) {

		if (isNumber(str)) {
			this.digit = new int[str.length()];
			for (int i = 0; i < str.length(); i++) {
				digit[i] = str.charAt(i) - '0';
			}
		} else {
			System.out.println(str + " is not a valid number");
		}
	}

	// checks if numeric
		public static boolean isNumber(String str) {
			try {
				double d = Double.parseDouble(str);
			} catch (NumberFormatException nfe) {
				return false;
			}
			return true;
		}
		
	// converts the result back to string
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < digit.length; i++) {
			sb.append((char) ('0' + digit[i]));
		}
		return sb.toString();
	}

	

	// traversing each number one by one and maintaining the carry
	public TaskOne add(TaskOne d) {

		StringBuilder sb = new StringBuilder();
		int length1 = this.digit.length - 1;
		int length2 = d.digit.length - 1;
		int resultdigit = 0;
		int carry = 0;
		while (length1 >= 0 && length2 >= 0) {
			resultdigit = this.digit[length1] + d.digit[length2] + carry;
			carry = resultdigit / 10;
			resultdigit = resultdigit % 10;
			length1--;
			length2--;
			sb.append((char) ('0' + resultdigit));
		}
		while (length1 >= 0) {
			resultdigit = this.digit[length1] + carry;
			carry = resultdigit / 10;
			resultdigit = resultdigit % 10;
			length1--;
			sb.append((char) ('0' + resultdigit));
		}
		while (length2 >= 0) {
			resultdigit = d.digit[length2] + carry;
			carry = resultdigit / 10;
			resultdigit = resultdigit % 10;
			length2--;
			sb.append((char) ('0' + resultdigit));
		}
		sb = sb.reverse();
		return new TaskOne(sb.toString());
	}

}
