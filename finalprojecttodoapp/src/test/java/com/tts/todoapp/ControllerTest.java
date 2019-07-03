package com.tts.todoapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ControllerTest {

	private MainController testController;

	@Test
	public void indexGetTest() {
		assertEquals("index", testController.index());
	}

}
