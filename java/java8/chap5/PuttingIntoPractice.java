package com.pwh.mycode.chap5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/4/16 9:46
 * 4
 */
public class PuttingIntoPractice {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        List<Transaction> tr2011 = transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted(comparing(Transaction::getValue)).collect(Collectors.toList());
        tr2011.forEach(r -> {
            System.out.println("姓名:" + r.getTrader().getName() + ", 年龄:" + r.getYear() + ", value值:" + r.getValue());
        });
        System.out.println("--------------------------------------------------");

        // 选择没有重复名的城市
        List<String> citys = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList());
        citys.forEach(r -> System.out.print(r + " ,"));
        System.out.println();
        System.out.println("--------------------------------------------------");


        List<Trader> traders = transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge")).distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
        traders.stream().forEach(r -> System.out.print(r.getCity() + " "));
        System.out.println();
        System.out.println("--------------------------------------------------");


        String str = transactions.stream().map(transaction -> transaction.getTrader().getName()).distinct().sorted().reduce("", (n1, n2) -> n1 + n2);
        System.out.println(str);

        System.out.println("--------------------------------------------------");
        boolean milanBased = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Raoul"));
        System.out.println(milanBased);

        System.out.println("--------------------------------------------------");

        transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Milan")).forEach(trader -> trader.setCity("Cambridge"));
        transactions.stream().forEach(r -> System.out.print(r.getTrader().getCity() + " ,"));

        System.out.println();
        System.out.println("--------------------------------------------------");
        int highestValue = transactions.stream().map(Transaction::getValue).reduce(0, Integer::max);
        System.out.println(highestValue);


    }
}
