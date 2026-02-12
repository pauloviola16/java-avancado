package secao13;

import java.util.*;

public class Generics {

    public static void main(String[] args) {

        Caixa<Integer> caixaInteira = new Caixa<>();

        caixaInteira.adicionar(100);

        System.out.println(caixaInteira.obter());


        // 2 - Métodos Genericos

        System.out.println("Maior valor entre 10 e 15: " + obterMaior(10, 15));

        String[] letras = {"a" , "B" , "C" , "D"};

        imprimirArray(letras);

        // 3 - Bounded types

        Comparador<Integer> comparadorInteiros = new Comparador<>();

        System.out.println("maior entre 20 e 10: " + comparadorInteiros.obterMaior(20, 10));


        // 4 - WildCard

        List<Integer> numeros2 = List.of(1,2,3,4,5);
        List<String> palavras2 = List.of("java" , "python" , "JS");

        // aceita qualquer tipo de lista (?)
        imprimirLista(palavras2);
        imprimirLista(numeros2);

        // aceita listas numéricas ( ? extends Number)
        somarNumeros(numeros2);

        // aceita tipos numericos especificos
        List<Integer> numeros3 = new ArrayList<>();

        adicionarNumeros(numeros3);


 
        // 5 - Generics com collections
        //LIST

        List<Integer> listaInteiros = new ArrayList<>();

        listaInteiros.add(12);
        listaInteiros.add(15);
        listaInteiros.add(18);

        for(Number numero : listaInteiros){
            System.out.println(numero);
        }

        //SET
        Set<String> conjuntoDePalavras = new HashSet<>();

        // segundo "java" nao vai ser impresso, só permite dados únicos
        conjuntoDePalavras.add("java");
        conjuntoDePalavras.add("java");
        conjuntoDePalavras.add("python");

 
        for(String palavras : conjuntoDePalavras){
            System.out.println(palavras);
        }


        //MAP
        Map<String, Integer> mapaDeIdades = new HashMap<>();

        mapaDeIdades.put("Paulo", 22);
        mapaDeIdades.put("Maria", 27);

        for(Map.Entry<String, Integer> entrada : mapaDeIdades.entrySet()){
            System.out.println(entrada.getKey() + " tem " + entrada.getValue() + " anos de idade");
        }









        
    }
    
    public static <T extends Comparable<T>> T obterMaior( T valor1, T valor2) {
        return (valor1.compareTo(valor2) > 0) ? valor1 : valor2;
    }

    // 2
    public static <T> void imprimirArray (T[] array){
        for(T elemento : array) {
            System.out.println(elemento + ", ");
        }
    }

    // 4
    // aceita todos os tipos
    public static void imprimirLista(List <?> lista){
        for(Object elemento : lista){
            System.out.println(elemento);
        }
    }


    // aceita tipos numéricos
    public static double somarNumeros (List<? extends Number> lista){
        double soma = 0;

        for (Number numero : lista){
            soma += numero.doubleValue();
        }
        return soma;
    }


 
    // aceita tipo numérico específico
    public static void adicionarNumeros(List<? super Integer> lista){
        for(int i = 0; i <= 5; i++){
            lista.add(i);
        }
    }






}
