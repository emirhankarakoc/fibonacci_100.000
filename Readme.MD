# Fibonacci with digit-by-digit addition

This Java project generates the first 100,000 Fibonacci numbers without using a fixed-width integer type for the calculation. Each number is held as a decimal `String`, and `toplayici` adds two values one digit at a time.

## Why strings?

A Java `int` or `long` has a maximum value. Fibonacci numbers eventually exceed it. Storing the decimal digits as characters lets the program keep adding after primitive integer types would overflow.

The addition is the same method we learned in elementary school: write the numbers one below the other, add from right to left, and carry to the next column.

```text
   999
 +   1
 -----
  1000
```

For two numbers with at most `d` decimal digits, the sum needs either `d` or `d + 1` digits. The code allocates a `byte[]` of length `max(length(a), length(b)) + 1` for the result digits and carries values of ten or more into the next slot. It then builds the decimal result without leading zeroes.

## How the code works

1. `reverse` puts each input's least significant digit at index zero.
2. `toplayici` visits corresponding indices and adds the digits and any carry already in the result array.
3. The result is read back from the highest digit to the lowest.
4. The main loop repeats that addition to produce 100,000 terms.

The video walkthrough of the algorithm is [here](https://youtu.be/WWiaCRL9wTY). A [saved output of the series](https://drive.google.com/drive/folders/1Npraotv1SWmKqcLt_k8NmT5G_wn2o9MA?usp=sharing) is also available.

## Run

```bash
javac Main.java
java Main
```

The program prints each term to standard output. Redirecting that output to a file is more practical than displaying all 100,000 lines in a terminal.

## Limits and possible improvements

This is a demonstration of arbitrary-precision *decimal addition*, not a claim of unlimited size. Java strings and arrays use `int` indexing, so they cannot hold ten billion digits in one object; available heap memory imposes a lower practical limit. The current `toplayici` also builds the final string through repeated `+=`, and the main loop keeps a second copy of the entire series in `fibonacciSeries`. A `StringBuilder` for one result and streaming output would reduce the time and memory cost.

For normal application code, Java's `BigInteger` is the standard solution. This project implements the arithmetic manually to show how carries and decimal digits work.
