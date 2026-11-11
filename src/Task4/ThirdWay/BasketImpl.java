package Task4.ThirdWay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class BasketImpl implements Basket {

    private final HashMap<String, Integer> products;

    public BasketImpl() {
        this.products = new HashMap<>();
    }

    @Override
    public void addProduct(String product, int quantity) {
        Objects.requireNonNull(product, "Название продукта не может быть null");

        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть > 0");
        }

        products.merge(product, quantity, (oldValue, newValue)-> Integer.sum(oldValue, newValue));
    }

    @Override
    public void removeProduct(String product) {
        products.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (product == null || quantity < 0) {
            throw new IllegalArgumentException("Название продукта не должно быть null, количество продукта не должно быть отрицательным");
        }

        if (products.containsKey(product)) {
            if (quantity == 0) {
                products.remove(product);
            } else {
                products.put(product, quantity);
            }
        } else {
            throw new IllegalArgumentException("Продукт не может быть обновлен, потому что его нет в корзине");
        }
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        return new ArrayList<>(products.keySet());
    }

    @Override
    public int getProductQuantity(String product) {
        if (products.containsKey(product)) {
            return products.get(product);
        } else {
            return 0;
        }
    }
}
