
public class Student {
	String id;
	String name;
	Student(String name, String id){
		this.name = name;
		this.id = id;
	}
	public Submission answerTask(String taskid){
		Submission s = new Submission(taskid);
		return s;
	}
}