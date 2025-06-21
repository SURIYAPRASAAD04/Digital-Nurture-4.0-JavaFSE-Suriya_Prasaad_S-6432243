public class SearchBenchmark {
    public static void benchmarkSearch(Product[] products, String targetId, String targetName) {
      
        long startTime = System.nanoTime();
        Product linearResult = LinearSearch.searchById(products, targetId);
        long endTime = System.nanoTime();
        System.out.println("Linear Search (by ID): " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        linearResult = LinearSearch.searchByName(products, targetName);
        endTime = System.nanoTime();
        System.out.println("Linear Search (by Name): " + (endTime - startTime) + " ns");

      
        Product[] sortedProducts = products.clone();
        BinarySearch.sortProductsById(sortedProducts);

        startTime = System.nanoTime();
        Product binaryResult = BinarySearch.searchById(sortedProducts, targetId);
        endTime = System.nanoTime();
        System.out.println("Binary Search (by ID): " + (endTime - startTime) + " ns");
    }
}