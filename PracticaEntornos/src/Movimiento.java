import java.time.LocalDateTime;

public class Movimiento {
    private double importe;
    private String concepto;
    private LocalDateTime fechaHoraMovimiento; //Esta clase LocalDateTime nos permite importar la fecha y hora local del sistema.

    public Movimiento (double importe, String concepto){
        this.importe=importe;
        this.concepto = concepto;
        this.fechaHoraMovimiento = LocalDateTime.now();
    }

    public double getImporte() {
        return importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public LocalDateTime getFechaHoraMovimiento() {
        return fechaHoraMovimiento;
    }

}
