package com.example.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Computer {
	public int srNo;
	public String brand;
	public int RAM;
	public int storage;
	public String MB;
	public int price;
	public int warranty;
	public boolean deliveryCharges;
	public int screenSize;
	public String color;
	public String series;

}
