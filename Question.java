
public class Question {
	String taskID;
	int questionID;
	String question;
	double score;
	Question(String taskID,int qID, String q, double s){
		this.taskID = taskID;
		questionID = qID;
		question = q;
		score = s;
	}
}
