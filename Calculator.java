import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Calculator {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome to My Calculator");
        double num1=0;
        double num2=0;
        ArrayList<Double> results=new ArrayList<>();
        do{

            System.out.println("_______________");
            System.out.println("Enter 1 to addition the numbers");
            System.out.println("Enter 2 to subtraction the numbers");
            System.out.println("Enter 3 to multiplication the numbers");
            System.out.println("Enter 4 to division the numbers");
            System.out.println("Enter 5 to modulus the numbers");
            System.out.println("Enter 6 to find minimum number");
            System.out.println("Enter 7 to find maximum number");
            System.out.println("Enter 8 to find the average of numbers");
            System.out.println("Enter 9 to print the last result in calculator");
            System.out.println("Enter 10 to print the list of all results in calculator");
            System.out.println("Enter -1 to exit calculator");
            System.out.println("_______________");

            System.out.print("Enter operation option number:");
            int option=input.nextInt();

            if(option==-1){
                System.out.println("Thank you , see you later!");
                break;
            }

            while(true) {
                try {
                   if(option==9 || option==10)break;
                   // System.out.println("Enter two number or -1 to quite");
                    System.out.print("Enter the first number:");
                    num1 = input.nextDouble();
                    System.out.print("Enter the second number:");
                    num2 = input.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("numbers only accepted");
                    input.next();
                }
            }

            switch (option){
                case 1:
                    System.out.println(num1+ " + "+num2+" = "+(num1+num2));
                    results.add((num1+num2));
                    break;
                case 2:
                    System.out.println(num1+ " - "+num2+" = "+(num1-num2));
                    results.add((num1-num2));
                    break;
                case 3:
                    System.out.println(num1+ " * "+num2+" = "+(num1*num2));
                    results.add((num1*num2));
                    break;
                case 4:
                    if(num2==0) {
                        System.out.println("Cannot divide by zero.");
                        continue;
                    }else{
                        System.out.println(num1+ " / "+num2+" = "+(num1/num2));
                        results.add((num1/num2));
                    }
                    break;
                case 5:
                    System.out.println(num1+ " % "+num2+" = "+(num1%num2));
                    results.add((num1%num2));
                    break;
                case 6:
                    results.add(findMin(num1,num2));
                    break;
                case 7:
                    results.add(findMax(num1,num2));
                    break;
                case 8:
                    System.out.println("average  "+num1+"+"+num2+"/2 ="+(num1+num2)/2);
                    results.add(((num1+num2)/2));
                    break;
                case 9:
                   printLast(results);
                    break;
                case 10:
                    printList(results);
                    break;




            }




        }while(num1 != -1 );
    }



   public static void  addition(double num1,double num2, ArrayList<String> arr){
        arr.add(""+num1+ " + "+num2+" = "+(num1+num2));
   }

   public static double findMax(double num1,double num2){
       if(num1==num2){
           System.out.println(num1+" == "+num2);
           return num1;
       }
       if(num1>num2){
           System.out.println(num1+" > "+num2);
           return num1;
       }
       else{
           System.out.println(num2+" > "+num1);
           return num2;
       }
   }

    public static double findMin(double num1,double num2){
        if(num1==num2){
            System.out.println(num1+" == "+num2);
            return num1;
        }
        if(num1<num2){
            System.out.println(num1+" < "+num2);
            return num1;
        }
        else{
            System.out.println(num2+" < "+num1);
            return num2;
        }
    }

    public static void printList(ArrayList<Double>results){
        if (results.size()==0){
            System.out.println("There is no data");
        }else {
            System.out.println("list of all results in calculator");
            for (Double result : results) {
                System.out.println(result);
            }
        }
    }

    public static void printLast(ArrayList<Double>results){
        if (results.size()==0){
            System.out.println("There is no data");
        }else {
            System.out.print("Last result:");
                System.out.println(results.get(results.size()-1));
        }
    }
}