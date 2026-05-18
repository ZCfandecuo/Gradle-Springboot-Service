package com.johnny.singlegradlespringboot.pojo;

import com.johnny.singlegradlespringboot.utils.ConstUtils;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;

public record User(String name, Integer age, String company) {

    public static void main(String[] args) {
        System.out.println(isValid("(){}}{"));
        int[] aa=new int[]{2,1,5,4,6,2,3,3,4,3};
        System.out.println(largestRectangleArea(aa));
//        Map<Integer,Integer> dp=new HashMap<>(11);
//        dp.put(1,3);
//        dp.merge(1,4,Integer::sum);
//        System.out.println(dp.get(1));
//        ArrayList<byte[]> list = new ArrayList<>();
//        for (int i = 0; i < 1000; i++) {
//            byte[] arr = new byte[1024 * 100];//100KB
//            list.add(arr);
//            try {
//                Thread.sleep(120);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(2+4&1);
//        System.out.println(2+(2&1));
//        int[][] people = {{1,3,1},{1,5,1},{4,2,1}};
//        Arrays.sort(people, (p1, p2) -> {
//            if(p1[0] !=p2[0]){
//                return p2[0]-p1[0];
//            }else{
//                return p1[1]-p2[1];
//            }
//        });
        LinkedList<Integer> integers = new LinkedList<>();
//        List<ListNode> list = new LinkedList<>();
//        Collections.sort(integers);

//        System.out.println(longestPalindrome("asdf11adfoj9adffdadq143245daffdaasdfdfdaasdffdassadffdsa"));
//        System.out.println(maxArea(new int[]{1,8,6,8,3,7}));
//        System.out.println(ConstUtils.longestMountain(new int[]{875,884,239,731,723,685}));
//        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        int[] ints = new int[]{};
//        System.out.println(climbStairs(44));
//        int[][] ints = {{1,3,1},{1,5,1},{4,2,1}};
//        int[][] int2 = {{1,2,3},{4,5,6}};
//        System.out.println(minPathSum(int2));
//        System.out.println(hh("abcabcabcabc", "abc"));
                String s = "  hello world  ";
//        System.out.println(uniquePaths(3,2));
//        System.out.println(longestPalindrome1("ac"));
//        LinkedList<String> str = new LinkedList<>();
//        str.pollLast()
//        System.out.println(reverseWords(s));
//        System.out.println(kidsWithCandies(new int[]{1,8,6,8,3,7}, 4));
    }
    private static int hh(String parent, String sub){
        parent = parent.toLowerCase();
        sub = sub.toLowerCase();
        int ans = 0;
        int index = sub.length();
        while(index<=parent.length()){
            if(sub.equals(parent.substring(index - sub.length(), index))){
                ans++;
                index+=sub.length();
            }else {
                index++;
            }
        }
        return ans;
    }
    public static boolean isValid(String str) {
        LinkedList<Character> stack=new LinkedList<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{'){
                stack.push(str.charAt(i));
            }
            else if(stack.isEmpty()) return false;
            else if(str.charAt(i)==')'){
                char s=stack.pop();
                if(s!='(') return false;
            }
            else if(str.charAt(i)==']'){
                char s=stack.pop();
                if(s!='[') return false;
            }
            else if(str.charAt(i)=='}'){
                char s=stack.pop();
                if(s!='{') return false;
            }

        }
        return stack.isEmpty();
    }
    public static int largestRectangleArea(int[] heights) {
        Deque<Integer> stack=new LinkedList<>();
        boolean b = 'b' > 'a';
        int res=0;
        for(int i=0;i<=heights.length;i++){
            int h= i == heights.length ? 0 : heights[i];
            while(!stack.isEmpty()&&heights[stack.peek()]>h){
                res=Math.max(res, heights[stack.pop()]*(stack.isEmpty() ? i : i - stack.peek() - 1));
            }
            stack.push(i);
        }
        return res;
    }
    public static String reverseWords(String s) {
//        Deque<Character> stack= new LinkedList<>();

        Queue<ListNode> queue=new PriorityQueue<>((o1,o2)->o1.val-o2.val);

        StringBuilder res= new StringBuilder();
        Deque<String> stack = new LinkedList<>();
        stack.clear();
        String[] s1 = s.split(" ");
        for (String letter:s1){

            if(!letter.isEmpty() &&!" ".equals(letter))
                stack.add(letter);
        }
        while(!stack.isEmpty()){
            res.append(" ").append(stack.pollLast());
        }
        return res.substring(1);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Set<ListNode> res = new HashSet<>();
        // while(headA!=null){
        //     res.add(headA);
        //     headA = headA.next;
        // }
        // while(headB!=null){
        //     if(res.contains(headB)) return headB;
        //     res.add(headB);
        //     headB = headB.next;
        // }
        if(headA==null||headB==null) return null;
        ListNode a = headA, b = headB;
        while(a!=b){
            a =  a.next==null? headB:a.next;
            b = b.next==null? headA:b.next;
        }
        return a;
    }

    public ListNode ad(ListNode head){

        ListNode tmp = null;
        while(head!=null){
            tmp = head.next;
            tmp.next=head;
            head=head.next;
        }
        return tmp;
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
        PriorityQueue<int[]> ints = new PriorityQueue<>(((pair1, pair2) -> pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]));
        LinkedList<Object> objects = new LinkedList<>();
        objects.clear();
        queue.poll();
        LinkedList<Boolean> res = new LinkedList<>();
        for (int candy:candies){
    max = Math.max(max, candy);
}
        for (int candy:candies){
            res.add(candy + extraCandies >= max);
        }
        return res;
    }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = target-nums[i];
            if(null!=map.get(nums[i])) {
                res = new int[]{i, map.get(nums[i])};
                break;
            }
            map.put(num, i);

        }
        return res;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int plus = (l1.val+l2.val)/10;
        ListNode res = new ListNode((l1.val+l2.val)%10);
        while (null!=l1.next&&null!=l2.next){
            l1 = l1.next;
            l2 = l2.next;
            res.next = new ListNode();
            res.val = (l1.val+l2.val)%10+plus;
            plus = (l1.val+l2.val)/10;
        }
        if(null==l1.next){
            while(null!=l2.next) {
                res.val = (l2.next.val + plus)%10;
                plus = (l2.next.val + plus)/10;
                l2=l2.next;
                res.next = new ListNode();
            }
        }else {
            while(null!=l1.next) {
                res.val = (l1.next.val + plus)%10;
                plus = (l1.next.val + plus)/10;
                l1=l1.next;
                res.next = new ListNode();
            }
        }
        if(plus==1){
            res.next = new ListNode();
            res.val = plus;
        }
        return res;
    }

    public static boolean canJump(int[] nums) {
        int length = nums.length;
        boolean res = true;
        for(int i=nums.length-2;i>=0;i--) {
            res = nums[i] > length - i-2;
            if(res) length = i+1;
        }
        return res;
    }
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public static String longestPalindrome(String s) {
        int max = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                if(j-i<max)
                    break;
                String substring = s.substring(i, j);
                if(isRotateStr(substring)) {
                    max = Math.max(max, j - i);
                    res = substring;
                }
            }
            if(s.length()-i<max)
                break;;
        }
        return res;
    }
    public static Boolean isRotateStr(String str){
        int foot = str.length()/2-1;
        while(foot>=0){
            if(str.charAt(foot)!=str.charAt(str.length()-foot-1)) {
                return false;
            }
            foot--;
        }
        return true;
    }

