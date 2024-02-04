import java.util.Scanner;
import java.util.Random;
class GuessingGame{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Random rand=new Random();
        // int ra=rand.nextInt(100);
        // System.out.println(ra);
        int computerguess;
        int userguess;
        int round=0;
        String PlayerName="";
        int ifcond1;
        int b1=0, b2=0, b3=0;

        while(true){
            while(true){
                System.out.println("1: Play Game.");
                System.out.println("2: Exit.");
                System.out.print("Enter the choice: ");
                ifcond1=sc.nextInt();
                if(ifcond1>0 && ifcond1<=2){
                    break;
                }
                else{
                    System.out.println("Wrong choice, Enter Again");
                }
            }

            if(ifcond1==1){
                System.out.print("Enter the Name: ");
                sc.nextLine();
                PlayerName=sc.nextLine();
                System.out.println("\n\nRules and Regulations.");
                System.out.println("1: Gussed number need to between 1 to 100.");
                System.out.println("2: You have only 5 chances to guess the number.");
                System.out.println("3: You can use 5 rounds.");
                System.out.println("4: In each round the guessing number will be changed");

                while(true){
                    round=0;
                    b1=0;
                    b2=0;
                    while(true){
                        round++;
                        computerguess=rand.nextInt(1,100);
                        for(int i=1; i<=7;i++){
                            while(true){
                                System.out.print("\nGuess The number:");
                                userguess=sc.nextInt();
                                if(userguess>0 && userguess<=100){
                                    break;
                                }
                                else{
                                    System.out.println("You Entered the number out of the range");
                                }
                            }
                            if(userguess==computerguess){
                                System.out.println("***** Congratualations "+PlayerName+" *****");
                                System.out.println("You guessed Correct Number");
                                System.out.println("You used:");
                                System.out.println("Rounds: "+round);
                                System.out.println("chances in last round: "+i);
                                System.out.println("Your Score: "+calculate_Score(round, i));
                                System.out.println("\n\n");
                                b2=1;
                                break;
                            }
                            else{
                                System.out.println("Wrong guess...!");
                                if(userguess<computerguess){
                                    System.out.println("Guess is less than the Number.");
                                }
                                if(userguess>computerguess){
                                    System.out.println("Guess is greater than the Number.");
                                }
                            }
                            
                        }

                        if(b2==1){
                            break;
                        }
                        System.out.println("You Lost all your chances.");
                        int playagaincond;
                        while(true){
                            System.out.println("1: Play Again using next round.\n2: Exit");
                            System.out.print("Enter the choice: ");
                            playagaincond=sc.nextInt();
                            if(playagaincond>0 && playagaincond<3){
                                break;
                            }
                            else{
                                System.out.println("You Entered Wrong choice, Enter again.");
                            }
                        }
                        if(playagaincond==1){
                            continue;
                        }
                        if(playagaincond==2){
                            b1=1;
                            break;
                    
                        }
                    }
                    int ch1;
                    while(true){
                        System.out.println("\n\n1: Play Again.\n2: Exit");
                        System.out.print("Enter the choice:");
                        ch1=sc.nextInt();
                        if(ch1>0 && ch1<3){
                            break;
                        }
                        else{
                            System.out.println("You entered wrong choice, Enter again.");
                        }
                    }
                    if(ch1==2){
                        b1=1;
                    }

                    if(b1==1){
                        System.out.println("Thank You for playing our game.");
                        System.out.println("You logouted "+PlayerName+"\n\n");
                        break;
                    }
                }
            }
            else{
                break;
            }
        }
    }

    static int calculate_Score(int round, int chance){
        int score=0;
        switch(round){
            case 1:{
                switch(chance){
                    case 1:
                        score=100;
                        break;
                    case 2:
                        score=96;
                        break;
                    case 3:
                        score=92;
                        break;
                    case 4:
                        score=88;
                        break;
                    case 5:
                        score=84;
                        break;
                    case 6:
                        score=80;
                        break;
                }
                break;
            }
            case 2:{
                switch(chance){
                    case 1:
                        score=76;
                        break;
                    case 2:
                        score=72;
                        break;
                    case 3:
                        score=68;
                        break;
                    case 4:
                        score=64;
                        break;
                    case 5:
                        score=60;
                        break;
                    case 6:
                        score=56;
                        break;
                }
                break;
            }
            case 3:{
                switch(chance){
                    case 1:
                        score=52;
                        break;
                    case 2:
                        score=48;
                        break;
                    case 3:
                        score=44;
                        break;
                    case 4:
                        score=40;
                        break;
                    case 5:
                        score=36;
                        break;
                    case 6:
                        score=32;
                        break;
                }
                break;
            }
        }
        return score;
    }
}

