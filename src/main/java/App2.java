import java.util.Scanner;

public class App2 {

    public static void main(String[] args) {

        System.out.println("Enter box number to select. Enjoy!\n");


        start();
    }

    static Scanner scan = new Scanner(System.in);
    static byte input;
    static byte rand;
    static byte i;
    static boolean boxAvailable;
    static byte winner = 0;
    static char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};


    static boolean boxEmpty = false;

    public static void start() {

        while (true) {

            System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");

            if (!boxEmpty) {
                for (i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }



            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (box[input - 1] == 'X' || box[input - 1] == 'O')
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        box[input - 1] = 'X';
                        break;
                    }
                } else
                    System.out.println("Invalid input. Enter again.");
            }

            boxAvailable = false;
            for (i = 0; i < 9; i++) {
                if (box[i] != 'X' && box[i] != 'O') {
                    boxAvailable = true;
                    break;
                }
            }

            if (!boxAvailable) {

                resultOfGame();
                break;

            }

            while (true) {
                rand = (byte) (Math.random() * 9 + 1);
                if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                    box[rand - 1] = 'O';
                    break;
                }
            }
        }
    }

    public static void resultOfGame() {
        if ((box[0] == 'X' && box[1] == 'X' && box[2] == 'X') || (box[3] == 'X' && box[4] == 'X' && box[5] == 'X') || (box[6] == 'X' && box[7] == 'X' && box[8] == 'X') ||
                (box[0] == 'X' && box[3] == 'X' && box[6] == 'X') || (box[1] == 'X' && box[4] == 'X' && box[7] == 'X') || (box[2] == 'X' && box[5] == 'X' && box[8] == 'X') ||
                (box[0] == 'X' && box[4] == 'X' && box[8] == 'X') || (box[2] == 'X' && box[4] == 'X' && box[6] == 'X')) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else if ((box[0] == 'O' && box[1] == 'O' && box[2] == 'O') || (box[3] == 'O' && box[4] == 'O' && box[5] == 'O') || (box[6] == 'O' && box[7] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[3] == 'O' && box[6] == 'O') || (box[1] == 'O' && box[4] == 'O' && box[7] == 'O') || (box[2] == 'O' && box[5] == 'O' && box[8] == 'O') ||
                (box[0] == 'O' && box[4] == 'O' && box[8] == 'O') || (box[2] == 'O' && box[4] == 'O' && box[6] == 'O')) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
        } else {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");

        }

    }
}
