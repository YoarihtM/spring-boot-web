package com.bolsadeideas.springboot.web.app;

// Con esta clase configuramos otros archivos de tipo properties, como por ejemplo
// el archivo textos.properties que creamos y es personalizado que contiene informacion
// estatica usada en los controladores, esto es un mero ejemplo no tiene que ser siempre así

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
// La notacion plural encapsula los archivos properties que se van a configurar
@PropertySources({
    // la notacion singular indica cual es el archivo que se configurara y se puede
    // agregar mas de uno separandolos por comas
    // la carpeta resources es lo que se conoce tambien como classpath por eso se indica
    // la ruta y el archivo de la siguiente manera "classpath:textos.properties"
    @PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {

}
