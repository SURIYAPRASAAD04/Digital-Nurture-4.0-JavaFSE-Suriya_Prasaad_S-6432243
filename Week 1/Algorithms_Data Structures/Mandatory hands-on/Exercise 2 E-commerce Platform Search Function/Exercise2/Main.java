public class Main {
    public static void main(String[] args) {
     
        Product[] products = {
            new Product("P100", "Laptop", "Electronics", 999.99),
            new Product("P203", "Smartphone", "Electronics", 699.99),
            new Product("P305", "Headphones", "Electronics", 199.99),
            new Product("P402", "Desk Chair", "Furniture", 249.99),
            new Product("P501", "Coffee Maker", "Appliances", 79.99),
            new Product("P615", "Blender", "Appliances", 49.99),
            new Product("P707", "Monitor", "Electronics", 299.99),
            new Product("P808", "Keyboard", "Electronics", 59.99),
            new Product("P909", "Mouse", "Electronics", 29.99),
            new Product("P110", "Notebook", "Stationery", 4.99)
        };

        
        String targetId = "P707";
        String targetName = "Blender";

        System.out.println("=== Search Results ===");
        Product result = LinearSearch.searchById(products, targetId);
        System.out.println("Linear Search by ID: " + (result != null ? result : "Not found"));

        result = LinearSearch.searchByName(products, targetName);
        System.out.println("Linear Search by Name: " + (result != null ? result : "Not found"));

       
        Product[] sortedProducts = products.clone();
        BinarySearch.sortProductsById(sortedProducts);
        result = BinarySearch.searchById(sortedProducts, targetId);
        System.out.println("Binary Search by ID: " + (result != null ? result : "Not found"));

        System.out.println("\n=== Performance Benchmark ===");
        SearchBenchmark.benchmarkSearch(products, targetId, targetName);

       
        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("Linear Search: O(n) time complexity");
        System.out.println("Binary Search: O(log n) time complexity (requires sorted array)");
        System.out.println("Sorting for Binary Search: O(n log n) time complexity (one-time cost)");
        
        System.out.println("\n=== Recommendation ===");
        System.out.println("For an e-commerce platform:");
        System.out.println("- Use Binary Search for product ID searches (fast for large catalogs)");
        System.out.println("- Use Linear Search for name/category searches (flexible, no sorting needed)");
        System.out.println("- Consider a hash table for even faster ID lookups (O(1) average case)");
    }
}