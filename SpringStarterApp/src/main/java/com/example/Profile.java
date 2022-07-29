package com.example;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Profile {
	@Size(min=4, max=10)
	private String forename;
	
	@Size(min=4, max=10)
	private String surname;
	
	@Pattern(regexp="^(0[1-9]|1[012])[-/.](0[1-9]|[12][0-9]|3[01])[-/.](19|20)\\\\d\\\\d$")
	private String dateOfBirth;
	
	@Size(min = 2, max = 12)
	@NotNull
	private String ethnicity;
	
	@Size
	private String gender;

	@Override
	public String toString() {
		return "Profile [forename=" + forename + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth
				+ ", ethnicity=" + ethnicity + ", gender=" + gender + "]";
	}
	
	

}
