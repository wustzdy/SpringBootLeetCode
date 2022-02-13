package com.wustzdy.spring.boot.leetcode.standard.algorithm.algorithm.leetCode20220213;

/*给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/palindrome-number
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
/*思路
    标签：数学
    如果是负数则一定不是回文数，直接返回 false
    如果是正数，则将其倒序数值计算出来，然后比较和原数值是否相等
    如果是回文数则相等返回 true，如果不是则不相等 false
    比如 123 的倒序 321，不相等；121 的倒序 121，相等

    链接：https://leetcode-cn.com/problems/palindrome-number/solution/hua-jie-suan-fa-9-hui-wen-shu-by-guanpengchn/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。*/
//20220213-01
public class Test_01_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int cur = 0;
        int num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }
}
