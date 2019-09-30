package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.ParamModel;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping
	public void home() {
		System.out.println("Ini adalah homecontroller");
	}
	
	@RequestMapping("/page")
	public String next() {
		return "home";
	}
	
	@RequestMapping("/next")
	public String sendVal(Model model) {
		String message = "Ini adalah nilai yang dikirim dari Controller";
		model.addAttribute("message", message);
		return "next";
	}
	
	@RequestMapping("/model")
	public String model(Model model) {
		ParamModel pm = new ParamModel();
		pm.setNama("AdIns");
		pm.setKelas("Center");
		model.addAttribute("message", "Param Model");
		model.addAttribute("object", pm);
		return "next";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0 ; i < 10 ; i++) {
			result.add(i);
		}
		model.addAttribute("list", result);
		return "collection/list";
	}
	
	@RequestMapping("/listModel")
	public String listModel(Model model) {
		List<ParamModel> result = new ArrayList<ParamModel>();
		for(int i = 0 ; i < 10 ; i++) {
			ParamModel mdl = new ParamModel();
			mdl.setNama("nama "+i);
			mdl.setKelas("kelas "+i);
			result.add(mdl);
		}
		model.addAttribute("list", result);
		return "collection/listModel";
	}
	
	@RequestMapping("/input")
	public String input() {
		return "input/form";
	}
	
	@PostMapping("/input")
	public String submitForm(@RequestParam("nama")String nama,@RequestParam("kelas")String kelas,Model model) {
		System.out.println(nama+" "+kelas);
		model.addAttribute("nama", nama);
		model.addAttribute("kelas", kelas);
		return "/input/result";
	}
	
	@RequestMapping("/inputModel")
	public String inputModel(Model model) {
		model.addAttribute("paramModel", new ParamModel());
		return "inputModel/form";
	}
	
	@PostMapping("/inputModel")
	public String submitFormModel(@ModelAttribute ParamModel pm) {
		System.out.println(pm.getNama()+" "+pm.getKelas());
		return "/inputModel/result";
	}
}
