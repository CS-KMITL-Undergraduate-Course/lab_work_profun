import java.io.*;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

class ReadFile
{
	static void	demo1()
	{
		ArrayList<ArrayList<String>> token = new ArrayList<ArrayList<String>>();

		try (Scanner input = new Scanner(Paths.get("./movies.csv")))
		{
			String row;
			
			while (input.hasNext())
			{
				ArrayList<String> buf = new ArrayList<String>(3);
				row = input.nextLine();
				String[] dataFields = row.split(",");

				for (String col : dataFields)
				{
					buf.add(col);
				}
				token.add(buf);
			}
		}
		catch (IOException e)
		{
			System.out.println("Somethign wrong ... FileNotFouneException, perhaps?");
		}
		finally
		{
			System.out.println(token);
		}
	}

	static void	demo2()
	{
		ArrayList<ArrayList<String>> token = new ArrayList<ArrayList<String>>();

		try (Scanner input = new Scanner(Paths.get("./movies2.csv")))
		{	
			String row;
			
			while (input.hasNext())
			{
				ArrayList<String> buf = new ArrayList<String>(3);
				row = input.nextLine();
				String[] dataFields = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

				buf.add(dataFields[0]);
				if (dataFields[1].matches("\\d+"))
					buf.add(dataFields[1]);
				else
				{
					System.err.println("Row " + "(" + dataFields.length + ")" + Arrays.toString(dataFields) + " data format error.");
					continue;
				}
				buf.add(dataFields[2]);

				token.add(buf);
			}
		}
		catch (NumberFormatException | ArrayIndexOutOfBoundsException e)
		{
			System.err.printf("Data format eror: %s%n", e);
		}
		catch (IOException e)
		{
			System.err.printf("I/O Error: %s%n", e);
			e.printStackTrace();
		}
		finally
		{
			System.out.println(token);
		}
	}
}

class Movie
{
	String	title;
	int		releasedYear;
	double	rating;

	Movie(String title, int year, double rating)
	{
		this.title = title;
		this.releasedYear = year;
		this.rating = rating;
	}

	String	getTitle()
	{
		return this.title;
	}

	int	getReleasedYear()
	{
		return this.releasedYear;
	}

	double	getRating()
	{
		return this.rating;
	}

	@Override 
	public String	toString()
	{
		return (this.getTitle() + "(" + this.getReleasedYear() + ", " + this.getRating() + ")");
	}
}

public class ProFun13_050800
{
	public static void main(String[] args)
	{
		System.out.println("Demo1");
		ReadFile.demo1();
		System.out.println("Demo2");
		ReadFile.demo2();
	}
}
