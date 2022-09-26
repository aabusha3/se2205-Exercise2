package Q1L2;


import java.util.*;

public class Student_Leader_List {

    public static Scanner keyBoard = new Scanner(System.in);//the input method for the user
    public static int intInputAndValidation(String inputMessage) { //asks for and returns an integers; gives error message if non-integer is entered
        int _int;
        while (true) {//runs infinitely
            try {//tries for integers
                System.out.println(inputMessage);
                System.out.print(" >:\t");
                _int = keyBoard.nextInt();
                if (_int != 2 && _int != 3 && _int != 4)
                    throw new Exception();

                break;  //the only way out of the infinite loop
            } catch (InputMismatchException e) {//catches non-integers, gives a "what went wrong" message and loops
                System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                System.out.println("Please Only Enter In INTEGERS\n");
                keyBoard.next();
            } catch (Exception e) {
                System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                System.out.println("Please Only Enter In 2, 3, Or 4\n");
            }
        }
        return _int;
    }

    public static void main(String[] args) {
        myHeader(2,1);


        ArrayList<Integer> values = new ArrayList(Arrays.asList(2, 3, 4, 3, 2, 2));
        ArrayList<String> keys = new ArrayList(Arrays.asList("Harry", "Lavender", "Ron", "Hermione", "Luna", "Vincent"));
        Pair[] pairing = new Pair[keys.size()];

        for (int index = 0; index < pairing.length; index++) {
            pairing[index] = new Pair(keys.get(index), values.get(index));
        }

        do {
            System.out.println();
            int yearValue = intInputAndValidation("Choose An Academic Year You Would Like To List The Leaders' Names Of");
            ArrayList<Integer> intCount = new ArrayList<>();
            for (int index = 0; index < pairing.length; index++)
                if (pairing[index].getValue().equals(Integer.valueOf(yearValue)))
                    intCount.add(Integer.valueOf(index));

            System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Ahmad Found " + intCount.size());
            if (intCount.size() != 1)
                System.out.print(" Student Leaders");
            else
                System.out.print(" Student Leader");
            System.out.print(" In Year " + yearValue + "; See List Below:\n");

            ListIterator<Integer> listIterator = intCount.listIterator();
            while (listIterator.hasNext())
                System.out.println("\u2022  " + pairing[listIterator.next()].getKey());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

            System.out.println("Do you want to Continue (y/n)?");
            System.out.print(" >:\t");
        } while(!keyBoard.next().equalsIgnoreCase("n"));


        myFooter();
    }

    //printHeader;  prints a header
    public static void myHeader(int labNum, int quesNum) {
        System.out.println();
        //general lab header
        int n = 81;
        for (int i = 0; i < n; i++) System.out.print("*");    //adds n asterisks
        System.out.println("\n\t\t\t\t\tHello User, My Name Is Ahmad Sami Abu Shawarib\n\t\t\t\t\t\t\tStudent Number: 251149713" +
                "\n\t\t\t\t\t\t Welcome To Lab #" + labNum + "\tQuestion #" + quesNum);
        for (int i = 0; i < n; i++) System.out.print("*");  //adds n asterisks

        //specific lab header
            System.out.println("\n\tThis Code Uses The Generic Type To Accept And Pair Integers With Strings" +
                    "\n To Print Out Student Leaders Names Corresponding To The Year Chosen By The User");
        for (int i = 0; i < n; i++) System.out.print("*");  //adds n asterisks
        System.out.println();
    }

    //printFooter;  prints a footer
    public static void myFooter() {//*****
        System.out.printf("%n%n****************%7s~The Program Has Stopped, GoodBye!~%7s****************", "", "");//matches the length of the n asterisks printed in the myHeader method
    }
}
