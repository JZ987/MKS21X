public class Driver{

    public static void main(String[] args){

	Rectangle x = new Rectangle();

	System.out.println(x.getWidth());
	System.out.println(x.getLength());

	x.setWidth(2.6);
	x.setLength(3.7);

	System.out.println(x.getWidth());
	System.out.println(x.getLength());

	System.out.println(x.getArea());
	System.out.println(x.getPerimeter());
	System.out.println(x.getSemiPerimeter());

	System.out.println(x);

	Circle y = new Circle();

	System.out.println(y.getRadius());

	y.setRadius(4.3);

	System.out.println(y.getRadius());

	System.out.println(y.getArea());
	System.out.println(y.getPerimeter());
	System.out.println(y.getSemiPerimeter());

	System.out.println(y);

	Square z = new Square(4);

	System.out.println(z.getWidth());
	System.out.println(z.getLength());

	z.setSide(6);
	
	System.out.println(z.getWidth());
	System.out.println(z.getLength());

	System.out.println(z.getArea());
	System.out.println(z.getPerimeter());
	System.out.println(z.getSemiPerimeter());

	System.out.println(z);
    }
}
