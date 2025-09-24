package br.com.atividades.hubCollege.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HtmlViewController {

    @GetMapping("/forms")
    public String showFormPage(Model model) {
        model.addAttribute("tituloPagina", "Maturidade Espiritual - Atividade");
        model.addAttribute("tituloPrincipal", "Maturidade Espiritual");
        model.addAttribute("autor", "Pra. Laura Valente");
        model.addAttribute("subtitulo", "Atividade - Módulo 2: Maturidade Espiritual");

        return "forms"; // Isso busca templates/forms.html
    }

    @PostMapping("/response")
    public String processarFormulario(
            @RequestParam("email") String email,
            @RequestParam("name") String name,
            @RequestParam("registrationNumber") String matricula,
            @RequestParam("module") String modulo,
            Model model
    ) {
        System.out.println("Recebido:");
        System.out.println("Email: " + email);
        System.out.println("Nome: " + name);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Módulo: " + modulo);

        // Envia mensagem de sucesso para exibir no HTML
        model.addAttribute("mensagem", "Formulário enviado com sucesso!");

        return "forms"; // ou redirect para uma página de agradecimento
    }
}
