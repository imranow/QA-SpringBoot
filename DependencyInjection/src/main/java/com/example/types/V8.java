package com.example.types;

import org.springframework.stereotype.Component;

import com.example.interfaces.Engine;

@Component("V8Engine")
public class V8 implements Engine{
	public String type() {
		return "V8 Engine is designed by imran";
	}

}
