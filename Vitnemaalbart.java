import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.lang.Math;

class Vitnemaalbart {
    HashMap<String, Double> ekstrapoeng = new HashMap<String, Double>();

    public void settPoeng() {
        ekstrapoeng.put("MAT1001", 0.5);
        ekstrapoeng.put("MAT1002", 1.0);
        ekstrapoeng.put("FYS1001", 0.5);
        ekstrapoeng.put("FYS1002", 1.0);
    }//end of settPoeng

    public void includeGrade(Vitnemaal vitnemaal, String filename) {
        int karakterer = vitnemaal.antKarakterer;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] lineArray = line.split("");
                String fagkode = lineArray[0].toUpperCase();
                Double fagkarakter = Double.parseDouble(lineArray[1]);

                if (ekstrapoeng.containsKey(fagkode)) {
                    Double poeng = ekstrapoeng.get(fagkode);
                    Double verdi = ((karakterer/10) * poeng);
                    Double differens = Math.abs(vitnemaal.snitt - fagkarakter); //kan fort bli feil her, dobbeltsjekk denne

                    if (verdi > differens) {
                        System.out.println("Karakteren i faget " + fagkode + " skal inkluderes.");
                    }//end of if-test
                }//end of if-test
            }//end of while

            reader.close();

        } catch (Exception e) {
            System.out.println("funkærtne");
        }//end of try-catch
    }//end of includeGrade
}//end of class