//    public static int maxArea(int[] height) {
//        int max = (height.length-1)*Math.min(height[height.length-1], height[0]);
//        int loopCnt = (height.length+1)/2;
//        for (int i = 0; i < loopCnt; i++) {
//            for (int j = i+1; j < height.length-i; j++) {
//                max =Math.max(max, (j-i)*Math.min(height[j], height[i]));
//                max = Math.max(max, (height.length-1-j-i)*Math.min(height[j], height[height.length-1-i]));
//            }
//        }
//        return max;
//    }
    public static int minPathSum(int[][] grid) {
        int length = grid.length, length1 = grid[0].length;
        int[][] dp = new int[length][length1];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < length1; i++) {
            dp[0][i] = grid[0][i]+ dp[0][i-1];

        }
        for (int i = 1; i < length; i++) {
            dp[i][0] = grid[i][0]+ dp[i-1][0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length1; j++) {
                dp[i][j] = grid[i][j]+ Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[length -1][length1 -1];
    }

        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }
            Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);

//            int length = nums.length;
//            if(length==1) return nums[0];
//            int res=nums[0], prev=0;
//            for(int i=0;i<length;i++){
//                prev = Math.max(nums[i], prev+nums[i]);
//
//                res = Math.max(prev, res);
//            }
//            return res;

