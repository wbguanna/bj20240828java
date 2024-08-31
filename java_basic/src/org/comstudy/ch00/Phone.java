package org.comstudy.ch00;

public class Phone {
	private String name;
	private String phone;
	
	public Phone() {
		// 디폴트 생성자
	}
	
	public Phone(String name, String phone) {
		// super(); 상속 받지 않으니까 부모의 생성자 호출은 삭제 해야 함.
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", phone=" + phone + "]";
	}
}
