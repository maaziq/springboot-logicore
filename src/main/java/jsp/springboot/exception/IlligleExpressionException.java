package jsp.springboot.exception;

@SuppressWarnings("serial")
public class IlligleExpressionException extends RuntimeException{
	
	public IlligleExpressionException(String messege) {
		super(messege);
	}

}
