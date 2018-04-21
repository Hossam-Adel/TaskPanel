package dto;

//import java.sql.Date;



public class Task {
	int ID;
	
	String title,description;
	Long assign_date,deadline_date,start_date;
	Status status;
	User creator,receiver;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Long getAssign_date() {
		return assign_date;
	}
	public void setAssign_date(Long assign_date) {
		this.assign_date = assign_date;
	}
	public Long getDeadline_date() {
		return deadline_date;
	}
	public void setDeadline_date(Long deadline_date) {
		this.deadline_date = deadline_date;
	}
	public Long getStart_date() {
		return start_date;
	}
	public void setStart_date(Long start_date) {
		this.start_date = start_date;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	

}
