package fr.epita.assistants;

import fr.epita.assistants.classics.Classics;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int expected = 120;
        if (Classics.factorial(n) != expected)
            System.err.println("Error factorial("+ n +") " +
                    "-> Actual: " + Classics.factorial(5) + " Expected: " + expected);

        // FIXME: Add more tests here
        int m=15;
        int exp=3136;
        if (Classics.tribonacci(m) != exp)
            System.err.println("Error Tribonnaci("+ m +") " +
                    "-> Actual: " + Classics.tribonacci(m) + " Expected: " + exp);


        String str = "Ple";
        int [] arr={10,9,3,4,12};
        System.out.print(Classics.isPalindrome(str));
        Classics.insertionSort(arr);
        for(int i=0;i<5;i++)
            System.out.print(arr[i]);

        System.out.print(Classics.combine("abc","123"));

    }
}
