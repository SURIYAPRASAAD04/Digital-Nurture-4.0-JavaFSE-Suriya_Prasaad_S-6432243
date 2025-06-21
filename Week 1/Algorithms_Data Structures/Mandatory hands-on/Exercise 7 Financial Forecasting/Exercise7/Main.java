public class Main {
    public static void main(String[] args) {
        
        double[] revenueHistory = {10.2, 11.5, 12.1, 13.4, 14.8, 16.2, 17.5, 19.1};
        
     
        RecursiveForecaster recursive = new RecursiveForecaster(revenueHistory);
        OptimizedForecaster optimized = new OptimizedForecaster(revenueHistory);
        
 
        System.out.printf("Calculated average growth rate: %.2f%%\n", 
                         recursive.calculateAverageGrowthRate() * 100);
        
   
        int[] forecastPeriods = {1, 5, 10, 20, 30};
        
        for (int periods : forecastPeriods) {
            System.out.println("\n=== Forecasting " + periods + " periods ahead ===");
            
            double recursiveForecast = recursive.forecast(periods);
            System.out.printf("Recursive forecast: $%.2f million\n", recursiveForecast);
            
            double optimizedForecast = optimized.forecast(periods);
            System.out.printf("Optimized forecast: $%.2f million\n", optimizedForecast);
        }
        
        
        ForecastingBenchmark.runBenchmark(revenueHistory, 10);
        ForecastingBenchmark.runBenchmark(revenueHistory, 20);
        ForecastingBenchmark.runBenchmark(revenueHistory, 30);
        
  
        System.out.println("\n=== Complexity Analysis ===");
        System.out.println("1. Basic Recursive Solution:");
        System.out.println("   - Time Complexity: O(2^n) - Exponential due to redundant calculations");
        System.out.println("   - Space Complexity: O(n) - Call stack depth");
        
        System.out.println("\n2. Optimized Solution (with Memoization):");
        System.out.println("   - Time Complexity: O(n) - Each period calculated once");
        System.out.println("   - Space Complexity: O(n) - Storage for memoization");
        
        System.out.println("\n3. Alternative Approach:");
        System.out.println("   - Iterative solution would be O(n) time and O(1) space");
        System.out.println("   - Formula-based solution (compound growth) would be O(1) for both");
        
        System.out.println("\n=== Optimization Recommendations ===");
        System.out.println("1. For production systems, consider:");
        System.out.println("   - Iterative implementation for simplicity and efficiency");
        System.out.println("   - Formula-based calculation: futureValue = currentValue * (1 + rate)^periods");
        System.out.println("2. Recursion with memoization is useful when:");
        System.out.println("   - Growth rates vary by period (non-constant growth)");
        System.out.println("   - You need to model complex recursive relationships");
    }
}