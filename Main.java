
public class Main {
	public static void main(String[] args){
		GUI ui = new GUI();
		
		Teacher t1 = new Teacher("Miss Chan","001");
		Student s1 = new Student("Chan Tai Man","100");
		String[][] answerDatabase = new String[100][100];
		Assignment a1 = t1.createAssignment("Assignment1","01",5,40.0,100.0);
		a1.addQuestion("01", 1, "Question 1", 20);
		a1.addQuestion("01", 2, "Question 2", 20);
		a1.addQuestion("01", 3, "Question 3", 20);
		a1.addQuestion("01", 4, "Question 4", 20);
		a1.addQuestion("01", 5, "Question 5", 20);
		Submission s = s1.answerTask(a1.aID);
		s.answer("A",1);
		s.answer("A",2);
		s.answer("A",3);
		s.answer("A",4);
		s.answer("A",5);
		s.checkAssignment(a1);
		Quiz q1 = t1.createQuiz("Quiz1", "02", 10, 4.0, 10.0);
		answerDatabase[02][1-1]=q1.addQuestion("02", 1, "Q1", "D");
		answerDatabase[02][2-1]=q1.addQuestion("02", 2, "Q2", "D");
		answerDatabase[02][3-1]=q1.addQuestion("02", 3, "Q3", "D");
		answerDatabase[02][4-1]=q1.addQuestion("02", 4, "Q4", "D");
		answerDatabase[02][5-1]=q1.addQuestion("02", 5, "Q5", "D");
		answerDatabase[02][6-1]=q1.addQuestion("02", 6, "Q6", "D");
		answerDatabase[02][7-1]=q1.addQuestion("02", 7, "Q7", "D");
		answerDatabase[02][8-1]=q1.addQuestion("02", 8, "Q8", "D");
		answerDatabase[02][9-1]=q1.addQuestion("02", 9, "Q9", "D");
		answerDatabase[02][10-1]=q1.addQuestion("02", 10, "Q10", "D");
		
		Submission s2 = s1.answerTask(q1.quizID);
		s2.answer("A", 1);
		s2.answer("D", 2);
		s2.answer("D", 3);
		s2.answer("D", 4);
		s2.checkQuiz(q1);
		
	}
}
