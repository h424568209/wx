//import java.util.*;

//    public class Leecode {
//        /**
//         * 将一个字符串的所有空格替换成%20
//         *
//         * @param str
//         * @return
//         */
//        public static String replaceSpace(StringBuffer str) {
//            StringBuilder s = new StringBuilder();
//            for (int i = 0; i < str.length(); i++) {
//                if (' ' != str.charAt(i)) {
//                    s.append("%");
//                    s.append("2");
//                    s.append("0");
//                } else {
//                    s.append(str.charAt(i));
//                }
//            }
//            return s.toString();
//        }
//
//        public static boolean isAnagram(String s, String t) {
//            /**
//             * 判断两个字符串所组成的字符是否相等
//             * 使用map存放一个字符串中字符出现的次数和字符，再另一个字符串中查找，若存在，则该字符对应的次数减一
//             * 最后若map为空，说明字符完全匹配
//             */
//            Map<Character, Integer> map = new HashMap<>();
//            for (int i = 0; i < s.length(); i++) {
//                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//            }
//            for (char ch : t.toCharArray()) {
//                Integer count = map.get(ch);
//                if (count == null) {
//                    return false;
//                } else if (count > 1) {
//                    map.put(ch, count - 1);
//                } else {
//                    map.remove(ch);
//                }
//            }
//            return map.isEmpty();
//        }
//
//        /**
//         * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j
//         * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
//         *
//         * @param nums
//         * @param k
//         * @return
//         */
//        public static boolean containsNearbyDuplicate(int[] nums, int k) {
//            Set<Integer> set = new HashSet<>();
//            for (int i = 0; i < nums.length; i++) {
//                if (set.contains(nums[i])) {
//                    return true;
//                }
//                set.add(nums[i]);
//                if (k < set.size()) {
//                    set.remove(nums[i - k]);
//                }
//            }
//            return false;
//        }
//
//        /**
//         * 判断一个整数数组中是否存在重复元素
//         * 使用set存放遍历后的每个元素，若最后set的长度等于nums的长度，则不存在重复元素、否则存在重复元素
//         *
//         * @param nums
//         * @return
//         */
//        public static boolean containsDuplicate(int[] nums) {
//            Set<Integer> set = new HashSet<>();
//            for (int e : nums) {
//                set.add(e);
//            }
//            return set.size() != nums.length;
//        }
//
//        /**
//         * 给定两个字符串，判断他们是不是同构的
//         * 若两个字符串从头遍历对应元素的下标相同，则他们的结构是同构的
//         *
//         * @param s
//         * @param t
//         * @return
//         */
//        public static boolean isIsomorphic(String s, String t) {
//            if (s.length() != t.length()) {
//                return false;
//            }
//            char[] p1 = s.toCharArray();
//            char[] p2 = t.toCharArray();
//            for (int i = 0; i < s.length(); i++) {
//                if (s.indexOf(p1[i]) != t.indexOf(p2[i])) {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        //使用哈希表判断两个字符串是不是同构的
//        //其中k——v 分别为s.charAt(i)、t.charAt(i)
//        public static boolean isIsomorphicwithMap(String s, String t) {
//            if (s.length() != t.length()) {
//                return false;
//            }
//            Map<Character, Character> map = new HashMap<>();
//            for (int i = 0; i < s.length(); i++) {
//                if (!map.containsKey(s.charAt(i))) {
//                    if (map.containsValue(t.charAt(i))) {
//                        return false;
//                    }
//                    map.put(s.charAt(i), t.charAt(i));
//                } else {
//                    if (map.get(s.charAt(i)) != t.charAt(i)) {
//                        return false;
//                    }
//                }
//            }
//            return true;
//        }
//
//        /**
//         * 输出小于n的所有素数的个数；
//         * 让一个boolean类型的数组全部设置为true
//         * 再从2开始遍历整个数组，将2的倍数，3的倍数...等设置为false
//         * 最后从2 开始遍历数组，计数为true的个数即为素数的个数
//         *
//         * @param n
//         * @return 0
//         */
//
//        public static int countPrimes(int n) {
//            boolean[] arr = new boolean[n];
//            Arrays.fill(arr, true);
//            for (int i = 2; i < n; i++) {
//                if (arr[i]) {
//                    for (int j = 2 * i; j < n; j += i) {
//                        arr[j] = false;
//                    }
//                }
//            }
//            int count = 0;
//            for (int i = 2; i < n; i++) {
//                if (arr[i]) {
//                    count++;
//                }
//            }
//            return count;
//        }
//
//        private static boolean isPrimes(int i) {
//            for (int n = 2; n * n <= i; n++) {
//                if (i % n == 0) {
//                    return false;
//                }
//            }
//            return true;
//        }
//
//        /**
//         * 快乐数指的：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
//         * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
//         * 使用Set存储计算的平方和，若出现重复的结果，则进入了死循环 返回false；
//         * 若结果为1 ，则这个数就是快乐数；
//         *
//         * @param n
//         * @return
//         */
//        public static boolean isHappy(int n) {
//            if (n <= 0) {
//                return false;
//            }
//            Set<Integer> set = new HashSet<>();
//            int m = 0;
//            while (true) {
//                while (n != 0) {
//                    m += Math.pow(n % 10, 2);
//                    n /= 10;
//                }
//                if (m == 1) {
//                    return true;
//                }
//                if (set.contains(m)) {
//                    return false;
//                }
//                set.add(m);
//                n = m;
//                m = 0;
//            }
//        }
//
//        /**
//         * 给定两个数字，返回他们相除后的小数，若为无限循环小数，用括号括出重复的数字
//         * 使用map存放余数和余数出现的位置，若有重复，则是无限循环小数
//         * 若没有重复，则余数乘10继续计算。
//         *
//         * @param numerator
//         * @param denominator
//         * @return
//         */
//        public static String fractionToDecimal(int numerator, int denominator) {
//            if (numerator == 0) {
//                return "0";
//            }
//            StringBuilder res = new StringBuilder();
//            if (numerator < 0 || denominator < 0) {
//                res.append("-");
//            }
//            long divident = Math.abs(Long.valueOf(numerator));
//            long divisor = Math.abs(Long.valueOf(denominator));
//            res.append(String.valueOf(divident / divisor));
//            long remainder = divident % divisor;
//            if (remainder == 0) {
//                return res.toString();
//            }
//            res.append(".");
//            Map<Long, Integer> map = new HashMap<>();
//            while (remainder != 0) {
//                if (map.containsKey(remainder)) {
//                    res.insert(map.get(remainder), "(");
//                    res.append(")");
//                    break;
//                }
//                map.put(remainder, res.length());
//                remainder *= 10;
//                res.append(String.valueOf(remainder / divisor));
//                remainder %= divisor;
//            }
//            return res.toString();
//        }
//
//
//        public class Nodecomparator implements Comparator<Node> {
//            @Override
//            public int compare(Node o1, Node o2) {
//                return o1.val - o2.val;
//            }
//        }
//        /**
//         * 复制一个带随机指针random的单链表
//         * 首先将单链表中的值和next复制到一个新的链表中，新链表的每一个结点为旧的链表的结点的next。
//         * 其次进行random指针的复制
//         * 最后将链表拆分
//         */
//
//        /**
//         * 使用单链表进行复制random指针
//         */
//        class Node {
//            public int val;
//            public Node next;
//            public Node random;
//
//            public Node() {
//            }
//
//            public Node(int _val, Node _next, Node _random) {
//                val = _val;
//                next = _next;
//                random = _random;
//            }
//
//            public Node copyRandomList(Node head) {
//                if (head == null) {
//                    return null;
//                }
//                Node p1 = head;
//                while (p1 != null) {
//                    Node p2 = new Node();
//                    p2.random = null;
//                    p2.val = p1.val;
//                    p2.next = p1.next;
//                    p1.next = p2;
//                    p1 = p2.next;
//                }
//                p1 = head;
//                while (p1 != null) {
//                    Node p2 = p1.next;
//                    if (p1.random != null) {
//                        p2.random = p1.random.next;
//                    }
//                    p1 = p2.next;
//                }
//                p1 = head;
//                Node newhead = p1.next;
//                while (p1 != null) {
//                    Node p2 = p1.next;
//                    p1.next = p2.next;
//                    if (p2.next != null) p2.next = p1.next.next;
//                    p1 = p1.next;
//                }
//                return newhead;
//            }
//
//            /**
//             * 使用map进行链表random指针的获取
//             *
//             * @param head
//             * @return
//             */
//            public Node copyRandomListwithMap(Node head) {
//                Map<Node, Node> map = new TreeMap<>(new Nodecomparator());
//                Node cur = head;
//                Node ret = null;
//                Node last = null;
//                while (cur != null) {
//                    Node node = new Node();
//                    node.val = cur.val;
//                    if (ret == null) {
//                        ret = node;
//                    } else {
//                        last.next = node;
//                    }
//                    last = node;
//                    map.put(node, cur);
//                    cur = cur.next;
//                }
//                cur = head;
//                Node node = ret;
//                while (cur != null) {
//                    if (cur.random != null) {
//                        node.random = map.get(cur.random);
//                    } else {
//                        node.random = null;
//                    }
//                    cur = cur.next;
//                    node = node.next;
//                }
//                return ret;
//            }
//        }
//
//        public static void main(String[] args) {
//            //   System.out.println(Leecode.fractionToDecimal(1,3));
//            //   System.out.println(Leecode.isHappy(11));
//            //     System.out.println(Leecode.countPrimes(12));
//            //      System.out.println(Leecode.isIsomorphicwithMap("edd","agg"));
//            //int nums[] = {1, 2, 3, 1, 2, 3};
//            //  System.out.println(Leecode.containsDuplicate(nums));
//            //System.out.println(Leecode.containsNearbyDuplicate(nums, 2));
//            System.out.println(Leecode.isAnagram("asdsss", "sdsssa"));
//
//        }
//
//    }
