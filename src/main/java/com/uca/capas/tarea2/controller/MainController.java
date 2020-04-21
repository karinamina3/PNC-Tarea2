package com.uca.capas.tarea2.controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@RequestMapping("/tarea2")
	public @ResponseBody String ejemplo() {
		String firstName = "Karina",
			   lastName = "Mina", 
			   carnet = " 00012217",
			   carrera = "Ingeniería Informática",
			   year = "4to año";
		
		return "NOMBRE: " +  firstName + " - APELLIDO: " + lastName +
			   " - CARNET: " + carnet + " - CARRERA: " + carrera + " - AÑO CURSADO: " + year;
		
	}

	
	@RequestMapping("/parametro")
	public @ResponseBody String parametro(HttpServletRequest request) {
		Integer paramDay = Integer.parseInt(request.getParameter("day"));
		Integer paramMonth = Integer.parseInt(request.getParameter("month"));
		Integer paramYear = Integer.parseInt(request.getParameter("year"));

		LocalDate localDate = LocalDate.of(paramYear, paramMonth, paramDay); 
		DayOfWeek dayOfWeek = DayOfWeek.from(localDate); 
		
		return paramDay + "/" + paramMonth + "/" + paramYear + " -> " + dayOfWeek.name().toString();
		
	}

}
