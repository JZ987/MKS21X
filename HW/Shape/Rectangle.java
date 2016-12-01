public class Rectangle extends Shape{

    private double width, length;

    public Rectangle(){
	width = 1.0;
	length = 1.0;
    }

    public Rectangle(double x, double y){
	width = x;
	length = y;
    }

    public void setWidth(double x){
	width = x;
    }

    public void setLength(double y){
	length = y;
    }

    public double getWidth(){
	return width;
    }

    public double getLength(){
	return length;
    }

    public double getArea(){
	return width * length;
    }

    public double getPerimeter(){
	return 2 * (width + length);
    }

    public String toString(){
	return "A Rectangle with width = " + width + " and length = " + length + ", which is a subclass of " + super.toString(); 
    }
}
