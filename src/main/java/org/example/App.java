package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        System.out.println("Enter box number to select. Enjoy!\n");


        start();
    }

    static Scanner scan = new Scanner(System.in);
    static byte input;
    static byte rand;
    static byte i;
    static boolean boxAvailable;
    static char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    static boolean boxEmpty = false;

    public static void start() {

        while (true) {
//            Базове меню
            System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
            System.out.println("-----------");
            System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");

//           Очищує мень перед грою
            if (!boxEmpty) {
                for (i = 0; i < 9; i++)
                    box[i] = ' ';
                boxEmpty = true;
            }

            sc();

//            Перевірка доступністі клітинки
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

            randNum();

        }
    }

//    Сканує відповідь користувача та за потреби корегує її
    public static void sc() {
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
    }

//    Генерує в яку клітинку поставити 'O'
    public static void randNum() {
        while (true) {
            rand = (byte) (Math.random() * 9 + 1);
            if (box[rand - 1] != 'X' && box[rand - 1] != 'O') {
                box[rand - 1] = 'O';
                break;
            }
        }
    }

//    Звітує результат гри
    public static void resultOfGame() {
        if (isItWin('X')) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");

        } else if (isItWin('O')) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");

        } else {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");

        }

    }

//    Перевірка на виграш
    public static boolean isItWin(char a) {
        boolean win = false;

        for (int i = 0; i < 3; i++) {

            /*Перевірка горизонтальних та вертикальних ліній*/
            if ( (box[i * 3] == a && box[i * 3 + 1] == a && box[i * 3 + 2] == a) || /*Перевірка горизонтальних ліній*/
            (box[i] == a && box[i + 3] == a && box[i + 6] == a)){ /*Перевірка вертикальних ліній*/
                win = true;
                break;
            }
        }
        /*Перевірка діагоналей*/
        if ((box[0] == a && box[4] == a && box[8] == a) || (box[2] == a && box[4] == 'X' && box[6] == a)) {
            win = true;
        }

        return win;
    }
}