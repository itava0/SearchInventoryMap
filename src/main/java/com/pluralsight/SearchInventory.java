package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SearchInventory {
    public static void main(String[] args) throws IOException {

        HashMap<String, Product> inventory = getInventory();
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
            String newProuctName = product_name.replaceAll("[^a-zA-Z0-9]", "");
            inventory.put(newProuctName.toLowerCase(), new Product(product_id, product_name, product_price));
        }
        readFile.close();

        Scanner scanner = new Scanner(System.in);
        System.out.println("We carry the following inventory: ");
        for (Product p : inventory.values()) {
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }

        for (String key : inventory.keySet()) {
            System.out.println(key);
        }
        while(true) {
            System.out.print("What item are you interested in? ");
            String name = scanner.nextLine().trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
            Product matchedProduct = inventory.get(name);
            System.out.println(matchedProduct);
            if (matchedProduct == null) {
                System.out.println("We don't carry that product");
                return;
            }
            System.out.printf("We carry %s and the price is $%.2f\n",
                    matchedProduct.getName(), matchedProduct.getPrice());

            System.out.println("Do you want to search again");
            String searchAgain = scanner.nextLine().trim();

            if ("no".equalsIgnoreCase(searchAgain)) {
                break;
            }
        }

        scanner.close();
    }
    public static HashMap<String, Product> getInventory() {
        HashMap<String, Product> inventory = new HashMap<>();

        return inventory;
    }
}
