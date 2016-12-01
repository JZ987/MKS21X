public class Square extends Rectangle{

    public Square(){
	super();
    }

    public Square(double x){
	super(x, x);
    }

    public void setSide(double x){
	super.setWidth(x);
	super.setLength(x);
    }

    public String toString(){
	return "A Square with side = " + super.getWidth() + ", which is a subclass of " + super.toString();
    }
}
