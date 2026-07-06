package jsp.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jsp.springboot.dto.ResponseStructure;

public class GlobalExceptipnHandler extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleINFE(IdNotFoundException exception){
		
		ResponseStructure<String> res = new ResponseStructure<>();
		
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		res.setMessage(exception.getMessage());
		res.setData("Failure");
		
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleNRAE(NoRecordFoundException exception){
		
		ResponseStructure<String> res = new ResponseStructure<String>();
		
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		res.setMessage(exception.getMessage());
		res.setData("Failure");
		
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(IlligleExpressionException.class)
	public ResponseEntity<ResponseStructure<String>> handleIEE(IlligleExpressionException exception){
		
		ResponseStructure<String> res = new ResponseStructure<String>();
		
		res.setStatusCode(HttpStatus.NOT_FOUND.value());
		res.setMessage(exception.getMessage());
		res.setData("Failure");
		
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);
		
	}
	

}
