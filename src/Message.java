
public class Message {
	
	
	String subject;
	String sender;
	String content;
	String time;
	int id;
	
	
	public Message(String subject, String sender, String content, String time, int id) {
		super();
		this.subject = subject;
		this.sender = sender;
		this.content = content;
		this.time = time;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "message [subject=" + subject + ", sender=" + sender + ", content=" + content + ", time=" + time + "]";
	}
}
