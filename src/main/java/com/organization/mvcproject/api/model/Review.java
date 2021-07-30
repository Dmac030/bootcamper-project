package com.organization.mvcproject.api.model;

public interface Review {

	public String getAuthor();
	
	public void setAuthor(String author);
	
	public Integer getRating();
	
	public void setRating(Integer rating);
	
	public String getReviewBody();
	
	public void setReviewBody(String reviewBody);
	
}
