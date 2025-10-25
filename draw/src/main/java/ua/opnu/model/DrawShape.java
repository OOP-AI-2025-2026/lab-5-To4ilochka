package ua.opnu.model;

import java.awt.*;

/*
 * Клас "Фігура для малювання".
 * Клас містить початкову та кінцеву точку, а також різні методи
 */
public class DrawShape {

    public static DrawShape newInstance(int shapeType) {
        return switch (shapeType) {
            case DrawShape.SHAPE_RECTANGLE -> new Rectangle();
            case DrawShape.SHAPE_ROUNDED_RECT -> new RoundedRectangle();
            case DrawShape.SHAPE_ELLIPSE -> new Ellipse();
            default -> throw new IllegalStateException("Unexpected value: " + shapeType);
        };
    }

    // Константи для типів фігур
    public static final int SHAPE_RECTANGLE = 0;
    public static final int SHAPE_ROUNDED_RECT = 1;
    public static final int SHAPE_ELLIPSE = 2;

    // Початкова та кінцева точки
    private Point startPoint;
    private Point endPoint;

    // Конструктор без параметрів
    public DrawShape() {
        this(new Point(0, 0), new Point(0, 0));
    }

    // Конструктор з початковими координатами
    public DrawShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    // Метод повертає фігуру, яку можна намалювати
    public Shape getShape() {
        return this.getShape(startPoint, endPoint);
    }

    // Так, як ми не можемо намалювати просто "фігуру", то метод повертає null
    public Shape getShape(Point startPoint, Point endPoint) {
        return null;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}
