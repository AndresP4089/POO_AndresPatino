package org.example;

public class CuentaBancaria {

    private String titular, numCuenta;
    private double saldo;

    public CuentaBancaria() {
    }

    public CuentaBancaria(String titular, String num_cuenta, double saldo) {
        this.titular = titular;
        this.numCuenta = num_cuenta;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNum_cuenta() {
        return numCuenta;
    }

    public void setNum_cuenta(String num_cuenta) {
        this.numCuenta = num_cuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void retirarDinero (double retiro) {
        System.out.println();

        if(this.saldo<=0){
            System.out.println("No tiene plata, sea serio");
        } else if(this.saldo<retiro){
            System.out.println("No tiene fondos suficientes, sea serio");
        } else {
            System.out.println("Retiro exitoso");
            this.saldo -= retiro;
        }

        System.out.println("Retiro: $" + retiro);
        System.out.println("Saldo actual: $" + saldo);
    }

    public void depositarDinero (double deposito) {
        if(deposito<=0){
            System.out.println("Sea serio mano, no va a depositar plata");
        } else {
            System.out.println("Deposito exitoso");
            this.saldo += deposito;
        }

        System.out.println("Deposito: $" + deposito);
        System.out.println("Saldo actual: $" + this.saldo);
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "titular='" + titular + '\'' +
                ", numCuenta='" + numCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }

}
