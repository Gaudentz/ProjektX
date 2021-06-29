package ch.zhaw.springboot.models;

public class IndictmentRequest {

	public String situation;
	public String date;
	public boolean verdict;
	
	public long crime_id;
	public long defendant_id;
	
	
	public IndictmentRequest(String date, String situation, boolean verdict, long crime_id, long defendant_id) {
		this.situation = situation;
		this.date = date;
		this.verdict = verdict;
		this.crime_id = crime_id;
		this.defendant_id = defendant_id;
	}	
}
