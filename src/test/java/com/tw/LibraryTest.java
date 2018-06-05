package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {
    Library library;

    @Before
    public final void before() {
        library = new Library();
    }

    @Test
    public void should_get_true_when_student_number_format_is_correct() {
        assertTrue(library.isStudentNum("120123,123456"));
    }

    @Test
    public void should_get_false_when_student_number_format_is_not_correct() {
        assertFalse(library.isStudentNum("addd"));
    }

   @Test
    public void should_get_true_when_student_information_format_is_correct() {
        assertTrue(library.isStudentInfo("张三，120161，数学：75，语文：95，英语：80"));
    }

    @Test
    public void should_get_false_when_student_information_format_is_not_correct() {
        assertFalse(library.isStudentInfo("张三，asas"));
    }
}
