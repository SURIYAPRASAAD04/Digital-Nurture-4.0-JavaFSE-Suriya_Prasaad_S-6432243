public abstract class FinancialForecaster {
    protected double[] historicalValues;
    protected double averageGrowthRate;

    public FinancialForecaster(double[] historicalValues) {
        this.historicalValues = historicalValues;
        this.averageGrowthRate = calculateAverageGrowthRate();
    }

    protected double calculateAverageGrowthRate() {
        if (historicalValues.length < 2) {
            return 0.0; 
        }

        double totalGrowth = 0.0;
        for (int i = 1; i < historicalValues.length; i++) {
            double growth = (historicalValues[i] - historicalValues[i-1]) / historicalValues[i-1];
            totalGrowth += growth;
        }
        return totalGrowth / (historicalValues.length - 1);
    }

    public abstract double forecast(int periods);
}