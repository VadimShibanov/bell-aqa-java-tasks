package Task4.SecondWay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BasketImpl implements Basket {

    private final HashMap<String, Integer> products;

    public BasketImpl() {
        this.products = new HashMap<>();
    }

    @Override
    public void addProduct(String product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Название продукта не должно быть null, количество продукта не должно быть отрицательным или 0");
        }

        if (products.containsKey(product)) {
            products.put(product, quantity + products.get(product));
        } else {
            products.put(product, quantity);
        }
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
        if (products.get(product) == null) {
            return 0;
        } else {
            return products.get(product);
        }
    }
}