//            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
            ArrayList<int[]> res = new ArrayList<>();
            int prev=0;
            for (int[] interval : intervals) {
                if (res.isEmpty() || interval[0] > prev) {
                    res.add(interval);
                } else {
                    prev = Math.max(interval[1], prev);
                }
            }
            return res.toArray(new int[res.size()][]);
        }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i]==nums[i-1]) continue;
            int start = 0;
            int end = nums.length - 1;
            while (start<i && i<end) {
                int medium = nums[start] + nums[end];
                if (medium == -nums[i]) {

                    res.add(List.of(nums[start],nums[i],nums[end]));
                    start++;
                    end--;
                } else if (medium > -nums[i]) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return res;
    }

    public static int climbStairs(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(2);
        res.add(3);
        for (int i = 3; i < n; ++i) {
            res.add(res.get(i-2)+res.get(i-1));
        }
        return res.get(n);
    }

    public static int maxArea(int[] height) {
        int i=0, j = height.length-1;
        int volume=0;
        while(i<j){
            volume = Math.max(volume, Math.min(height[i], height[j])*(j-i));
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return volume;
    }

    public static int maxOperations(int[] nums, int k) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        int res = 0;
        int i=0, j = sortedNums.length-1;
        while (i<j){
            if(sortedNums[i]+sortedNums[j]>k){
                j--;
            } else if (sortedNums[i] + sortedNums[j] < k) {
                i++;
            }else{
                res++;
                j--;
                i++;
            }
        }
        return res;
    }
    public int pairSum(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head.next!=null){
            res.add(head.val);
            head = head.next;
        }
        int ret = 0;
        int i=0, j = res.size()-1;
        while (i<j){
            ret = Math.max(res.get(i)+res.get(j), ret);
            i++;
            j--;
        }
        return ret;
    }

    public static int longestOnes(int[] nums, int k) {
        int zeroCnt=0;
        int i=0, j =0;
        while (j<nums.length){
            zeroCnt += 1-nums[j++];
            if(zeroCnt>k){
                zeroCnt -= 1-nums[i++];
            }
        }
        return j-i;
    }

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    public int dfs(TreeNode root, int compare){
        if(root==null) return 0;
        int res = 0;
        if(root.val>compare){
            res++;
            compare = root.val;
        }
        res += dfs(root.left, compare)+dfs(root.right, compare);
        return res;
    }
    public static int findKthLargest(int[] nums, int k) {

        int[] ints = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            ints[i+10000]++;
        }
        for (int i = 20000; i >= 0; i--) {
            if(k-ints[i]<=0){
                return nums[i-10000];
            }
        }
        return 0;
    }

    public int rob(int[] nums) {
        if(nums.length<2) return nums[0];
        List<Integer> res = new LinkedList<>();
        res.add(nums[0]);
        res.add(Math.max(nums[0], nums[1]));
        for(int i=2;i<nums.length;i++){
            res.add(Math.max(res.get(i-2)+nums[i], res.get(i-1)));
        }
        return res.get(nums.length-1);
    }

    public int tribonacci(int n) {
        int[] res = new int[n+1];
        res[0]=0;
        res[1]=1;
        res[2]=1;
        for(int i=3;i<n+1;i++){
            res[i]=res[i-1]+res[i-2]+res[i-3];
        }
        return res[n];
    }

    public static int uniquePaths(int m, int n) {
        int max=0;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                max=res[i-1][j]+res[i][j-1];
                res[i][j]=max;
            }
        }
        return max;
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length(), length2 = text2.length();
        int[][] res = new int[length1 +1][length2+1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if(text1.charAt(i)==text2.charAt(j)){
                    res[i][j] = res[i-1][j-1]+1;
                }else{
                    res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
                }
            }
        }
        return res[length1][length2];
    }

    public int maxProfit(int[] prices, int fee) {
        int[][] res = new int[prices.length][2];
        res[0][0] = -prices[0];
        res[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
                res[i][0] = Math.max(res[i-1][1]-prices[i], res[i-1][0]);
                res[i][1] = Math.max(res[i-1][1], res[i-1][0]+prices[i]-fee);

        }
        return res[prices.length-1][1];
    }
//babadadadadfadaf
    public static String longestPalindrome1(String s) {
        int max = 0;
        String ret = s.substring(0,1);
        int[][] res = new int[s.length()][s.length()];
        for (int k = 0; k < s.length(); k++) {
            res[k][k] = 1;
        }
        for (int i = s.length()-2; i >=0; i--) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i<2||res[i+1][j-1]==1)) {
                    res[i][j] = 1;
                    if(j-i>max){
                        max = j-i;
                        ret = s.substring(i, j+1);
                    }
                }
                else {
                    res[i][j] = 0;
                }
            }
        }
        return ret;
    }
}

