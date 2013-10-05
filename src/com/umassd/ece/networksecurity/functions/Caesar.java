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

		if(isAlphaCharacter(c))
		{
			if(right)
			{
				for(int i = 0; i < loop; i++)
				{
					C++;
	
					if(C == (((int)'Z') + 1))
						C = ((int)'A');
					if(C == (((int)'z') + 1))
						C = ((int)'a');
				}
			}
			else
			{
				for(int i = loop; i > 0; i--)
				{
					C--;
	
					if(C == (((int)'A') - 1))
						C = ((int)'Z');
					if(C == (((int)'a') - 1))
						C = ((int)'z');
				}
			}
		}

		return ((char)C);
	}
	
	private static boolean isAlphaCharacter(char c)
	{
		if((c >= ((int)'A') && c <= ((int)'Z')) || (c >= ((int)'a') && c <= ((int)'z')))
			return true;

		return false;
	}
}
