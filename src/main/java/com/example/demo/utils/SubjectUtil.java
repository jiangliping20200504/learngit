package com.example.demo.utils;

import java.util.*;
import java.util.stream.Collectors;

public class SubjectUtil {

    //计算字符串最后一个单词的长度，单词以空格隔开。
    public static void testSubject1() {
        Scanner scanner = new Scanner(System.in);
        String inStr = scanner.nextLine();
        int index = inStr.lastIndexOf(" ");
        if (index == -1) {
            System.out.println(inStr.length());
        } else {
            System.out.println(inStr.substring(index, inStr.length() - 1).length());
        }
        scanner.close();
    }

    //计算字符个数。
    public static void testSubject2() {
        Scanner scanner = new Scanner(System.in);
        String inStr = scanner.nextLine();
        String[] inStrArr = inStr.split(" ");
        String str = inStrArr[0].toLowerCase();
        String cStr = inStrArr[1].toLowerCase();
        int total = 0;
        int count = 0;
        char[] chars = str.toCharArray();
        char c = cStr.toCharArray()[0];
        for (int i = 0; i < chars.length; i++) {
            if (c == chars[i]) {
                total += 1;
            }
        }
        /*for (int j = 0; j < str.length(); j++) {
            if (cStr.equals(str.substring(j, j + 1))) {
                count += 1;
            }
        }
        System.out.println(count);*/
        System.out.println(total);
        scanner.close();
    }

