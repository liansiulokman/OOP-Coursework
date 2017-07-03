
public class Quiz{
	String quizID;
	String title;
	double passingScore;
	double fullMark;
	int size;
	String[] questions= new String[100];
	String[] answers= new String[100];
	Quiz(String id,String t,int size, double p, double f){
		quizID = id;
		title = t;
		passingScore = p;
		fullMark = f;
		this.size = size;
	}
	public String addQuestion(String taskID,int qID, String question, String ans){
		double score = fullMark/size;
		Question q = new Question(taskID, qID,question,score);
		questions[qID-1]=q.toString();
		answers[qID-1]=ans.toString();
		return answers[qID-1].toString();
	}
}
