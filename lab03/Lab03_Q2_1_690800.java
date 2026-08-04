import java.util.Scanner;

class Lab03_Q2_1_690800
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int	a = scanner.nextInt();
		int b = scanner.nextInt();

		if (a < 0 && b > 100)
			System.out.println("true");
		else if (b < 0 && a > 100)
			System.out.println("true");
		scanner.close();
	}
}