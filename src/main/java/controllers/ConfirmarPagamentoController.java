package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfirmarPagamentoController {
	@GetMapping("/")
	public String confirmarPagamento(){
		return "Hello world";
	}
}
