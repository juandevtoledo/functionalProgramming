package bestpractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Buscar numeros pares en un listado random de 10 enteros
public class EvenNumberOldApproach {
    public static void main(String... args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i <= 10; i++) {
            list.add(random.nextInt(100));
        }
        for (int v : list ){
            if(v % 2 ==0){
                System.out.println(v);
            }
        }
    }
}
