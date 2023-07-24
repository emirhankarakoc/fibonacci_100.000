package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        String a = "1", b = "1";
        String sonuc = "0";


        StringBuilder fibonacciSeries = new StringBuilder();

        for (int i = 0; i < 100000; i++) {
            a = b;
            b = sonuc;
            sonuc = toplayici(a, b);

            fibonacciSeries.append("fibonacci ").append(i).append("= \t").append(sonuc).append("\n");
            System.out.println("fibonacci serisinin "+(i+1)+". elemani = "+sonuc);
        }

        // Dosyaya yazma işlemi
        String filePath = "C:\\Users\\emirhan karakoc\\Desktop\\fibonacci.txt";
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(fibonacciSeries.toString());
            bufferedWriter.close();

        } catch (IOException e) {

        }




    }

    // Stringi tersine çeviren metot
    public static String reverse(String input) {
        int length = input.length();
        StringBuilder reversedString = new StringBuilder(length);

        for (int i = length - 1; i >= 0; i--) {
            reversedString.append(input.charAt(i));
        }

        return reversedString.toString();
    }

    public static String toplayici(String sayi1, String sayi2) {
        // Sayıları tersine çevirme
        String sayi1Reversed = reverse(sayi1);
        String sayi2Reversed = reverse(sayi2);

        // Toplama işlemi için yeni bir dizi oluşturma
        double maxLength = Math.max(sayi1Reversed.length(), sayi2Reversed.length());
        maxLength++;
        byte[] dizi = new byte[(int) maxLength];

        // Sayıları diziye ekleme ve taşmaları kontrol etme
        for (int i = 0; i < maxLength; i++) {
            int toplam = dizi[i];
            if (i < sayi1Reversed.length()) {
                toplam += Byte.parseByte(String.valueOf(sayi1Reversed.charAt(i)));
            }
            if (i < sayi2Reversed.length()) {
                toplam += Byte.parseByte(String.valueOf(sayi2Reversed.charAt(i)));
            }

            if (toplam >= 10) {
                dizi[i + 1] += toplam / 10;
                toplam %= 10;
            }

            dizi[i] = (byte) toplam;
        }

        // Sonucu elde etmek için bir String oluşturma
        String toplamaSonucu = "";
        boolean leadingZeros = true;
        for (int i = dizi.length - 1; i >= 0; i--) {
            if (leadingZeros && dizi[i] == 0) {
                continue;
            }
            leadingZeros = false;
            toplamaSonucu += dizi[i];
        }

        // Toplama Sonucunu ekrana yazdırma
        return toplamaSonucu;
    }
}
