package com.coderpwh.effective_java.chapter1.two;

/**
 * Builder 模式
 *
 * @author coderpwh
 * @Date: 2018/1/30.
 * @Description:
 */
public class NutritionFacts3 {

    private final int servingSize;

    private final int servigns;

    private final int calories;

    private final int fat;

    private final int sodium;

    private final int carbohydrate;

    public NutritionFacts3(Builder builder) {

        servingSize = builder.servingSize;

        servigns = builder.servigns;

        calories = builder.calories;

        fat = builder.fat;

        sodium = builder.sodium;

        carbohydrate = builder.carbohydrate;
    }

    public static class Builder {

        private final int servingSize;

        private final int servigns;

        private int calories = 0;

        private int fat = 0;

        private int carbohydrate = 0;

        private int sodium = 0;

        public Builder(int servingSize, int servigns) {
            this.servingSize = servingSize;
            this.servigns = servigns;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutritionFacts3 build() {
            return new NutritionFacts3(this);
        }
    }


}
