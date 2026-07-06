package jsp.springboot.exception;

@SuppressWarnings("serial")
public class NoRecordFoundException extends RuntimeException{
	
	public NoRecordFoundException(String messege) {
		super(messege);
	}
}
