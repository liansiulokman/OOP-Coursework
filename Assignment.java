
public class Assignment{
	String aID;
	String title;
	double passingScore;
	double fullMark;
	int size;
	Assignment(String id,String t,int size, double p, double f){
		aID = id;
		title = t;
		passingScore = p;
		fullMark = f;
		this.size=size;
	}
	public void addQuestion(String taskID,int qID, String question, double score){
		String[] questions = new String[size];
		Question q = new Question(taskID, qID,question,score);
		questions[qID-1]=q.toString();
	}
	
}
