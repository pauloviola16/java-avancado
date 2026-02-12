package secao11;

import java.io.*;

public class Erros {

    public static void main(String[] args) {
        
        // try catch

        try{

            int a = 0;
            int b = 10;
            int resultado = a / b;

        } catch(ArithmeticException e){

            System.out.println("Divisão por zero não é permitida.");

        }

           
        try {

            int[] numeros = {1, 2, 3};
            System.out.println(numeros[5]);
            
        } catch (Exception e) {

            System.out.println("Erro genérico");

            System.out.println("Erro: " + e.getMessage());

        }


        // Finally

          try {

            int[] numeros = {1, 2, 3};
            System.out.println(numeros[5]);
            
        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Erro genérico finally");

            System.out.println("Erro: " + e.getMessage());

        } finally {

            System.out.println("Bloco finally executado.");

        }



       // exceções com throws

       try {

        validarIdade(10);

        validarIdade(20);

       } catch (Exception e) {

        System.out.println("Erro: " + e.getMessage());

       }

       // Exceções customizadas

       Banco minhaConta = new Banco(500);
       
       try {
        
        minhaConta.sacar(1000);

       } catch (SaldoInsuficienteException e) {

        System.out.println("Erro: " + e.getMessage());
        
       }


    // Verificadas e não verificadas


    // Verificada

    try {
        BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"));
        String linha = reader.readLine();
        System.out.println(linha);

    } catch (Exception e) {
        System.out.println("Erro ao ler arquivo: " + e.getMessage());

    }

    // não verificada

    String texto = null;

    System.out.println(texto.length());



   // throws em métodos
 
   try {

    processarArquivo("");

   } catch (FileNotFoundException e) {
        System.out.println("Erro: " + e.getMessage());
   } catch (IOException e){
        System.out.println("Erro: " + e.getMessage());
   }

     // Encadeamento de exceções 

     try {
    
        abrirArquivo(null);

    } catch (Exception e) {
        System.out.println("Erro: "+ e.getMessage());

        System.out.println("Causa original: " + e.getCause());
    
    }
   }





    

    public static void validarIdade(int idade){
          
        if (idade < 18) {
             throw new IllegalArgumentException("Idade deve ser maior ou igual a 18 anos.");
            
        }

            System.out.println("Idade válida: " + idade + " anos.");
       }
    

       // throws em métodos
 
    public static void processarArquivo (String caminho) throws FileNotFoundException, IOException {

         if (caminho == null || caminho.isEmpty()) {
            throw new IOException("Caminho inválido");
            
         }

         File arquivo = new File(caminho);

         if (!arquivo.exists()) {
            throw new FileNotFoundException("Arquivo não encontrado");
            
         }

         System.out.println("Arquivo encontrado com sucesso");

 }


       
       // Encadeamento de exceções

         public static void abrirArquivo (String caminho){

            try {
                if (caminho == null) {
                    throw new NullPointerException("Caminho nulo");
                    
                }

                throw new FileNotFoundException("Arquivo não encontrado");

            } catch (FileNotFoundException e) {

                NullPointerException npe = new NullPointerException("Erro ao processar arquivo");

                npe.initCause(e);

                throw npe; 
                
            }
         }

        }
