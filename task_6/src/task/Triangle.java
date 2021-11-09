package task;

public class Triangle {

    // Fields
    private double a;
    private double b;
    private double c;

    // Constructors
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Methods
    public double getA() {return a;}
    public double getB() {return b;}
    public double getC() {return c;}
    public boolean isValid() {
        return (a > 0) && (b > 0) && (c > 0) && (a + b > c) && (a + c > b) && (b + c > a);
    }
    public double square() {
        if (!this.isValid()) return -1.0;
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p -b) * (p - c));
    }
    public double perimeter() {
        if (!this.isValid()) return -1.0;
        return a + b + c;
    }


}

