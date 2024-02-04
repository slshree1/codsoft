import java.util.Scanner;
import java.util.ArrayList;

class userAccount{
    Scanner sc=new Scanner(System.in);
    public int AccountNo, balance;
    public String password, name, mobile;

    public void create_account_data(int tempaccno){
		AccountNo=tempaccno;
		System.out.println("\n\n\n\n");
		System.out.print("Enter the account holder name: ");
		name=sc.nextLine();
		balance=0;
		System.out.print("Enter the Mobile No :");
		mobile=sc.nextLine();
		System.out.print("Enter the Password for you Account: ");
		password=sc.nextLine();
        System.out.println("\n\nYour account no is : "+AccountNo);
        System.out.println("Remember the account Number to do later transactions. it will be required.");
		System.out.println("account created succesfully");
		// System.out.println("\n");
	}

    public void viewAccounts(){
        System.out.println("\n\nAccount No: "+AccountNo);
        System.out.println("Name: "+name);
        System.out.println("Mobile No: "+mobile);
        System.out.println("Balance: "+balance);
        System.out.println("Name: "+password);
    }

    public void display_balance(){
        System.out.println("\n\n\n\n");
        System.out.print("Enter the password:");
        String temppass=sc.nextLine();
        int cond=temppass.compareTo(password);
        // System.out.println(cond);
        if(cond==0){
            System.out.println("Hello "+name+" sir");
		    System.out.println("Your Current Account Balance is: "+balance);
        }
        else{
            System.out.println("Wrong Password, try again");
        }
		System.out.println("\n");
	}
	public void deposite_amount(){
		System.out.println("\n");
        System.out.print("Enter the password:");
        String temppass=sc.nextLine();
        int cond=temppass.compareTo(password);
        // System.out.println(cond);
        if(cond==0){
            System.out.print("Enter the amount you want to deposite: ");
		    balance+=sc.nextInt();
		    sc.nextLine();
        }
        else{
            System.out.println("Wrong Password, try again");
        }
		System.out.println("\n");
	}
	public void withdraw_amount(){
		System.out.println("\n");
        System.out.print("Enter the password:");
        String temppass=sc.nextLine();
        int cond=temppass.compareTo(password);
        // System.out.println(cond);
        if(cond==0){
            System.out.print("Enter the amount to withdraw: ");
		    int tempbal=sc.nextInt();
            if(tempbal<=balance){
                balance-=tempbal;
            }
            else{
                System.out.println("You dont have enough balance to withdraw.");
            }
		    
        }
        else{
            System.out.println("Wrong Password, try again");
        }
        sc.nextLine();
		System.out.println("\n");
	}
	
