package secao11;

public class Banco {

    private double saldo;

    public Banco(double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque.");
        }

        saldo -= valor;

        System.out.println("Saque realizado com sucesso. Valor sacado: " + valor);
    }
    
}
