package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // con esto podemos redirigir la url a otra ruta de modo que el metodo no devuelve
    // una vista sino una cadena que es la que indica a que ruta vamos a redirigir
    // para ello se usa la palabra clave seguida de los dos puntos y la ruta "redirect:<ruta>"
    // @GetMapping("/")
    // public String home() {

    //     return "redirect:/app/index";
    // }

    // otra forma de realizar la redireccion es mediante el uso de "forward:/<ruta>"
    // con esto, se realiza un dispatch en la misma peticion http y se ejecuta la redireccion
    // asi los parametros del request no se pierden y se mantiene la url del inicio sin redirigir
    // no se puede hacer un forward de una ruta o url externa como con redirect
    @GetMapping("/")
    public String home(){
        return "forward:/app/index";
    }


}
