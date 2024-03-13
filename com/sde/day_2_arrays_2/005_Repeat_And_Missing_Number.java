package com.sde.day_2_arrays_2;

import java.util.*;

class Solution {
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        long n = A.size();

        long sum = (n * (n + 1)) / 2L;
        long sum_sqr = ((n) * (n + 1) * ((2 * n) + 1)) / 6L;

        for (Integer num : A) {
            long x = (long) num;
            sum = sum - x;
            sum_sqr = sum_sqr - (x * x);
        }

        // now we have
        // x-y
        // x^2 - y^2
        // so make x^2-y^2 => x+y
        // x^2-y^2 = (x+y)(x-y)
        // so divide by (x-y) in (x^2-y^2) to make (x+y)

        long diff_xy = sum;
        long sum_xy = sum_sqr / diff_xy;

        long x = (sum_xy + diff_xy) / 2L;
        long y = (sum_xy - diff_xy) / 2L;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add((int) y);
        ans.add((int) x);

        return ans;
    }
}
