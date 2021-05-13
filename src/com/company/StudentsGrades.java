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
