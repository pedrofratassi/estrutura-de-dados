package BiMap;

import com.google.common.collect.HashBiMap;

import java.util.Map;

public class Idiomas {

    public static void main(String[] args){

//          Chave           :     Valor
//          Português       :     Livro
//          English         :     Book
//          Spanish         :     Libro         ( x )
//          French          :     Livre
//          Greek           :     Βιβλίο
//          Dutch           :     Buch
//          Italian         :     Libro         ( x )

        HashBiMap<String, String> lingua = HashBiMap.create();

        lingua.put("Português", "Livro");
        lingua.put("English", "Book");
        lingua.put("Spanish", "Libro");
        lingua.put("French", "Livre");
        lingua.put("Greek", "Βιβλίο");
        lingua.put("Dutch", "Buch");
        //lingua.put("Italian", "Libro");

        for(Map.Entry entradaDePar: lingua.entrySet()){
            System.out.println(entradaDePar.getKey() + " : " + entradaDePar.getValue());
        }
    }
}
