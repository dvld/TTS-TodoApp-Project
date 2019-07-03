package com.tts.todoapp.Controller;

import com.tts.todoapp.Model.Todo;
import com.tts.todoapp.Repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class TodoController {

	@Autowired
	private TodoRepository todoRepo;
	
	@GetMapping("/")
	public String loadIndexPage(Todo todo, Model model) {
		model.addAttribute("todos", todoRepo.findAll());
		model.addAttribute("completed", todoRepo.findAll());
		return "index";
	}
	
	@GetMapping("/new")
	public String loadNewTodoPage(Todo todo, Model model) {
		model.addAttribute("todos", todoRepo.findAll());
		return "new";
	}
	
	@GetMapping("/update/{id}")
	public String loadUpdateTodoPage(@PathVariable long id, Model model) {
		Todo todo = todoRepo.findById(id).orElse(null);
		model.addAttribute("todos", todo);
		return "update";
	}
	
	@PostMapping("/new")
	public String createNewTodoLoadIndexPage(Todo todo, Model model) {
		todoRepo.save(todo);
		model.addAttribute("todos", todoRepo.findAll());
		model.addAttribute("completed", todoRepo.findAll());
		return "index";
	}
	
	@PutMapping("/update/{id}")
	public String updateExistingTodoLoadIndexPage(@PathVariable long id, Todo todo, Model model) {
		Todo existingTodo = todoRepo.findById(id).orElse(null);
		existingTodo.setTitle(todo.getTitle());
		existingTodo.setDescription(todo.getDescription());
		existingTodo.setAuthor(todo.getAuthor());
		todoRepo.save(existingTodo);
		model.addAttribute("todos", todoRepo.findAll());
		model.addAttribute("completed", todoRepo.findAll());
		return "index";
	}
	
	@PutMapping("/complete/{id}")
	public String markTodoCompletionStatusReloadIndexPage(@PathVariable long id, Todo todo, Model model) {
		Todo todoToMark = todoRepo.findById(id).orElse(null);
		
		if (todoToMark.isStatus() == false) {
			todoToMark.setStatus(true);
		}
		
		if (todoToMark.isStatus() == true) {
			todoToMark.setStatus(false);
		}
		
		todoRepo.save(todoToMark);
		model.addAttribute("todos", todoRepo.findAll());
		model.addAttribute("completed", todoRepo.findAll());
		return "index";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteTodoReloadIndexPage(@PathVariable long id, Todo todo, Model model) {
		todoRepo.deleteById(id);
		model.addAttribute("todos", todoRepo.findAll());
		model.addAttribute("completed", todoRepo.findAll());
		return "index";
	}
	
}
