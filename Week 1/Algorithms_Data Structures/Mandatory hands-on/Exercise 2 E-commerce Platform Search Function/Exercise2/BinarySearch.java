import java.util.Comparator;

public class BinarySearch {
    public static Product searchById(Product[] products, String productId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void sortProductsById(Product[] products) {
        java.util.Arrays.sort(products, Comparator.comparing(Product::getProductId));
    }
}