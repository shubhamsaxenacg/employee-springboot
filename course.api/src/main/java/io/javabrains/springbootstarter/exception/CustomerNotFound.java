package io.javabrains.springbootstarter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Id not found")
public class CustomerNotFound extends RuntimeException {
public CustomerNotFound() {
	// TODO Auto-generated constructor stub
}
}
