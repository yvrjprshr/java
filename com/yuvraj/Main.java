package com.yuvraj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    Scanner sc = new Scanner(System.in);

    public void tc() {
        int n = sc.nextInt();
        String td = sc.next();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.next());
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            String t = arr.get(i);
            if (t.equals(td)) {
                ans.add(i + 1);
            } else {

                // checking inserting character at 1st position or last
                String sub1 = td.substring(1);
                String sub2 = td.substring(0, td.length() - 1);
                // System.out.println(xx+" "+yy);
                if (sub1 == t || sub2 == t) {
                    ans.add(i + 1);
                    System.out.println("xx==sd|yy==sd");
                    continue;
                }

                // checking deleted character
                int a = 0;
                int b = 0;
                int times = 0;
                boolean flag = true;

                if (td.length() - 1 == t.length()) {
                    while (a < td.length()) {
                        if (td.charAt(a) == t.charAt(b)) {
                            a++;
                            b++;
                        } else if (times == 0) {
                            a++;
                            times++;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        System.out.println("deleted character");
                        ans.add(i + 1);
                        continue;
                    }
                }

                // checking changing 1 charcter
                a = 0;
                b = 0;
                times = 0;
                flag = true;

                if (td.length() == t.length()) {
                    while (a < td.length()) {
                        if (td.charAt(a) == t.charAt(b)) {
                            a++;
                            b++;
                        } else if (times == 0) {
                            times++;
                            a++;
                            b++;
                        } else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        ans.add(i + 1);
                    }
                }
            }
        }

        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 1;
        // n = sc.nextInt();
        Main tj = new Main();
        while (n-- > 0) {
            tj.tc();
        }
    }
}