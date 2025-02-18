import java.util.Scanner;

/*Añadir un metodo en clase CuentaBancaria que me devuelva el total de dinero relacionado con nóminas. Para ello habrá que buscar la palabra Nomina (sin importar mayus/minus) en los movimientos. */

public class DamBank {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        boolean salir = false;

        System.out.println("\n***BIENVENIDO A DAMBANK***\n");
        System.out.println("Necesito los siguientes datos para crear tu cuenta bancaria:\n");

        System.out.print("Nombre del titular de la cuenta: ");
        String nombreTitular = teclado.nextLine();
        System.out.print("Apellidos del titular de la cuenta: ");
        String apellidosTitular = teclado.nextLine();
        System.out.print("Fecha de nacimiento del titular: ");
        String fechaNacimientoTitular = teclado.nextLine();
        Persona personaConCuenta = new Persona(nombreTitular,apellidosTitular,fechaNacimientoTitular);


        System.out.print("IBAN: ");
        String iban = teclado.nextLine();
        //String iban = "ES1254785421245212158796";
        boolean ibanCorrecto = comprobarIBAN(iban);
            while (!ibanCorrecto){
                System.err.println("IBAN no válido.");
                System.out.println();
                System.out.println("Por favor, escriba un IBAN válido formado por dos letras y 22 números.");
                iban = teclado.nextLine();
                ibanCorrecto = comprobarIBAN(iban);
            }

            CuentaBancaria cuenta = new CuentaBancaria(iban);
            personaConCuenta.anadirCuentaALista(cuenta);
            System.out.println("*********La cuenta se ha creado correctamente.**********");


            while (!salir) {
                System.out.println("\nDime que quieres hacer, pulsa el número de la operación que deseas realizar: \n" +
                        "\n** 1. Datos de la cuenta. Mostrará el IBAN, el titular y el saldo." +
                        "\n** 2. IBAN. Mostrará el IBAN." +
                        "\n** 3. Titular. Mostrará el titular." +
                        "\n** 4. Saldo. Mostrará el saldo disponible." +
                        "\n** 5. Ingreso. Pedirá la cantidad a ingresar y realizará el ingreso si es posible." +
                        "\n** 6. Retirada. Pedirá la cantidad a retirar y realizará la retirada si es posible." +
                        "\n** 7. Movimientos. Mostrará una lista con el historial de movimientos." +
                        "\n** 8. Hacer una transferencia." +
                        "\n** 9. Crear nueva cuenta." +
                        "\n** 10. Salir. Termina el programa\n");

                int opcion = teclado.nextInt();
                teclado.nextLine();


                while (opcion < 1 || opcion > 10) {
                    System.out.println("Opción no disponible. Por favor elige una opción entre 1 y 8.");
                    opcion = teclado.nextInt();
                }

                switch (opcion)
                {
                    case 1:
                        System.out.println("Has seleccionado la opción: Datos de la cuenta.");
                        System.out.println("*****Datos del titular de la cuenta: \n");
                        personaConCuenta.mostrarDatosTitular();
                        System.out.println("******Datos de la cuenta: \n");
                        cuenta.mostrarDatos();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opción: IBAN.");
                        personaConCuenta.mostrarListaCuentas();
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opción: Titular.");
                        System.out.println("******Datos del titular de la cuenta: \n");
                        personaConCuenta.mostrarDatosTitular();
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opción: Saldo.");
                        System.out.println("¿De que cuenta quieres ver el saldo?");
                        personaConCuenta.mostrarListaCuentas();
                        opcion = teclado.nextInt();
                        personaConCuenta.mostrarSaldo(opcion);
                        break;
                    case 5:
                        System.out.println("Has seleccionado la opción: Ingreso.");
                        System.out.println("¿En que cuenta quieres ingresar el dinero?");
                        personaConCuenta.mostrarListaCuentas();
                        opcion = teclado.nextInt();
                        System.out.println("¿Que cantidad quieres ingresar?");
                        double dineroAIngresar = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Cual es el concepto de este movimiento?");
                        String conceptoIngreso = teclado.nextLine();
                        personaConCuenta.eleccionCuentaIngreso(opcion,dineroAIngresar, conceptoIngreso);
                        personaConCuenta.mostrarSaldo(opcion);
                        break;
                    case 6:
                        System.out.println("Has seleccionado la opción: Retirada.");
                        System.out.println("¿En que cuenta quieres ingresar el dinero?");
                        personaConCuenta.mostrarListaCuentas();
                        opcion = teclado.nextInt();
                        System.out.println("¿Que cantidad quieres retirar?");
                        double dineroARetirar= teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Cual es el concepto del movimiento?");
                        String conceptoRetirada = teclado.nextLine();
                        personaConCuenta.eleccionCuentaRetirada(opcion, dineroARetirar, conceptoRetirada);
                        personaConCuenta.mostrarSaldo(opcion);
                        break;
                    case 7:
                        System.out.println("Has seleccionado la opción: Movimientos.");
                        System.out.println("¿De que cuenta quieres ver los movimientos?");
                        personaConCuenta.mostrarListaCuentas();
                        opcion = teclado.nextInt();
                        personaConCuenta.eleccionCuentaMovimientos(opcion);
                        break;
                    case 8:
                        System.out.println("Has seleccionado la opción: Hacer transferencia.");
                        System.out.println("Selecciona de que cuenta a que cuenta quieres hacer la transferencia.");
                        System.out.println("Elige el numero desde que cuenta que deseas hacer la transferencia:");
                        personaConCuenta.mostrarListaCuentas();
                        int opcion1 = teclado.nextInt();
                        System.out.println("Ahora elige a que cuenta quieres hacer la transferencia:");
                        int opcion2 = teclado.nextInt();
                        System.out.println("Ahora dime que cantidad quieres transferir.");
                        double cantidadATransferir = teclado.nextDouble();
                        System.out.println("Cual es el concepto del transferencia?");
                        String conceptoTransferencia = teclado.nextLine();
                        personaConCuenta.hacerTransferencia(cantidadATransferir, opcion1, opcion2, conceptoTransferencia);
                        break;
                    case 9:
                        System.out.println("Has seleccionado la opción: crear nueva cuenta. ");
                        System.out.println("Dime el IBAN de la nueva cuenta: ");
                        iban = teclado.nextLine();
                        ibanCorrecto = comprobarIBAN(iban);

                        while (!ibanCorrecto){
                            System.err.println("IBAN no válido. ");
                            System.out.println();
                            System.out.println("Por favor, escriba un IBAN válido formado por dos letras y 22 números. ");
                            iban = teclado.nextLine();
                            ibanCorrecto = comprobarIBAN(iban);
                        }
                        cuenta = new CuentaBancaria(iban);
                        personaConCuenta.anadirCuentaALista(cuenta);
                        break;
                    case 10:
                        System.out.println("Has seleccionado la opción: Salir.");
                        System.out.println("***HASTA PRONTO***");
                        salir = true;
                        break;
                }
            }

    }


    private static boolean comprobarIBAN(String iban) {
        boolean ibanCorrecto = true;
        char primerCaracter = iban.charAt(0);
        char segundoCaracter = iban.charAt(1);

        if (Character.isLetter(primerCaracter) && Character.isLetter(segundoCaracter) && iban.length() == 24){
            int pos = 2;

            while (pos<iban.length() && ibanCorrecto){
                char caracter = iban.charAt(pos);
                if (!Character.isDigit(caracter)){
                    ibanCorrecto = false;
                }
                pos++;
            }
        } else {
            ibanCorrecto = false;
        }

        return ibanCorrecto;
    }
}