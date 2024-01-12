import java.util.Random;
import java.util.Scanner;

public class main {

    public static void rpsGame(){
        String[] choices={"Rock","Paper","Scissors"};

        Random random = new Random();
        int computerChoiceIndex= random.nextInt(choices.length);
        String computerChoice=choices[computerChoiceIndex];

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice (Rock, Paper, or Scissors): ");
        String userChoice=scanner.nextLine();

        System.out.print("\n\nYour Choice is: " + userChoice);
        System.out.print("\nComputer Choice is: " + computerChoice+"\n\n");


        if(userChoice.equalsIgnoreCase(computerChoice)){
            System.out.println("It's a tie"); 
        }
        else if( (computerChoice.equalsIgnoreCase("Rock") && userChoice.equalsIgnoreCase("Paper")) ||
                 (computerChoice.equalsIgnoreCase("Paper") && userChoice.equalsIgnoreCase("Scissors"))||
                 (computerChoice.equalsIgnoreCase("Scissors") && userChoice.equalsIgnoreCase("Rock"))   ){

                    System.out.println("You Win!!!!");
        }
        else{
             System.out.println("Computer Win!!!!");
        }

    }


    public static void guessGame(){
        int guessNo;
        int secretN0;
        int attmpt=1;

        Random random = new Random();
        secretN0 = random.nextInt(100)+1;

        Scanner scanner = new Scanner(System.in);
       

        do{
           
            System.out.println("Guess a number between 1 and 100");
            guessNo = scanner.nextInt();
            if(guessNo>secretN0){
                System.out.println("Your guessed no "+ guessNo +" is greater than secret no");
            }else if(guessNo<secretN0){
                System.out.println("Your guessed no "+ guessNo +" is less than secret no");
            }

            attmpt++;
        }while (guessNo!=secretN0);
            
        

        System.out.println("You guessed it right in "+attmpt+" attempts");
    }

    public static void printLeftTriangle(){
        for(int i=0; i<5; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printRightTriangle(){
        for(int i=0;i<5;i++){
            for(int k=0; k<5-i;k++){
                System.out.print("  ");
            }
            for(int j=0;j<=i;j++){
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
       rpsGame();
    }
}
