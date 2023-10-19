package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SearchInventory {
    public static void main(String[] args) throws IOException {

        HashMap<Integer, Product> inventory = getInventory();
        BufferedReader readFile = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
        String input;
        int product_id;
        String product_name;
        float product_price;

        while((input = readFile.readLine()) != null){
            String[] temp = input.split("\\|");
            product_name = temp[1];
            product_price = Float.parseFloat(temp[2]);
            product_id = Integer.parseInt(temp[0]);
            inventory.put(product_id, new Product(product_id, product_name, product_price));
        }
        readFile.close();

        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (Product p : inventory.values()) {
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }
    public static HashMap<Integer, Product> getInventory() {
        HashMap<Integer, Product> inventory = new HashMap<>();

        return inventory;
    }
}
