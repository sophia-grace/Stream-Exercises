/*
Name: Sophia Trump
File: StreamExercises.java
Description: Practice using java streams
Date: 28 Nov 2018
*/
import java.util.*;
import java.util.stream.*;

public class StreamExercises {

  // returns the longest string in an input list, if that list is nonempty
  public static Optional<String> longest(List<String> strings) {
    return strings.stream().max(Comparator.comparing(String::length)); // compare strings by their length
  }

  // when given an input stream, produces an output stream containing
  // the maximum 5 elements of the input stream, in descending order
  // ** Assumes that the input stream has at least 5 elements
  public static <A extends Comparable<? super A>> Stream<A> top5(Stream<A> input) {
    return input.sorted(Comparator.reverseOrder()).limit(5);
  }

  // returns the sum of all prime numbers between lo and hi inclusive
  public static int sumPrimes(int lo, int hi) {
    if(hi <= 1 || hi < lo) {
      return -1;
    }
    return IntStream.rangeClosed(lo, hi).filter(StreamExercises::isPrime).sum();
  }

  // check whether a number is prime
  public static boolean isPrime(int n) {
    return n > 1 && IntStream.range(2,n).filter(d -> n % d == 0).count() == 0;
  }

  public static void main(String[] args) {
    List<String> list = Arrays.asList("a", "bbb", "cc");
    List<String> list2 = Arrays.asList("aaa", "bb", "c");
    List<String> list3 = Arrays.asList("aa", "b", "ccc");
    List<String> list4 = Arrays.asList("a", "b", "c");
    List<String> emptyList = Arrays.asList();
    System.out.println(longest(list));
    System.out.println(longest(emptyList));
    System.out.println(longest(list2));
    System.out.println(longest(list3));
    System.out.println(longest(list4));
    System.out.println(sumPrimes(3, 3));
    System.out.println(sumPrimes(2, 11));
    System.out.println(sumPrimes(7, 0));
    System.out.println(sumPrimes(-10,1));
  }
}
