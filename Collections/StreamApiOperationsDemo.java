package secao14;

import java.util.ArrayList;
import java.util.stream.*;
import java.util.*;

public class Colecoes2 {

    public static void main(String[] args) {
        
      
    List<Integer> numeros = new ArrayList<>();

    numeros.add(2);
    numeros.add(4);
    numeros.add(6);
    numeros.add(8);
    numeros.add(10);

    System.out.println(numeros);


    List<String> nomes = new ArrayList<>();

    nomes.add("Paulo");
    nomes.add("Viola");
    nomes.add("Simone");
    nomes.add("Maria");

    System.out.println(nomes);

    // 1 - Filter

    List<Integer> numerosFiltrados = numeros.stream()
                                            .filter(numero -> numero > 5)
                                            .collect(Collectors.toList());


    System.out.println(numerosFiltrados);


    // 2 - Busca

    // for

    int numeroParaEncontrar = 6;

    boolean encontrou = false;

    for(Integer numero : numeros){
        if (numero == numeroParaEncontrar) {
            encontrou = true;
           } 
        }

        System.out.println("Encontrou o número: " + encontrou);


    // contains    
    String nomeBuscado = "Paulo";
    boolean encontrou2 = nomes.contains(nomeBuscado);

    System.out.println("Encontrou o nome: " + encontrou2);


    //findAny
    Optional<Integer> qualquerNumero = numeros.stream().findAny();

    System.out.println(qualquerNumero);
    



    // 3 - Map 

    // modificam a collection

    List<Integer> quadrados = numeros.stream()
                                     .map(n -> n * n)
                                     .collect(Collectors.toList());

                                     System.out.println(numeros);
                                     System.out.println(quadrados);

    List<String> nomesMaiusculos = nomes.stream()
                                        .map(String::toUpperCase)
                                        .collect(Collectors.toList());

                                        System.out.println(nomes);
                                        System.out.println(nomesMaiusculos);





 
    // 4 - Modificação

    //adiciona
    numeros.add(55);
    System.out.println(numeros);

    //remove pelo valor e nao indice
    numeros.remove(Integer.valueOf(4));
    System.out.println(numeros);

    // alterar todos os elementos
    numeros.replaceAll(n -> n * 2);
    System.out.println(numeros);

    // remoção baseada em condição
    numeros.removeIf(n -> n > 20);
    System.out.println(numeros);





    // 5 - Reduce - transforma os elementos de uma lista em um só, somando, concatenando etc.....

    int soma = numeros.stream()
                      .reduce(0,(acumulador, n) -> acumulador + n);

                      System.out.println("A soma de todos os números da lista é: " + soma);




    // 6 - ordenação com comparator      
    
    List<Pessoa> pessoas = new ArrayList<>();

    pessoas.add(new Pessoa("Paulo", 22));  
    pessoas.add(new Pessoa("Simone", 55));
    pessoas.add(new Pessoa("Márcio", 34));
    pessoas.add(new Pessoa("Edimar", 67));
    pessoas.add(new Pessoa("Paulo", 20)); 

    // ordenar por nome
    pessoas.sort(Comparator.comparing(Pessoa::getNome));

    for(Pessoa pessoa : pessoas){
        System.out.println(pessoa);
    }


    // ordenar por nome e idade
    pessoas.sort(Comparator.comparing(Pessoa::getNome)
                           .thenComparing(Pessoa::getIdade));

           for(Pessoa pessoa : pessoas){
               System.out.println(pessoa);
              }



    
    // 7 - uso avançado de streams       
    
    //flat map - achatar listas 
    List<List<String>> listaDeListas =  Arrays.asList(
        Arrays.asList("Banana" , "Melancia"),
        Arrays.asList("Uva" , "Maça"),
        Arrays.asList("Melão" , "Mamão")
    );


    List<String> listaUnica = listaDeListas.stream()
                                           .flatMap(List::stream)
                                           .collect(Collectors.toList());

                                           System.out.println(listaDeListas);
                                           System.out.println(listaUnica);


    // pipeline
    
    List<Integer> resultado = numeros.stream()
                                     .filter(n -> n % 2 == 0) // filtro de pares
                                     .map(n -> n * 5) // multiplicação dos elementos por 5
                                     .sorted() // ordenação
                                     .collect(Collectors.toList());

                                     System.out.println(resultado);

      }
    }
    

