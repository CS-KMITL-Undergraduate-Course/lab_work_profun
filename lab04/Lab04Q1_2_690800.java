import java.util.Scanner;

public class Lab04Q1_2_690800
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int buf = 0;
		int sum = 0;
		
		while (x-- > 0)
		{
			buf = sc.nextInt();
			
			if (buf % 2 == 0)
				sum += buf;
		}
		System.out.println("Sum of even number: " + sum);
		sc.close();
	}
}