    //字符串分隔
    public static void testStrSplit() {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<lines+1 ;i++){
            String temp = scanner.nextLine();
            while (temp.length() % 8 != 0){
                temp+="0";
            }
            sb.append(temp);
        }
        for(int j=0;j<sb.length();j+=8){
            System.out.println(sb.substring(j,j+8));
        }
        scanner.close();
    }

    //字符串分隔
    public static void testSubject4() {
        Scanner scanner = new Scanner(System.in);
        String[] str = new String[2];
        str[0] = scanner.nextLine();
        str[1] = scanner.nextLine();
        for (int i = 0; i < 2; i++) {
            String lineStr = str[i];
            if (lineStr.length() == 8) {
                System.out.println(lineStr);
            } else if (lineStr.length() < 8) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < 8 - lineStr.length(); j++) {
                    sb.append("0");
                }
                System.out.println(lineStr + sb);
            } else {
                int arrLength = lineStr.length() / 8;
                int mode = lineStr.length() % 8;
                int len = mode == 0 ? arrLength : arrLength + 1;
                for (int t = 0; t < len; t++) {
                    if ((t + 1) * 8 < lineStr.length()) {
                        System.out.println(lineStr.substring(t * 8, (t + 1) * 8));
                    }
                    if (t == len - 1 && mode > 0) {
                        StringBuffer sb = new StringBuffer();
                        for (int j = 0; j < 8 - (lineStr.length() - t * 8); j++) {
                            sb.append("0");
                        }
                        System.out.println(lineStr.substring(t * 8) + sb);
                    }
                }
            }
        }
        scanner.close();
    }

    //进制转换
    public static void testSubject5_1() {
        System.out.println((int) "0".charAt(0));
        System.out.println((int) "9".charAt(0));
        System.out.println((int) "0".charAt(0) + "ABCDEF".length() + 1);
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String str = scanner.next();
//            int result = Integer.parseInt(str.replaceAll("^0[x|X]", ""), 16);
//            System.out.println(str.replace("^0[x|X]", ""));
//            System.out.println(result);
//            System.out.println((char) result);
//        }
//        scanner.close();
    }

    //进制转换
    public static void testSubject5_2() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            int sum = 0;
            for (int k = 2; k < s.length(); k++) {
                if ((int) (s.charAt(k)) >= '0' && (int) (s.charAt(k)) <= '9') {
                    sum += ((int) s.charAt(k) - '0') * Math.pow(16, (double) (s.length() - k - 1));
                } else {
                    int n = (int) s.charAt(k) - ('0'+"ABCDEF".length()+1);
                    sum += n * Math.pow(16, (double) (s.length() - k - 1));
                }
            }
            System.out.println(sum);
        }
        in.close();
    }

    //质数因子
    public static void testSubject6() {
        Scanner scanner = new Scanner(System.in);
        long data = scanner.nextLong();
        StringBuffer sb = new StringBuffer();
        for (int i = 2; i <= data; i++) {
            while (data % i == 0) {
                data = data / i;
                sb.append(i);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
        scanner.close();
    }

    //取近似值
    public static void testSubject7() {
        Scanner scanner = new Scanner(System.in);
        float data = scanner.nextFloat();
        String str = String.valueOf(data);
        int c = Integer.parseInt(str.substring(0, str.indexOf(".")));
        int ci = Integer.parseInt(str.substring(str.indexOf(".") + 1, str.indexOf(".") + 2));
        int res = ci >= 5 ? c + 1 : c;
        System.out.println(res);
        scanner.close();
    }

    //合并表记录：数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
    public static void testSubject8() {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> map = new TreeMap<>();
        int count = scanner.nextInt();
        scanner.nextLine();
        map.put(scanner.nextInt(), scanner.nextInt());
        scanner.nextLine();
        for (int i = 1; i < count; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (map.containsKey(a)) {
                int c = map.get(a);
                map.put(a, b + c);
            } else {
                map.put(a, b);
            }
        }
        Set<Integer> s = map.keySet();
        for (Integer i : s) {
            System.out.println(i + " " + map.get(i));
        }
        scanner.close();
    }

    //提取不重复的整数：输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
    public static void testSubject9() {
        Scanner scanner = new Scanner(System.in);
        int data = scanner.nextInt();
        String str = String.valueOf(data);
        String resStr = "";
        for (int i = str.length(); i > 0; i--) {
            String temp = str.substring(i - 1, i);
            if (!resStr.contains(temp)) {
                resStr += temp;
            }
        }
        System.out.println(resStr);
        scanner.close();
    }

    //字符个数统计：编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
    public static void testSubject10() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)>=0 && str.charAt(i)<=127){
                set.add(str.charAt(i));
            }
        }
        System.out.println(set.size());
    }

    /**
     *
     * 密码加密：小写字母编程对应数字,数字不变,密码中没有空格，
     * 而密码中出现的大写字母则变成小写之后往后移一位，
     * 如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦
     */
    public static void testSubject11() {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i = 'a';i<='z'; i++){
            int temp = i < 's' ? ((i-('a'-1)) % 3 == 0 ? (i-('a'-1)) / 3+1 : (i-('a'-1)) / 3+2) : i=='s' ? 7 : i<='v'? 8 : 9;
            map.put((char)i ,  temp);
        }
        /*map.forEach((key, val)->{
            System.out.println(key+":"+val);
        });*/
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<line.length();i++){
                char c = line.charAt(i);
                if(c>='A' && c<='Z'){
                    sb.append((char)(c =='Z' ? 'a' : c+('a'-'A')+1));
                }
                if(c>='0' && c<='9'){
                    sb.append(c);
                }
                if(c>='a' && c<='z'){
                    sb.append(map.get(c));
                }
            }
            System.out.println(sb.toString());
        }
    }

    //最小公倍数
    public static void LeastCommonMultiple(){
        Scanner scanner = new Scanner(System.in);
        int line1 = scanner.nextInt();
        int line2 = scanner.nextInt();
        int divisor = getMaxCommonDivisor1(line1, line2);
        System.out.println(line1*line2/divisor);
    }

    /**
     * 求最大公约数 辗转相除法
     * @param m
     * @param n
     * @return
     */
    public static int getMaxCommonDivisor(int m,int n) {
        if(n<=0){
            return m;
        }
        int b= m%n;
        m=n;
        n=b;
        return getMaxCommonDivisor(m,n);
    }
    /**
     * 求最大公约数 更相减损法
     * @param m
     * @param n
     * @return
     */
    public static int getMaxCommonDivisor1(int m,int n) {
        if(m==n){
            return m;
        }
        if(m>n){
            m=m-n;
        }
        if(m<n){
            n=n-m;
        }
        return getMaxCommonDivisor1(m,n);
    }

    //求立方根
    public static void getCubeRoot(){
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double x = 1.0;
        while (Math.abs(x * x * x - a) > 1e-9) {
            x = x - ((x * x * x - a) / (3 * x * x));
        }
        System.out.printf("%.1f", x);
    }

    //求平方根
    public static void getSqRoot2(){
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
//        1e-15和1e-9和1e-1 区别只是精度不同
        double x = 1.0;
        while (Math.abs(x * x  - a) > 1e-9) {
            x = x - ((x * x  - a) / (2 * x));
        }
        /*double y = 1.0;
        while (Math.abs(y * y  - a) > 1e-15) {
            y = y - ((y * y  - a) / (2 * y));
        }
        System.out.println(y);*/
        System.out.println(x);
        System.out.printf("%.1f", x);
    }

    //求平方根
    public static void getSqRoot(){
        Scanner sc = new Scanner(System.in);
        double c = sc.nextDouble();
        if (c < 0) {
            System.out.println(Double.NaN);
        }
        double x = c;
        double y = (x + c / x) / 2;
        while (Math.abs(x - y) > 1e-15) {
            x = y;
            y = (x + c / x) / 2;
        }
        System.out.println(Math.sqrt(c));
        System.out.println(x);
    }

    //字符逆序
    public static void strReverse(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=chars.length-1; i>=0; i--){
            sb.append(chars[i]);
        }
        System.out.println(sb.toString());
    }

    //记负均正
    public static void negativeAndPositive(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int lines = sc.nextInt();
            int cout1 = 0;
            int sum2 = 0;
            int cout2 = 0;
            for(int i=0; i<lines; i++){
                int line = sc.nextInt();
                if(line < 0){
                    cout1 ++;
                }
                if(line > 0){
                    cout2 ++;
                    sum2 += line;
                }
            }
            System.out.println("负数有"+cout1+"个,正数的平均数为"+Double.parseDouble(String.valueOf(sum2/cout2)));
        }


    }



    //输入整型数组和排序标识，对其元素按照升序或降序进行排序
    public static void testArrSort() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        List<Integer> list = new ArrayList();
        for (int i = 0; i < count; i++) {
            list.add(scanner.nextInt());
        }
        int flag = scanner.nextInt();
