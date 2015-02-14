package exceptions;

public abstract class AutoException extends Exception{
	private int code;
	private String msg;

	public AutoException(int num, String msg) {
		this.code = num;
		this.msg = msg;
	}
	
	public abstract void print();
	
	public String toString(){
		return "Error code= " + code + "\n" + "Error Message = " + msg;
	}

	public int getErrorCode() {
		return code;
	}

	public void setErrorCode(int errorNum) {
		this.code = errorNum;
	}

	public String getErrorMsg() {
		return msg;
	}

	public void setErrorMsg(String errorMsg) {
		this.msg = errorMsg;
	}
}
