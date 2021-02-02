/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

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
        // registro de los clientes de la empresa
        easydrive.registrarCliente(cliente1);
        easydrive.registrarCliente(cliente2);
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

        //Alquilar el vehiculo
        System.out.println("El vehiculo se ha alquilado correctamente " + easydrive.alquilerVehiculo(cliente1, vehiculo1, 2));
        System.out.println("El vehiculo se ha alquilado correctamente " + easydrive.alquilerVehiculo(cliente2, vehiculo5, 2));

        System.out.println("Los vehiculos alquilados son: ");
        easydrive.imprimirListaVehiculosAlquilados();
        System.out.println("---------");

        easydrive.recibirVehiculo(vehiculo5);
        
        System.out.println("Los vehiculos alquilados son: ");
        easydrive.imprimirListaVehiculosAlquilados();
        System.out.println("---------");
        
        System.out.println("El vehiculo se ha alquilado correctamente " + easydrive.alquilerVehiculo(cliente1, vehiculo2, 10));
        
        easydrive.imprimirMatriculaFecha();
        
        
        
        

    }
}
