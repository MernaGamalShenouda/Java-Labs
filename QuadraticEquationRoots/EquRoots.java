
class EquRoots{
    private double root1;
    private double root2;
	private double root1Imag;
    private double root2Imag;

    // Constructor
    public EquRoots(double root1, double root2) {
        this.root1 = root1;
        this.root2 = root2;
		this.root1Imag = 0;
		this.root2Imag = 0;
    }
	
	// Getter and setter for 'root1'
    public double getRoot1() {
        return root1;
    }

    public void setRoot1(double root1) {
        this.root1 = root1;
    }
	
	// Getter and setter for 'root2'
    public double getRoot2() {
        return root2;
    }

    public void setRoot2(double root2) {
        this.root2 = root2;
    }
	
	// Getter and setter for 'root1Imag'
    public double getRoot1Imag() {
        return root1Imag;
    }

    public void setRoot1Imag(double root1Imag) {
        this.root1Imag = root1Imag;
    }
	
	// Getter and setter for 'root2Imag'
    public double getRoot2Imag() {
        return root2Imag;
    }

    public void setRoot2Imag(double root2Imag) {
        this.root2Imag = root2Imag;
    }
}