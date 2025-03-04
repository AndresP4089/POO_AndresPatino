package org.example;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        boolean flag = true;

        ArrayList<CuentaBancaria> listaCuentas = new ArrayList<>();

        listaCuentas.add(new CuentaBancaria("Juanito Perez", "0", 5000));
        listaCuentas.add(new CuentaBancaria("Camila Mendez", "1", 4000000));
        listaCuentas.add(new CuentaBancaria());

        listaCuentas.get(2).setTitular("Andres Martinez");
        listaCuentas.get(2).setNum_cuenta("2");
        listaCuentas.get(2).setSaldo(5000000);

        System.out.println("\n\tCuentas Disponibles\n");
        for(CuentaBancaria cb: listaCuentas){
            System.out.println("----------------------------");
            System.out.println("Cuenta numero " + cb.getNum_cuenta());
            System.out.println();
        }

        do {
            int numCuenta;
            int opcion1;

            System.out.println("\n\n\tMenú Principal\n\n1) Ingresar a la cuenta\n2) Crear cuenta");
            opcion1 = scan.nextInt();

            switch (opcion1){
                case 1:
                    do {
                        System.out.println("\n\n\tMenú Principal\n\nDigite la cuenta: ");
                        numCuenta = scan.nextInt();
                    } while (numCuenta>=listaCuentas.toArray().length || numCuenta<0);

                    do {
                        int opcion2;

                        System.out.println("\n\n\tMenú Cuenta Bancaria");
                        System.out.println("\n1) Retirar\n2) Depositar\n3) Consultar saldo y datos de la cuenta\n4) Salir");
                        opcion2 = scan.nextInt();

                        switch (opcion2){
                            case 1:
                                double retiro;
                                System.out.println("\n\n\tRetiro\n\nDigite la cantidad a retirar: ");
                                retiro = scan.nextDouble();
                                listaCuentas.get(numCuenta).retirarDinero(retiro);
                                break;
                            case 2:
                                double deposito;
                                System.out.println("\n\n\tDeposito\n\nDigite la cantidad a depositar");
                                deposito = scan.nextDouble();
                                listaCuentas.get(numCuenta).depositarDinero(deposito);
                                break;
                            case 3:
                                System.out.printf("\n\n\tDatos de la cuenta\n\n-Numero de cuenta: %s\n-Titular de cuenta: %s\n-Saldo actual: $%.2f\n", listaCuentas.get(numCuenta).getNum_cuenta(), listaCuentas.get(numCuenta).getTitular(), listaCuentas.get(numCuenta).getSaldo());
                                break;
                            case 4:
                            default:
                                flag = false;
                                break;
                        }

                    } while (flag);
                    break;
                case 2:
                    String titular;
                    String cuentaNum = "" + listaCuentas.toArray().length;
                    System.out.println("\n\n\tCrear cuenta\n");
                    System.out.println("Ingrese el nombre del titular de la cuenta: ");
                    titular = scan2.next();
                    listaCuentas.add(new CuentaBancaria(titular, cuentaNum, 0));
                    break;
            }

            System.out.println("\n\tCuentas Disponibles\n");
            for(CuentaBancaria cb: listaCuentas){
                System.out.println("----------------------------");
                System.out.println("Cuenta numero " + cb.getNum_cuenta());
                System.out.println();
            }

        } while (true);

    }
}