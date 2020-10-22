package com.hotmail.kalebmarc.textfighter.main;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VersionTest5 {
    String hi = "";
    @Before
    public void setUp() throws Exception {
        hi = "hi";
    }

    @Test
    public void test() {
        assertEquals(hi, "hi");
    }
}