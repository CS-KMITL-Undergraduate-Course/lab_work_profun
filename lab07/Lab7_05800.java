public class Lab7_05800
{
	static String substr(String str, int start, int end)
	{
		String	result = "";

		for (int i = start; i < end; i++)
			result += str.charAt(i);
		return (result);
	}

	static int	q2_1_myIndexOf(String str, String sub)
	{
		for (int i = 0; i < str.length() - sub.length(); i++)
		{	
			for (int j = 0; j < sub.length(); j++)
			{
				if (str.charAt(i + j) != sub.charAt(j))
					break;
				if (j + 1 == sub.length())
					return (i);
			}
		}
		return (-1);
	}

	static boolean q2_2_containsAndBefore(String input, String sub1, String sub2)
	{
		int start = q2_1_myIndexOf(input, sub1);

		if (start != -1)
		{
			if (q2_1_myIndexOf(substr(input, start, input.length()), sub2) != -1)
				return (true);
		}
		return (false);
	}

	static String q2_3_replaceWith(String str, String pattern, String newPattern)
	{
		int start_index = q2_1_myIndexOf(str, pattern);

		if (start_index == -1)
			return (str);
		String	new_string = substr(str, 0, start_index) + newPattern;
		return (new_string + q2_3_replaceWith(substr(str, start_index + 1, str.length()), pattern, newPattern));
	}

	static boolean rotateAndSearch(String str, String pattern, int loop)
	{
		int index_found = q2_1_myIndexOf(str, pattern);

		if (loop == 0 && index_found == -1)
			return (false);
		if (index_found != -1)
			return (true);
		return (rotateAndSearch(substr(str, 1, str.length()) + str.charAt(0), pattern, --loop));
	}

	static boolean q2_4_isClockwiseRotate(String str, String pattern)
	{
		return (rotateAndSearch(str, pattern, str.length()));
	}

	public static void main(String[] args)
	{
		String str = "Hello";
		String sub = "ello";

		String str2 = "PMRQNO";
		String sub1 = "PM";
		String sub2 = "QNO";

		String str3 = "At KMITL CHALONGKRUNG BMI MTL";
		String pattern = "MI";
		String newPattern = "CSP";

		String str4 = "KMITL";
		String pattern1 = "LTI";

		System.out.println("Index: " + (q2_1_myIndexOf(str, sub)));

		System.out.println("ResultQ2: " + q2_2_containsAndBefore(str2, sub1, sub2));

		System.out.println("Before sub: " + str3);
		System.out.println("After sub: " + q2_3_replaceWith(str3, pattern, newPattern));

		System.out.println("Find pattern: " + q2_4_isClockwiseRotate(str4, pattern1));
	}
}
