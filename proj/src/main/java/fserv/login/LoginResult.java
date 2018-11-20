package fserv.login;

public class LoginResult {
	private boolean result;
	private String errorComment;
	
	
	public LoginResult(boolean result, String errorComment) {
		this.result = result;
		this.errorComment = errorComment;
	}
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getErrorComment() {
		return errorComment;
	}
	public void setErrorComment(String errorComment) {
		this.errorComment = errorComment;
	}

}
