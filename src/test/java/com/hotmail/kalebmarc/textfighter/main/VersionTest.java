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
        String changes = Version.getChange();

        assertTrue(changes.contains("Updated information: Health"));
        assertTrue(changes.contains("Refractor weapons"));
        assertTrue(changes.contains("Refractor enemies"));
        assertTrue(changes.contains("Added critical hits"));
        assertTrue(changes.contains("Testing Directory"));
        assertTrue(changes.contains("Weapon Upgrade System"));
        assertTrue(changes.contains("Organize Classes/packages"));
        assertTrue(changes.contains("Fixed JUnit. Tests are now operable"));
        assertTrue(changes.contains("Confirm overwriting save"));
        assertTrue(changes.contains("Separate battle menu"));
        assertTrue(changes.contains("Updated potion stats"));
        assertTrue(changes.contains("Multiple save files"));
    }
}