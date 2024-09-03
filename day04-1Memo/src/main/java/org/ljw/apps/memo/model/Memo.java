package org.ljw.apps.memo.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Memo {
	private int id;
	private String title;
	private String content;
	
	private static int ID = 1;
//	private LocalDateTime createdTime;
//	private LocalDateTime updatedTime;

	public Memo() {
	}
	
	public Memo(String title, String content) {
		this.id = ID++;
		this.title = title;
		this.content = content;
	}
	

	public Memo(int id, String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Memo other = (Memo) obj;
		return id == other.id;
	}
	
	
	
}
