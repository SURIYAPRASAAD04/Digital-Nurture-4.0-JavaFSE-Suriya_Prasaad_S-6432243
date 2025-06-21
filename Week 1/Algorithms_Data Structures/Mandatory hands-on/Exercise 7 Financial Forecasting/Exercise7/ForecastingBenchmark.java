public class ForecastingBenchmark {
    public static void runBenchmark(double[] historicalData, int periods) {
        System.out.println("\nBenchmarking for " + periods + " periods...");
        
    
        long startTime = System.nanoTime();
        RecursiveForecaster recursive = new RecursiveForecaster(historicalData);
        double recursiveResult = recursive.forecast(periods);
        long endTime = System.nanoTime();
        System.out.printf("Recursive forecast: %.2f (Time: %d ns)\n", 
                         recursiveResult, (endTime - startTime));

       
        startTime = System.nanoTime();
        OptimizedForecaster optimized = new OptimizedForecaster(historicalData);
        double optimizedResult = optimized.forecast(periods);
        endTime = System.nanoTime();
        System.out.printf("Optimized forecast: %.2f (Time: %d ns)\n", 
                         optimizedResult, (endTime - startTime));
    }
}