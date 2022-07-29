package com.example.types;

import org.springframework.stereotype.Component;

import com.example.interfaces.Engine;

@Component("V6Engine")
public class V6 implements Engine{
	public String type() {
		return "V6 Engine is designed by imran";
	}

}
