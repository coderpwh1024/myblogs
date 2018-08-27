package com.pwh.mycode.other.factory;

public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();


        // 获取 Circle 对象，并实现调用
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        shape1.drow();


        // RECTANGLE  对象
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        shape2.drow();

        //  Square 对象
        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.drow();


    }
}
