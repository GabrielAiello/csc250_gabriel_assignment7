package hwassignment7csc250;
import java.util.Scanner;

public class Driver 
{

		public static void main(String[] args)
		{
			//type name = value;
			int[] jersey_numbers = new int[5];
			int[] player_ratings = new int[5];
			Scanner input = new Scanner (System.in);
			jersey_numbers = Driver.printJersey(jersey_numbers,player_ratings);
			player_ratings = Driver.printRating(jersey_numbers,player_ratings);
			
			char option;
			do
			{
				option = Driver.showMenu();
				
				//respond the option here
				if(option == 'u')
				{
					Driver.update(jersey_numbers, player_ratings);
				}
				else if(option == 'a')
				{
					Driver.outputAbove(jersey_numbers, player_ratings);
				}
				else if(option == 'r')
				{
					int g = Driver.replaceA(jersey_numbers, 0);
					jersey_numbers = Driver.replaceB(jersey_numbers, player_ratings, g);
					player_ratings = Driver.replaceC(jersey_numbers, player_ratings, g);
				}
				else if(option == 'o')
				{
					Driver.output(jersey_numbers, player_ratings);
				}
			}
			while(option != 'q');
			
			System.out.println("Get lost!");
		} //end of main method
		
		static int replaceA (int[] a, int b)
		{
			Scanner input = new Scanner (System.in);
			System.out.print("What player would you like to replace? ");
			int jersey_number = input.nextInt();
			for(int i = 0; i < a.length; i++)
			{
				if(jersey_number == a[i])
				{
					b = i;
					break;
				}
			}
			return b;
		}
		
		static int[] replaceB (int[] a, int[] b, int i)
		{
			Scanner input = new Scanner (System.in);
			//I found the player they want to replace
			System.out.print("Enter new player's jersey number:");
			a[i] = input.nextInt();
			return a;
		}	
		
		static int[] replaceC (int[] a, int[] b, int i)
		{
			Scanner input = new Scanner (System.in);
			//I found the player they want to replace
			System.out.print("Enter new player's rating:");
			b[i] = input.nextInt();
			return b;
		}
		
		static void outputAbove (int[] a, int[] b)
		{
			Scanner input = new Scanner (System.in);
			System.out.print("What is the minimum rating? ");
			int min_rating = input.nextInt();
			for(int i = 0; i < a.length; i++)
			{
				if(b[i] >= min_rating)
				{
					System.out.println("Jersey Number: " + a[i] + " (" + b[i] + " rating)");
				}
			}
		}
		static int[] update (int[] a, int[] b)
				{
					Scanner input = new Scanner (System.in);
					System.out.print("What player would you like to update? ");
					int jersey_number = input.nextInt();
					for(int i = 0; i < a.length; i++)
					{
						if(jersey_number == a[i])
						{
							//I found the player they want to update
							System.out.print("What is the new rating? ");
							b[i] = input.nextInt();
							break;
						}
					}
		
						return b;
				}
		
		static void output(int[] a, int[] b)
		{
			for(int i = 0; i < a.length; i++)
			{
				System.out.println("Jersey Number: " + a[i] + " (" + b[i] + " rating)");
			}
		}
		
		static int[] printJersey(int[] a, int[] b) //determines value of player_jersey
		{
			Scanner input = new Scanner (System.in);
			for(int i = 0; i < a.length; i++)
			{
				System.out.print("Enter player " + (i + 1) + "'s jersey number:");
				a[i] = input.nextInt(); // a is jersey, b is rating
			}
			return (a);
		}
		
		static int[] printRating(int[] a, int[] b) //determines value of player_ratings
		{
			Scanner input = new Scanner (System.in);
			for(int i = 0; i < a.length; i++)
			{
				System.out.print("Enter player " + (i + 1) + "'s rating:");
				b[i] = input.nextInt(); // a is jersey, b is rating
			}
			return (b);
		}
		
		static char showMenu()
		{
			Scanner elephant = new Scanner(System.in);
			System.out.println("MENU");
			System.out.println("u - Update player rating");
			System.out.println("a - Output players above a rating");
			System.out.println("r - Replace player");
			System.out.println("o - Output roster");
			System.out.println("q - Quit");
			System.out.print("Choose an option: ");
			return elephant.next().charAt(0);
		}
	}
