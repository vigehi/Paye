
public class nhif {
    public static float getNHIF(float grossPay1) {
      float nhif = 0;
  
      if (grossPay1 < 6000) {
        nhif = 150;
      } else if (grossPay1 < 8000) {
        nhif = 300;
      } else if (grossPay1 < 12000) {
        nhif = 400;
      } else if (grossPay1 < 15000) {
        nhif = 500;
      } else if (grossPay1 < 20000) {
        nhif = 600;
      } else if (grossPay1 < 25000) {
        nhif = 750;
      } else if (grossPay1 < 30000) {
        nhif = 850;
      } else if (grossPay1 < 35000) {
        nhif = 900;
      } else if (grossPay1 < 40000) {
        nhif = 950;
      } else if (grossPay1 < 45000) {
        nhif = 1000;
      } else if (grossPay1 < 50000) {
        nhif = 1100;
      } else if (grossPay1 < 60000) {
        nhif = 1200;
      } else if (grossPay1 < 70000) {
        nhif = 1300;
      } else if (grossPay1 < 80000) {
        nhif = 1400;
      } else if (grossPay1 < 90000) {
        nhif = 1500;
      } else if (grossPay1 < 100000) {
        nhif = 1600;
      } else if (grossPay1 >= 100000) {
        nhif = 1700;
      }
  
      return nhif;
    }
  }
  