/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquiler;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    
    //Cuando es static todas las empresas commparten los mismos clientes 
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
    public void registrarCliente(Cliente nuevo) {
        listaCliente.add(nuevo);
    }

    //Metodo para buscar un cliente con binarysearch
    //Antes crearemos un metodo privado para oredenar 
    //ya que si no, no se podra realizar la busqueda
    private void ordendarCliente() {
        Comparator<Cliente> criterio = (c1, c2) -> c1.getNif().compareTo(c2.getNif());
        Collections.sort(listaCliente, criterio);
    }

    public int buscarCliente(Cliente c) {
        this.ordendarCliente();

        return Collections.binarySearch(listaCliente, c , (c1, c2) -> c1.getNif().compareTo(c2.getNif()));
    }

    //Metodo para imprimir cliente
    public void imprimirListaCliente() {
        listaCliente.forEach(System.out::println);
    }

    //Metodo para registrar un nuevo vehiculo
    public void registrarVehiculo(Vehiculo nuevo) {
        listaVehiculo.add(nuevo);
    }

    //Metodo para buscar un vehiculo con binarysearch
    //Antes crearemos un metodo privado para oredenar 
    //ya que si no, no se podra realizar la busqueda
    public void ordendarVehiculo() {
        Comparator<Vehiculo> criterio = (c1, c2) -> c1.getMatricula().compareTo(c2.getMatricula());
        Collections.sort(listaVehiculo, criterio);
    }

    public int buscarVehiculo(Vehiculo v) {
        this.ordendarVehiculo();
        return Collections.binarySearch(listaVehiculo, v, (c1, c2) -> c1.getMatricula().compareTo(c2.getMatricula()));
    }

    //Metodo para imprimir vehiculo
    public void imprimirvehiculo() {
        listaVehiculo.forEach(System.out::println);
    }
    //Metodo para alquilar vehiculo
    public boolean alquilerVehiculo(Cliente c, Vehiculo v, int dias) {
        // busca el cliente a partir del nif
        Cliente cliente = cogerCliente(buscarCliente(c));
        // busca el vehiculo a partir de la marticula
        Vehiculo vehiculo = cogerVehiculo(buscarVehiculo(v));

        if (cliente != null && vehiculo != null) {
            if (vehiculo.isDisponible()) {
                vehiculo.setDisponible(false);
                this.listaAlquiler.add(new VehiculoAlquilado(cliente, vehiculo,
                        LocalDate.now(), dias));

                return true; // El alquiler se realiza correctamente
            }
        }
        return false; // No se puede alquilar el vehiculo por el cliente
    }

    //Metodo para devolver un cliente pasandole la posicion
    private Cliente cogerCliente(int posicion) {
        if (posicion >= 0 && posicion < listaCliente.size()) {
            return listaCliente.get(posicion);
        } else {
            return null;
        }
    }
    //Metodo para devolver un vehiculo pasandole la posicion
    private Vehiculo cogerVehiculo(int posicion) {
        if (posicion >= 0 && posicion < listaVehiculo.size()) {
            return listaVehiculo.get(posicion);
        } else {
            return null;
        }
    }

    public void recibirVehiculo(Vehiculo v) {
        Vehiculo vehiculo = cogerVehiculo(buscarVehiculo(v));
        if (vehiculo != null) {
            vehiculo.setDisponible(true);
            
            /*Yo quiero quitar el objeto de la lista*/

        }

    }

    public void imprimirListaVehiculosAlquilados() {
        listaAlquiler.forEach(System.out::println);
    }

    public void imprimirMatriculaFecha() {
        for (int i = 0; i < listaAlquiler.size(); i++) {
            System.out.println("La matricula es: " + listaAlquiler.get(i).getVehiculo().getMatricula() + "y la fecha de entrega es "
                    + entregaVehiculos(listaAlquiler.get(i)));
        }
    }

    //Metodo para averiguar la fecha que hay que devolver el vehiculo
    private LocalDate entregaVehiculos(VehiculoAlquilado v) {
        LocalDate fechaAlquiler = v.getFechaAlquiler().plus(v.getTotalDiasAlquiler(), ChronoUnit.DAYS);
        return fechaAlquiler;
    }

}
