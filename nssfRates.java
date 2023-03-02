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
    }