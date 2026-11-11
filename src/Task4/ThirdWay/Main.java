package Task4.ThirdWay;

public class Main {
    public static void main(String[] args) {
        Basket basket = new BasketImpl();

        String oranges = "Orange";
        basket.addProduct(oranges, 100);
        basket.addProduct(oranges, 200);

        System.out.println(basket.getProducts());
        System.out.println(basket.getProductQuantity(oranges));

        basket.updateProductQuantity(oranges, 0);
        System.out.println(basket.getProductQuantity(oranges));
        System.out.println(basket.getProducts());
    }
}
