package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

    // Este handler se usa para lograr enviar los parametros variables a las rutas que se manejan con los mismos
    // de modo que podemos escribir los parametros que se van a enviar a los rutas desde esta vista
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Enviar parametros a la ruta (@PathVariable)");

        return "variables/index";
    }

    // Aqui es donde cambia en lugar de usar la notacion @RequestParam se usa @PathVariable
    // con lo cual podemos enviar un parametro que contiene una parte del texto que es valga la redundancia, variable
    // el nombre de la variable enviada en la ruta debe ser el mismo que en el parametro y en caso de no serlo
    // se puede especificar en el argumento de la notacion, como por ejemplo @PathVariable(name="texto") String textoOtro
    @GetMapping("/string/{texto}")
    public String variables(@PathVariable String texto, Model model){
        model.addAttribute("titulo", "Recibir los parametros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto);

        return "variables/ver";
    }

    // Version con mas de un parametro variable en la ruta, donde se separan por un slash
    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model){
        model.addAttribute("titulo", "Recibir los parametros de la ruta (@PathVariable)");
        model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto + " " +  numero);

        return "variables/ver";
    }

}
