package Task4.FirstWay;

import java.util.*;

public class BasketImpl implements Basket {

    private final Map<String, Integer> products;

    public BasketImpl() {
        this.products = new HashMap<>();
    }

    @Override
    public void addProduct(String product, int quantity) {
        Objects.requireNonNull(product, "Название продукта не может быть null");

        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть > 0");
        }

        products.merge(product, quantity, Integer::sum);
    }


    @Override
    public void removeProduct(String product) {
        products.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        Objects.requireNonNull(product, "Название продукта не может быть null");

        if (!products.containsKey(product)) {
            throw new IllegalArgumentException("Товара нет: " + product);
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("Обновленное количество продукта не должно быть < 0");
        }

        if (quantity == 0) {
            products.remove(product);
        } else {
            products.put(product, quantity);
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
        Objects.requireNonNull(product, "Название продукта не может быть null");

        return products.getOrDefault(product, 0);
    }
}

