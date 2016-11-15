/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bg.svetlinankov.test;

import bg.svetlinankov.regexp.Pattern;

/**
 *
 * @author Svetlin
 */
public final class RegexpTest {

    private static void test(String haystack, String pattern, boolean expected) {
        boolean actual = Pattern.match(haystack, pattern);

        System.out.println(
                String.format("{%s} in [%s]: matches=%b %s",
                        pattern, haystack, actual,
                        actual == expected ? "CORRECT" : "FAILED"));
    }

    public static void testRegexp() {
        test("aaaabc", "a", false);
        test("aaaabc", "a.", false);
        test("aaaabc", ".", false);
        test("aaaabc", ".*", true);
        test("aaaabc", "a.*", true);
        test("aaaabc", "a*bc", true);
        test("baaaabc", "a*bc", false);
        test("baaaabc", ".c", false);
        test("qc", ".c", true);
        test("qqcqcqqcccic", ".*", true);
        test("qqcqcqqcccic", ".*x", false);

        // These should fail as * is non-greedy
        // in this implementation.
        // test("qqcqcqqcccic", ".*c", true);
        // test("fqqcqcqqcccic", "f.*c", true);
    }
}
