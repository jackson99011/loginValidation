package com.example.password.valid;

import java.util.ArrayList;
import java.util.List;

public class ValidResult {
	
	private boolean valid;
	
	private List<String> validErrorsMsg;

	public ValidResult() {
		super();
		validErrorsMsg = new ArrayList<String>();
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public List<String> getValidErrorsMsg() {
		return validErrorsMsg;
	}

	private void setValidErrorsMsg(List<String> validErrorsMsg) {
		this.validErrorsMsg = validErrorsMsg;
	}
	
	public void addValidErrorsMsg(String errorMessage){
		this.validErrorsMsg.add(errorMessage);
	}
	
	
	

}
