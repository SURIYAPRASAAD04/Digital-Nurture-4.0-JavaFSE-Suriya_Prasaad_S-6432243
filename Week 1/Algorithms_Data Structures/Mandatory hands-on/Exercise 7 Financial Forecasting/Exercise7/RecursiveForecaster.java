public class RecursiveForecaster extends FinancialForecaster {
    public RecursiveForecaster(double[] historicalValues) {
        super(historicalValues);
    }

    
    public double forecast(int periods) {
        if (periods <= 0) {
            return historicalValues[historicalValues.length - 1]; 
        }
        
        double lastValue = forecast(periods - 1); 
        return lastValue * (1 + averageGrowthRate);
    }
}