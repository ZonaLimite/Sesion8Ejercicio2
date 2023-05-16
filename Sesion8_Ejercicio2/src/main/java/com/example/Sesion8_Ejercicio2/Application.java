package com.example.Sesion8_Ejercicio2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //Obtener contexto
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

       /*
        //Obtener bean repositorio
        LaptopRepository laptopRepository = (LaptopRepository) applicationContext.getBean(LaptopRepository.class);

        // Crear algun objeto Laptop
        Laptop laptop = new Laptop(null, "Asus", "200Gio", 4000, 180000);

        //Persistir un laptop
        laptopRepository.save(laptop);
*/

    }

}
