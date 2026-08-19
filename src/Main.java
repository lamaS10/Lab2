import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        //Q1
//        String[] words={"cat","dog","red","is","am"};
        System.out.print("please enter how many words want to enter: ");
        int countWord=input.nextInt();
        input.nextLine();

        String[] words=new String[countWord];

        for (int i=0;i<countWord;i++){
            System.out.print("please enter a word:  ");
            String Word=input.nextLine();
            words[i]=Word;
        }

        int lenghtlongest=0;
        //first check what the longest lenth in the arrsy
        for (String word: words){
            if (word.length()>lenghtlongest){
                lenghtlongest=word.length();
            }
        }

        //print the longest lentgh that we find
        for (String word1:words){
            if (word1.length()==lenghtlongest){
                System.out.println(word1);
            }
        }

        //Q2
        System.out.println("----------------------------------------------------------------------------");

        int[] numbers={1,1,1,3,3,5};
        //اراي ليست حتى نضيف فيها الاعداد الي عديناها وتحققنا منها حتى مايعير طابعة جملة طباعه
        ArrayList<Integer>checknum=new ArrayList<>();

        for (int i=0;i<numbers.length;i++){
            if(!checknum.contains(numbers[i])){
                int count=0;

                //ياخذ اول رقم من لوب اول ويبدأ يشيك عليه بلوب ثانيه عبر كل أرقام
                for (int n=0;n<numbers.length;n++){
                    if(numbers[i]==numbers[n]){
                        count++;
                    }
                }

                System.out.println(numbers[i]+" occurs "+count+" Times");
                checknum.add(numbers[i]);
            }
        }

        //Q3
        System.out.println("----------------------------------------------------------------------------");

        ArrayList<Integer> numbers1=new ArrayList<>();

        System.out.print("please enter how many numbers want to enter: ");
        int countnumber=input.nextInt();

        for (int i=0;i<countnumber;i++){
            System.out.print("please enter a number: ");
            int num=input.nextInt();
            numbers1.add(num);
        }

        numbers1.sort(null);
        int k=3;
        for (int i=numbers1.size()-1;i>=numbers1.size()-k;i--){
            System.out.print(numbers1.get(i)+" ");
        }
        System.out.println("");
        //Q4
        System.out.println("----------------------------------------------------------------------------");
        int[] numbers2={5,4,3,2,1};

        reversArray(numbers2);
        for (int num:numbers2){
            System.out.print(num);
        }

        //Q5
        System.out.println("----------------------------------------------------------------------------");

        System.out.print("Please enter the size of array");
        int size=input.nextInt();

//        ArrayList<Integer> numbers3 = new ArrayList<>();
        int[]numbers3=new int[size];
        int choice;
        do{
            System.out.println("1. Accept Elements.");
            System.out.println("2. Display Elements.");
            System.out.println("3. Search the element within array.");
            System.out.println("4. Sort the array.");
            System.out.println("5. Stop program.");

            System.out.println("Please enter your choice: ");
            choice=input.nextInt();

            switch (choice){
                case 1:
                    for (int i = 0; i < size; i++) {
                        System.out.print("Enter number"+(i+1)+": ");
                        int number9=input.nextInt();
                        numbers3[i]=number9;
                    }
                    break;
                case 2:
                    for (int num:numbers3){
                        System.out.print(num);
                    }
                    break;
                case 3:
                    System.out.print("what element want to Search: ");
                    int chearchNum=input.nextInt();

                    boolean isFound=false;
                    for (int num:numbers3){
                        if (num == chearchNum) {
                            isFound=true;
                            break;
                        }
                    }

                    if(isFound){
                        System.out.println("The element ("+chearchNum+") is found in array");
                    }else {
                        System.out.println("The element ("+chearchNum+") is not found in array");
                    }
                    break;
                case 4:
                    Arrays.sort(numbers3);
                    for (int num:numbers3){
                        System.out.print(num);
                    }
                    System.out.println("The array is sorted!");
                    break;
            }


        }while (choice!=5);

        //Q6
        System.out.println("----------------------------------------------------------------------------");

        System.out.print("Enter min number: ");
        int min = input.nextInt();

        System.out.print("Enter max number: ");
        int max = input.nextInt();

        System.out.print("How many random numbers do you want: ");
        int countRandom = input.nextInt();

        generateRandomNumber(min, max, countRandom);

        //Q7
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter a password: ");
        String password = input.nextLine();

        int totalScore =checkLength(password)+checkSpecialCharacters(password)+checkUpperCaseLowerCase(password);

        if (totalScore >= 8) {
            System.out.println("Password is strong");
        } else if (totalScore >= 5) {
            System.out.println("Password is moderately strong");
        } else {
            System.out.println("Password is weak");
        }

        //q8
        System.out.println("----------------------------------------------------------------------------");
        System.out.print("Enter the number of Fibonacci terms to generate: ");
        int numbeer = input.nextInt();

        generateFibonacci(numbeer);






    }
    //reverse array
    public static void reversArray(int[] numbers) {

        for (int i = 0; i < numbers.length / 2; i++) {
            //نحفظ اول قيمة بمتغير حتى اقدر اعطيه لاخر قيمة
            int tempNumber = numbers[i];

            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = tempNumber;
        }
    }

    //generate Random Number
    public static void generateRandomNumber(int min,int max,int countNumber){
        Random random = new Random();
        for (int i = 0; i < countNumber; i++) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            System.out.println((i+1)+" random number is: "+randomNumber);
        }
    }
    //check lenght of password
    public static int checkLength(String password) {

        if (password.length() >= 8) {
            return 3;
        } else if (password.length() >= 6) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int checkSpecialCharacters(String password) {

        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i))) {
                return 2;
            }
        }
        return 0;
    }

    public static int checkUpperCaseLowerCase(String password) {

        boolean hasUpper = false;
        boolean hasLower = false;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUpper = true;
            }
            if (Character.isLowerCase(password.charAt(i))) {
                hasLower = true;
            }
        }

        if (hasUpper && hasLower) {
            return 3;
        }
        return 0;
    }

    //generateFibonacci method
    public static void generateFibonacci(int number) {
        int firstNumber=0;
        int secondNumber=1;

        for (int i = 0; i < number; i++) {
            System.out.print(firstNumber);

            int nextNumber= firstNumber+secondNumber;
            firstNumber=secondNumber;
            secondNumber=nextNumber;
        }
    }
}

