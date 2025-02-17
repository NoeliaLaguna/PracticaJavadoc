public class CuentaBancaria {

    private String iban;
    private String nombreTitular;
    private double saldo = 0;
    private Movimiento [] movimientos = new Movimiento[5];
    private final int SALDO_MINIMO = -50;
    private final int HACIENDA = 3000;
    private int pos = 0;
    String concepto;

    public CuentaBancaria (String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void mostrarDatos(){
       // Mostrará el IBAN, el titular y el saldo.
        System.out.println("IBAN: " + iban +
                "\nSaldo: " + saldo);
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getSALDO_MINIMO() {
        return SALDO_MINIMO;
    }

    public int getHACIENDA() {
        return HACIENDA;
    }

    public void mostrarMovimientos() {
        System.out.println("****MOVIMIENTOS*****");
        if (movimientos[0] != null){
            int cont = 0;
            while (cont < movimientos.length && movimientos[cont]!= null) {
                System.out.println("Concepto: " + movimientos[cont].getConcepto() + " | Importe: " + movimientos[cont].getImporte() + " | Fecha y hora del movimiento: " + movimientos[cont].getFechaHoraMovimiento());
                cont++;
            }
            System.out.println("Saldo Actual: " + saldo);
        } else {
            System.out.println("\n********Aun no tienes movimientos en la cuenta.**********");
        }

    }

    public void ingresarDinero(double cantidadIngreso) {
        saldo+=cantidadIngreso;
    }

    public void retirarDinero(double cantidadRetirada) {
        if (saldo>SALDO_MINIMO && (saldo-cantidadRetirada)>SALDO_MINIMO){
            saldo -= cantidadRetirada;
            cantidadRetirada = cantidadRetirada*-1;
        } else {
            System.out.println("No puedes retirar el dinero, ya que la cuenta queda con un saldo no permitido.");
        }
    }

    public void anadirMovimiento(Movimiento movimiento) {
        if (pos>=movimientos.length && movimientos[pos-1]!= null){
            desplazarMovimientos();
            movimientos [pos-1] = movimiento;
            pos = movimientos.length-1;
            pos++;
        } else {
            movimientos [pos] = movimiento;
            pos++;
        }
    }

    private void desplazarMovimientos() {
        for(int cont = 1; cont<movimientos.length; cont++){
            movimientos [cont-1]= movimientos[cont];
        }
    }




}
