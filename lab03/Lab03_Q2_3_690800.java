import java.util.Scanner;

public class Lab03_Q2_3_690800 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int result = 0;

		while (num / 10 > 0)
		{
			result *= 10;
			result += num % 10;
			num /= 10;
		}
		result *= 10;
		result += num % 10;
		System.out.println(result);
		scanner.close();
	}
}
