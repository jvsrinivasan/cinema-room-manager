//package cinema;
import java.util.*;

public class Cinema {
    
    // main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rowsInTheatre = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInEachRow = scanner.nextInt();
        char[][] seatTemplateArray = new char[rowsInTheatre + 1][seatsInEachRow + 1];
        generateSeatLayout(seatTemplateArray);
        displaySeatLayout(seatTemplateArray); 
        boolean breakFlag = false;
        while(breakFlag == false) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            switch(scanner.nextInt()) {
                case 1:
                    displaySeatLayout(seatTemplateArray);
                    break;
                case 2: 
                    
                    buyTicket(seatTemplateArray, rowsInTheatre, seatsInEachRow);
                    break;
                case 3:
                    getStatistics(seatTemplateArray);
                    break;
                case 0:
                    breakFlag = true;
                    break;
                default:
                    break;
            }
        }
    }

    /** This method generates the seat layout.
        This method takes a character array as a parameter */
    public static void generateSeatLayout(char[][] seatTemplateArray) {
        for (int i = 0; i < seatTemplateArray.length; i++) {
            for (int j = 0; j < seatTemplateArray[i].length; j++) {
                if (i == 0 && j == 0) 
                {
                    seatTemplateArray[i][j] = ' ';
                }
                else
                {
                    if (i == 0 && j > 0) 
                    {
                         seatTemplateArray[i][j] = Character.forDigit(j, 10);
                    }
                    else
                    {
                        if (j == 0 && i > 0) 
                        {
                            seatTemplateArray[i][j] = Character.forDigit(i, 10);
                        }
                        else
                        {
                            if (j > 0 && i > 0) 
                            {
                                seatTemplateArray[i][j] = 'S';
                            }   
                        }
                    }
                }              
            }
        }
    }
    
    /** This method Displays the seat layout to user.
        This method takes a character array as a parameter */
    public static void displaySeatLayout(char[][] seatTemplateArray) {
        System.out.println("\nCinema:");
        for (int i = 0; i < seatTemplateArray.length; i++) {
            for (int j = 0; j < seatTemplateArray[i].length; j++) {
                System.out.print(seatTemplateArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    /** This method Displays the Ticket price to the user for the selected Seat.
        This method also blocks the seat chosen on the Seat layout.
        This method takes a character array as a parameter */
    public static void buyTicket(char[][] seatTemplateArray, int rowsInTheatre, int seatsInEachRow) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int selectedRow = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int selectedSeat = scanner.nextInt();
        if (selectedRow > 0 && selectedRow <= rowsInTheatre && selectedSeat > 0 && selectedSeat <= seatsInEachRow) {
            if (seatTemplateArray[selectedRow][selectedSeat] != 'B') {
                System.out.println("\nTicket price: ");
                System.out.print("$" + calculateTicketPrice(rowsInTheatre, seatsInEachRow, selectedRow));
                System.out.println();
                seatTemplateArray[selectedRow][selectedSeat] = 'B';
                } else {
                    System.out.println("That ticket has already been purchased!");
                    System.out.println();
                    buyTicket(seatTemplateArray, rowsInTheatre, seatsInEachRow);
                    }
            } else {
                System.out.println("Wrong input!");
                buyTicket(seatTemplateArray, rowsInTheatre, seatsInEachRow);
                }
        System.out.println();
    }

    /** This method display the statistics.
        This method takes a character array as a parameter.
        This method displays the no. of purchased tickets, purchased tickets in %, current income and total income */
    public static void getStatistics(char[][] seatTemplateArray) {
        int noOfTicketsPurchased = 0;
        int currentIncome = 0;
        double ticketsPurchasedPercent = 0.00;
        int rowsInTheatre = seatTemplateArray.length - 1;
        int seatsInEachRow = seatTemplateArray[0].length - 1;
        int i = 0;
        int j = 0;
        for(i = 1; i <= seatTemplateArray.length - 1; i++) {
            for(j = 1; j <= seatTemplateArray[i].length - 1; j++) {
                if (seatTemplateArray[i][j] == 'B') {
                    noOfTicketsPurchased += 1;
                    currentIncome += calculateTicketPrice(rowsInTheatre, seatsInEachRow, i);
                }
            }            
        }
        ticketsPurchasedPercent = (100.00 / (rowsInTheatre * seatsInEachRow)) * noOfTicketsPurchased;
        System.out.printf("Number of purchased tickets: %d%n", noOfTicketsPurchased);
        System.out.printf("Percentage: %.2f%%%n", ticketsPurchasedPercent);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d", totalIncome(rowsInTheatre, seatsInEachRow));
        System.out.println();
    }
    
    /** This method calculates the Ticket price for the selected row and seat.
        This method takes 3 arguments as parameters and returns the ticket price */
    public static int calculateTicketPrice(int rowsInTheatre, int seatsInEachRow, int selectedRow) {
        int result = 0;
        if (rowsInTheatre * seatsInEachRow <= 60)
        {
            result = 10;
        }
        else
        {
            if (rowsInTheatre % 2 == 0)
            {
                if (selectedRow <= (rowsInTheatre % 2)) 
                {
                    result = 10;
                }
                else
                {
                    result = 8;
                }
            }
            else
            {
                if (selectedRow <= (rowsInTheatre / 2))
                {
                    result = 10;
                }
                else
                {
                    result = 8;
                }
            }
        }
        return result;
    }

    /** This method calculates the Total income of the Theatre.
        This method accepts 2 parameters and return one integer. */
    public static int totalIncome(int rows, int seats) {
        int result = 0;
        if (rows * seats <= 60)
        {
            result = rows * seats * 10;  
        }
        else
        {
            if (rows % 2 == 0)
            {
                result = ((rows / 2) * seats * 10) + ((rows / 2) * seats * 8);
            }
            else
            {
                result = ((rows / 2) * seats * 10) + ((rows - (rows / 2)) * seats * 8);
            }
        }
        return result;
    }
}
