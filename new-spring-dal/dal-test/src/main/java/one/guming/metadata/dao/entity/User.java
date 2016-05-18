package one.rangp.metadata.dao.entity;

public class User {
	private Integer userId;
	private String name;
	
	private String address;
	
	

	public User(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
