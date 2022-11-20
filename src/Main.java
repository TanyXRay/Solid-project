import basket.Basket;
import basket.BasketInt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> products = new HashMap<>();
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);

        printProducts(products);

        BasketInt purchase = new Basket(4,products);

        System.out.println("Введите два слова: название товара и количество. Или end");
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)){
                break;
            }
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);

            purchase.addPurchase(product, count);
        }
        long sum = purchase.sumAllProducts();
        System.out.println("ИТОГО: " + sum);
    }

    private static void printProducts(Map<String, Integer> products) {
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
    }
}

