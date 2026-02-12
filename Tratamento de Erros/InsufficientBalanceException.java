package secao11;

// Exceção personalizada
// Criando uma exceção para saldo insuficiente em um banco

public class SaldoInsuficienteException extends Exception{

    public SaldoInsuficienteException(String message) {
        super(message);
    }
    
}
