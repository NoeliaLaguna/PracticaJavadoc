/**
 * Clase de objeto para almacenar los datos de las personas.
 * @author Noelia Laguna
 * @version 1.0
 */

public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    private String fechaNacimiento;
    CuentaBancaria [] listaCuentas = new CuentaBancaria[10];
    int  pos = 0;

    /**
     * Constructor por parámetros de la cuenta bancaria.
     * @param nombre  Tipo String recibido por entrada de teclado con el nombre del usuario.
     * @param apellidos Tipo String recibido por entrada de teclado con el apellido del usuario.
     * @param fechaNacimiento Tipo String recibido por entrada de teclado con el apellido del usuario
     */
    public Persona ( String nombre, String apellidos, String fechaNacimiento){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Metodo vacío para mostrar los datos del titular por pantalla.
     */
    public void mostrarDatosTitular(){
        System.out.println("Nombre del titular: "+ nombre +
                "\nApellidos del titular: "+apellidos+
                "\nFecha de nacimiento: "+ fechaNacimiento);
    }


    /**
     * Metodo vacío que añade la cuenta del usuario concreto a un array de cuentas bancarias.
     */
    public void anadirCuentaALista(CuentaBancaria cuenta) {
        if (pos<listaCuentas.length && listaCuentas[pos]==null) {
            listaCuentas [pos] = cuenta;
            pos++;
        } else {
            System.out.println("No es posible crear mas cuentas para este titular.");
        }
    }

    /**
     * Metodo vacío que realiza una transferencia de saldo de una cuenta a otra y además, invoca el metodo añadirMovimiento.
     * @param dineroATransferir Valor double que se introduce por teclado, indica el dinero que se va a transferir.
     * @param cuenta1 Valor entero que se introduce por teclado, posición de la cuenta desde la que se transfiere el dinero.
     * @param cuenta2 Valor entero que se introduce por teclado, posicion de la cuenta a la que se transfiere el dinero.
     * @param conceptoTransferencia Valor String que se introduce por teclado, indica el concepto que se asigna a la transferencia.
     */
    public void hacerTransferencia (double dineroATransferir, int cuenta1, int cuenta2, String conceptoTransferencia){
        if (listaCuentas[cuenta1-1].getSaldo()-dineroATransferir>=0){
            listaCuentas[cuenta1-1].retirarDinero(dineroATransferir);
            listaCuentas[cuenta1-1].anadirMovimiento(new Movimiento(dineroATransferir, conceptoTransferencia));
            listaCuentas[cuenta2-1].ingresarDinero(dineroATransferir);
            listaCuentas[cuenta2-1].anadirMovimiento(new Movimiento(dineroATransferir,conceptoTransferencia));
            System.out.println("****LA TRANSFERENCIA SE HA REALIZADO CORRECTAMENTE****");
            mostrarSaldo(cuenta1);
            mostrarSaldo(cuenta2);

        } else {
            System.out.println("****NO HAY SALDO SUFICIENTE PARA REALIZAR LA TRANSFERENCIA****");
        }
    }
    /**
     * Metodo vacío que muestra todas las cuentas dentro del array de cuentas por pantalla.
     */
    public void mostrarListaCuentas (){
        int cont = 0;
        while (cont<listaCuentas.length && listaCuentas[cont]!=null){
            System.out.println((cont+1) + ".- " + listaCuentas[cont].getIban());
            cont++;
        }

    }

    /**
     * Metodo vacío que muestra el saldo de la cuenta elegida por pantalla.
     * @param opcion Valor entero que se introduce por teclado y es la posicion de la cuenta dentro del array de cuentas, de la cual se mostrará el saldo.
     */
    public void mostrarSaldo(int opcion){
        System.out.println("El saldo de la cuenta "+ opcion + " es: " + listaCuentas[opcion-1].getSaldo());
    }

    /**
     * Metodo vacío que selecciona la cuenta a la cual se realizara un ingreso y además, invoca el metodo de ingresarDinero en dicha cuenta.
     * @param opcion Valor entero que se introduce por teclado y es la posición de la cuenta dentro del array de cuentas.
     * @param cantidadIngreso Valor double que se introduce por teclado, es la cantidad que se ingresa en la cuenta.
     * @param conceptoIngreso Valor String que se introduce por teclado, indica el concepto asignado al ingreso.
     */
    public void eleccionCuentaIngreso(int opcion, double cantidadIngreso, String conceptoIngreso){
        listaCuentas[opcion-1].ingresarDinero(cantidadIngreso);
        Movimiento movimiento = new Movimiento(cantidadIngreso, conceptoIngreso);
        listaCuentas[opcion-1].anadirMovimiento(movimiento);
    }


    /**
     * Metodo vacío que selecciona la cuenta a la cual se realizara una retirada y además, invoca el metodo de retirarDinero en dicha cuenta.
     * @param opcion Valor entero que se introduce por teclado y es la posición de la cuenta dentro del array de cuentas.
     * @param cantidadRetirada Valor double que se introduce por teclado, es la cantidad que se retira en la cuenta.
     * @param conceptoRetirada Valor String que se introduce por teclado, indica el concepto asignado a la retirada.
     */
    public void eleccionCuentaRetirada(int opcion, double cantidadRetirada, String conceptoRetirada){
        listaCuentas[opcion-1].retirarDinero(cantidadRetirada);
        Movimiento movimiento = new Movimiento(cantidadRetirada, conceptoRetirada);
        listaCuentas[opcion-1].anadirMovimiento(movimiento);
    }

    /**
     * Metodo vacío que selecciona la cuenta de la cual se quieren mostrar los movimientos, y además, invoca el metodo mostrarMovimientos sobre dicha cuenta.
     * @param opcion Valor entero que se introduce por teclado y es la posición de la cuenta dentro del array de cuentas.
     */
    public void eleccionCuentaMovimientos (int opcion){
        listaCuentas[opcion-1].mostrarMovimientos();
    }

}
