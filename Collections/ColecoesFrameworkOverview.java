package secao14;

import java.util.*;
import java.util.stream.*;


public class ColecoesFrameworkOverview {

    public static void main(String[] args) {
        
       
        // 1 - ArrayList 
        List<String> listaDeNomes = new ArrayList<>();

        // adicionar
        listaDeNomes.add("Paulo");
        listaDeNomes.add("Maria");
        listaDeNomes.add("Joana");
        listaDeNomes.add("Carlos");

        // resgatar
        System.out.println("O primeiro da lista é: " + listaDeNomes.get(0));


        // alterar
        listaDeNomes.set(1, "Simone");
        System.out.println("Segundo da lista alterado para: " + listaDeNomes.get(1));

        // remove
        listaDeNomes.remove(1);

        // procura por um item
        System.out.println(listaDeNomes.contains("Paulo"));



        // LinkedList
  
        List<Integer> numeros = new LinkedList<>();

        numeros.add(1);
        numeros.add(4);
        numeros.add(12);
        numeros.add(5);
        numeros.add(8);

        System.out.println(numeros.get(2));

        numeros.remove(1);

        System.out.println(numeros.toString());

        // trocar valor

        numeros.set(0, 25);
        System.out.println(numeros.get(0));



     //  1 ArrayList x  1.2 LinkedList

     // 1 - acesso por índice mais rápido, melhor para leitura, inserção e remoção mais lenta
     // 1.2 - inserção e remoção rapida, acesso lento



     // 2 - Set
     
     // HashSet - reordena os elementos

     Set<String> conjunto = new HashSet<>();

     conjunto.add("Python");
     conjunto.add("Java");
     conjunto.add("PHP");
   
    System.out.println(conjunto);

    System.out.println(conjunto.contains("Java"));


    // LinkedHashSet - mantém a ordem dos elementos

    Set<Integer> numeros2 = new LinkedHashSet<>();

    numeros2.add(2);
    numeros2.add(7);
    numeros2.add(5);
    numeros2.add(3);

    System.out.println(numeros2);


    // TreeSet - reordena a ordem dos elementos

    Set<String> nomes = new TreeSet<>();

    nomes.add("Paulo");
    nomes.add("Simone");
    nomes.add("Viola");
    nomes.add("Maria");

    System.out.println(nomes);

    // Set não possui a funcionalidade get
    //System.out.println(nomes.get(2));



    // 3 - Map

    // Hashmap
    
    Map<String, Integer> idadeMap = new HashMap<>();

    // adicionar

    idadeMap.put("Paulo" , 22);
    idadeMap.put("Simone" , 50);
    idadeMap.put("Viola" , 55);

    System.out.println(idadeMap);

   // map com key já existente, apenas altera o valor
    idadeMap.put("Viola" , 25);

    idadeMap.remove("Paulo");

    System.out.println(idadeMap);

    System.out.println(idadeMap.containsKey("Viola"));
    System.out.println(idadeMap.containsValue(59));



    // LinkedHashMap

    Map<String, String> capitalMap = new LinkedHashMap<>();

    capitalMap.put("Brasil", "Brasília");
    capitalMap.put("EUA", "Washington");
    capitalMap.put("Canadá", "Ottawa");
    capitalMap.put("Japão", "Tokio");

    System.out.println(capitalMap);

    System.out.println(capitalMap.containsKey("Brasil"));

 
    // TreeMap - reoordena os itens

    Map<String, Double> produtoPrecoMap = new TreeMap<>();

    produtoPrecoMap.put("Camisa", 99.90);
    produtoPrecoMap.put("Casaco", 250.90);
    produtoPrecoMap.put("Tênis", 999.00);

    System.out.println(produtoPrecoMap);




    // 4 - Iterando as collections

    // for-each
    for (String nome : nomes) {
        System.out.println(nome);
    }


    // iterator
    Iterator<String> nomesIterator = nomes.iterator();

    // remover um elemento
    while (nomesIterator.hasNext()) {

        String nome = nomesIterator.next();

        if (nome.equals("Paulo")) {
            nomesIterator.remove();
        }
    }
    System.out.println(nomes);


    // ListIterator
    ListIterator<String> listIteratorNomes = listaDeNomes.listIterator();

    while (listIteratorNomes.hasNext()) {
        System.out.println("Nome: " + listIteratorNomes.next());
        
    }
    


    // 5 - Collections imutaveis

    // criando lista imutável

    List<String> listMutavel = new ArrayList<>();

    listMutavel.add("Teste1");
    listMutavel.add("Teste2");
    listMutavel.add("Teste3");

    List<String> listaImutavel = Collections.unmodifiableList(listMutavel);

    System.out.println(listaImutavel);

    // da erro se executar, pois é imutavel
    listaImutavel.add("Teste4");


    // Outra forma se fazer a lista imutavel
    // também não pode ser modificada  
    List<String> listaImutavel2 = List.of("item1" , "Item2");
    
    System.out.println(listaImutavel2);



    // 6 - Filter

     List<Integer> numerosFiltrados = numeros.stream()
                                            .filter(numero -> numero > 3)
                                            .collect(Collectors.toList());

                                            System.out.println(numerosFiltrados);
   

                                            




    }
    
}
