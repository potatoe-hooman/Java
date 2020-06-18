/*
Problem Statement
https://hackerrank-challenge-pdfs.s3.amazonaws.com/27196-game-with-cells-English?AWSAccessKeyId=AKIAJ4WZFDFQTZRGO3QA&Expires=1592470477&Signature=96zTOoOq5zz036mPGXdqon9VXlM%3D&response-content-disposition=inline%3B%20filename%3Dgame-with-cells-English.pdf&response-content-type=application%2Fpdf
*/

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the gameWithCells function below.
     */
    static int gameWithCells(int n, int m) {
        /*
         * Write your code here.
         */
         int l = n/2; int k=m/2;
         int lk=l*k;
         int sq= 4*lk;
         int rem= n*m-sq;
         if(rem == 0)
            return lk;
         else{
             int ex = rem/2;
             if (rem%2==0) lk=lk+ex;
             else lk=lk+ex+1;
             }

        return lk;
        }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int result = gameWithCells(n, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
