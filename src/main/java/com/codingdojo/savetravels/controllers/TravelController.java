package com.codingdojo.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	
	@GetMapping("/expenses/{id}")
	public String getOne(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expenses", expense);
		return "expense.jsp";
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
			return "index.jsp";
		}
		else {
			expenseService.createExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	
	//Edit and Update Method
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/{id}")
	public String update(
			@Valid @ModelAttribute("expense") Expense expense, BindingResult result ) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} 
		else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	
	//Delete Method
	
	@DeleteMapping("/expenses/{id}")
	public String destroy(@PathVariable("id") Long id) {
		expenseService.destoryExpense(id);
		return "redirect:/expenses";
	}
}
