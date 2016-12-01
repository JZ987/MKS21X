public class Circle extends Shape{

    private double radius;

    public Circle(){
	radius = 1.0;
    }

    public Circle(double x){
	radius = x;
    }

    public void setRadius(double x){
	radius = x;
    }

    public double getRadius(){
	return radius;
    }

    public double getArea(){
	return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter(){
	return Math.PI * 2 * radius;
    }

    public String toString(){
	return "A Circle with radius = " + radius + ", which is a subclass of " + super.toString(); 
    }
}
