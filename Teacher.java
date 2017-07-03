
public class Teacher {
	String id;
	String name;
	Teacher(String name, String id){
		this.name = name;
		this.id = id;
	}
	public Assignment createAssignment(String title, String id,int size, double pass, double full){
		Assignment t = new Assignment(this.id,title,size,pass,full);
		return t;
	}
	public Quiz createQuiz(String title, String id, int size, double pass, double full){
		Quiz t = new Quiz(this.id,title,size,pass,full);
		return t;
	}
}
