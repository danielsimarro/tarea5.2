/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author daniel
 */
public class EmpresaAlquilerVehiculos {
    
    //Atributos de la empresa
    private String cif;
    private String nombre;
    private String paginaWeb;
    //Atributo con la lista de los clientes que hay, donde
    //cada posición se almacenaran los datos de ese cliente
    private ArrayList<Cliente> listaCliente;
    //Atributo con la lista de los vehiculos que hay, donde
    //cada posición se almacenaran los datos de ese vehiculo
    private ArrayList<Vehiculo> listaVehiculo;
    //Atributo con la lista de los vehiculos alquilados que hay, donde
    //cada posición se almacenaran los datos de esos vehiculos alquilados
    private ArrayList<VehiculoAlquilado> listaAlquiler;
    
    //Constructor donde se le pasan los parametros y se iicializa el arraylist de las listas
    public EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        listaCliente = new ArrayList<>();
        listaVehiculo = new ArrayList<>();
        listaAlquiler = new ArrayList<>();
    }

    //Metodos getters y setters
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    public ArrayList<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(ArrayList<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    public ArrayList<VehiculoAlquilado> getListaAlquiler() {
        return listaAlquiler;
    }

    public void setListaAlquiler(ArrayList<VehiculoAlquilado> listaAlquiler) {
        this.listaAlquiler = listaAlquiler;
    }
    
    
    //Metodo para registrar un nuevo cliente
    public void registrarCliente(Cliente nuevo){
        listaCliente.add(nuevo);
    }
    
    //Metodo para buscar un cliente con binarysearch
    //Antes crearemos un metodo privado para oredenar 
    //ya que si no, no se podra realizar la busqueda
    private void ordendarCliente(){
        Comparator <Cliente> criterio = (c1, c2) -> c1.getNombre().compareTo(c2.getNombre());
        Collections.sort(listaCliente, criterio);
    }
    
    public int buscarCliente(Cliente c){
        this.ordendarCliente();
        
        return Collections.binarySearch(listaCliente,c,(c1, c2) -> c1.getNombre().compareTo(c2.getNombre()));
    }
    
    //Metodo para imprimir cliente
    public void imprimirListaCliente(){
        listaCliente.forEach(System.out::println);
    }
    
    //Metodo para registrar un nuevo vehiculo
    public void registrarvehiculo(Vehiculo nuevo){
        listaVehiculo.add(nuevo);
    }
    
    //Metodo para buscar un vehiculo con binarysearch
    //Antes crearemos un metodo privado para oredenar 
    //ya que si no, no se podra realizar la busqueda
    private void ordendarvehiculo(){
        Comparator <Vehiculo> criterio = (c1, c2) -> c1.getMarca().compareTo(c2.getMarca());
        Collections.sort(listaVehiculo, criterio);
    }
    
    public int buscarVehiculo(Vehiculo v){
        this.ordendarvehiculo();
        return Collections.binarySearch(listaVehiculo,v,(c1, c2) -> c1.getMarca().compareTo(c2.getMarca()));
    }
    
    //Metodo para imprimir vehiculo
    
    
}
