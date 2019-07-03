package com.tts.todoapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

import com.tts.todoapp.Model.Todo;


public class TodoTest {

	private Todo testTodo;
	
	@Test
	public void constructorTest() {
		testTodo = new Todo("Title", "Description", "Author");
		assertEquals("Title", testTodo.getTitle());
		assertEquals("Description", testTodo.getDescription());
		assertEquals("Author", testTodo.getAuthor());
		
		testTodo2 = new Todo("Niko", "Patricia", "Jared");
		assertEquals("Niko", testTodo2.getTitle());
		assertEquals("Patricia", testTodo2.getDescription());
		assertEquals("Jared", testTodo2.getAuthor());
	}
	
	@Test
	public void constructorExceptionTest() {
		Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
			public void execute() throws Throwable {
				testTodo = new Todo(0, "Patricia", "Jared");
			}
		});
	}

}
