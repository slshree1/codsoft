import java.util.Scanner;
class Student_Grade_Calculator{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the total numbers of subjects");
        int totalsub=sc.nextInt();
        int marks[]=new int[totalsub];
        int totalmarks=0;
        System.out.println("Enter the marks between 0 to 100.");
        for(int i=1; i<=totalsub; i++){
            System.out.print("Enter the marks of subject "+i+": ");
            marks[i-1]=sc.nextInt();
            totalmarks+=marks[i-1];
        }
       
        int avgmarks=totalmarks/totalsub;
        char grade;
        if(avgmarks>80){
            grade='A';
        }
        else if(avgmarks>60){
            grade='B';
        }
        else if(avgmarks>40){
            grade='C';
        }
        else if(avgmarks>20){
            grade='D';
        }
        else{
            grade='F';
        }

        System.out.println("\n\n");
        System.out.println(" ____________________________________________");
        System.out.println("|                                            |");
        System.out.println("|****************** Result ******************|");
        System.out.println("|* ________________________________________ *|");
        System.out.println("|*|                                        |*|");
        if(totalmarks<100){
            System.out.println("|*|  TotalMarks            |  "+totalmarks+"           |*|");
        }
        else{
            System.out.println("|*|  TotalMarks            |  "+totalmarks+"          |*|");
        }
        System.out.println("|*|----------------------------------------|*|");
        System.out.println("|*|  Average Percentage    |  "+avgmarks+"           |*|");
        System.out.println("|*|----------------------------------------|*|");
        if(grade=='F'){
            System.out.println("|*|  Grade                |  F(Fail)       |*|");
        }
        else{
            System.out.println("|*|  Grade                 |  "+grade+"            |*|");
        }
        System.out.println("|*|________________________________________|*|");
        System.out.println("|*                                          *|");
        System.out.println("|********************************************|");
        System.out.println("|____________________________________________|");
    }
}