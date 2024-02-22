
import java.util.function.Function;
import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

class MainQuadraticEqu implements Function<QuadraticEqu,EquRoots>{
  public static void main(String args[]){
	if(args.length==3){
		if(checkNumber(args[0]) && checkNumber(args[1]) && checkNumber(args[2])){
			String mySign1, mySign2;
			QuadraticEqu myEqu = new QuadraticEqu(Double.parseDouble(args[0]),Double.parseDouble(args[1]),Double.parseDouble(args[2]));
	        EquRoots myEquRoots = new EquRoots(0,0);
			MainQuadraticEqu main1 = new MainQuadraticEqu();
			myEquRoots = main1.apply(myEqu);
			
			if(myEquRoots.getRoot1Imag()!=0 || myEquRoots.getRoot2Imag()!=0){
			  System.out.println("Root1 = " + myEquRoots.getRoot1() + "+" + myEquRoots.getRoot1Imag() + " i" ); 
			  System.out.println("Root2 = " + myEquRoots.getRoot2() + myEquRoots.getRoot2Imag() + " i" ); 
			}else{
			  System.out.println("Root1 = " + myEquRoots.getRoot1()); 
			  System.out.println("Root2 = " + myEquRoots.getRoot2()); 
			}
			
		}else{
		  System.out.println("The args should be numbers"); 
	    }
	  }else{
		System.out.println("Error! 3 arg only are allowed ");
	  }
  }
  
  	public EquRoots apply(QuadraticEqu myEqu){
		double a = myEqu.getA();
		double b = myEqu.getB();
		double c = myEqu.getC();
		EquRoots myEquRoots = new EquRoots(0,0);

        if (a == 0) {
            System.out.println("Invalid");
			myEquRoots.setRoot1(0);
			myEquRoots.setRoot2Imag(0);
			myEquRoots.setRoot1Imag(0);
			myEquRoots.setRoot2Imag(0);
        }
 
        double d = b * b - 4 * a * c;
        double sqrt_val = sqrt(abs(d));
 
        if (d > 0) {
            System.out.println("Roots are real and different \n");
            myEquRoots.setRoot1((double)(-b + sqrt_val) / (2 * a));
			myEquRoots.setRoot2((double)(-b - sqrt_val) / (2 * a));
			myEquRoots.setRoot1Imag(0);
			myEquRoots.setRoot2Imag(0);
        }
        else if (d == 0) {
            System.out.println("Roots are real and same \n");
            myEquRoots.setRoot1(-(double)b / (2 * a));
			myEquRoots.setRoot2(-(double)b / (2 * a));
			myEquRoots.setRoot1Imag(0);
			myEquRoots.setRoot2Imag(0);
        }
        else // d < 0
        {
            System.out.println("Roots are complex \n");
            myEquRoots.setRoot1(-(double)b / (2 * a));
			myEquRoots.setRoot2(-(double)b / (2 * a));
			myEquRoots.setRoot1Imag(sqrt_val / (2 * a));
			myEquRoots.setRoot2Imag(-(sqrt_val / (2 * a)));
       }
	   return myEquRoots;
	}
   
   static boolean checkNumber(String str) {
     return str.matches("^-?[0-9].*");
   }  
}