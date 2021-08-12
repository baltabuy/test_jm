package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Calc raschet =new Calc();
        raschet.text = console.nextLine();
        raschet.GetResult();
    }
}

