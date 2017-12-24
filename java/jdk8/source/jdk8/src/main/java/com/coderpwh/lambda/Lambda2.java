package com.coderpwh.lambda;

/**
 * Created by coderpwh on 2017/12/19.
 */
public class Lambda2 {

    @FunctionalInterface
     public static interface Converter<F,T>{
         T convert(F from);
    }

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface  PersonFactory<P extends  Person>{

       P create(String firstName, String lastName);
    }

    public static void main(String[] args) {

         Converter<String ,Integer> integerConverter1 = (from)->Integer.valueOf(from);
         Integer converted1 = integerConverter1.convert("123");
         System.out.println(converted1);

         Converter<String,Integer> integerConverter2 = Integer::valueOf;
         Integer converted2 = integerConverter2.convert("123");
         System.out.println(converted2);

         Something something = new Something();

         Converter<String ,String> stringConverter = something::startsWith;
         String converted3 = stringConverter.convert("Java");
         System.out.println(converted3);

         // PersonFactory<Person> p1 = (PersonFactory<Person>) new Person();

         PersonFactory<Person> personPersonFactory= Person::new;

         Person person = personPersonFactory.create("Peter","Parker");






    }




}
