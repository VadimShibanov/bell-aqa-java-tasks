package Task4.FirstWay;

public class Main {
    public static void main(String[] args) {
        Basket basket = new BasketImpl();

        String apples = "Apple";
        basket.addProduct(apples, 100);
        System.out.println(basket.getProductQuantity(apples));

        basket.addProduct(apples, 50);
        System.out.println(basket.getProductQuantity(apples));

        basket.updateProductQuantity(apples, 0);
        System.out.println(basket.getProductQuantity(apples));
        System.out.println(basket.getProductQuantity(apples));
    }
}
