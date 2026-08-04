import java.util.Scanner;

public class Lab04Q1_1_690800
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Temperature in farenheit: ");
		float temp_farenheit = sc.nextFloat();

		float temp_celcius = (temp_farenheit - 32) / 9 * 5;
		System.out.printf("Temperature in celcius: %.2f\n", temp_celcius);
		sc.close();
	}
}
