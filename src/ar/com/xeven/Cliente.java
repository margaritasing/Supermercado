package ar.com.xeven;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    List<Item> items;
    String nombre;
    Boolean jubilado;
    LocalDate fechaNacimiento;

    public void agregarItem(int cantidad, Producto producto){
        items.add(new Item(cantidad, producto));
    }

    public void borrarItem (Producto producto){items.remove(0);}


    public Double calcularTotal(){
        Double total = 0.0;
        for(Item i: items)
            total += i.getCantidad() * i.getProducto().getPrecioUnitario();

        if(jubilado)
            total -= total * 0.15;

        LocalDate hoy = LocalDate.now();
        int esteAnio = hoy.getYear();
        int mesCumple = fechaNacimiento.getMonthValue();
        int diaCumple = fechaNacimiento.getDayOfMonth();
        Boolean cumpleAnios = hoy.equals(LocalDate.of(esteAnio,mesCumple, diaCumple));

        if(cumpleAnios)
            total -= total * 0.10;

        return total;
    }

    public Double mostrarTotal(){
        Double total = 0.0;
        for (Item i: items)
            total+= i.getCantidad() * i.getProducto().getPrecioUnitario();
        return total;
    }

    public Double mostrarDescuentoJubi(){
        Double total1 = 0.0;
        for (Item cont : items)
            if (jubilado)
                total1 += cont.getCantidad()*cont.getProducto().getPrecioUnitario();
            return total1;

    }

    public Double mostrarDesCumple(){
        Double total2 = 0.0;
        LocalDate hoy = LocalDate.now();
        int esteAnio = hoy.getYear();
        int mesCumple = fechaNacimiento.getMonthValue();
        int diaCumple = fechaNacimiento.getDayOfMonth();
        Boolean cupleAnios = hoy.equals(LocalDate.of(esteAnio, mesCumple, diaCumple));

        for (Item aux: items)
            if (cupleAnios)
                total2+= aux.getCantidad()*aux.getProducto().getPrecioUnitario();
            return total2;
   

    }


    public Cliente(String nombre, LocalDate fechaNacimiento, Boolean jubilado) {
        this.items = new ArrayList<>();
        this.nombre = nombre;
        this.jubilado = jubilado;
        this.fechaNacimiento = fechaNacimiento;
    }

}
