package com.demo.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {

    public static void main(String[] args) {

        //  Separate Odd and Even Numbers

        Map<Boolean, List<Integer>> oddEven = IntStream.range(1, 11)
                .boxed()
                .collect(Collectors.partitioningBy(
                        num -> (num & 1) == 1
                ));

        System.out.println("Separate Odd Even : ");
        System.out.println(oddEven);
        System.out.println();

        //  Frequency of Character in String

        String str = "Frequency of Character in String";

        Map<Character, Long> charFreq = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println("Frequency of Character in String");
        System.out.println(charFreq);
        System.out.println();

        //  Sort List in Reverse Order

        int[] arr = {4, 67, 1, 100, 43, 12, 56, 87, 22};

        List<Integer> reverseSort = Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Reverse Order List Sort");
        System.out.println(reverseSort);
        System.out.println();

        //  Print Multiples of 5

        List<Integer> multiplesFive = IntStream.range(1, 101)
                .boxed()
                .filter(num -> num % 5 == 0)
                .collect(Collectors.toList());

        System.out.println("Print Multiples of 5");
        System.out.println(multiplesFive);
        System.out.println();

        //  Merge two unsorted arrays

        List<Integer> list1 = Arrays.asList(43, 65, 23, 87, 45, 65, 12, 43, 99, 91);
        List<Integer> list2 = Arrays.asList(34, 56, 32, 78, 54, 56, 21, 34, 99, 19);

        List<Integer> sorted = Stream.of(list1, list2)
                .flatMap(Collection::stream)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Merge two Unsorted Arrays");
        System.out.println(sorted);
        System.out.println();

        //  Merge two unsorted arrays without duplicates

        List<Integer> sortedWithoutDuplicates = Stream.of(list1, list2)
                .flatMap(Collection::stream)
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Merge two Unsorted Arrays without duplicates");
        System.out.println(sortedWithoutDuplicates);
        System.out.println();

        //  Three max & min numbers from list

        List<Integer> min3 = list1.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());

        List<Integer> max3 = list1.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Three max and min numbers from list");
        System.out.println("Min : " + min3);
        System.out.println("Max : " + max3);
        System.out.println();

        //  Sort String based on String Length

        List<String> strings = Arrays.asList("abc", "ab", "abcde", "a", "aabbcc");

        List<String> sortedStr = strings.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());

        System.out.println("Sort Strings based on String Length");
        System.out.println(sortedStr);
        System.out.println();

        //  Sum and Average of Elements of Array

        Integer sum = sorted.stream()
                .reduce(0, Integer::sum);

        OptionalDouble average = sorted.stream()
                .mapToInt(Integer::intValue)
                .average();

        System.out.println("Sum and Average of Numbers");
        System.out.println("Sum : " + sum);
        System.out.println("Average : " + average.orElse(0));
        System.out.println();

        //  Reverse an Integer Array

        int[] reverseArr = IntStream.range(0, arr.length)
                .map(i -> arr[arr.length - 1 - i])
                .toArray();

        System.out.println("Reverse Integer Array");
        System.out.println("Original Array : " + Arrays.toString(arr));
        System.out.println("Reversed : " + Arrays.toString(reverseArr));
        System.out.println();

        //  Palindrome Program

        String str1 = "abcdefedcba";
        String str2 = "abcde";

        boolean str1Palindrome = IntStream.range(0, str1.length() / 2)
                .noneMatch(i -> str1.charAt(i) != str1.charAt(str1.length() - 1 - i));
        boolean str2Palindrome = IntStream.range(0, str2.length() / 2)
                .noneMatch(i -> str2.charAt(i) != str2.charAt(str2.length() - 1 - i));

        System.out.println("Palindrome Check");
        System.out.println("String : " + str1 + ". Result : " + str1Palindrome);
        System.out.println("String : " + str2 + ". Result : " + str2Palindrome);
        System.out.println();

        //  Last Element of Array

        OptionalInt lastElement = Arrays.stream(arr)
                .skip(arr.length - 1)
                .findFirst();

        System.out.println("Last Element of Array");
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("Last Element : " + lastElement.orElseThrow(NoSuchElementException::new));
        System.out.println();

        //  Frequency of Each Element of Array

        Map<Integer, Long> numberFreq = sorted.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        System.out.println("Frequency of Each Element of Array");
        System.out.println(numberFreq);
        System.out.println();

        //  Join list of Strings with Prefix, Suffix, Delimiter

        String joinedStr = strings.stream()
                .collect(Collectors.joining(
                        " Delimiter ",
                        "Prefix ",
                        " Suffix"
                ));

        System.out.println("Join List of Strings");
        System.out.println("Strings : " + strings);
        System.out.println(joinedStr);
        System.out.println();

        //  Sum of all digits of a number

        int num = 432521;

        Integer sumOfDigits = Stream.of(String.valueOf(num).split(""))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);

        System.out.println("Sum of all Digits of number");
        System.out.println("Number : " + num);
        System.out.println("Sum : " + sumOfDigits);
        System.out.println();

        //  Common Elements between two lists

        List<Integer> common = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());

        System.out.println("Common Elements between two lists");
        System.out.println(common);
        System.out.println();

        //  Reverse Each word of a String

        String wordsReverse = Stream.of(str.split(" "))
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .map(String::new)
                .collect(Collectors.joining(" "));

        System.out.println("Reverse Each word of String");
        System.out.println("String : " + str);
        System.out.println("Reverse Words : " + wordsReverse);
        System.out.println();

        //  Find Duplicate Elements from list

        Set<Integer> unique = new HashSet<>();

        List<Integer> duplicate = sorted.stream()
                .filter(i -> !unique.add(i))
                .collect(Collectors.toList());

        System.out.println("Find Duplicate Elements from List");
        System.out.println("List : " + sorted);
        System.out.println("Unique : " + unique);
        System.out.println("Duplicate : " + duplicate);
        System.out.println();

    }

}
