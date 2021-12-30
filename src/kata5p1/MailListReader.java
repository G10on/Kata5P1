package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReader {

    public static List<String> read(String fileName) {

        ArrayList<String> mails = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            String lineText = reader.readLine();
            while (lineText != null) {
                if (lineText.matches("^[a-zA-Z0-9+.-]+@[a-zA-Z0-9.]+$")) {
                    mails.add(lineText);
                }
                lineText = reader.readLine();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("ERROR MailListReader::read FileNotFoundException" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("ERROR MailListReader::read IOException" + ex.getMessage());
        }
        return mails;
    }
}