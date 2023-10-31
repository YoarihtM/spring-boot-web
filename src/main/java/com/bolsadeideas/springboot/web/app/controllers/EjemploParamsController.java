package com.bolsadeideas.springboot.web.app.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
    @GetMapping("/")
    public  String index(Model model) {
        model.addAttribute("titulo", "Notacion @RequestParam para enviar parametros");

        return "params/index";
    }

    @GetMapping("/string")
    // La idea es recibir un parámetro desde el request que se va a agregar al controlador
    // mediante la url al hacer la petición GET
    // Se agrega la notación @RequestParam, el tipo de dato y el nombre (el nombre también se puede agregar en el parámetro de la notación)
    // en la notacion se le puede asignar un valor por defecto con el parametro defaultValue
    // o bien podemos modificar si el parametro es requerido o no con required (recibe un valor booleano)
    public String param(@RequestParam(name = "texto", required = false) String texto, Model model){

        model.addAttribute("titulo", "Notacion @RequestParam para recibir parametros en url (query params)");
        model.addAttribute("resultado", "El parametro enviado es: " + texto);

        return "params/ver";
    }

    // De esta manera podemos enviar mas de un parametro por url al controlador y usamos ya un tipo de dato distinto de String
    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model){

        model.addAttribute("titulo", "Notacion @RequestParam para recibir mas de un parametro en url (query params)");
        model.addAttribute("resultado", "El parametro enviado es: '" + saludo + "' y el numero es: '" + numero + "'");

        return "params/ver";
    }

    // Otra forma de enviar parametros es directamente con el objeto HttpServletRequest
    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model){
        String saludo = request.getParameter("saludo");
        Integer numero = null;

        try{
            numero = Integer.parseInt(request.getParameter("saludo"));
        }catch (NumberFormatException e){
            numero = 0;
        }

        model.addAttribute("titulo", "Notacion @RequestParam para recibir mas de un parametro en url (query params)");
        model.addAttribute("resultado", "El parametro enviado es: '" + saludo + "' y el numero es: '" + numero + "'");

        return "params/ver";
    }
}