	public void transfer_amount(userAccount obj){
        System.out.print("Enter the password:");
        String temppass=sc.nextLine();
        int cond=temppass.compareTo(password);
        // System.out.println(cond);
        if(cond==0){
            System.out.print("Enter the amount to transfer: ");
		    int temp=sc.nextInt();
            if(temp<=balance){
                balance-=temp;
                sc.nextLine();
                obj.balance+=temp;
            }
		    else{
                System.out.println("You dont have enough balance to transfer");
            }
        }
        else{
            System.out.println("Wrong Password, try again");
        }
	}
}
class ATM extends userAccount{
    public static void main(String args[]){
        // int total_accounts=2;
		int account_pointer=1;
		userAccount[] accountList=new userAccount[100];
        Scanner sc=new Scanner(System.in);
        int mainmenue;
        int adminmenue;
        int loop1=0, loop2=0, loop3=0;
        int accounttype=0;
        String adminpass="Admin", enteredpass;
        int user_input_acc_no, user_input_acc_no1;
        
        System.out.println("\n\n\nThis system is not connected with the database then whatever you made processes");
        System.out.println("the data will remains in the execution loop or time, when you exits the system ");
        System.out.println("The data will be lost");

        int xyz=0;
        while(true){
            System.out.println("\n\nTo select the option enter the number front of the option...");
            System.out.println("1: Continue to ATM Machine>>>>>>");
            System.out.print("Enter the option: ");
            xyz=sc.nextInt();
            if(xyz==1){
                break;
            }
            else{
                System.out.println("\nWrong choice, Enter again...");
            }
        }

        while(true){
            while(true){
                System.out.println("\n1: Admin\n2: User\n3: Exit");
                System.out.print("Enter the account type:");
                accounttype=sc.nextInt();
                if(accounttype>0 && accounttype<=3){
                    break;
                }
                else{
                    System.out.println("\nWrong choice, select again....");
                }
            }
            if(accounttype==1){
                while(true){
                    sc.nextLine();
                    for(int i=0; i<4;i++){
                        loop2=0;
                        System.out.println("For your understanding Use Password : Admin");
                        System.out.print("Enter Admin Password:");
                        enteredpass=sc.nextLine();
                        if(enteredpass.compareTo(adminpass)==0){
                            System.out.println("Login successful.");
                            break;
                        }
                        else{
                            System.out.println("\nWrong Password.....");
                            System.out.println("Try again");
                        }
                        if(i==3){
                            System.out.println("You Lost your 4 Chances....\n\n");
                            loop2=1;
                            break;
                        }
                    }
                    if(loop2==1){
                        break;
                    }
                    
                    while(true){
                        while(true){
                            System.out.println("\n\n1: Create Account\n2: View Accounts\n3: Exit");
                            System.out.print("Enter the choice:");
                            adminmenue=sc.nextInt();
                            if(adminmenue>0 && adminmenue<=3){
                                break;
                            }
                            else{
                                System.out.println("Wrong choice, choose again.");
                            }
                        }
                        switch(adminmenue){
                            case 1:{
                                // createAccount();
                                int tempaccno=account_pointer-1;
					            accountList[tempaccno]=new userAccount();
					            accountList[tempaccno].create_account_data(tempaccno);
					            // total_accounts++;
					            account_pointer++;
                                System.out.println("The case 1 is completed");
                                break;
                            }
                            case 2:{
                                //view accounts
                                System.out.println("-------------------------------");
                                for(int i=0; i<(account_pointer-1); i++){
                                    accountList[i].viewAccounts();
                                }
                                System.out.println("-------------------------------");
                                break;
                            }
                            case 3:{
                                break;
                            }
                        }
                        if(adminmenue==3){
                            loop3=1;
                            break;
                        }
                    }
                    if(loop3==1){
                        break;
                    }
                }
            }
            if(accounttype==2){  
                while(true){ 
                    while(true){
                        System.out.println("\n1: Withdraw\n2: Deposite\n3. Transfer\n4: Check Balance\n5: Exit");
                        System.out.print("Enter the choice:");
                        mainmenue=sc.nextInt();
                        if(mainmenue>0 && mainmenue<6){
                            break;
                        }
                        else{
                            System.out.println("Wrong choice, choose again.");
                        }
                    }

                    switch(mainmenue){
                        case 1:{
                            // withdraw();
                            System.out.print("Enter the account number: ");
                            int ack=0;
					        user_input_acc_no=sc.nextInt();
                            if(user_input_acc_no<account_pointer-1){
                                accountList[user_input_acc_no].withdraw_amount();
                            }
					        else{
                                System.out.println("\n\nThe account is not exists.");
                            }
                            break;
                        }
                        case 2:{
                            // deposite();
                            System.out.print("Enter the account number: ");
					        user_input_acc_no=sc.nextInt();
                            if(user_input_acc_no<account_pointer-1){
                                accountList[user_input_acc_no].deposite_amount();
                            }
					        else{
                                System.out.println("The account is not exist.");
                            }
                            break;
                        }
                        case 3:{
                            // transfer();
                            System.out.println("Enter your account number: ");
					        user_input_acc_no=sc.nextInt();
					        sc.nextLine();
                            if(user_input_acc_no<account_pointer-1){
                                System.out.println("Enter the account number you want to transfer the amount: ");
					            user_input_acc_no1=sc.nextInt();
					            sc.nextLine();
                                if(user_input_acc_no1<account_pointer-1){
                                    accountList[user_input_acc_no].transfer_amount(accountList[user_input_acc_no1]);
                                }
                                else{
                                    System.out.println("The account is not exists.");
                                }
					            
                            }
                            else{
                                System.out.println("The account is not exists.");
                            }
                            break;
                        }
                        case 4:{
                            // checkbalance();
                            System.out.print("Enter the account Number: ");
					        user_input_acc_no=sc.nextInt();
					        sc.nextLine();
                            if(user_input_acc_no<account_pointer-1){
                                accountList[user_input_acc_no].display_balance();
                            }
                            else{
                                System.out.println("The account is not exists.");
                            }
                            break;
                        }
                        case 5:{
                            loop1=1;
                            break;
                        }
                    }
                    if(loop1==1){
                        break;
                    }
                }
            }
            if(accounttype==3){
                break;
            }
        }
    }
}
