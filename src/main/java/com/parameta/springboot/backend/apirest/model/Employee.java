package com.parameta.springboot.backend.apirest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {


	private Long id;

	@NotBlank(message = "El nombre es requerido.")

	private String name;

	@NotBlank(message = "El apellido es requerido.")
	private String lastName;

	@NotBlank(message = "El tipo de documento es requerido.")
	private String typeDocument;

	@NotBlank(message = "El numero de documento es requerido.")
	private String numberDocument;
	
	@NotBlank(message = "La fecha de nacimiento es requerida.")
	@JsonFormat(pattern="yyyy/MM/dd")
	private String dateBirthday;
	
	@NotBlank(message = "La fecha de vinculacion es requerida.")
	@JsonFormat(pattern="yyyy/MM/dd", timezone = JsonFormat.DEFAULT_TIMEZONE)
	private String dateEntry;
	
	@NotBlank(message = "El cargo es requerido.")
	private String position;

	private Double salary;

	private String age;

	private String timeEntry;


}
