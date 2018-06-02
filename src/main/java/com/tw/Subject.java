package com.tw;

public class Subject {
    private int math;
    private int chinese;
    private int english;
    private int program;

    public int getMath() {
        return math;
    }

    public int getChinese() {
        return chinese;
    }

    public int getEnglish() {
        return english;
    }

    public int getProgram() {
        return program;
    }

    public int getSum(){
        return math+chinese+english+program;
    }

    public double getAverage(){
        return (double) getSum() / 4;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public void setProgram(int program) {
        this.program = program;
    }
}
