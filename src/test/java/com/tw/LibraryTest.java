package com.tw;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {

    @Test
    public void should_get_true_when_student_number_format_is_correct() {
        Library library = new Library();
        String studentNum = "120123,123456";
        assertTrue("someLibraryMethod should return 'true'", library.isStudentNum(studentNum));
    }

   /* @Test
    public void should_get_true_when_student_format_is_correct() {
        Library library = new Library();
        String studentInfo = "张三，120161，数学：75，语文：95，英语：80";
        assertTrue("someLibraryMethod should return 'true'", library.isStudentInfo(studentInfo));
    }*/
}
