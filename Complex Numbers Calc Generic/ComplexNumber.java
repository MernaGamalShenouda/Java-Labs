import java.math.BigDecimal; 

public class ComplexNumber <T extends BigDecimal> {
    private T real, imag;
	
	// Getter and setter for 'real'
    public T getReal() {
        return real;
    }

    public void setReal(T real) {
        this.real = real;
    }
	
	// Getter and setter for 'imag'
    public T getImag() {
        return imag;
    }

    public void setImag(T imag) {
        this.imag = imag;
    }
 
    public void showC(){
        System.out.println(this.real.toString() + " + i" + this.imag.toString());
    }
 
    public ComplexNumber addComp(ComplexNumber n)
    {
		ComplexNumber newComp = new ComplexNumber();
        newComp.setReal((T)this.real.add(n.real));
		newComp.setImag((T)this.imag.add(n.imag));

        return newComp;
    }
	
	public ComplexNumber subtractComp(ComplexNumber n)
    {
		ComplexNumber newComp = new ComplexNumber();
        newComp.setReal((T)this.real.subtract(n.real));
		newComp.setImag((T)this.imag.subtract(n.imag));

        return newComp;
    }
}