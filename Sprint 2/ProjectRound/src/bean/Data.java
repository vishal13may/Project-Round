package bean;

import java.util.HashMap;
import java.util.Map;

public class Data {
	private int answer;
	private String question;
	private Map<Integer, String> choices = new HashMap<Integer, String>();
	private int questionId;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Map<Integer, String> getChoices() {
		return choices;
	}

	public void setChoices(Map<Integer, String> choices) {
		this.choices = choices;
	}

}
