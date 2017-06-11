package org.duncan.entity;

import java.io.Serializable;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="vehicles")
public class Vehicle implements Serializable { 

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="nickname")
	@NotEmpty(message="*Please provide nickname")
	private String nickname;

	@Column(name="plate")
	@Length(min=5, max=8, message="*The plate must have between 5 and 8 characters")
	@NotEmpty(message="*Please enter plate")
	private String plate;
	
	@Column(name="year")
	@Min(value=1970, message="*The model year must be at least 1970")
	@NotNull(message="*Please enter model year of vehicle")
	private int year = Year.now().getValue();
	
	@Column(name="type_of_vehicle")
	@Min(value=1)
	@NotNull(message="*Please enter type of vehicle")
	private byte typeOfVehicle;
	
	@ManyToOne
	private Model model;
	
	@Column(name="color")
	@Length(min=7, max=7, message="*The color must be 7 characters hexadecimal string")
	@NotEmpty(message = "*Please select color")
	private String color;
	
	@Column(name="active")
	private boolean active;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public byte getTypeOfVehicle(){
		return typeOfVehicle;
	}
	
	public void setTypeOfVehicle(byte typeOfVehicle){
		this.typeOfVehicle = typeOfVehicle;
	}
	
	public Model getModel(){
		return model;
	}
	
	public void setModel(Model model){
		this.model = model;
	}
	
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public boolean getActive(){
		return active;
	}
	
	public void setActive(boolean active){
		this.active = active;
	}

}