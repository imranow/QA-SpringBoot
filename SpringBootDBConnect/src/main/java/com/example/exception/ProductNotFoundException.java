package com.example.exception;

import javax.persistence.EntityNotFoundException;

public class ProductNotFoundException extends EntityNotFoundException{
	public ProductNotFoundException() {}
	public ProductNotFoundException(String msg) {
		super(msg);
	}
}
