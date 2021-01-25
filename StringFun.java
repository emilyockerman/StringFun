/*
* StringFun.java
* Author: Emily Ockerman
* Submission Date: October 4, 2018
*
* Purpose: To have some fun with strings! And learn about loops in the process!
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
CSCI 1301: Project 1 Page 3
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/

import java.util.Scanner;

public class StringFun {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//prompt user for string input
		System.out.println("Enter the string to be manipulated");
		String toBeManipulated = input.nextLine();
		String command = "";
		boolean wantToQuit = false;
		
		while (!wantToQuit)
		{
		//asking user what they want done to their string input
		System.out.println("Enter your command (reverse, replace first, replace last, remove all, remove)");
		command = input.nextLine();
		

			//REVERSES ORDER OF ORIGINAL STRING
			String reversedString = " ";
			
			if (command.equalsIgnoreCase("reverse"))
			{
				//stores the length of string input as an integer so program can know how long it is
				int length = toBeManipulated.length();
				//loop to find end of string (acts as a counter!)
				for (int r = length - 1; r >= 0; r--)
				{
					//loops program so it calls the variables backwards and adds them to each other
					reversedString = reversedString + toBeManipulated.charAt(r);
				}
			System.out.println("Your new string is:" + reversedString);
			toBeManipulated = reversedString;
			}
			
			
			//REPLACES FIRST INSTANCE OF CHAR
			else if (command.equalsIgnoreCase("replace first"))
			{
				//prompt user to enter the character to replace and the new character w which they want to replace it
				System.out.println("Enter the character to replace");
				String charToReplace = input.nextLine();
				System.out.println("Enter the new character");
				String newChar = input.nextLine();
				//d&i new empty string in which replace first string will be stored
				String replaceFirstString = " ";
				int length = toBeManipulated.length();
				boolean seenOne = false;
				//counter to step through string until it hits a char that matches 
				for (int rf = 0; rf < length; rf++)
				{
					if ((toBeManipulated.charAt(rf)) == (charToReplace.charAt(0)) && !seenOne && (Character.isLetter(charToReplace.charAt(0)))) //if the char at the index scanned matches the old char
					{
						replaceFirstString = replaceFirstString + newChar.charAt(0);
						//then it replaces that char w the new one, stops the loop, and prints the word
						seenOne = true;
					}
					else
					{
						replaceFirstString = replaceFirstString + toBeManipulated.charAt(rf);
					}
				}
				if (!seenOne)
				{
					System.out.println("character was not found.");
				}
				else
				{
					System.out.println("Your new string is: " + replaceFirstString);
					toBeManipulated = replaceFirstString;
				}
			}
			
		
			//REPLACES LAST INSTANCE OF THE CHAR
			else if (command.equalsIgnoreCase("replace last"))
			{
				System.out.println("Enter the character to replace");
				String charToReplace = input.nextLine();
				System.out.println("Enter the new character");
				String newChar = input.nextLine();
				//d&i new empty string in which replace first string will be stored
				String replaceLastString = " ";
				int length = toBeManipulated.length();
				boolean seenOne = false;
				String firstHalf = " ", secondHalf = " ";
				//counter to step through string until it hits a char that matches 
				for (int rl = length - 1; rl >= 0; rl--)
				{
					if ((toBeManipulated.charAt(rl)) == (charToReplace.charAt(0)) && !seenOne && (Character.isLetter(charToReplace.charAt(0))))
					{
						firstHalf = toBeManipulated.substring(0, rl);
						secondHalf = toBeManipulated.substring(rl + 1, length);
						seenOne = true;
					}
					replaceLastString = firstHalf + newChar + secondHalf;
				
				}
				if (!seenOne)
				{
					System.out.println("character was not found.");
				}
				else
				{
					System.out.println("Your new string is: " + replaceLastString);
					toBeManipulated = replaceLastString;
				}
			}
			
					
			//REMOVES ONE SPECIFIC INSTANCE OF A CHAR
			else if (command.equalsIgnoreCase("remove"))
			{
				System.out.println("Enter the character to remove");
				String charToRemove = input.nextLine();
				System.out.println("Enter the " + charToRemove + " you want to remove");
				int nthChar = input.nextInt();
				input.nextLine();
				int letterCount = 0;
				//d&i new empty string in which replace first string will be stored
				String removeString = "";
				int length = toBeManipulated.length();
				boolean seenOne = false;
				String firstHalf = "", secondHalf = "";
				//counter to step through string until it hits a char that matches
				for (int re = 0; re < length; re++)
				{
					if (toBeManipulated.charAt(re) == (charToRemove.charAt(0)) && !seenOne)
					{
						letterCount++;
						if (nthChar == letterCount)
						{
							firstHalf = toBeManipulated.substring(0, re);
							secondHalf = toBeManipulated.substring(re + 1, length);
							seenOne = true;
						}
					}
					else
					{
						removeString = removeString + toBeManipulated.charAt(re);
					}
					removeString = firstHalf + secondHalf;
				}
				if (!seenOne || nthChar != letterCount)
				{
					System.out.println("character was not found.");
				}
				else
				{
				System.out.println("Your new string is: " + removeString);
				toBeManipulated = removeString;
				}
			}
			
			
			//REMOVES ALL OF THE CHARS
			else if (command.equalsIgnoreCase("remove all"))
			{
				System.out.println("Enter the character to remove");
				String removeAll = input.nextLine();
				int length = toBeManipulated.length();
				String removeAllString = " ";
				String nuthin = "";
				boolean seenOne = false;
				//counter to step through string until it hits a char that matches
				for (int ra = 0; ra < length; ra++)
				{
					if ((toBeManipulated.charAt(ra)) == (removeAll.charAt(0)))
					{
						removeAllString = removeAllString + nuthin;
						seenOne = true;
					}
					else
					{
						removeAllString = removeAllString + toBeManipulated.charAt(ra);
					}
				}
				if (!seenOne)
				{
					System.out.println("character was not found.");
				}
				else
				{
				System.out.println("Your new string is: " + removeAllString);
				toBeManipulated = removeAllString;
				}
			}
		
			
			//ENDS PROGRAM
			else if (command.equalsIgnoreCase("quit"))
			{
				wantToQuit = true;
				System.out.println("That was fun. Bye for now!");
				System.exit(0);
			}
			
			//INVALID COMMAND
			else
			{
				System.out.println("Enter a correct command.");
			}
		}	
	}
}
