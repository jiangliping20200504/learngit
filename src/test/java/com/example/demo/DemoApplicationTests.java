package com.example.demo;

import com.example.demo.entity.FeatureVo;
import com.example.demo.entity.GeometryVo;
import com.example.demo.entity.PropertieVo;
import com.example.demo.thread.CMyThread;
import com.example.demo.thread.RMyThread;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

//@SpringBootTest
class DemoApplicationTests {

    //计算字符串最后一个单词的长度，单词以空格隔开。
    @Test
    void testSubject1() {
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
    @Test
    void testSubject2() {
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
        for (int j = 0; j < str.length(); j++) {
            if (cStr.equals(str.substring(j, j + 1))) {
                count += 1;
            }
        }
        System.out.println(total);
        System.out.println(count);
        scanner.close();
    }

    //字符串分隔
    @Test
    void testSubject4() {
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
    @Test
    void testSubject5_1() {
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
    @Test
    void testSubject5_2() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            int sum = 0;
            for (int k = 2; k < s.length(); k++) {
                if ((int) (s.charAt(k)) >= 48 && (int) (s.charAt(k)) <= 57) {
                    sum += ((int) s.charAt(k) - 48) * Math.pow(16, (double) (s.length() - k - 1));
                } else {
                    int n = (int) s.charAt(k) - 55;
                    sum += n * Math.pow(16, (double) (s.length() - k - 1));
                }
            }
            System.out.println(sum);
        }
        in.close();
    }

    //质数因子
    @Test
    void testSubject6() {
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
    @Test
    void testSubject7() {
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
    @Test
    void testSubject8() {
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
    @Test
    void testSubject9() {
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
    @Test
    void testSubject10() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                set.add(str.charAt(i));
            }
        }
        System.out.println(set.size());
        /*Map<Integer, Object> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            int charCode = str.charAt(i);
            if (charCode >= 0 && charCode <= 127) {
                if (!map.containsKey(charCode)) {
                    map.put(charCode, str.charAt(i));
                    count += 1;
                }
            }
        }
        System.out.println(count);
        map.forEach((key, val) -> {
            System.out.println(key + ":" + val);
        });*/

    }

    //输入整型数组和排序标识，对其元素按照升序或降序进行排序
    @Test
    void testArrSort() {
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
    @Test
    void testArithmeticSequence() {
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

    //自守数
    @Test
    void testAutonomousNumber() {
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
    @Test
    void testMarkNumber() {
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
    @Test
    void testRMBConversion() {

    }


    @Test
    void testMapJava8() {
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


    @Test
    void MaxRepeatString2(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        if(str==null||str.trim().length()==0){
            System.out.println("");
        }
        if(str.length()<2){
            System.out.println(str);
        }

    }

    /**
     * 从第一个字符开始，遍历循环每一个字符，利用maxBegin和maxEnd来记录当前连续出现的子字符串的起始位置，
     * 如果当前字符串长度大于历史最大字符串长度，或者两者长度一样，但当前的字符串ASCII码小于之前的，
     * 就要用当前的字符串覆盖历史最长的字符串，这里要注意最后一个字符的边界问题。
     *
     * **/
    @Test
    void MaxRepeatString(){
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

    @Test
    void testChar() {
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

    @Test
    void testMath() {
        System.out.println("计算平方根 Math.sqrt(49)--------" + Math.sqrt(49));//计算平方根
        System.out.println("计算立方根 Math.cbrt(8)--------" + Math.cbrt(8));//计算立方根
        System.out.println("计算（3平方+4平方）的平方根 Math.hypot(3,4)--------" + Math.hypot(3, 4));//计算（3平方+4平方）的平方根
        System.out.println("计算x的y次方 Math.pow(Math.E,3)--------" + Math.pow(Math.E, 3));//计算x的y次方
        System.out.println("计算E的y次方 Math.exp(3)--------" + Math.exp(3));//计算E的y次方
        System.out.println("计算最大值 Math.max(7,5.0)--------" + Math.max(7, 5.0));//计算最大值
        System.out.println("计算最小值 Math.min(5,5.0)--------" + Math.min(5, 5.1));//计算最小值
        System.out.println("求绝对值 Math.abs(-10)--------" + Math.abs(-10));//求绝对值
        System.out.println("求绝对值 Math.abs(11.5)--------" + Math.abs(11.5));//求绝对值
        System.out.println("向上取整 Math.ceil(11.5)--------" + Math.ceil(11.5));//向上取整
        System.out.println("向上取整 Math.ceil(-11.4)--------" + Math.ceil(-11.4));//向上取整
        System.out.println("向下取整 Math.floor(11.5)--------" + Math.floor(11.5));//向下取整
        System.out.println("向下取整 Math.floor(-11.4)--------" + Math.floor(-11.4));//向下取整
        System.out.println("[0,1)随机数 Math.random()--------" + Math.random());//[0,1)随机数
        System.out.println("[0,100)随机数 Math.random()*100--------" + Math.random() * 100);//[0,100)随机数
        System.out.println("四舍五入 Math.rint(10.45)--------" + Math.rint(10.45));//四舍五入 返回double值
        System.out.println("四舍五入 Math.round(10.45)--------" + Math.round(10.45));//四舍五入 float时返回int值，double时返回long值
        System.out.println("返回比a大一点点的浮点数 Math.nextUp(10.47)--------" + Math.nextUp(10.47));//返回比a大一点点的浮点数
        System.out.println("返回比a小一点点的浮点数 Math.nextDown(10.47)--------" + Math.nextDown(10.47));//返回比a小一点点的浮点数
        System.out.println("返回(a,b)或(b,a)间与a相邻的浮点数 b可以比a小 Math.nextAfter(10.47,20)--------" + Math.nextAfter(10.47, 20));//Math.nextAfter(a,b) 返回(a,b)或(b,a)间与a相邻的浮点数 b可以比a小
        System.out.println("返回(a,b)或(b,a)间与a相邻的浮点数 b可以比a小 Math.nextAfter(10.47,20)--------" + Math.nextAfter(10.47, -10));//Math.nextAfter(a,b) 返回(a,b)或(b,a)间与a相邻的浮点数 b可以比a小
        System.out.println("求和 Math.addExact(6,89)" + Math.addExact(6, 89));
        System.out.println("两个参数之差 Math.subtractExact(6,89)" + Math.subtractExact(6, 89));
        System.out.println("参数值加一 Math.incrementExact(6))" + Math.incrementExact(6));
        System.out.println("参数值减一 Math.decrementExact(6))" + Math.decrementExact(6));
        System.out.println("两个参数之积 Math.multiplyExact(2,8))" + Math.multiplyExact(2, 8));
        System.out.println("改变参数符号 Math.negateExact(2))" + Math.negateExact(2));
        System.out.println("改变参数符号 Math.negateExact(-3))" + Math.negateExact(-3));
        System.out.println("第一个参数除以第二参数 Math.floorDiv(-10,3))" + Math.floorDiv(-10, 3));
        System.out.println("第一个参数除以第二参数 Math.floorDiv(10,3))" + Math.floorDiv(10, 3));//第一个参数除以第二参数，然后针对结果执行floor操作，返回小于或等于商的整数
        System.out.println("------1>" + Math.floorMod(4, 3));//1
        System.out.println("------2>" + (4 % 3));//1
        //如果参数的符号不同，则结果与％运算符不同。
        System.out.println("------3>" + Math.floorMod(4, -3));//-2
        System.out.println("------4>" + (4 % -3));//1
        System.out.println("------5>" + Math.floorMod(-4, 3));//2
        System.out.println("------6>" + (-4 % 3));//-1
        System.out.println("------7>" + Math.floorMod(-4, -3));//-1
        System.out.println("------8>" + (-4 % -3));//-1
        System.out.println("------8>" + Math.floorMod(3, 4));//3
        System.out.println("------8>" + (3 % 4));//3
        System.out.println("------8>" + Math.floorMod(3, -4));//-1
        System.out.println("------8>" + (3 % -4));//3
        // % 取余  返回与被除数（第一个参数）符号一致的除数被除数绝对值取余，商向0方向舍去小数
        // Math.floorMod() 取模 返回值与除数符号一致，商向负无穷方向舍去小数
    }


    @Test
    void testTime() {

        Integer a = 10;
        Integer a1 = 10;
        System.out.println(a == a1);
        Integer a2 = 128;
        Integer a3 = 128;
        System.out.println(a2 == a3);


        LocalDate now = LocalDate.now();
//        System.out.println(now);
//        System.out.println(now.atStartOfDay());
//        System.out.println(now.atStartOfDay(ZoneId.systemDefault()));
//        System.out.println(now.getYear());
//        System.out.println(now.getMonthValue());
//        System.out.println(now.getDayOfMonth());
//        System.out.println(now.getDayOfWeek().getValue());
//        System.out.println(now.getDayOfYear());
        ZonedDateTime date = LocalDate.of(2020, 3, 22).atStartOfDay(ZoneId.systemDefault());
        System.out.println(date.plusMonths(-2));
//        System.out.println(time.toEpochSecond());
//        System.out.println(time.toInstant());
        System.out.println(date.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(date.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println(date.with(TemporalAdjusters.lastInMonth(DayOfWeek.FRIDAY)));
        System.out.println(date.withDayOfMonth(1));
        System.out.println(date.withDayOfMonth(3));
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String formatStr = date.format(fmt);
        System.out.println(formatStr);

        LocalTime time = LocalTime.now();
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MIDNIGHT);
        System.out.println(LocalTime.of(13, 45, 55));
        System.out.println(time);
        System.out.println(time.atDate(LocalDate.of(2020, 4, 14)));
        System.out.println(LocalTime.parse("15:09:08"));

        LocalDate date1 = LocalDate.now(Clock.systemDefaultZone());
        LocalDate date2 = LocalDate.now(ZoneId.systemDefault());
        LocalDateTime localDateTime = LocalDateTime.of(2020, 4, 14, 03, 22, 17);
        System.out.println(LocalDateTime.now());
        System.out.println(date1.get(ChronoField.DAY_OF_MONTH));
//        System.out.println(localDateTime.);


    }


    @Test
    void testSort() {
        System.out.println(System.currentTimeMillis() / 1000);
//        int year, int month, int date, int hrs, int min, int sec
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = df.parse("20200409");
            date2 = df.parse("20200415");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date1);
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date2);
            long timestamp = cal.getTimeInMillis();
            System.out.println(cal.getTimeInMillis() / 1000);
            System.out.println(cal1.getTimeInMillis() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        getRandom();
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        ClassLoader parent = classLoader.getParent();
//        int[] array = new int[]{3,5,1,55,7,89,455,63,51,45};
//        long t1 = System.currentTimeMillis();
//        int i =5;
//        int b,c;
////        int a = (b=i++) + (c=++i);
//        int a = i++ + ++i;
//        System.out.println(a);
//        System.out.println(i);
////        SortUtil.insertSort(array);
////        SortUtil.shellSort(array);
////        SortUtil.shellSort2(array);
////        SortUtil.selectSort(array);
////        SortUtil.heapSort(array, array.length-1);
////        SortUtil.bubbleSort(array);
//        SortUtil.mergeSort(array, 0, array.length-1);
//        long t2 = System.currentTimeMillis();
//        char[] charArr = {'d','a','c','b'};
//        Arrays.sort(charArr);
//        String[] strArr = {"A","D","B","C","AB","AC","AD","ABC","ABD","ACD","ABCD","BC","BD","BCD","CD","DC","DB","DA","DBA"};
//        Arrays.sort(strArr);
//        System.out.println(JsonHelp.obj2String(array) + "用时"+(t2-t1));
//        System.out.println(JsonHelp.obj2String(charArr));
//        System.out.println(JsonHelp.obj2String(strArr));
    }

    public void getRandom() {
        int max = 10000, min = 1;
        int ran2 = (int) (Math.random() * (max - min) + min);
        System.out.println(ran2);
    }

    @Test
    void testThread() {
        int s = 2 % 3;
        //存在线程安全问题
        System.out.println(s);
//        TMyThread tMyThread1 = new TMyThread();
//        TMyThread tMyThread2 = new TMyThread();
//        TMyThread tMyThread3 = new TMyThread();
//        tMyThread1.start();
//        tMyThread2.start();
//        tMyThread3.start();

    }

    @Test
    void testRunnableThread() {
        //存在线程安全问题
        RMyThread rMyThread = new RMyThread();
        Thread thread1 = new Thread(rMyThread);
        Thread thread2 = new Thread(rMyThread);
        Thread thread3 = new Thread(rMyThread);
        thread1.start();
        thread2.start();
        thread3.start();

    }

    @Test
    void testCallableThread() {

    }

    @Test
    void testCallablePoolThread() throws InterruptedException, ExecutionException {
        System.out.println("----程序开始运行----");
        Date date1 = new Date();

        int taskSize = 5;
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < taskSize; i++) {
            Callable c = new CMyThread(i + " ");
            // 执行任务并获取Future对象
            Future f = pool.submit(c);
            // System.out.println(">>>" + f.get().toString());
            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();

        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }

        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【"
                + (date2.getTime() - date1.getTime()) + "毫秒】");
    }

    @Test
    void contextLoads() {
        String str = "'{'\"type\":\"point\",\"contidirtion\":[[[[{0},{1}],[{2},{3}]]]]'}'";
        String format = MessageFormat.format(str, new String[]{"108.3465", "34.45367", "108.23567", "34.6768"});
        System.out.println(format);
    }

    private static final Integer ONE = 1;

    @Test
    void dataToJson() {
        Map<String, Object> map = new HashMap<>();
        /* 读取数据 */
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("E:/work/高新派出所.txt")),
                    "UTF-8"));
            String lineTxt = null;
            List<FeatureVo> featureVoList = new ArrayList<>();
            while ((lineTxt = br.readLine()) != null) {//数据以逗号分隔
                String[] names = lineTxt.split(",");
                FeatureVo featureVo = new FeatureVo();
                PropertieVo propertieVo = new PropertieVo(Integer.parseInt(names[0]), names[1], "", "");
                double lonlat[] = {Double.parseDouble(names[2]), Double.parseDouble(names[3])};
                GeometryVo geometryVo = new GeometryVo("Point", lonlat);
                featureVo.setProperties(propertieVo);
                featureVo.setGeometry(geometryVo);
                featureVoList.add(featureVo);

            }
            map.put("type", "FeatureCollection");
            map.put("name", "fffff");
//            map.put("crs", "fffff");
            map.put("features", featureVoList);
            System.out.println(JSONObject.toJSONString(map));
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }

        /* 输出数据 */
        /*try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E:/work/get.police-office-new.json")),
                    "UTF-8"));

            for (String name : map.keySet()) {
                bw.write(name + " " + map.get(name));
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            System.err.println("write errors :" + e);
        }*/
    }


}
