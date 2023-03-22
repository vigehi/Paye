public class TaxCalculator {
    public static final float RATE1 = 0.1f;
    public static final float RATE2 = 0.25f;
    public static final float RATE3 = 0.3f;
    

    public static float computePaye(float taxableIncome) {
        float paye = 0f;
        float annualIncome = taxableIncome * 12f;

        // Calculate PAYE based on tax bands from KRA
        if (annualIncome <= 288000f) {
            paye = annualIncome * RATE1;
        } else if (annualIncome <= 388000f) {
            float incomeInBand1 = 288000f;
            float incomeInBand2 = annualIncome - incomeInBand1;
            paye = (incomeInBand1 * RATE1) + (incomeInBand2 * RATE2);
        } else {
            float incomeInBand1 = 288000f;
            float incomeInBand2 = 100000f;
            float incomeInBand3 = annualIncome - (incomeInBand1 + incomeInBand2);
            paye = (incomeInBand1 * RATE1) + (incomeInBand2 * RATE2) + (incomeInBand3 * RATE3);
        }
        
        
        return paye;
    }
}
