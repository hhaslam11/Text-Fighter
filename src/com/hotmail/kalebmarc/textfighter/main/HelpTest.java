package com.hotmail.kalebmarc.textfighter.main;
import com.hotmail.kalebmarc.textfighter.main.Help;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import org.junit.jupiter.api.Test;

import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;


public class HelpTest {

	@Test
	//Test to ensure the Help.view() User input 4 outputs Health information
	public void testView() {
		Help.view();
		Ui user = mock(Ui.class);
		when(user.getValidInt()).thenReturn(4);
		//Check console output
		assertEquals(4,Ui.getValidInt());
	}

}
