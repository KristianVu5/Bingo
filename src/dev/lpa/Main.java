package dev.lpa;

import java.util.*;

public class Main {
    static void main(String[] args) {
        List<String> bingoPoll = new ArrayList<>(75);

        int start = 1;

        for(char c : "BINGO".toCharArray()) {
            for(int i = start; i < (start + 15);i++) {
                bingoPoll.add("" + c + i);
            }
            start += 15;
        }

        Collections.shuffle(bingoPoll);
        for(int i = 0; i < 15; i++ ) {
            System.out.println(bingoPoll.get(i));
        }
        System.out.println("-------------------------------");

        List<String> firstOnes = bingoPoll.subList(0,15);
        firstOnes.sort(Comparator.naturalOrder());
        firstOnes.replaceAll(s -> {
            if(s.indexOf('G') == 0 || s.indexOf("O") == 0) {
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.println(updated + " ");
                return updated;
            }
            return s;
        });
        System.out.println("\n------------------------------------");

        for(int i = 0; i < 15; i++) {
            System.out.println(bingoPoll.get(i));
        }
        System.out.println("------------------------------------------");

        bingoPoll.stream()
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf("O") == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted()
                .forEach(s -> System.out.print(s + " "));
        System.out.println("\n-----------------------------------------");

        for(int i = 0; i < 15; i++) {
            System.out.println(bingoPoll.get(i));
        }
        System.out.println("------------------------------------------");

    }
}
