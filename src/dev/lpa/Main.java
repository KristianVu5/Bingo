package dev.lpa;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    static int counter = 0;
    static void main(String[] args) {
//        List<String> bingoPoll = new ArrayList<>(75);
//
//        int start = 1;
//
//        for(char c : "BINGO".toCharArray()) {
//            for(int i = start; i < (start + 15);i++) {
//                bingoPoll.add("" + c + i);
//            }
//            start += 15;
//        }
//
//        Collections.shuffle(bingoPoll);
//        for(int i = 0; i < 15; i++ ) {
//            System.out.println(bingoPoll.get(i));
//        }
//        System.out.println("-------------------------------");
//
//        List<String> firstOnes = bingoPoll.subList(0,15);
//        firstOnes.sort(Comparator.naturalOrder());
//        firstOnes.replaceAll(s -> {
//            if(s.indexOf('G') == 0 || s.indexOf("O") == 0) {
//                String updated = s.charAt(0) + "-" + s.substring(1);
//                System.out.println(updated + " ");
//                return updated;
//            }
//            return s;
//        });
//        System.out.println("\n------------------------------------");
//
//        for(int i = 0; i < 15; i++) {
//            System.out.println(bingoPoll.get(i));
//        }
//        System.out.println("------------------------------------------");
//
//        bingoPoll.stream()
//                .limit(15)
//                .filter(s -> s.indexOf('G') == 0 || s.indexOf("O") == 0)
//                .map(s -> s.charAt(0) + "-" + s.substring(1))
//                .sorted()
//                .forEach(s -> System.out.print(s + " "));
//        System.out.println("\n-----------------------------------------");
//
//        for(int i = 0; i < 15; i++) {
//            System.out.println(bingoPoll.get(i));
//        }
//        System.out.println("------------------------------------------");

        int seed = 1;

        var streamB = Stream.iterate(seed,i -> i <= 15,i -> i + 1)
                .map(i -> "B" + i);
       //         streamB.forEach(System.out::println);

                seed += 15;
        var streamI = Stream.iterate(seed, i -> i + 1)
                .limit(15)
                .map(i -> "I" + i);

      //  streamI.forEach(System.out::println);

        seed += 15;
        int nSeed = seed;
        String[] oLabels = new String[15];
        Arrays.setAll(oLabels, i -> "N" + (nSeed + i));
        var streamN = Arrays.stream(oLabels);

      //  streamN.forEach(System.out::println);

        seed += 15;

        var streamG = Stream.of("G46", "G47", "G48", "G49", "G50", "G51", "G52", "G53", "G54", "G55",
                "G56", "G57", "G58", "G59", "G60");

      //  streamG.forEach(System.out::println);

        seed += 15;
        int rSeed = seed;

        var streamO = Stream.generate(Main::getCounter)
                .limit(15)
                .map(i -> "O" + (rSeed + i));

     //   streamO.forEach(System.out::println);


        var streamBI = Stream.concat(streamB, streamI);
        var streamNG = Stream.concat(streamN, streamG);
        var streamBING = Stream.concat(streamBI, streamNG);
        Stream.concat(streamBING,streamO)
                .forEach(System.out::println);


        System.out.println("-".repeat(60));
        Stream.generate(() -> new Random().nextInt(rSeed, rSeed + 15))
                .distinct()
                .limit(15)
                .map(i -> "O" + i)
                .sorted()
                .forEach(System.out::println);
    }

    static int getCounter() {
        return counter++;
    }
}
