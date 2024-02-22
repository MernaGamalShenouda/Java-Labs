import java.math.BigDecimal; 

public class ComplexNumberMain{
	public static void main(String args[]){
		ComplexNumber <BigDecimal> comp1 = new ComplexNumber<>();
		comp1.setReal(new BigDecimal(5));
		comp1.setImag(new BigDecimal(2));
		comp1.showC();
		
		ComplexNumber <BigDecimal> comp2 = new ComplexNumber<>();
		comp2.setReal(new BigDecimal(3));
		comp2.setImag(new BigDecimal(1));
		comp2.showC();
		
		ComplexNumber <BigDecimal> comp3 = new ComplexNumber<>();
		comp3.setReal(comp2.addComp(comp1).getReal());
		comp3.setImag(comp2.addComp(comp1).getImag());

		comp3.showC();	
	}
}