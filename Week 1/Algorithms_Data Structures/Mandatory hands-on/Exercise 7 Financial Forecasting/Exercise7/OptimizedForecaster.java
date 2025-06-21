import java.util.HashMap;
import java.util.Map;

public class OptimizedForecaster extends FinancialForecaster {
    private Map<Integer, Double> memo = new HashMap<>();

    public OptimizedForecaster(double[] historicalValues) {
        super(historicalValues);
    }


    public double forecast(int periods) {
        if (periods <= 0) {
            return historicalValues[historicalValues.length - 1]; 
        }

        
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }

       
        double result = forecast(periods - 1) * (1 + averageGrowthRate);
        memo.put(periods, result);
        return result;
    }
}