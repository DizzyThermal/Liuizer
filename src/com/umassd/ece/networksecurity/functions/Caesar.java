package com.umassd.ece.networksecurity.functions;

public class Caesar
{
	public static String shift(String inputString, int[] steps, boolean right)
	{
		String shiftedString = "";
		for(int i = 0; i < inputString.length(); i++)
			shiftedString += addAndCheckWrap(inputString.charAt(i), (i+1), steps, right);
		
		return shiftedString;
	}
	
	private static char addAndCheckWrap(char c, int currentChar, int[] steps, boolean right)
	{
		int C = ((int)c);

		int loop;
		int mod = (currentChar % steps.length);
		if(mod == 0)
			loop = steps[steps.length-1];
		else
			loop = steps[(mod-1)];

		if(isAlphaNumericCharacter(c))
		{
			if(right)
			{
				for(int i = 0; i < loop; i++)
				{
					C++;
	
					if(C == (((int)'Z') + 1))
						C = ((int)'A');
					else if(C == (((int)'z') + 1))
						C = ((int)'a');
					else if(C == (((int)'9') + 1))
						C = ((int)'0');
				}
			}
			else
			{
				for(int i = loop; i > 0; i--)
				{
					C--;
	
					if(C == (((int)'A') - 1))
						C = ((int)'Z');
					else if(C == (((int)'a') - 1))
						C = ((int)'z');
					else if(C == (((int)'0') - 1))
						C = ((int)'9');
				}
			}
		}

		return ((char)C);
	}
	
	private static boolean isAlphaNumericCharacter(char c)
	{
		if((c >= ((int)'A') && c <= ((int)'Z')) || (c >= ((int)'a') && c <= ((int)'z')) || (c >= ((int)'0') && c <= ((int)'9')))
			return true;

		return false;
	}
}
