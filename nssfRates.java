public class nssfRates {

    static float getOldRate(float grosspay) {
  
        float nssfAmount = grosspay * 0.05f;
        if(nssfAmount > 200) nssfAmount = 200.0f;
        
        System.out.println("Gross Pay= " + grosspay + " OLd Nssf Amount= " + nssfAmount);
        return nssfAmount;
       }

       static float getNewRate(float grosspay) {

        float nssfAmount = grosspay * 0.06f;
        if(nssfAmount > 2080) nssfAmount =2080.0f;
        
        System.out.println("Gross Pay= " + grosspay + " NEW Nssf Amount= " + nssfAmount);
        return nssfAmount;
        }

public static void main(String[] args) {

  System.out.println("Welcome to NSSF Calculation function");
  
  nssfAmount = getOldRate(4000.0f);
  nssfAmount = getOldRate(7000.0f);
  nssfAmount = getOldRate(10000.0f);
  nssfAmount = getOldRate(40000.0f);
  
  System.out.println("\n");
  
  nssfAmount = getNewRate(3000.0f);
  nssfAmount = getNewRate(4000.0f);
  nssfAmount = getNewRate(7000.0f);
  nssfAmount = getNewRate(10000.0f);
  nssfAmount = getNewRate(20000.0f);
 }
    
}
