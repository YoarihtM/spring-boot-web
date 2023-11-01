package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    @GetMapping("/string/{texto}")
    // Aqui es donde cambia en lugar de usar la notacion @RequestParam se usa @PathVariable
    // con lo cual podemos enviar un parametro que contiene una parte del texto que es valga la redundancia, variable
    // el nombre de la variable enviada en la ruta debe ser el mismo que en el parametro y en caso de no serlo
    // se puede especificar en el argumento de la notacion, como por ejemplo @PathVariable(name="texto") String textoOtro
    public String variables(@PathVariable String texto, Model model){
        model.addAttribute("titulo", "Recibir los parametros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto);

        return "variables/ver";
    }


}
