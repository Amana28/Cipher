import java.util.ArrayList;
import java.util.Random;

public class SubstitutionCipher extends Cipher {

    ArrayList<Character> Table;

    public SubstitutionCipher(long key){

        super(key);
        this.Table = createTable(getKey());
    }


    // encrypts a clear text by using a substitution table generated by a PRNG using
    // key as a seed
    public ArrayList<Character> encrypt (ArrayList<Character> cleartext){

        ArrayList<Character> ciphertext = Cipher.createList();

        for(int i=0; i<cleartext.size(); i++){

            //get the Characters in cleartext
            //use their int values as an index for the Table
            //and find their corresponding value

            ciphertext.add(Table.get((int)(cleartext.get(i))));

        }

        return ciphertext;

    }

    // decrypts an encrypted text using the same table as a reference
    public ArrayList<Character> decrypt (ArrayList<Character> ciphertext) {

        ArrayList<Character> cleartext = Cipher.createList();

        for(int i=0; i<ciphertext.size(); i++){

            //get the Characters of ciphertext
            //find their index from the table
            //convert the index back to cleartext


            cleartext.add((char)(Table.indexOf(ciphertext.get(i))));

        }

        return cleartext;
    }

    private ArrayList<Character> createTable(long key){
        Random rand = new Random(key);
        ArrayList<Character> table = Cipher.createList();
        for(int i=0; i<256; i++){
            char randomChar = (char)rand.nextInt(256);

            //check if randomChar has already been used in our table
            //if it has stay at this level for the next iteration of
            //the loop and find another randomChar
            if (table.contains(randomChar)){
                i--;
            }
            else{
                table.add(randomChar);
            }


        }//for


        return table;
    }


}
