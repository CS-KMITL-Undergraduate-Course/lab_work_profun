package LAB05;
/**
 * Lab5Q4_2_05800
 */
public class Lab5Q4_2_05800 {
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Require at least 1 argument.");
			return ;
		}

		int index = -1;

		for (int i = 0; i < args[0].length(); i++)
		{
			char buf = (char) (args[0].charAt(i) | ' ');

			if (buf == 'a' || buf == 'e' || buf == 'i' || buf == 'o' || buf == 'u')
			{
				index = i;
				break;
			}
		}
		if (index != -1)
			System.out.println("Found vowel at index: " + index);
		else
			System.out.println("Vowel not found");
	}
}