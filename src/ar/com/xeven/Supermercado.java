package ar.com.xeven;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {

    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        List<Producto> productos = new ArrayList<>();

        clientes.add(new Cliente("pablo", LocalDate.of(2020,9,01),false));
        clientes.add(new Cliente("eric", LocalDate.of(2019,1,30),true));
        clientes.add(new Cliente("ana", LocalDate.of(2015,1,30),false));
        clientes.add(new Cliente("samantha", LocalDate.of(2010,8,14),true));

        productos.add(new Producto("banana","desc",20.0,"Frutas"));
        productos.add(new Producto("manzana","desc",25.0,"Comidas"));
        productos.add(new Producto("Plato","desc",80.0,"Bazar"));
        productos.add(new Producto("lavandina","desc",15.0,"Limpieza"));
        productos.add(new Producto("Arroz", "desc", 20.0, "Comidas"));
        productos.add(new Producto("Platano", "desc", 25.0, "Fruta"));
        productos.add(new Producto("Naranja", "desc", 80.0, "Fruta"));
        productos.add(new Producto("Café", "desc", 15.0, "Bebida"));

        /* filtrar producto */
        productos.stream().filter(p -> p.getClasificacion().equals("Fruta"))
                .forEach(p -> System.out.println(p.getClasificacion() + ": " +  p.getNombre()));
        System.out.println("==============================");


        clientes.get(0).agregarItem(10, productos.get(1));
        clientes.get(0).agregarItem(25, productos.get(0));
        clientes.get(1).agregarItem(20, productos.get(0));
        clientes.get(2).agregarItem(60, productos.get(5));

        Cliente cliente0 = clientes.get(0);
        Cliente cliente1 = clientes.get(1);
        /*System.out.println("Monto sin descuento : $ " + cliente0.mostrarSinDescu());
         System.out.println("Descuento Jubilado es: 0.15 % $" + cliente0.mostrarDescuento());
         System.out.println("Descuento por cumpleaños es : 0.10 % $ " + cliente0.mostrarDesCumple());
         System.out.println("Total: $" + cliente0.calcularTotal());

         System.out.println("=======================================");
         System.out.println("Monto sin descuento : $ " + cliente1.mostrarSinDescu());
         System.out.println("Descuento Jubilado es: 0.15 % $" + cliente1.mostrarDescuento());
         System.out.println("Descuento por cumpleaños es : 0.10 % $ " + cliente1.mostrarDesCumple());
         System.out.println("Total: $" + cliente1.calcularTotal()); */

        /*Borrar Item*/
        clientes.get(0).borrarItem(productos.get(1));
        clientes.get(0).borrarItem(productos.get(0));
        System.out.println("========================================");
        System.out.println("El cliente 0 va a gastar: $"+cliente0.calcularTotal());
        System.out.println("El cliente 1 va a gastar: $"+cliente1.calcularTotal());


    }
}
