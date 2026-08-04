import java.util.Scanner;

class Lab03_Q2_2_690800
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int digit = 0;

		while (num / 10 > 0)
		{
			++digit;
			num /= 10;
		}
		++digit;
		System.out.println(digit);
		scanner.close();
	}
}
