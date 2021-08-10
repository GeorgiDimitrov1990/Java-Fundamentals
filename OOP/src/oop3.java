import java.util.Scanner;

public class oop3 {

    static class Circle{
        double radius;

        Circle(double radius){
            this.radius = radius;
        }

        double getArea() {
            return radius * radius * Math.PI;
        }

        void scale (double factor) {
            radius *= factor;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Circle c = new Circle(5);

        System.out.println(c.getArea());

        Circle c2 = new Circle(10);
        c2.scale(2);
        System.out.println(c2.getArea());


    }
}
