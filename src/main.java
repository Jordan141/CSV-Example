import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class main {
    private final static String GRASS_TYPE = "Grass";
    private final static String WATER_TYPE = "Water";
    private final static String POKEMON_CSV_PATH = "D:/pokemon.csv";
    private final static String GRASS_CSV_PATH = "D:/grassPokemon.csv";
    private final static String WATER_CSV_PATH = "D:/waterPokemon.csv";
    
    public static void main(String[] args) {
      try{
          List<Pokemon> pokemonList = readCSVFile(POKEMON_CSV_PATH);
          List<Pokemon> grassPokemon = sortByTypes(pokemonList, GRASS_TYPE);
          List<Pokemon> waterPokemon = sortByTypes(pokemonList, WATER_TYPE);
         
          writeFile(GRASS_CSV_PATH, prepareFile(grassPokemon));
          writeFile(WATER_CSV_PATH, prepareFile(waterPokemon));
          
      }catch(FileNotFoundException e){
          System.out.println(e.toString());
      }
    }
    
    public static List<Pokemon> readCSVFile(String myPokemonFilePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(myPokemonFilePath));
        List<Pokemon> pokemonList = new ArrayList<Pokemon>();

		while(scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            pokemonList.add(new Pokemon(nextLine.split(",")));
	    }
        scanner.close();
        return pokemonList;
    }
    public static List<Pokemon> sortByTypes(List<Pokemon> pokemons, String type){
    	final Predicate<Pokemon> compareTypes = poke -> (poke.getTypeOne().equals(type) || poke.getTypeTwo().equals(type));
    	
        List<Pokemon> sortedPokemon = pokemons.stream()
            .filter(compareTypes)
            .collect(Collectors.toList());
        
        return sortedPokemon;
    }
    public static String prepareFile(List<Pokemon> pokemonList) {
   	 	String CSVFile = pokemonList.stream()
   	 			.map(pokemon -> pokemon.toCSV())
   	 			.reduce("", (file, newLine) -> String.join(file, newLine,"\n"));
   	 	
        return CSVFile;
   }
    public static void writeFile(String fileName, String content) throws FileNotFoundException {
    	try (PrintWriter out = new PrintWriter(fileName)) {
    	    out.println(content);
    	}
    }
 }