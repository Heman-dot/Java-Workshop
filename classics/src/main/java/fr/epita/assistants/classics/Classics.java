package fr.epita.assistants.classics;

public class Classics {
    /**
     * Computes the factorial of n.
     * @param n the nth value to compute, negative values should return -1
     *
     * @return the long value of n!
     */
    public static long factorial(int n) {
        /* FIXME */
        if(n<0)
            return -1;
        if(n >=1){
            return n * factorial(n-1);
        }
        else
            return 1;
    }

    /**
     * Computes the nth value of the tribonacci suite.
     * f(0) = 0, f(1) = 1, f(2) = 1, f(n+3) = f(n) + f(n+1) + f(n+2)
     *
     * @param n the nth sequence to compute
     */
    public static long tribonacci(int n) {
        /* FIXME */
        if (n<0)
            return -1;
        if (n==0)
            return 0;
        if(n<3)
            return 1;

        long a=0,b=1,c=1,next;
        for(int i=3;i<=n;i++){
            next=a+b+c;
            a=b;
            b=c;
            c=next;
        }
        return c;
    }

    /**
     * Checks if a word is a palindrome.
     *
     * @param word the string to check
     * @return true if the word is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String word) {
        /* FIXME */
        if(word == null)
            return false;
        String str=word.replaceAll("\\s","").toLowerCase();
        int left =0;
        int right = str.length()-1;
        while(left < right){
            if(str.charAt(left)!=str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Sorts an array using an insertion sort.
     *
     * @param array the array to sort in place
     * @return
     */
    public static void insertionSort(int[] array) {
        /* FIXME */
        int n= array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }

    /**
     * Combines two strings by alternating their characters. Must use a StringBuilder.
     * If the strings do not have the same length, appends the remaining characters at the end of the result.
     * For instance, combine("abc", "def") returns "adbecf"
     */
    public static String combine(String a, String b) {
        /* FIXME */
        StringBuilder res = new StringBuilder();
        int l1= a.length();
        int l2 = b.length();
        int max = Math.max(l1,l2);
        for(int i=0;i<max;i++){
            if(i<l1){
                res.append(a.charAt(i));
            }
            if(i<l2){
                res.append(b.charAt(i));
            }
        }
        return res.toString();

    }
}
