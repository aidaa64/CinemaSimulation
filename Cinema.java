import java.util.Scanner;

public class Cinema {

	public static void main(String[] args) {

		String param = args[0];
		int ticketPrice= Integer.parseInt(param);
		System.out.println(ticketPrice);
		int ticketTotal = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number of rows in hall: ");
		int rowOFhall = input.nextInt();
		
		System.out.println("Enter number of seats in each row: ");
		int seatsOFrow = input.nextInt();
		
		
		String[][] hall = new String[rowOFhall][seatsOFrow];
		
		
		
		
		System.out.println("Hall seating arrangement");
		for(int i = 0; i < rowOFhall ; i++) {
			System.out.print((rowOFhall - i)+". ");
			for(int j = 0;j < seatsOFrow; j++ ) {
				hall[i][j] = "*";
				System.out.print(  hall[i][j] + " ");			
			}
			System.out.println();
		}
		
		
		boolean status = true;
		do {
			int ticket =0;
			System.out.println("Hello, which row would you like?(0 to exit)");
			int rowChoice = input.nextInt();
			
			if(rowChoice == 0){
				status = false;
				break;
			}
			
			
			System.out.println("How many places you want?");
			int placeChoice = input.nextInt();
			
			
			if(rowChoice <=rowOFhall ) {
				
			int line = (rowOFhall-rowChoice);
			int counter = 0;
			int index =-1;
			for(int i=0;i < seatsOFrow;i++ ) {
				if(hall[line][i].equals("*")) {
					counter +=1;
					if(placeChoice == counter) {
						index = i - placeChoice +1;
						break;
					}
				}
				else {
					counter=0;
				}
			}
			if(index == -1) {
				System.out.println("There are not enough places in the row you selected! Please choose new one");
			}
			else {
				for(int i=index; i<index+placeChoice;i++) {
					hall[(rowOFhall-rowChoice)][i] = "|";
					
					ticket = ticketPrice*placeChoice;
					
				}
			}
			
			
			if(ticket > 0) {
			System.out.println("Your ticket price is: "+ ticket);
			}
			display(rowOFhall,seatsOFrow, hall);
			
			ticketTotal += ticket;
			//System.out.println("Your ticket tot price is: "+ ticketTotal);
			
			
			if(ticketTotal == (ticketPrice*rowOFhall*seatsOFrow)) {
				input.close();
				status = false;
			}
		}	
			else {
				System.out.println("There is no raw according to your choice!");
				display(rowOFhall,seatsOFrow, hall);
			}
		}
		while(status == true);
		
	}
	
		private static void display(int rowOFhall, int seatsOFrow,String[][] hall) {    // Display 
			System.out.println("Hall seating arrangement");
			for(int i = 0; i < rowOFhall ; i++) {
				System.out.print((rowOFhall - i)+". ");
				for(int j = 0;j < seatsOFrow; j++ ) {
					System.out.print(  hall[i][j] + " ");
					if(hall[i][j].equals("|")) {
					}
				}
				System.out.println();
			}
			
		}
	
}