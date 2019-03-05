package com.ListDemo;

import java.util.Set;

import com.Question.Question;

public class ListDemo 
{

	private Set<Question> answers;

	public Set<Question> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Question> answers) {
		this.answers = answers;
	}
	public void show()
	{
		for(Question s:answers)
		{
			System.out.println(s.getQuestion()+" "+s.getAnswer());
		}
	}

}
