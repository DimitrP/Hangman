import java.util.Random;
import java.util.Scanner;

public class GuessOrBeHanged {

    static String animals[] = ReadFromFile.readMe();


    static Random random = new Random();
    static int position = random.nextInt(animals.length);
    static int word_length = animals[position].length();
    static String realWord = animals[position];
    static String tryToGuess = " ";
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        String mystery = new String(new char[animals[position].length()]).replace("\0", "*");

        int attemps = word_length*2;

        System.out.println(mystery);
        System.out.println("This is a prompt. You are guessing this word " + realWord.toUpperCase());
        String string = mystery;
        while (attemps > 0 && mystery.contains("*")) {
            System.out.println("Please try to guess a letter. You have "+ attemps + " attemps !");
            tryToGuess = scanner.next();
            System.out.println(checkTheWord(realWord, mystery, tryToGuess));
            mystery = checkTheWord(realWord, mystery, tryToGuess);
            attemps--;

            // вызов метода checkTheWord пердача ему трех парметров
            // этот метод должен вернуть новую строку в которой будут * и буквы
            //вывод на печать результата заново
        }

        if(attemps==0)
        {
            System.out.println("GOOD BYE !");
            Thread.sleep(200);
            System.out.println("   ____________");
            Thread.sleep(200);
            System.out.println("   |          _|_");
            Thread.sleep(200);
            System.out.println("   |         /   \\");
            Thread.sleep(200);
            System.out.println("   |        |     |");
            Thread.sleep(200);
            System.out.println("   |         \\_ _/");
            Thread.sleep(200);
            System.out.println("   |          _|_");
            Thread.sleep(200);
            System.out.println("   |         / | \\");
            Thread.sleep(200);
            System.out.println("   |          / \\ ");
            Thread.sleep(200);
            System.out.println("___|___      /   \\");
            Thread.sleep(200);
            System.out.println("The word was " + realWord.toUpperCase());

        }
        else
            System.out.println("You won !\n We will hang you next time");

    }


    public static String checkTheWord(String realWord, String mysteryWord, String tryToGuess) {
        //creates new string and retuns it
        stringBuilder = new StringBuilder();

        for (int i = 0; i < word_length; i++) {
            String tempRealSubstring = realWord.substring(i,i+1);
            String tempMysterySubstring = mysteryWord.substring(i,i+1);

            if (!tempMysterySubstring.equals("*")) {

                stringBuilder.append(tempMysterySubstring);
                continue;
            }

            if (tempRealSubstring.equals(tryToGuess)) {
                stringBuilder.append(tryToGuess);

            } else
                stringBuilder.append("*");


        }

        return stringBuilder.toString();
    }
}