//            0 asc     1 desc
        List<Integer> collect = list.stream()
                .sorted(flag == 0 ? Comparator.comparingInt(Integer::intValue) : Comparator.comparingInt(Integer::intValue).reversed())
                .collect(Collectors.toList());
        collect.stream().forEach(e -> {
            System.out.println(e + " ");
        });
        scanner.close();
    }

    //等差数列  Sn = n*a1 + d*n*(n-1)/2
    public static void testArithmeticSequence() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int count = scanner.nextInt();
            if(count<1){
                System.out.println(-1);
            }else{
                System.out.println(2*count+3*count*(count-1)/2);
            }
        }
        /*while (scanner.hasNext()){
            int count = scanner.nextInt();
            int sum = 0;
            if(count<1){
                System.out.println(-1);
            }else {
                for (int i = 1; i <= count; i++) {
                    int an = 2 + 3 * (i - 1);
                    sum += an;
                }
                System.out.println(sum);
            }
        }*/
    }

    //n以内自守数的数量
    public static void testAutonomousNumber() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int line = sc.nextInt();
            int count = 0;
            for(int i=0; i<=line; i++){
                String len = String.valueOf(i);
                String str = String.valueOf(i * i);
                if(Integer.parseInt(str.substring(str.length()-len.length())) == i){
                    count ++;
                }
//                System.out.println(str.substring(str.length()-len.length()));
//                System.out.println(i);
            }
            System.out.println("个数是"+count);
        }
    }

    //表示数字
    public static void testMarkNumber() {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<line.length();i++){
            if(line.charAt(i)>='0' && line.charAt(i)<='9'){
                sb.append('*').append(line.charAt(i)).append('*');
            }else {
                sb.append(line.charAt(i));
            }
        }
        System.out.println(sb.toString().replace("**",""));
    }

    //人民币转换
    public static void testRMBConversion() {

    }


    public static void testMapJava8() {
        Map<Integer, Double> map = new HashMap<>();
        map.put(1, Math.pow(1, 1));
        map.put(4, Math.pow(4, 4));
        map.put(9, null);
        map.putIfAbsent(5, 5.1);
        map.putIfAbsent(4, 4.8);
        map.putIfAbsent(9, 9.2);
        System.out.println("5-----" + map.get(5));
        System.out.println("4-----" + map.get(4));
        System.out.println("9-----" + map.get(9));
        map.putIfAbsent(2, 1.6878);
        map.putIfAbsent(3, null);
        System.out.println("2-----" + map.get(2));
        System.out.println("3-----" + map.get(3));
        map.computeIfPresent(2, (key, val) -> key + val);
        System.out.println("2-----" + map.get(2));
        map.computeIfPresent(3, (key, val) -> key + val);
        System.out.println("3-----" + map.get(3));
        map.computeIfPresent(2, (key, val) -> null);
        System.out.println("2-----" + map.get(2));
        map.computeIfAbsent(3, key -> key + 9.999999999);
        System.out.println("3-----" + map.get(3));
        map.replace(11, 11.11);
        System.out.println("11-----" + map.get(11));
        map.putIfAbsent(11, 11.2);
        System.out.println("11-----" + map.get(11));
        map.replace(11, null);
        System.out.println("11-----" + map.get(11));
        map.replace(11, 34.32);
        System.out.println("11-----" + map.get(11));
        System.out.println(map.replace(11, 34.32, 34.3));
        System.out.println(map.replace(11, 34.3, 34.33));
        System.out.println("11-----" + map.get(11));
        map.replaceAll((key, val) -> key + val);
        System.out.println("11-----" + map.get(11));
        map.remove(11, 45.32);
        System.out.println("11-----" + map.get(11));
        map.putIfAbsent(11, 18.9);
        map.compute(11, (key, val) -> key + 100 + val);
        System.out.println("11-----" + map.get(11));

        List<Map.Entry<Integer, Double>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        List<Map.Entry<Integer, Double>> collect1 = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        System.out.println();
//        RetreenLock retreenLock

    }

    public static void testChar() {
        String str = "1239Aabc姜丽萍";
        List list = Arrays.asList(str.split(""));
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            System.out.println("!" + it.next());
        }
        list.stream().forEach(e -> {
            System.out.println(e);
        });
        char char1 = '中';
        System.out.println(Math.pow(2, 7));
        for (int i = 0; i < str.length(); i++) {
            System.out.println((int) str.charAt(i) + ":" + str.charAt(i));
        }
    }

    //明明的随机数
    public static void testMingMingRandom() {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int count = sc.nextInt();
            int[] arr = new int[count];
            for(int i=0; i<count; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for(int j=0; j<count; j++){
                if(j==0 || arr[j]!=arr[j-1]){
                    System.out.println(arr[j]);
                }
            }
        }
    }

    public static void testPerfectName(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int count = sc.nextInt();
            for(int i=0;i<count; i++){
                String line = sc.next().toLowerCase();
                char[] charArr = line.toCharArray();
                int[] aa = new int[26];
                for(int j=0;j<charArr.length;j++){
                    aa[charArr[j]-'a'] = aa[charArr[j]-'a'] + 1;
                }
                Arrays.sort(aa);
                int count1 = 0;
                for(int t=26; t>0; t--){
                    count1 += (t*aa[t-1]);
                }
                System.out.println(count1);
            }
        }

    }

    /**
     * 从第一个字符开始，遍历循环每一个字符，利用maxBegin和maxEnd来记录当前连续出现的子字符串的起始位置，
     * 如果当前字符串长度大于历史最大字符串长度，或者两者长度一样，但当前的字符串ASCII码小于之前的，
     * 就要用当前的字符串覆盖历史最长的字符串，这里要注意最后一个字符的边界问题。
     *
     * **/
    public static void maxRepeatString(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if(str==null||str.trim().length()==0){
            System.out.println("");
        }
        if(str.length()<2){
            System.out.println(str);
        }
        int maxBegin = 0;
        int maxEnd = 1;
        char [] charArr = str.toCharArray();
        String tempStr = "";
        String maxLenStr = "";
        for(int i=0;i<charArr.length-1;i++){
            maxEnd = i+1;
            if(charArr[i]==charArr[i+1]){
                tempStr = str.substring(maxBegin, maxEnd+1);
            }else {
                tempStr = str.substring(maxBegin, maxEnd);
                maxBegin = maxEnd;//不相等时，改变截取字符串的开始位置
            }
            if(tempStr.length()>maxLenStr.length()){
                maxLenStr = tempStr;
            }else if(tempStr.length()==maxLenStr.length()&&maxLenStr.length()>0){
                if((int)(tempStr.charAt(0))<(int)(maxLenStr.charAt(0))) {
                    maxLenStr = tempStr;
                }
            }
            if(maxEnd==charArr.length-1){//最后一次遍历，并且
                if(maxLenStr.length()==1){
                    if((int)(charArr[charArr.length-1])<(int)(maxLenStr.charAt(0))) {
                        maxLenStr = String.valueOf(charArr[charArr.length-1]);
                    }
                }
            }
        }
        System.out.println(maxLenStr);
    }

    //找出输入字符串中的重复字符，再根据ascii把重复的字符从小到大排序
    public static void getRepeatCharByASCII(){
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        TreeMap<Character, Integer> map = new TreeMap<>();
        char[] charArr = line.toCharArray();
        for(int i=0; i<charArr.length; i++){
            if(!map.containsKey(charArr[i])){
                map.put(charArr[i], 1);
            }else {
                map.put(charArr[i],map.get(charArr[i])+1);
            }
        }
        Iterator<Character> iterator = map.keySet().iterator();
        Character key;
        StringBuffer sb = new StringBuffer();
        while (iterator.hasNext()){
            key = iterator.next();
            if(map.get(key) > 1){
                sb.append(key);
            }
        }
        System.out.println(sb.toString());
    }



    public static void main(String[] args) {
//        SubjectUtil.testSubject10();
//        SubjectUtil.testSubject11();
//        SubjectUtil.LeastCommonMultiple();
//        SubjectUtil.testStrSplit();
//        SubjectUtil.getCubeRoot();
//        SubjectUtil.getSqRoot();
//        SubjectUtil.getSqRoot2();
//        SubjectUtil.strReverse();
//        SubjectUtil.negativeAndPositive();
//        SubjectUtil.testPerfectName();
        SubjectUtil.getRepeatCharByASCII();
//        System.out.println(1e-9);
//        System.out.println(1*Math.pow(10,-9));
    }


}
