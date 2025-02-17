public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    private String fechaNacimiento;
    CuentaBancaria [] listaCuentas = new CuentaBancaria[10];
    int  pos = 0;


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

    public void mostrarDatosTitular(){
        System.out.println("Nombre del titular: "+ nombre +
                "\nApellidos del titular: "+apellidos+
                "\nFecha de nacimiento: "+ fechaNacimiento);
    }

    public void anadirCuentaALista(CuentaBancaria cuenta) {
        if (pos<listaCuentas.length && listaCuentas[pos]==null) {
            listaCuentas [pos] = cuenta;
            pos++;
        } else {
            System.out.println("No es posible crear mas cuentas para este titular.");
        }
    }


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

    public void mostrarListaCuentas (){
        int cont = 0;
        while (cont<listaCuentas.length && listaCuentas[cont]!=null){
            System.out.println((cont+1) + ".- " + listaCuentas[cont].getIban());
            cont++;
        }

    }

    public void mostrarSaldo(int opcion){
        System.out.println("El saldo de la cuenta "+ opcion + " es: " + listaCuentas[opcion-1].getSaldo());
    }

    public void eleccionCuentaIngreso(int opcion, double cantidadIngreso, String conceptoIngreso){
        listaCuentas[opcion-1].ingresarDinero(cantidadIngreso);
        Movimiento movimiento = new Movimiento(cantidadIngreso, conceptoIngreso);
        listaCuentas[opcion-1].anadirMovimiento(movimiento);
    }

    public void eleccionCuentaRetirada(int opcion, double cantidadRetirada, String conceptoRetirada){
        listaCuentas[opcion-1].retirarDinero(cantidadRetirada);
        Movimiento movimiento = new Movimiento(cantidadRetirada, conceptoRetirada);
        listaCuentas[opcion-1].anadirMovimiento(movimiento);
    }

    public void eleccionCuentaMovimientos (int opcion){
        listaCuentas[opcion-1].mostrarMovimientos();
    }

}
