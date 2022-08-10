package com.qa.testdrivendevelopment;

import java.util.ArrayList;

public class Questions {

	/**
	 * EXAMPLE: THIS ONE HAS BEEN DONE FOR YOU <br>
	 * 
	 * Given a name, return "Hi" plus the name <br>
	 * <br>
	 * For Example:<br>
	 * greetingExample("John") → "Hi John" <br>
	 * greetingExample("Matt") → "Hi Matt" <br>
	 * greetingExample("Angelica") → "Hi Angelica"
	 * 
	 */
	public String greetingExample(String name) {
		return "Hi " + name;
	}

	/**
	 * Given a string, return a string where for every char in the original string,
	 * there are three chars.<br>
	 * <br>
	 * 
	 * For Example:<br>
	 * multChar("The") → "TTThhheee"<br>
	 * multChar("AAbb") → "AAAAAAbbbbbb"<br>
	 * multChar("Hi-There") → "HHHiii---TTThhheeerrreee"
	 */
	public String multiChar(String input) {
		StringBuilder sb = new StringBuilder();
		for (char c : input.toCharArray()) {
			sb.append(c);
			sb.append(c);
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * Return the string (backwards) that is between the first and last appearance
	 * of "bread" in the given string, or return the empty string "" if there is not
	 * 2 occurances of "bread". Ignore Case<br>
	 * <br>
	 * For Example: sandwichFilling("breadclivebread") → "evilc"<br>
	 * sandwichFilling("xxbreadfridgebreadyy") → "egdirf"<br>
	 * sandwichFilling("xxBreadfridgeBReAdyy") → "egdirf"<br>
	 * sandwichFilling("xxbreadyy") → "" sandwichFilling("xxbreADyy") → ""<br>
	 * <br>
	 * HINT: "a" == "a" if false HINT: "a".equals("a") is true
	 */

	public String sandwichFilling(String sandwich) {
		String result = "";
		String target = "bread";
		int firstIndex = 0;
		int secondIndex = 0;
		StringBuilder sb = new StringBuilder(sandwich.toLowerCase());

		// Determine if the target word appears twice, capturing any indices:
		if (sb.toString().contains(target)) {
			firstIndex = sb.indexOf(target);

			if (firstIndex != sb.lastIndexOf(target)) {
				secondIndex = sb.indexOf(target, firstIndex + 1);

				// Build the required string and reverse it:
				StringBuilder forwards = new StringBuilder(sb.substring(firstIndex + target.length(), secondIndex));
				result = forwards.reverse().toString();
			}
		}
		return result;
	}

	/**
	 * Given three ints, a b c, one of them is small, one is medium and one is
	 * large. Return true if the three values are evenly spaced, so the difference
	 * between small and medium is the same as the difference between medium and
	 * large. Do not assume the ints will come to you in a reasonable order.<br>
	 * <br>
	 * For Example:<br>
	 * evenlySpaced(2, 4, 6) → true<br>
	 * evenlySpaced(4, 6, 2) → true<br>
	 * evenlySpaced(4, 6, 3) → false<br>
	 * evenlySpaced(4, 60, 9) → false
	 */
	public boolean evenlySpaced(int a, int b, int c) {
		boolean result = false;
		int low, mid, high;
		ArrayList<Integer> numbers = new ArrayList<>();

		// Determine which values are low, mid, and high:
		low = Math.min(Math.min(a, b), c);
		high = Math.max(Math.max(a, b), c);

		numbers.add(a);
		numbers.add(b);
		numbers.add(c);

		numbers.remove(Integer.valueOf(low));
		numbers.remove(Integer.valueOf(high));

		mid = numbers.get(0);

		// Determine if evenly spaced:
		if (high - mid == mid - low) {
			result = true;
		}

		return result;
	}

	/**
	 * Given a string and an int n, return a string that removes n letters from
	 * the'middle' of the string. The string length will be at least n. The input
	 * string will have an odd number of letters. n will always be an odd
	 * number.<br>
	 * <br>
	 * For Example:<br>
	 * nMid("Hello", 3) → "Ho"<br>
	 * nMid("Chocolate", 3) → "Choate"<br>
	 * nMid("Chocolate", 1) → "Choclate"<br>
	 */
	public String nMid(String input, int n) {
		StringBuilder sb = new StringBuilder(input);
		int firstIndex = (sb.length() / 2) - (n / 2);
		int secondIndex = (sb.length() / 2) + (n / 2) + 1;
    	return sb.delete(firstIndex, secondIndex).toString();
	}

	/**
	 * Given a string, return the boolean True if it ends in "java" and False if
	 * does not end in "java". Ignore Case.<br>
	 * <br>
	 * For Example: <br>
	 * endsJava("ilovejava") → true <br>
	 * endsJava("iloveJaVa") → true <br>
	 * endsJava("welovejava") → true <br>
	 * endsJava("welovejavamoreeveryday") → false <br>
	 * endsJava("javaiscool") → false <br>
	 * endsJava("pythoniscool") → false <br>
	 */
	public boolean endsJava(String input) {
		return input.toLowerCase().endsWith("java");
	}

	/**
	 * Given a string, return the length of the largest "block" in the string. A
	 * block is a run of adjacent chars that are the same, do not ignore case.<br>
	 * <br>
	 * For Example: superBlock("hooopplla") → 3 <br>
	 * superBlock("abbCCCddDDDDeeEEE") → 4 <br>
	 * superBlock("abbCCCCC")) → 5 <br>
	 * superBlock("") → 0 <br>
	 * <br>
	 * HINT: "a" == "a" if false HINT: "a".equals("a") is true
	 */
	public int superBlock(String input) {
		int result = 0;
		int cursor = 0;
		int counter = 0;

		if (!input.equals("")) {

			// Iterate through the whole input:
			while (cursor < input.length()) {
				char currentChar = input.charAt(cursor);
				counter++;

				// Calculate the size of the current block:
				while ((cursor < input.length() - 1) && (currentChar == input.charAt(cursor + 1))) {
					counter++;
					cursor++;
				}

				// If this is the largest block so far, overwrite result:
				if (counter > result) {
					result = counter;
				}

				// Reset counter and advance cursor:
				counter = 0;
				cursor++;
			}
		}
    	return result;
	}

	/**
	 * Given a string - return the number of times "am" appears in the String
	 * ignoring case - BUT ONLY WHEN the word "am" appears without being followed or
	 * preceded by other letters <br>
	 * <br>
	 * For Example: <br>
	 * amISearch("Am I in Amsterdam") → 1 <br>
	 * amISearch("I am in Amsterdam am I?") → 2 <br>
	 * amISearch("I have been in Amsterdam") → 0 <br>
	 * <br>
	 * HINT: String.toLowerCase
	 */
	public int amISearch(String sentence) {
		int result = 0;
		int index;
		String target = " am ";
		StringBuilder sb = new StringBuilder(" " + sentence.toLowerCase() + " ");

		// Determine if the target word appears:
		if (sb.toString().contains(target)) {
			index = sb.indexOf(target);
			result++;

			// Loop to find any and all further occurrences of target:
			while (index != sb.lastIndexOf(target)) {
				index = sb.indexOf(target, index + 1);
				result++;
			}
		}
    	return result;
	}

	/**
	 * Given a number if this number is divisible by 3 return "fizz" if this number
	 * is divisible by 5 return "buzz" if this number is divisible by both 3 and 5
	 * return "fizzbuzz" if this number is not divisible by 3 or 5 return null<br>
	 * <br>
	 * For Example: <br>
	 * fizzBuzz(3) → "fizz" <br>
	 * fizzBuzz(10) → "buzz" <br>
	 * fizzBuzz(15) → "fizzbuzz" <br>
	 * fizzBuzz(8) → null
	 */
	public String fizzBuzz(int number) {
		String result;
		if (number % 15 == 0) {
			result = "fizzbuzz";
		}
		else if (number % 3 == 0) {
			result = "fizz";
		}
		else if (number % 5 == 0) {
			result = "buzz";
		}
		else {
			result = null;
		}
		return result;
	}

	/**
	 * Given a string, split the string into the individual numbers present then add
	 * each digit of each number to get a final value for each number <br>
	 * <br>
	 * String example = "55 72 86"<br>
	 * <br>
	 * "55" will = the integer 10 <br>
	 * "72" will = the integer 9 <br>
	 * "86" will = the integer 14 <br>
	 * <br>
	 * You then need to return the highest value <br>
	 * <br>
	 * For Example: <br>
	 * largest("55 72 86") → 14 <br>
	 * largest("15 72 80 164") → 11 <br>
	 * largest("555 72 86 45 10") → 15 <br>
	 * <br>
	 * HINT: Integer.parseInt
	 */
	public int largest(String input) {
		int result = 0;
		int count = 0;
		int currentNumber;

		// Capture individual numbers:
		String[] numbers = input.split(" ");

		// For each number, determine the result:
		for (String number : numbers) {
			for (char digit : number.toCharArray())
				count += Integer.parseInt(String.valueOf(digit));

			// If this is the largest result so far, overwrite result:
			if (count > result) {
				result = count;
			}
			count = 0;
		}
    	return result;
	}

	/**
	 * Given a string, int and a char, return a boolean value if the 'nth'
	 * (represented by the int provided) char of the String supplied is the same as
	 * the char supplied. The int provided will NOT always be less than than the
	 * length of the String. Ignore case and Whitespace. <br>
	 * <br>
	 * For Example: <br>
	 * compares("The",2,'h') → true <br>
	 * compares("AAbb",1,'b') → false <br>
	 * compares("Hi-There",10,'e') → false <br>
	 * <br>
	 * HINT: String.charAt
	 */
	public boolean compares(String word, int index, char letter) {
		boolean result = false;

		// Ignore whitespace and case:
		String formatted = word.replaceAll("\\s","").toLowerCase();

		// If index is valid, compare:
		if (index < formatted.length()) {
			result = letter == formatted.charAt(index);
		}

    	return result;
	}
}
