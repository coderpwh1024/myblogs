package com.pwh.mycode.other.factory;

/**
 *  创建的工厂类
 *   根据type不同的类型从而来创建对象
 */
public class ShapeFactory {


    public Shape getShape(String shapeType){
        if(shapeType==null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return  new Circle();
        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
          return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

        return  null;
    }

}
