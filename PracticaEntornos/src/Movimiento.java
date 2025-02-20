import java.time.LocalDateTime;
/**
 * Clase de objeto para los movimientos.
 * @author Noelia Laguna
 * @version 1.0
 */

public class Movimiento {
    private double importe;
    private String concepto;
    private LocalDateTime fechaHoraMovimiento; //Esta clase LocalDateTime nos permite importar la fecha y hora local del sistema.

    /**
     * Constructor por parámetros de los movimientos.
     * @param importe Valor double que se recibe por teclado, indica la cantidad de dinero del movimiento.
     * @param concepto Valor String que se recive por teclado, indica el concepto asignado a ese movimiento.
     */
    public Movimiento (double importe, String concepto){
        this.importe=importe;
        this.concepto = concepto;
        this.fechaHoraMovimiento = LocalDateTime.now();
    }

    /**
     * Metodo get para el importe del movimiento.
     * @return devuelve  el importe del movimiento.
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Metodo get para el concepto del movimiento.
     * @return devuelve el concepto del movimiento.
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Metodo get para la fecha y hora del movimiento.
     * @return devuelve la fecha y hora del movimiento.
     */
    public LocalDateTime getFechaHoraMovimiento() {
        return fechaHoraMovimiento;
    }

}
