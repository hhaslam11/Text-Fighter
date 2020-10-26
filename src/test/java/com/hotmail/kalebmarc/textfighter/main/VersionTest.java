package com.hotmail.kalebmarc.textfighter.main;

import org.junit.Test;

import static org.junit.Assert.*;

public class VersionTest {

    @Test
    public void get() {
        assertEquals(Version.get(), "4.9DEV");
    }

    @Test
    public void getStage() {
        assertTrue(Version.getStage() == "Alpha");
    }

    @Test
    public void getChange() {
    }
}