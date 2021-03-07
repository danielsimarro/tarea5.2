/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

import java.util.ArrayList;

/**
 *
 * @author NitroPc
 */
public class Main {

    public static void main(String[] args) {

        // la instancia easydrive de la clase EmpresaAlquilerVehiculos
        EmpresaAlquilerVehiculos easydrive = new EmpresaAlquilerVehiculos("A-28-187189", "easy drive", "www.easydrive.com");
        //Creo los clientes
        Cliente cliente1 = new Cliente("X5618927C", "Juan", "González López");
        Cliente cliente2 = new Cliente("Z7568991Y", "Luis", "Fernández Gómez");
        Cliente cliente3 = new Cliente("580ds9403", "Marco", "Nieto Moreno");
        Cliente cliente4 = new Cliente("8043dad93", "Luna", "Mouzo Reigada");
        Cliente cliente5 = new Cliente("7498s9df0", "Martin", "Salvador Trujillo");
        // registro de los clientes de la empresa
        easydrive.registrarCliente(cliente1);
        easydrive.registrarCliente(cliente2);
        easydrive.registrarCliente(cliente3);
        easydrive.registrarCliente(cliente4);
        easydrive.registrarCliente(cliente5);
        
        // Creo los vehiculos
        Vehiculo vehiculo1 = new Vehiculo("4060 TUR", "Skoda", "Fabia", "Blanco", 90.0, false);
        Vehiculo vehiculo2 = new Vehiculo("4070 DEP", "Ford", "Mustang", "Rojo", 150.0, true);
        Vehiculo vehiculo3 = new Vehiculo("4080 TUR", "VW", "GTI", "Azul", 110.0, false);
        Vehiculo vehiculo4 = new Vehiculo("4090 TUR", "SEAT", "Ibiza", "Blanco", 90.0, false);
        Vehiculo vehiculo5 = new Vehiculo("4100 FUR", "Fiat", "Ducato", "Azul", 80.0, true);

        // registro de los vehículos de la empresa 
        easydrive.registrarVehiculo(vehiculo1);
        easydrive.registrarVehiculo(vehiculo2);
        easydrive.registrarVehiculo(vehiculo3);
        easydrive.registrarVehiculo(vehiculo4);
        easydrive.registrarVehiculo(vehiculo5);
        
        //Imprimir contenido de las listas
        System.out.println("Lista de los clientes");
        easydrive.getListaCliente().forEach((System.out::println));
        System.out.println("Listas de los vehiculos");
        easydrive.getListaVehiculo().forEach(System.out::println);
        //Alquilar el vehiculo
        System.out.println("El vehiculo se ha alquilado correctamente " + easydrive.alquilerVehiculo(cliente1, vehiculo1, 2));
        System.out.println("El vehiculo se ha alquilado correctamente " + easydrive.alquilerVehiculo(cliente2, vehiculo5, 10));
        System.out.println("El vehiculo se ha alquilado correctamente " + easydrive.alquilerVehiculo(cliente3, vehiculo2, 1));
        System.out.println("El vehiculo se ha alquilado correctamente " + easydrive.alquilerVehiculo(cliente4, vehiculo3, 4));
        System.out.println("El vehiculo se ha alquilado correctamente " + easydrive.alquilerVehiculo(cliente5, vehiculo4, 7));
        //Ordenar vehiculos por tarifa
        easydrive.ordendarVehiculoTarifa();
        System.out.println("Listas de los vehiculos ordenados por tarifa:");
        easydrive.getListaVehiculo().forEach(System.out::println);
        //Ordenar los alquileres por fecha de alquiler
        easydrive.ordendarAlquilerFecha();
        System.out.println("Listas de los alquileres ordenados por fecha:");
        easydrive.getListaAlquiler().forEach(System.out::println);
        //Buscar alquileres de un cliente segun su nif
        System.out.println("Lista alquleres del cliente: ");
        ArrayList <VehiculoAlquilado> mostrar = easydrive.getListaAlquiler();
        mostrar.forEach(System.out::println);
        //Finalizamos tres alquileres
        
        
        
        
        
        
        
        
        
        

    }
}
