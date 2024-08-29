package org.comstudy.myweb.model;

public class TodoVo {
	private int no;
	private String title;
	private boolean done;
	
	// 생성자, setters, getters, toString()-객체만 출력한다고 하면 자동으로 출력됨, etc..
	
	public TodoVo() {
		// Default 생성자 - 디폴트 생성자는 매개변수가 없다.
	}
	// 생성자 오버로딩 : 페이지에서 우클릭 > Source > Generate Constructor using Fields...

	public TodoVo(int no, String title, boolean done) {
		super(); // 부모의 생성자 불러옴
		this.no = no; // 자신의 속성 참조
		this.title = title;
		this.done = done;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "TodoVo [no=" + no + ", title=" + title + ", done=" + done + "]";
	}

	
	
}
