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

	static void	demo3()
	{
		ArrayList<ArrayList<String>> token = new ArrayList<ArrayList<String>>();

		try (Scanner input = new Scanner(Paths.get("./movies2.csv")))
		{	
			String row;
			
			while (input.hasNext())
			{
				row = input.nextLine();
				String[] dataFields = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				String title = dataFields[0];
				int	releaseYear;	
				if (dataFields[1].matches("\\d+"))
					releaseYear = Integer.parseInt(dataFields[1]);
				else
				{
					continue;
				}
				Double	rating = Double.parseDouble(dataFields[2]);	
				Movie movie = new Movie(title, releaseYear, rating);
				System.out.println(movie);
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

	static void demo4()
	{
		int rowNum = 1;
		ArrayList<Movie> movies = new ArrayList<Movie>();

		try (Scanner input = new Scanner(Paths.get("./movies.csv")))
		{
			while (input.hasNext())
			{
				String row = input.nextLine();
				String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

				try
				{
					Movie movie = new Movie(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
					movies.add(movie);
				}
				catch (NumberFormatException nfe)
				{
					System.out.println("At row " + rowNum + ", exception name is " + nfe + "... skip");
				}
				finally
				{
					rowNum++;
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			for (Movie movie : movies)
				System.out.println(movie);
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

class MovieCounter
{
	ArrayList<Movie> availableList = new ArrayList<Movie>();
	ArrayList<Movie> checkOutList = new ArrayList<Movie>();

	MovieCounter()
	{
		int rowNum = 1;

		try (Scanner input = new Scanner(Paths.get("./movies2.csv")))
		{
			while (input.hasNext())
			{
				String row = input.nextLine();
				String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

				try
				{
					Movie movie = new Movie(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
					availableList.add(movie);
				}
				catch (NumberFormatException nfe)
				{
					System.out.println("At row " + rowNum + ", exception name is " + nfe + "... skip");
				}
				finally
				{
					rowNum++;
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			for (Movie movie : availableList)
				System.out.println(movie);
		}
	}

	void	showAvailableList()
	{
		for (Movie movie : availableList)
			System.out.println(movie);
	}

	void	showCheckoutList()
	{
		for (Movie movie : checkOutList)
			System.out.println(movie);
	}

	void	checkout(int index)
	{
		checkOutList.add(availableList.remove(index));
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
		System.out.println("Demo3");
		ReadFile.demo3();
		System.out.println("Demo4");
		ReadFile.demo4();

		MovieCounter location1 = new MovieCounter();
		MovieCounter location2 = new MovieCounter();

		System.out.println("Location 1");
		location1.showAvailableList();

		location1.checkout(1);
		System.out.println("Location 1");
		location1.showCheckoutList();
	}
}
