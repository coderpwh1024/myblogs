package com.coderpwh.effective_java.chapter1.two;

/**
 * @author coderpwh
 * @Date: 2018/1/30.
 * @Description:
 */
public class TestNutritionFacts {

    NutritionFacts3 cocaCal = new NutritionFacts3.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();

    NutritionFacts cocalCal2 = new NutritionFacts(100,0,0,0,0,0);

    NutritionFacts  cocalCal3 = new NutritionFacts(0,0);

}
