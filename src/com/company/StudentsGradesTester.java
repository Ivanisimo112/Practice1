package com.company;

import java.util.Arrays;

public class StudentsGradesTester {
    public static void main(String[] args) {
        StudentsGrades studentsGrades = new StudentsGrades();
        System.out.print("Вводите оцінки студентів, що припинити введіть число більше 100 або менше 0: ");
        int stud = DataInput.getInt();
        while (stud >= 0 && stud <= 100){
            studentsGrades.adderToStudentAssessments(stud);
            stud = DataInput.getInt();
        }
        //вивести всі оцінки (метод toString())
        System.out.println(studentsGrades.toString());
        //1
        System.out.println("найвищий бал: " + studentsGrades.max());
        //2
        System.out.println("найменший бал: " + studentsGrades.min());
        //3
        System.out.println("середній бал групи: " + studentsGrades.averageRating());
        //4
        System.out.println("кількість студентів в яких бал вищий за середній: "+ studentsGrades.numbOfStuWithAScoAboveAver());
        //5
        System.out.println("кількість студентів в яких бал нижчий за середній: "+ studentsGrades.numbOfStuWithAScoBelowAver());
        //6
        System.out.println("кількість студентів з відмінною оцінкою: "+ studentsGrades.numbExcellent());
        //7
        System.out.println("кількість студентів з оцінкою \"добре\": "+ studentsGrades.numbGood());
        //8
        System.out.println("кількість студентів з оцінкою \"задовільно\": "+ studentsGrades.numbSatisfactory());
        //9
        System.out.println("кількість студентів з оцінкою \"не задовільно\": "+ studentsGrades.numbUnsatisfactory());
        studentsGrades.sortToMore();
        System.out.println(studentsGrades.toString());
        studentsGrades.sortToLess();
        System.out.println(studentsGrades.toString());

    }
}
