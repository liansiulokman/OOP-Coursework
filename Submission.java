
public class Submission {
	String id;
	String[] answers = new String[100];
	Submission(String taskid){
		id = taskid;
	}
	public void checkAssignment(Assignment a){
		System.out.println("Assignment "+a.aID+" submitted successfully. Your teacher will mark it very soon.");
	}
	public void checkQuiz(Quiz q){
		System.out.println("Quiz "+q.quizID+" submitted successfully.");
		double score=0;
		for(int l=0;l<q.size;l++){
			if(q.answers[l].equals(this.answers[l])){
				score+=(q.fullMark/q.size);
			}
		}
		System.out.println("Your score is "+score+"/"+q.fullMark);
		if(score>=q.passingScore) System.out.println("You are Pass.");
		else System.out.println("You are failed.");
	}
	public void answer(String ans,int qID){
		answers[qID-1]=ans;
	}
}
