interface Shape {
    void computeArea();
}

class Circle implements Shape {
    @Override
    public void computeArea() {
        // Implement logic to calculate area of a circle
        System.out.println("Circle area calculated.");
    }
}

class Rectangle implements Shape {
    @Override
    public void computeArea() {
        // Implement logic to calculate area of a rectangle
        System.out.println("Rectangle area calculated.");
    }
}

class ShapeFactory {

    public Shape getShape(String shapeType) {
        if (shapeType.equals("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equals("RECTANGLE")) {
            return new Rectangle();
        } else {
            throw new IllegalArgumentException("Invalid shape type.");
        }
    }
}

public class Factory {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.computeArea();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.computeArea();
    }
}
