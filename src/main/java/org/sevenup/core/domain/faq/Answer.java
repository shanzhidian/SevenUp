package org.sevenup.core.domain.faq;

import java.util.List;

import org.sevenup.core.domain.common.Category;

public class Answer {
	private String answerId;
	private String answerNumber;
	private String answerName;
	private List<Category> categories;
	private String answerDescription = "Answer Description";
	
	private List<Question> questions;
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	public String getAnswerNumber() {
		return answerNumber;
	}
	public void setAnswerNumber(String answerNumber) {
		this.answerNumber = answerNumber;
	}
	public String getAnswerName() {
		return answerName;
	}
	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public String getAnswerDescription() {
		return answerDescription;
	}
	public void setAnswerDescription(String answerDescription) {
		this.answerDescription = answerDescription;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
