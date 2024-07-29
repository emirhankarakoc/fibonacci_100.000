

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
            System.out.println("Series "+(i+1)+". item = "+sonuc);
        }

        // // Writing the files(no need)
        // String filePath = "C:\\Users\\emirhan karakoc\\Desktop\\fibonacci.txt";
        // try {
        //     FileWriter fileWriter = new FileWriter(filePath);
        //     BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        //     bufferedWriter.write(fibonacciSeries.toString());
        //     bufferedWriter.close();

        // } catch (IOException e) {

        // }




    }

    //String reversing
    public static String reverse(String input) {
        int length = input.length();
        StringBuilder reversedString = new StringBuilder(length);

        for (int i = length - 1; i >= 0; i--) {
            reversedString.append(input.charAt(i));
        }

        return reversedString.toString();
    }
    
    //superstar method is here. this method sums 2 number with different style
    public static String toplayici(String sayi1, String sayi2) {
        // reversing
        String sayi1Reversed = reverse(sayi1);
        String sayi2Reversed = reverse(sayi2);

        //creating new array for sum
        double maxLength = Math.max(sayi1Reversed.length(), sayi2Reversed.length());
        maxLength++;
        byte[] dizi = new byte[(int) maxLength];

        // Adding numbers to array and checking for overflows
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

        //creating response string
        String toplamaSonucu = "";
        boolean leadingZeros = true;
        for (int i = dizi.length - 1; i >= 0; i--) {
            if (leadingZeros && dizi[i] == 0) {
                continue;
            }
            leadingZeros = false;
            toplamaSonucu += dizi[i];
        }

        // return sum
        return toplamaSonucu;
    }
    
}
