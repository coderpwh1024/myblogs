package com.coderpwh.effective_java.chapter1.two;

/**
 * 缺点: 构造器的参数无法保证一致
 *
 * @author coderpwh
 * @Date: 2018/1/30.
 * @Description:
 */
public class NutritionFacts2 {

    private int servingSize = -1;

    private int servings = -1;

    private int calories = 0;

    private int fat = 0;

    private int sodium = 0;

    private int carbohydrate = 0;


    public NutritionFacts2() {

    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }
}
