package org.sevenup.core.domain.faq;

import java.util.List;

import org.sevenup.core.domain.common.Category;

public class Question {
	private String questionId;
	private String questionNumber;
	private String questionName;
	
	private List<Category> categories;
	private String qustionDescription = "Question Description";
	private List<Answer> answers;
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(String questionNumber) {
		this.questionNumber = questionNumber;
	}
	public String getQuestionName() {
		return questionName;
	}
	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public String getQustionDescription() {
		return qustionDescription;
	}
	public void setQustionDescription(String qustionDescription) {
		this.qustionDescription = qustionDescription;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
