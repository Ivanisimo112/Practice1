package com.company;

import java.util.Arrays;

public class StudentsGrades {
    private int[] studentAssessments = new int[0];

    //1
    public int max() {
        int max = 0;
        for (int i = 0; i < studentAssessments.length; i++) {
            if (studentAssessments[i] > max) {
                max = studentAssessments[i];
            }
        }
        return max;
    }

    //2
    public int min() {
        int min = 100;
        for (int i = 0; i < studentAssessments.length; i++) {
            if (studentAssessments[i] < min) {
                min = studentAssessments[i];
            }
        }
        return min;
    }

    //3
    public double averageRating() {
        double sum = 0;
        for (int i = 0; i < studentAssessments.length; i++) {
            sum = sum + studentAssessments[i];
        }
        return sum / (double) studentAssessments.length;
    }

    //4
    public int numbOfStuWithAScoAboveAver() {
        int counter = 0;
        for (int i = 0; i < studentAssessments.length; i++) {
            if (studentAssessments[i] > averageRating()) {
                counter++;
            }
        }
        return counter;
    }

    //5
    public int numbOfStuWithAScoBelowAver() {
        int counter = 0;
        for (int i = 0; i < studentAssessments.length; i++) {
            if (studentAssessments[i] < averageRating()) {
                counter++;
            }
        }
        return counter;
    }

    //метод який підраховує числа в даному інтервалі
    private int quantityInAGivenInterval(int a, int b) {
        int counter = 0;
        for (int i = 0; i < studentAssessments.length; i++) {
            if (studentAssessments[i] >= a && studentAssessments[i] <= b) {
                counter++;
            }
        }
        return counter;
    }

    //6
    public int numbExcellent() {
        return quantityInAGivenInterval(91, 100);
    }

    //7
    public int numbGood() {
        return quantityInAGivenInterval(71, 90);
    }

    //8
    public int numbSatisfactory() {
        return quantityInAGivenInterval(60, 70);
    }

    //9
    public int numbUnsatisfactory() {
        return quantityInAGivenInterval(0, 59);
    }

    //10
    @Override
    public String toString() {
        return "Оцінки студентів : " + Arrays.toString(studentAssessments);
    }

    //метод сортування злиттям до більшого
    public int[] sortToMore(int[] ints) {
        if (ints.length < 2) {
            return ints;
        }

        int[] ints1 = new int[ints.length / 2];
        for (int i = 0; i < ints1.length; i++) {
            ints1[i] = ints[i];
        }
        int[] ints2 = new int[ints.length-ints.length/2];
        int a = 0;
        for (int i = ints.length / 2; i < ints.length; i++) {
            ints2[a] = ints[i];
            a++;
        }
        ints1 = sortToMore(ints1);
        ints2 = sortToMore(ints2);

        return merger(ints1, ints2);
    }

    //метод сортування злиттям до меньшого
    public int[] sortToLess(int[] ints1) {
        sortToMore(ints1);
        int[] ints = new int[studentAssessments.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = studentAssessments[studentAssessments.length - 1 - i];
        }
        return ints;
    }

    //
    private int[] merger(int[] ints1, int[] ints2) {
        int[] ints = new int[ints1.length + ints2.length];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < ints.length; i++) {
            if (i1 < ints1.length && i2 < ints2.length && ints1[i1] <= ints2[i2]) {
                ints[i] = ints1[i1];
                i1++;
            } else if (i2 == ints2.length) {
                ints[i] = ints1[i1];
                i1++;
            } else if (i1 == ints1.length) {
                ints[i] = ints2[i2];
                i2++;
            } else {
                ints[i] = ints2[i2];
                i2++;
            }
        }

        return ints;
    }

    public void adderToStudentAssessments(int appraisal) {
        int[] ints = new int[getStudentAssessments().length + 1];
        for (int i = 0; i < studentAssessments.length; i++) {
            ints[i] = studentAssessments[i];
        }
        ints[ints.length - 1] = appraisal;
        setStudentAssessments(ints);
    }

    public int[] getStudentAssessments() {
        return studentAssessments;
    }

    public void setStudentAssessments(int[] studentAssessments) {
        this.studentAssessments = studentAssessments;
    }
}
