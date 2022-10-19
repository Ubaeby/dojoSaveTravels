package com.codingdojo.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

@Controller
public class TravelController {

	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String main(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpense();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String add(
			@Valid @ModelAttribute("expense") Expense expense, BindingResult result,  Model model) {
		System.out.println(result.hasErrors());
		if (result.hasErrors()) {
			System.out.println("test");
			return "index.jsp";
		}
		else {
			System.out.println("otherTest");
			expenseService.createExpense(expense);

			return "redirect:/expenses";

		}
	}
}
