import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Problema {
	
	public static void main(String[] args) {

		//Creo la lista de números
		LinkedList<Integer> numeros = new LinkedList<Integer>(Arrays.asList(1,1,1,3,4,3,3,3,4,5,3,1,3)); 
				
		//Busco el más repetido
		Integer result = mayorRepetido(numeros);
		
		System.out.println("Mayor Repetido: "+ result);

        // test cases
        System.out.println("42: " + mayorRepetido(new LinkedList<Integer>(Arrays.asList(42))));
        System.out.println("41: " + mayorRepetido(new LinkedList<Integer>(Arrays.asList(42,41))));
        System.out.println("1: " + mayorRepetido(new LinkedList<Integer>(Arrays.asList(9,8,7,6,5,4,3,2,1))));
        System.out.println("4: " + mayorRepetido(new LinkedList<Integer>(Arrays.asList(9,8,7,6,5,4,4,3,2,1))));
        System.out.println("1: " + mayorRepetido(new LinkedList<Integer>(Arrays.asList(9,8,7,6,5,4,3,2,1,1))));
        System.out.println("9: " + mayorRepetido(new LinkedList<Integer>(Arrays.asList(9,9,8,7,6,5,4,3,2,1))));
        try {
            // test degenerate case
            mayorRepetido(new LinkedList<Integer>());
            System.out.println("Failed test for empty list");
        } catch (IllegalArgumentException e) {
            // test passed
        }
    }

	private static Integer mayorRepetido(LinkedList<Integer> numeros) {
        if (numeros.isEmpty()) {
            // evitar caso degenerado
            throw new IllegalArgumentException("Empty list not allowed");
        }

        //Sortear primero, complejidad O(nlogn), incluso con LinkedList
        Collections.sort(numeros);

        int current = numeros.get(0);

        //En esta variable me voy quedando con el más repetido
        int repetido=numeros.get(0);

        //En esta variable me quedo con la cantidad de repeticiones
        int repeticiones=1, max = 1;

        for (int i = 1; i < numeros.size(); i++) {
            int element = numeros.get(i);

            if (element == current) {
                // sigue contando current numero
                repeticiones++;
                if (repeticiones > max) {
                    max = repeticiones;
                    repetido = current;
                }
            } else {
                // nuevo valor
                current = element;
                repeticiones = 1;
            }
        }

        //Devuelvo el más repetido
        return repetido;
	}
	
}
