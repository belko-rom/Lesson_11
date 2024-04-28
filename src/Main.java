import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строку:");
        String firstString = scanner.nextLine();

        System.out.println("Введите вторую строку:");
        String secondString = scanner.nextLine();

        System.out.println("Введите третью строку:");
        String thirdString = scanner.nextLine();

        String shortestString = findShortestString(firstString, secondString, thirdString);
        String longestString = findLongestString(firstString, secondString, thirdString);

        System.out.println("Самая короткая строка: " + shortestString + ", длина: " + shortestString.length());
        System.out.println("Самая длинная строка: " + longestString + ", длина: " + longestString.length());
        //Еще можно решить через compareTo(), но как выполнил ниже понятней.
        //По compareTo() если результат равен  0 то равны, если < 0 то строка которая сравнивается меньше, если > 0 то
        //строка которая сравнивается больше.

        System.out.println(sortStr(firstString,secondString,thirdString));
        outputStringsLessAverageLength(firstString, secondString, thirdString);
        String uniqueWord = wordDifferentSymbols(firstString, secondString, thirdString);
        System.out.println("Слово из уникальных символов: " + uniqueWord);
        letterDuplication();
        palindrome();



    }
    public static String findShortestString(String line1, String line2, String line3){
        String shortest = line1;
        if(line2.length() < shortest.length()){
            shortest = line2;
        }
        if(line3.length() < shortest.length()){
            shortest = line3;
        }
        return shortest;
    }
    public static String findLongestString(String line1, String line2, String line3){
        String longest = line1;
        if(line2.length() > longest.length()){
            longest = line2;
        }
        if(line3.length() > longest.length()){
            longest = line3;
        }
        return longest;
    }
    public static String sortStr(String line1, String line2, String line3){
        String[] arr = {line1, line2, line3};

        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            /*Сравниваем элементы попарно,
             если они имеют неправильный порядок,
             то меняем местами */
                if( arr[j].length() > arr[j+1].length() ){
                    String tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        System.out.print("Отсортированные строки по возрастанию с помощью массива: ");
        return Arrays.toString(arr);
    }
    public static void outputStringsLessAverageLength(String line1, String line2, String line3){
        String[] arr = {line1, line2, line3};
        double averageLength = (double) (line1.length() + line2.length() + line3.length())/ arr.length;
        System.out.print("Строки, длина которых меньше средней: ");
        for (String str : arr) {
            if (str.length() < averageLength) {
                System.out.print(str);
                System.out.println(", Длина: " + str.length() + ";");
            }
        }
    }
    public static String wordDifferentSymbols(String line1, String line2, String line3){

        String[] words = {line1, line2, line3};

        for (String word : words) {
            String[] array = word.split(" ");
            for (String w : array) {

                boolean test = true;
                for (int i = 0; i < w.length() - 1; i++) {
                    char currentChar = w.charAt(i);
                    if (currentChar == w.charAt(i + 1)) {
                        test = false;
                        break;
                    }
                }
                if (test) {
                    return w;
                }
            }
        }
        return "Такого слова не найдено";
    }
    public static void letterDuplication(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        if (scanner.hasNext()) {
            char[] array = scanner.next().toCharArray();
            StringBuilder duplicationStr = new StringBuilder();
            for (char letter : array) {
                duplicationStr.append(letter).append(letter);
            }
            System.out.println("Строка с дублированными буквами: " + duplicationStr);
        }
    }

    //Task*
    public static void palindrome(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        if(scanner.hasNext()){
            String[] words = scanner.nextLine().split("[,. !?_–]+");
            for (String word : words) {
                System.out.println(word);
            }
            System.out.println("Введите число для проверки, является ли любое выбранное слово в строке палиндромом:");
            if(scanner.hasNextInt()){
                int enterNumberWord = scanner.nextInt() - 1;
                if(enterNumberWord <= words.length){
                    StringBuilder result = new StringBuilder(words[enterNumberWord]);
                    if(words[enterNumberWord].equalsIgnoreCase(result.reverse().toString())){
                        System.out.println(words[enterNumberWord] + " - палиндром!");
                    } else {
                        System.out.println(words[enterNumberWord] + " - не палиндром!");
                    }
                } else {
                    System.out.println("Введеное число больше длины строки!");
                }
            }else {
                System.out.println("Введите целое число!");
            }
        }
    }

}
