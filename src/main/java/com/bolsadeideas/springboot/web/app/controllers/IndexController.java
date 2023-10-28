package com.bolsadeideas.springboot.web.app.controllers;

import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller

// El RequestMapping genera una ruta general que sera la ruta de primer nivel por donde todos los handlers
// tendran que pasar, siendo que los controladores contendran todas las rutas de segundo nivel
// en este caso la ruta de primer nivel es /app por lo que para acceder a la aplicacion
// deberiamos ingresar al menos en el servidor local con localhost:8080/app/<controlador>
@RequestMapping("/app")
public class IndexController {
    // Handlers o métodos que representan una página web
    // para manejar las peticiones de los usuarios

    // Se mapea para relacionar la ruta URL con el metodo que estamos implementando
    // el primer parametro es la ruta y el segundo el metodo de peticion con el que se accede a la ruta
    // si es por metodo GET se puede omitir, caso contrario es necesario importarlo como se muestra en el ejemplo de abajo
    // @RequestMapping(value = "/index", method = RequestMethod.GET)

    // otra forma de realizar el get request es mediante la importacion de otra notacion
    // esta notacion funciona como alias al RequestMapping de tipo GET
    // Existen los alias para todos los tipos de metodos http usados con RequestMapping (POST, PUT, DELETE)

    // El parametro por defecto es el value por lo que si no hay mas parametros se puede omitir y dejar solo el valor
    // el metodo puede estar mapeado a mas de una url haciendo uso de las llaves para englobar todas las url que mapea
    // @GetMapping(value = "/index")

    // Para enviar datos desde el controlador a la vista existen varios metodos, uno de ellos es
    // con la interfaz Model que se manda como argumento al handler

    // public String index(Model model){

    // otra forma es usando el ModelMap que es una clase heredada de Map
    // reciben ambas los mismos argumentos

    // public String index(ModelMap model){

    // una tercera forma es implementando directamente la clase Map
    // la diferencia es que en lugar de usar el metodo addAttribute se usa put
    // public String index(Map<String, Object> map) {
    //      map.put("titulo", "Hola Spring con map");
    //
    //      return "index";
    //
    // }

    // otra forma de hacerlo es con ModelAndView
    // en este caso el método es addObject y en lugar de retornar un String se retorna un ModelAndView
    // y para retornar la vista se utiliza el método setViewName del objeto ModelAndView
    // dentro del método se indica la vista que se busca renderizar
    @GetMapping({"", "/", "/index", "/home"})
    public ModelAndView index(ModelAndView mv){

        // se envian los datos de la siguiente manera donde primero se manda el atributo del nombre del dato
        // y el segundo parametro es el valor del dato
        mv.addObject("titulo", "Hola Spring Framework con ModelAndView!");
        mv.setViewName("index");

        return mv;
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Yoariht");
        usuario.setApellido("Macedo");

        model.addAttribute("titulo", "Perfil de usuario: ".concat(usuario.getNombre()));
        model.addAttribute("usuario", usuario);

        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){

    //    List<Usuario> usuarios = new ArrayList<>();
    //
    //    usuarios.add(new Usuario("Yoariht", "Macedo", "ymacedo@mail.com"));
    //    usuarios.add(new Usuario("Brenda", "Martinez", "bmartinez@mail.com"));
    //    usuarios.add(new Usuario("Melanie", "Macedo", "mmacedo@mail.com"));

    //  Otra forma de crear la lista de usuarios

//        List<Usuario> usuarios = Arrays.asList(
//                new Usuario("Yoariht", "Macedo", "ymacedo@mail.com"),
//                new Usuario("Brenda", "Martinez", "bmartinez@mail.com"),
//                new Usuario("Melanie", "Macedo", "mmacedo@mail.com")
//        );

        model.addAttribute("titulo", "Listado de usuarios");
    //  model.addAttribute("usuarios", usuarios);

        return "listar";
    }

    // Otra forma de pasar datos desde el controlador a la vista es mediante la notacion @ModelAttribute
    // En la anotacion se coloca el nombre de la variable que vamos a enviar a la vista de modo que
    // como en el caso anterior la variable de la lista fue "usuarios" esta vez se anota @ModelAttribute("usuarios")
    // y se retorna el valor asignado a dicha variable por eso el metodo es de tipo List en este caso
    // esta notacion se hace para pasar datos a la vista de todos los handlers o controladores que formen parte de la app
    // por esa razon se ha comentado en el metodo anterior la informacion de los usuarios
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Yoariht", "Macedo", "ymacedo@mail.com"),
                new Usuario("Brenda", "Martinez", "bmartinez@mail.com"),
                new Usuario("Melanie", "Macedo", "mmacedo@mail.com")
        );

        return usuarios;
    }

}
