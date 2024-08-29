package org.comstudy.myweb.model;

import java.util.ArrayList;

public class TodoDTO {
	private ArrayList<TodoVo> todos;

	public TodoDTO() {
		super();
		this.todos = new ArrayList<TodoVo>(8);
	}
	
	
	
	public ArrayList<TodoVo> getTodos() {
		return todos;
	}



	public void setTodos(ArrayList<TodoVo> todos) {
		this.todos = todos;
	}



	public boolean appendTodo(TodoVo newTodo) {
		return todos.add(newTodo);
	}
	
	public boolean deleteTodo(int no) {
		boolean result = false;
		for (TodoVo todo : todos) {
			if (todo.getNo() == no) {
				
			}
			
		}
		return result;
	}
	
}
