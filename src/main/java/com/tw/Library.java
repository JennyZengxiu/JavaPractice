package com.tw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Library {
    public static List<Student> studentsList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：\n");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    generateReportCard();
                    break;
                case 3:
                    System.exit(0);
                    break;
                    default:
            }
        }
    }

    public static void addStudent(){
        boolean flag = true;
        System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            String inputStr = scanner.nextLine();
            if (isStudentInfo(inputStr)) {
                List<String> studentInfo = Arrays.asList((inputStr.split("，")));
                Student student = new Student();
                Subject subject = new Subject();
                student.setName(studentInfo.get(0));
                student.setStuNumber(Integer.valueOf(studentInfo.get(1)));
                for (String stuInfo:studentInfo){
                    if (stuInfo.contains("数学")) {
                        subject.setMath(Integer.valueOf(stuInfo.split("：")[1]));
                    }
                    else if (stuInfo.contains("英语")) {
                        subject.setEnglish(Integer.valueOf(stuInfo.split("：")[1]));
                    }
                    else if (stuInfo.contains("语文")) {
                        subject.setChinese(Integer.valueOf(stuInfo.split("：")[1]));
                    }
                    else if (stuInfo.contains("编程")) {
                        subject.setProgram(Integer.valueOf(stuInfo.split("：")[1]));
                    }
                }
                student.setSubject(subject);
                studentsList.add(student);
                System.out.println("学生"+student.getName()+"的成绩被添加\n");
                flag = false;
            } else {
                System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
            }
        }
    }

    public static void generateReportCard(){
        boolean flag = true;
        System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            String inputStr = scanner.nextLine();
            if (isStudentNum(inputStr)) {
                List<String> studentNum = Arrays.asList((inputStr.split("，")));
                List<Integer> studentSumScore = new ArrayList<>();
                System.out.println("成绩单");
                System.out.println("姓名|数学|语文|英语|编程|平均分|总分");
                for(Student student:studentsList){
                    if(studentNum.contains(String.valueOf(student.getStuNumber()))){
                        System.out.println(student.getName()+"|"+student.getStuNumber()+"|"+student.subject.getMath()+"|"
                                +student.subject.getChinese()+"|"+student.subject.getEnglish()+"|"+student.subject.getProgram()+"|"
                                +student.subject.getAverage()+"|"+student.subject.getSum());
                    }
                    studentSumScore.add(student.subject.getSum());
                }
                System.out.println("全班总分平均数："+studentSumScore.stream().mapToDouble((x) ->x).summaryStatistics().getAverage());
                List<Integer> temp = studentSumScore.stream().map(x->x).sorted().collect(Collectors.toList());
                System.out.println("全班总分中位数："+ temp.get(temp.size()/2));
                flag = false;
            } else {
                System.out.println("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
            }
        }
    }

    public static boolean isStudentInfo(String studentInfo){
        String matchStr = ".+\\，[0-9]+\\，(.+\\：[0-9]{1,3}\\，*)+";
        if(studentInfo.matches(matchStr))
        {
            return true;
        }
        else
            return false;
    }

    public static boolean isStudentNum(String studentNum){
        String matchNum = "([0-9]+\\,*)+";
        if (studentNum.matches(matchNum)){
            return true;
        }
        else {
            return false;
        }
    }
}
