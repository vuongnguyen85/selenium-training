package Basket;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Items itemList = new Items()

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number of items in the form 'PriceBasKet item1 item2 item3 ...'");
        String action  = scanner.nextLine();
        System.out.println(action);

    }
}
