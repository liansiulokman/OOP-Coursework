import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener{
	boolean isTeacher = false;
	boolean isStudent = false;
	String teacherName;
	String teacherID;
	String studentName;
	String studentID;
	Teacher teacher1 = new Teacher(null,null);
	Student student1 = new Student(null,null);
	Assignment assignment1 = new Assignment(null,null,0,0,0);
	Quiz quiz1 = new Quiz(null,null,0,0,0);
	Question question1 = new Question(null,0,null,0);
	String tempID;
	String[][] database = new String[100][100];
	String[] ids = new String[100];
	int total=0;
	int count=1;
	int qcount=1;
	int totalQuiz=0;
	
	public GUI(){
		super("Mini LEARN@PolyU");
		this.setLayout(new BorderLayout());
		JPanel main = new JPanel(new GridLayout(1,2));
		JPanel login = new JPanel(new GridLayout(7,2));
		JPanel rightPanel = new JPanel(new GridLayout(7,1));
		
		JPanel teacherPage = new JPanel(new GridLayout(3,1));
		JPanel studentPage = new JPanel(new GridLayout(3,1));
		JPanel createAssPage = new JPanel(new GridLayout(6,2));
		JPanel addAssQPage = new JPanel(new GridLayout(5,2));
		JPanel createQuizPage = new JPanel(new GridLayout(6,2));
		JPanel addQuizQPage = new JPanel(new GridLayout(10,2));
		
		
		createAssPage.add(new JLabel("Task ID:"));
		JTextField taskID = new JTextField(10);
		createAssPage.add(taskID);
		
		createAssPage.add(new JLabel("Assignment Title:"));
		JTextField title = new JTextField(10);
		createAssPage.add(title);
		
		createAssPage.add(new JLabel("Number of questions:"));
		JTextField numOfQ = new JTextField(10);
		createAssPage.add(numOfQ);
		
		createAssPage.add(new JLabel("Passing Score:"));
		JTextField passScore = new JTextField(10);
		createAssPage.add(passScore);
		
		createAssPage.add(new JLabel("Full Mark:"));
		JTextField fullMark = new JTextField(10);
		createAssPage.add(fullMark);
		
		createAssPage.add(new JLabel(""));
		JButton createAssBut = new JButton("Click to add questions");
		createAssBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int num = -1;
				double p = -1;
				double f = -1;
				boolean inputCheck = false;
				String intMsg = "Number of questions and scores should be an integer!";
				String wrongMsg = "Invalid number input, Please try again!";
				try{
					num = Integer.parseInt(numOfQ.getText());
					p = Double.parseDouble(passScore.getText());
					f = Double.parseDouble(fullMark.getText());
					if((num==(int)num)&&(p==(double)p)&&(f==(double)f)&&(title.getText().compareTo("")!=0)&&(taskID.getText().compareTo("")!=0)){
						inputCheck = true;
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(new JButton(e.toString()),intMsg,"Input Error",JOptionPane.ERROR_MESSAGE);
				}
				if(repeat(taskID.getText())){
					JOptionPane.showMessageDialog(new JButton(e.toString()),"Repeated Task ID!","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if((num>0)&&(p>0)&&(f>0)&&(f>=p)&&inputCheck==true&&(!repeat(taskID.getText()))){
					tempID = taskID.getText().toString();
					createAssPage.setVisible(false);
					main.remove(0);
					main.add(addAssQPage,0);
					addAssQPage.setVisible(true);
					teacher1 = new Teacher(teacherName,teacherID);
					total++;
					ids[total-1]=taskID.getText();
					assignment1 = teacher1.createAssignment(title.getText(), taskID.getText(), num, p, f);
				}
				else{
					if(inputCheck==true)
						JOptionPane.showMessageDialog(new JButton(e.toString()),wrongMsg,"Input Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tempID = taskID.getText().toString();
		createAssPage.add(createAssBut);
		
		addAssQPage.add(new JLabel("Task ID:"));
		JTextField tas = new JTextField(10);
		tas.setText(update(tempID));
		tas.setEnabled(false);
		addAssQPage.add(tas);
		
		addAssQPage.add(new JLabel("Question number:"));
		JTextField qNum = new JTextField(10);
		qNum.setText(Integer.toString(count));
		qNum.setEnabled(false);
		addAssQPage.add(qNum);
		
		addAssQPage.add(new JLabel("Question:"));
		JTextField question = new JTextField(10);
		addAssQPage.add(question);
		
		addAssQPage.add(new JLabel("Score:"));
		JTextField score = new JTextField(10);
		addAssQPage.add(score);
		
		addAssQPage.add(new JLabel("Click Main/Back when finish adding all questions."));
		JButton addQBut = new JButton("Add question");
		addQBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double sc = -1;
				boolean inputCheck = false;
				String inputMsg = "Empty field(s) are not allowed. Please enter integer for score.";
				String intMsg = "Please enter an integer for score.";
				String maxMsg = "The number of questions exceeds the size of this assignment. Please click Main Page/Back button to leave this page.";
				try{
					sc = Double.parseDouble(score.getText());
					if((sc==(double)sc)&&(question.getText().compareTo("")!=0)){
						inputCheck = true;
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(new JButton(e.toString()),inputMsg,"Input Error",JOptionPane.ERROR_MESSAGE);
				}
				if(count>assignment1.size){
					System.out.println("LOOP");
					JOptionPane.showMessageDialog(new JButton(e.toString()),maxMsg,"Error",JOptionPane.ERROR_MESSAGE);
				}
				else if((sc>0)&&inputCheck==true&&(count<=assignment1.size)){
					question.setText("");
					score.setText("");
					assignment1.addQuestion(tempID, count, question.getText(), sc);
					count++;
					qNum.setText(Integer.toString(count));
				}
				else if(count>assignment1.size){
					JOptionPane.showMessageDialog(new JButton(e.toString()),maxMsg,"Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
					if(inputCheck==true)
						JOptionPane.showMessageDialog(new JButton(e.toString()),intMsg,"Input Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		addAssQPage.add(addQBut);
		
		createQuizPage.add(new JLabel("Task ID:"));
		JTextField quizID = new JTextField(10);
		createQuizPage.add(quizID);
		
		createQuizPage.add(new JLabel("Question number:"));
		JTextField quizTitle = new JTextField(10);
		createQuizPage.add(quizTitle);
		
		createQuizPage.add(new JLabel("Number of questions:"));
		JTextField totalQ = new JTextField(10);
		createQuizPage.add(totalQ);
		
		createQuizPage.add(new JLabel("Passing Score:"));
		JTextField ps = new JTextField(10);
		createQuizPage.add(ps);
		
		createQuizPage.add(new JLabel("Full Mark:"));
		JTextField fm = new JTextField(10);
		createQuizPage.add(fm);
		
		createQuizPage.add(new JLabel("Click to add questions"));
		JButton createQuizBut = new JButton("Add question");
		createQuizBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double pas = -1;
				double ful = -1;
				int qnumber = -1;
				boolean inputCheck = false;
				String inputMsg = "Empty field(s) are not allowed. Please enter integer for score.";
				String intMsg = "Please enter valid integers.";
				try{
					pas = Double.parseDouble(ps.getText());
					ful = Double.parseDouble(fm.getText());
					qnumber = Integer.parseInt(totalQ.getText());
					if((pas==(double)pas)&&(ful==(double)ful)&&(qnumber==(int)qnumber)&&(quizTitle.getText().compareTo("")!=0)&&(quizID.getText().compareTo("")!=0)){
						inputCheck = true;
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(new JButton(e.toString()),inputMsg,"Input Error",JOptionPane.ERROR_MESSAGE);
				}
				if(repeat(quizID.getText())){
					JOptionPane.showMessageDialog(new JButton(e.toString()),"Repeated Task ID!","Error",JOptionPane.ERROR_MESSAGE);
				}
				else if((pas>0)&&(ful>0)&&(qnumber>0)&&inputCheck==true&&(!repeat(quizID.getText()))){
					tempID = taskID.getText().toString();
					createQuizPage.setVisible(false);
					main.remove(0);
					main.add(addQuizQPage,0);
					addQuizQPage.setVisible(true);
					teacher1 = new Teacher(teacherName,teacherID);
					total++;
					ids[total-1]=quizID.getText();
					quiz1 = teacher1.createQuiz(quizTitle.getText(), quizID.getText(), qnumber, pas, ful);
					totalQuiz++;
				}
				else{
					if(inputCheck==true)
						JOptionPane.showMessageDialog(new JButton(e.toString()),intMsg,"Input Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		createQuizPage.add(createQuizBut);

		
		
		addQuizQPage.add(new JLabel("Task ID:"));
		JTextField qID = new JTextField(10);
		qID.setText(update(tempID));
		qID.setEnabled(false);
		addQuizQPage.add(qID);
		
		addQuizQPage.add(new JLabel("Question number:"));
		JTextField qnumBer = new JTextField(10);
		qnumBer.setText(Integer.toString(qcount));
		qnumBer.setEnabled(false);
		addQuizQPage.add(qnumBer);
		
		addQuizQPage.add(new JLabel("Question:"));
		JTextField quest = new JTextField(10);
		addQuizQPage.add(quest);
		
		addQuizQPage.add(new JLabel("Choice A:"));
		JTextField choiceA = new JTextField(10);
		addQuizQPage.add(choiceA);
		addQuizQPage.add(new JLabel("Choice B:"));
		JTextField choiceB = new JTextField(10);
		addQuizQPage.add(choiceB);
		addQuizQPage.add(new JLabel("Choice C:"));
		JTextField choiceC = new JTextField(10);
		addQuizQPage.add(choiceC);
		addQuizQPage.add(new JLabel("Choice D:"));
		JTextField choiceD = new JTextField(10);
		addQuizQPage.add(choiceD);
		
		DefaultListModel ans = new DefaultListModel();
		ans.addElement("A");
		ans.addElement("B");
		ans.addElement("C");
		ans.addElement("D");
		
		addQuizQPage.add(new JLabel("Answers:"));
		JList ansList = new JList(ans);
		ansList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addQuizQPage.add(ansList);
		
		addQuizQPage.add(new JLabel("Score:"));
		JTextField mark = new JTextField(10);
		addQuizQPage.add(mark);
		
		addQuizQPage.add(new JLabel("Click Main/Back when finish adding all questions."));
		JButton addBut = new JButton("Add question");
		addBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				double sco = -1;
				boolean inputCheck = false;
				String inputMsg = "Empty field(s) are not allowed. Please enter integer for score.";
				String intMsg = "Please enter an integer for score.";
				String maxMsg = "The number of questions exceeds the size of this assignment. Please click Main Page/Back button to leave this page.";
				try{
					sco = Double.parseDouble(mark.getText());
					if((sco==(double)sco)&&(quest.getText().compareTo("")!=0)&&(choiceA.getText().compareTo("")!=0)&&(choiceB.getText().compareTo("")!=0)&&(choiceC.getText().compareTo("")!=0)&&(choiceD.getText().compareTo("")!=0)){
						inputCheck = true;
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(new JButton(e.toString()),inputMsg,"Input Error",JOptionPane.ERROR_MESSAGE);
				}
				if(qcount>quiz1.size){
					JOptionPane.showMessageDialog(new JButton(e.toString()),maxMsg,"Error",JOptionPane.ERROR_MESSAGE);
				}
				else if((sco>0)&&inputCheck==true&&(qcount<=quiz1.size)){
					quest.setText("");
					mark.setText("");
					database[totalQuiz-1][qcount]=quiz1.addQuestion(tempID, qcount, quest.getText(), ansList.getSelectedValue().toString());
					qcount++;
					qnumBer.setText(Integer.toString(qcount));
					choiceA.setText("");
					choiceB.setText("");
					choiceC.setText("");
					choiceD.setText("");
					ansList.clearSelection();
				}
				
				else{
					if(inputCheck==true)
						JOptionPane.showMessageDialog(new JButton(e.toString()),intMsg,"Input Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		addQuizQPage.add(addBut);
		
		
		
		
		
		
		
		
		
		
		teacherPage.add(new JLabel("Choose to create a new Assignment/Quiz.",SwingConstants.CENTER));
		JPanel teacherButton = new JPanel(new GridLayout(3,1));
		JButton createAss = new JButton("Create New Assignment");
		createAss.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				teacherPage.setVisible(false);
				createAssPage.setVisible(true);
				main.remove(0);
				main.add(createAssPage, 0);
			}
		});
		JButton createQuiz = new JButton("Create New Quiz (MC)");
		createQuiz.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				teacherPage.setVisible(false);
				createQuizPage.setVisible(true);
				main.remove(0);
				main.add(createQuizPage, 0);
			}
		});
		teacherButton.add(createAss);
		teacherButton.add(new JLabel(""));
		teacherButton.add(createQuiz);
		teacherPage.add(teacherButton);
		
		
		studentPage.add(new JLabel("Choose one to create a new submission.",SwingConstants.CENTER));
		JPanel studentButton = new JPanel(new GridLayout(3,1));
		JButton answerAss = new JButton("Assignment");
		JButton answerQuiz = new JButton("Quiz (MC)");
		studentButton.add(answerAss);
		studentButton.add(new JLabel(""));
		studentButton.add(answerQuiz);
		studentPage.add(studentButton);
		
		JPanel returnPanel = new JPanel(new GridLayout(1,2));
		JButton backToMain = new JButton("Login Page");
		backToMain.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				teacherPage.setVisible(false);
				returnPanel.setVisible(false);
				studentPage.setVisible(false);
				createAssPage.setVisible(false);
				addAssQPage.setVisible(false);
				createQuizPage.setVisible(false);
				addQuizQPage.setVisible(false);
				taskID.setText("");
				title.setText("");
				numOfQ.setText("");
				passScore.setText("");
				fullMark.setText("");
				tas.setText("");
				qNum.setText("");
				score.setText("");
				question.setText("");
				qnumBer.setText("");
				quest.setText("");
				choiceA.setText("");
				choiceB.setText("");
				choiceC.setText("");
				choiceD.setText("");
				ansList.clearSelection();
				mark.setText("");
				quizID.setText("");
				quizTitle.setText("");
				totalQ.setText("");
				ps.setText("");
				fm.setText("");
				
				main.removeAll();
				main.add(login);
				main.add(rightPanel);
				login.setVisible(true);
				rightPanel.setVisible(true);
			}
		});
		JButton back = new JButton("Main Menu");
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				teacherPage.setVisible(false);
				returnPanel.setVisible(false);
				studentPage.setVisible(false);
				createAssPage.setVisible(false);
				addAssQPage.setVisible(false);
				createQuizPage.setVisible(false);
				addQuizQPage.setVisible(false);
				taskID.setText("");
				title.setText("");
				numOfQ.setText("");
				passScore.setText("");
				fullMark.setText("");
				tas.setText("");
				qNum.setText("");
				score.setText("");
				question.setText("");
				qnumBer.setText("");
				quest.setText("");
				choiceA.setText("");
				choiceB.setText("");
				choiceC.setText("");
				choiceD.setText("");
				ansList.clearSelection();
				mark.setText("");
				quizID.setText("");
				quizTitle.setText("");
				totalQ.setText("");
				ps.setText("");
				fm.setText("");
				
				main.removeAll();
				if(isTeacher==true){
					main.add(teacherPage);
					teacherPage.setVisible(true);
				}
				else{
					main.add(studentPage);
					studentPage.setVisible(true);
				}
				main.add(returnPanel);
				returnPanel.setVisible(true);
			}
		});
		returnPanel.add(new JLabel(""));
		JPanel ret = new JPanel(new GridLayout(4,1));
		ret.add(new JLabel(""));
		ret.add(new JLabel(""));
		ret.add(new JLabel(""));
		JPanel r = new JPanel(new GridLayout(1,2));
		r.add(backToMain);
		r.add(back);
		ret.add(r);
		returnPanel.add(ret);
		teacherPage.add(returnPanel);
		
		
		rightPanel.add(new JLabel(""));
		rightPanel.add(new JLabel(""));
		rightPanel.add(new JLabel(""));
		rightPanel.add(new JLabel(""));
		rightPanel.add(new JLabel(""));
		rightPanel.add(new JLabel(""));
		JPanel layout = new JPanel(new GridLayout(1,2));
		layout.add(new JLabel(""));
		JButton reTurn = new JButton("Exit");
		reTurn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		layout.add(reTurn);
		rightPanel.add(layout);
		
		//JPanel backPanel = new JPanel(new GridLayout(3,1));
		
		
		
		
		
		
		
		JRadioButton teacher = new JRadioButton("Teacher");
		teacher.setHorizontalAlignment(SwingConstants.CENTER);
		teacher.setSelected(true);
		JRadioButton student = new JRadioButton("Student");
		student.setHorizontalAlignment(SwingConstants.CENTER);
		teacher.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				student.setSelected(false);
			}
		});
		student.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				teacher.setSelected(false);
			}
		});
		
		login.add(teacher);
		login.add(student);
		login.add(new JLabel(""));
		login.add(new JLabel(""));
		
		login.add(new JLabel("ID:",SwingConstants.CENTER));
		JTextField id = new JTextField(10);
		login.add(id);
		login.add(new JLabel(""));
		login.add(new JLabel(""));
		
		login.add(new JLabel("Name:",SwingConstants.CENTER));
		JTextField name = new JTextField(10);
		login.add(name);
		login.add(new JLabel(""));
		login.add(new JLabel(""));
		
		
		JButton enter = new JButton("Enter");
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if((id.getText().compareTo("")==0)||(name.getText().compareTo("")==0)){
					JOptionPane.showMessageDialog(new JButton(e.toString()), "Empty field(s)!");
				}
				else{
					login.setVisible(false);
					rightPanel.setVisible(false);
					main.remove(login);
					main.remove(rightPanel);
					id.setText("");
					name.setText("");
					if(teacher.isSelected()==true){
						teacherPage.setVisible(true);
						isTeacher=true;
						isStudent=false;
						main.add(teacherPage);
						teacherName = name.getText();
						teacherID = id.getText();
					}
					else if(student.isSelected()==true){
						studentPage.setVisible(true);
						isStudent=true;
						isTeacher=false;
						main.add(studentPage);
						studentName = name.getText();
						studentID = id.getText();
					}
					main.add(returnPanel);
					returnPanel.setVisible(true);
				}
			}
		});
		login.add(enter);
		login.add(new JLabel(""));
		main.add(login);
		main.add(rightPanel);
		
		this.add(main,BorderLayout.CENTER);
		this.setSize(1200, 750);
		this.setLocation(100, 100);
		this.setVisible(true);
	}

	
	public String update(String id){
		return tempID;
	}
	
	public boolean repeat(String key){
		boolean h = false;
		for(int c=0;c<total;c++){
			if(ids[c].toString().compareTo(key)==0){
				h=true;
			}
		}
		return h;
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
