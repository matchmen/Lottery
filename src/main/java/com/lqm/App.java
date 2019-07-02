package com.lqm;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){


        System.out.println("彩票随机数打印！");
        System.out.println("请选择彩票类型！");
        System.out.println("A: 双色球");
        System.out.println("B: 大乐透");
        Boolean again = false;
        Scanner sc = new Scanner(System.in);
        String type = "";
        do {
            String typeTemp = sc.next();
            if(typeTemp.equalsIgnoreCase("a") || typeTemp.equalsIgnoreCase("b")){
                type = typeTemp;
            }else {
                System.out.println("选择类型不存在！请重新选择：");
                System.out.println("A: 双色球");
                System.out.println("B: 大乐透");
            }

        } while (type.equals(""));

        do {
            again = false;
            if(type.equalsIgnoreCase("a")) {
                dubbleBall();
            }else {
                bigBall();
            }

            System.out.println("是否再次打印？Y");

            String need = sc.next();
            if (need.equalsIgnoreCase("y")) {
                again = true;
                System.out.println("请选择彩票类型！");
                System.out.println("A: 双色球");
                System.out.println("B: 大乐透");
                do {
                    String typeTemp = sc.next();
                    if(typeTemp.equalsIgnoreCase("a") || typeTemp.equalsIgnoreCase("b")){
                        type = typeTemp;
                    }else {
                        System.out.println("选择类型不存在！请重新选择：");
                        System.out.println("A: 双色球");
                        System.out.println("B: 大乐透");
                    }

                } while (type.equals(""));
            }
        } while (again);

    }


    public static void dubbleBall(){

        System.out.println("请输入需要打印的双色球注数：");
        Scanner sc = new Scanner(System.in);
        String numstr = "";
        int num = 0;

        do {
            numstr = sc.next();
            if (numstr.matches("\\d{1,100}")) {
                num = Integer.valueOf(numstr);
            }else {
                System.out.println("请输入合法数字！");
            }
        } while (num == 0);

        Map<Integer, List<Integer>> map = new HashMap<>();
        Random randomRed = new Random();
        Random randomBlue = new Random();

        int index = 1;
        while (index <= num) {
            List<Integer> lottery = new ArrayList<>();
            int nextNum = 0;
            while (lottery.size() < 6) {
                if (!lottery.contains(nextNum = randomRed.nextInt(33) + 1) && nextNum != 0) {

                    lottery.add(nextNum);
                }
            }

            map.put(index, lottery);
            index++;

            System.out.print("红球: ");
            for (int n : lottery) {
                if (n < 10) {
                    System.out.print("0" + n);
                } else {
                    System.out.print(n);
                }
                System.out.print("  ");
            }

            int blueNum = randomBlue.nextInt(16) + 1;
            if (blueNum < 10) {
                System.out.print("篮球: 0" + blueNum);
            } else {
                System.out.print("篮球: " + blueNum);
            }
            System.out.println();
        }
    }

    public static void bigBall(){
        System.out.println("请输入需要打印的大乐透注数：");
        Scanner sc = new Scanner(System.in);
        String numstr = "";
        int num = 0;

        do {
            numstr = sc.next();
            if (numstr.matches("\\d{1,100}")) {
                num = Integer.valueOf(numstr);
            }else {
                System.out.println("请输入合法数字！");
            }
        } while (num == 0);

        Map<Integer, List<Integer>> map = new HashMap<>();
        Random randomRed = new Random();
        Random randomBlue = new Random();

        int index = 1;
        while (index <= num) {
            List<Integer> lottery = new ArrayList<>();
            int nextNum = 0;
            while (lottery.size() < 5) {
                if (!lottery.contains(nextNum = randomRed.nextInt(35) + 1) && nextNum != 0) {

                    lottery.add(nextNum);
                }
            }
            System.out.print("红球: ");
            for (int n : lottery) {
                if (n < 10) {
                    System.out.print("0" + n);
                } else {
                    System.out.print(n);
                }
                System.out.print("  ");
            }

            lottery.clear();

            while (lottery.size() < 2) {
                if (!lottery.contains(nextNum = randomBlue.nextInt(12) + 1) && nextNum != 0) {

                    lottery.add(nextNum);
                }
            }

            System.out.print("蓝球: ");
            for (int n : lottery) {
                if (n < 10) {
                    System.out.print("0" + n);
                } else{
                    System.out.print(n);
                }
                System.out.print("  ");
            }
            System.out.println();

            index++;
        }
    }


}
