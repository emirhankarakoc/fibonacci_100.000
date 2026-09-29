# Fibonacci with strings

This Java program prints 100,000 Fibonacci numbers. It adds decimal numbers as strings, one digit at a time.

## Why?

Java `int` and `long` have a limit. Fibonacci numbers soon become too large for them. This project shows how to keep adding decimal digits without using those number types.

The idea is the same as adding numbers on paper: start on the right, add each pair of digits, and carry to the next place.

```text
   999
 +   1
 -----
  1000
```

If the longer input has `d` digits, the answer needs at most `d + 1` digits. The code uses a `byte[]` for those digits. See `toplayici` in [Main.java](Main.java).

## Run

```bash
javac Main.java
java Main
```

The program prints every number. You can save the output with `java Main > fibonacci.txt`.

## Limits

Strings and arrays have an index limit in Java, and the computer needs enough memory. Ten billion digits will not fit in one Java array. The program keeps all results in memory, so large runs can be slow. For normal apps, Java `BigInteger` is a better choice.

[Video explanation](https://youtu.be/WWiaCRL9wTY)
