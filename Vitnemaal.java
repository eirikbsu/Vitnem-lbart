import java.io.BufferedReader;
import java.io.FileReader;

class Vitnemaal {
    int antKarakterer;
    Double karaktertall;
    Double snitt;

    Vitnemaal(String filename) {
        this.antKarakterer = 0;
        this.karaktertall = 0.0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = reader.readLine()) != null) {
                antKarakterer ++;
                String[] lineArray = line.split("");
                Double karakter = Double.parseDouble(lineArray[1]); //antagelsen her er at karakteren er element #2 i denne lista
                karaktertall = karaktertall + karakter;

            }//end of while
            snitt = (karaktertall / (double) antKarakterer);

            reader.close();

        } catch (Exception e) {
            System.out.println("funkærtne");
        }//end of try-catch

    }//end of constructor
}//end of class
