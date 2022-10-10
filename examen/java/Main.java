import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String args[]){
        String nombre;
        String password;
        boolean validacion = false;
        float saldo = 0.0f;
        Util util = new Util();
        Scanner scanner = new Scanner(System.in);
        try {

            System.out.print("Ingresar el nombre de usuario: ");
            nombre = scanner.nextLine();
        
            for(int i=0; i<3; i++){
                System.out.print("Ingresar la contraseña: ");
                password = scanner.nextLine();
                validacion = util.validarPassword(password);
                if(validacion){
                    System.out.println("Ingreso correcto");
                    System.out.println(String.format("Hola, Bienvenido %s", nombre));
                    break;
                }
            }
            while(validacion){
                System.out.println("   .:MENU:.");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Retirar Saldo");
                System.out.println("3: Ingresar saldo");
                System.out.println("4: Histórico de Movimientos");
                System.out.println("5: Salir");
                System.out.print("Eliga una opción: ");
                int opcion = Integer.parseInt(scanner.nextLine());
                if(opcion == 1){
                    saldo = util.consultarSaldo();
                    System.out.println(saldo);
                }
                else if(opcion == 2){
                    System.out.print("Dinero a retirar: ");
                    saldo = Float.parseFloat(scanner.nextLine());
                    boolean isRetiro = util.retirarSaldo(saldo);
                    if (isRetiro)
                        System.out.println("Retiro correcto");
                    else
                        System.out.println("Validar saldo, no se tienen fondos suficientes");
                }
                else if(opcion == 3){
                    System.out.print("Dinero a ingresar: ");
                    saldo = Float.parseFloat(scanner.nextLine());
                    util.ingresarSaldo(saldo);
                }
                else if(opcion == 4){
                    System.out.println(util.getMovimientos());
                }
                else if(opcion == 5){
                    System.out.println("Saliendo...");
                    break;
                }
                else
                    System.out.println("Ingrese una opción correcta");
            }
        } 
        catch (Exception ex){
            System.out.println("Fin del programa, se ingresó un dato erroneo");
        }
    }
}


class StaticConstantes {
    public static String PASS = "1235";
    public static String PATTERN = "dd-MM-yyyy HH:mm:ss";
}


class Util {
    private float saldo;
    private boolean check;
    private String movimientos;

    public Util(){
        saldo = 1000;
        check = false;
        movimientos = "";
    }

    String fechaHora(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern(StaticConstantes.PATTERN);
        String formattedDate = date.format(format);
        return formattedDate;
    }

    public String getMovimientos(){
        return movimientos;
    }

    public boolean validarPassword(String password){
        StringBuilder sb = new StringBuilder(fechaHora()).append(": ");
        sb = sb.append("Validación de contraseña").append("\n");
        movimientos += sb.toString();
        if((password).equals(StaticConstantes.PASS))
            check = true;
        return check;
    }

    public float consultarSaldo(){
        StringBuilder sb = new StringBuilder(fechaHora()).append(": ");
        sb = sb.append("Consulta de saldo").append("\n");
        movimientos += sb.toString();
        return saldo;
    }

    public boolean retirarSaldo(float saldo){
        StringBuilder sb = new StringBuilder(fechaHora()).append(": ");
        sb = sb.append("Retiro de saldo ").append(saldo).append("\n");
        movimientos += sb.toString();
        if(this.saldo >= saldo){
            this.saldo -=saldo;
            return true;
        } else
            return false;
    }

    public String consultarMovimientos(){
        StringBuilder sb = new StringBuilder(fechaHora()).append(": ");
        sb = sb.append("Consulta de movimientos").append("\n");
        movimientos += sb.toString();
        return movimientos;
    }

    public void ingresarSaldo(float saldo){
        StringBuilder sb = new StringBuilder(fechaHora()).append(": ");
        sb = sb.append("Ingreso de saldo ").append(saldo).append("\n");
        movimientos += sb.toString();
        this.saldo += saldo;
    }

}