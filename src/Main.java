import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static Integer arabNum(String num1) {
        switch (num1) {

            case "1":
                return 1;

            case "2":
                return 2;

            case "3":
                return 3;

            case "4":
                return 4;

            case "5":
                return 5;

            case "6":
                return 6;

            case "7":
                return 7;

            case "8":
                return 8;

            case "9":
                return 9;

            case "10":
                return 10;

            default:

                return 404;

        }
    }

    public static Integer rimNum(String num1) {
        switch (num1) {

            case "I":
                return 1;

            case "II":
                return 2;

            case "III":
                return 3;

            case "IV":
                return 4;

            case "V":
                return 5;

            case "VI":
                return 6;

            case "VII":
                return 7;

            case "VIII":
                return 8;

            case "IX":
                return 9;

            case "X":
                return 10;

            default:

                return 404;

        }
    }


    public static String numRim2(int num3) {
        String[] rimNums = { "error", "I","II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX","XXI","XXII",
                "XXIII","XXIV","XV","XVI","XVII","XVIII","XXIX","XXX","XXXI","XXXII","XXXIII",
                "XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL","XLI","XLII","XLIII",
                "XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV",
                "LVI","LVII","LVIII","LIX","LX","LXI","LXII","LXIII","LXIV","LXV","LXVI",
                "LXVII","LXVIII","LXIX","LXX","LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI",
                "LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV",
                "LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV",
                "XCV","XCVI","XCVII","XCVIII","XCIX","C"

        };
        return rimNums[num3];
        }


    public static String calc(String str) {

        //words[] = new String[4];
        String[] words = str.split("\\s");
        int num1, num2, resultatus;
        if (words.length != 3) {
            return "Error";
        }
        num1 = arabNum(words[0]);
        num2 = arabNum(words[2]);
        boolean rim = false;
        if (num1 == 404 || num2 == 404) {
            num1 = rimNum(words[0]);
            num2 = rimNum(words[2]);
            rim = true;
            if (words[1].equals("-") && num1 - num2 <= 0) {
                return "Error";
            }
        }
        if (num1 == 404 || num2 == 404) {
            return "Error";
        } else {
            switch (words[1]) {
                case "+":
                    resultatus = num1 + num2;
                    break;
                case "-":
                    resultatus = num1 - num2;
                    break;
                case "*":
                    resultatus = num1 * num2;
                    break;
                case "/":
                    resultatus = num1 / num2;
                    break;
                default:
                    return "Error";

            }
            return rim ? numRim2(resultatus) : (resultatus + "");
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (calc(str).equals("Error")) {
            try {
                throw new IOException();

            } catch (IOException e) {
                System.out.println("Некорректный ввод");

            }
        } else System.out.println(calc(str));
    }
}