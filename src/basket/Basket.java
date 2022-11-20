package basket;

import purcase.Purchase;

import java.util.Map;

public class Basket implements BasketInt {
    private Purchase[] purchases;
    private Map<String, Integer> prices;

    public Basket(int productSize, Map<String, Integer> prices) {
        this.purchases = new Purchase[productSize];
        this.prices = prices;
    }

    @Override
    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].getTitle().equals(title)) {
                purchases[i].setCount(purchases[i].getCount() + count);
                return;
            }
        }
    }

    @Override
    public long sumAllProducts() {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (Purchase purchase : purchases) {
            if (purchase == null) {
                continue;
            }
            System.out.println("\t" + purchase.getTitle() + " " + purchase.getCount() + " шт. в сумме " + (purchase.getCount() * prices.get(purchase.getTitle())) + " руб.");
            long sumOfEachProduct = (long) purchase.getCount() * prices.get(purchase.getTitle());
            sum += sumOfEachProduct;
        }
        return sum;
    }
}
