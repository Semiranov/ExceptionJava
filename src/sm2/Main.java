package sm2;

import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        File myFile = new File("/Users/vladimirsemiranov/Work/Учеба/Exp/Exception/src/sm2/name.txt");
        HashMap<String, String> myHashMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String stringName = new String();
            while ((stringName = reader.readLine()) != null) {
                String[] str = stringName.split("=");
                if (str[1].equals("?")) {
                    str[1] = String.valueOf(str[0].length());
                }
                myHashMap.put(str[0], str[1]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        writeFile("/Users/vladimirsemiranov/Work/Учеба/Exp/Exception/src/sm2/name.txt", myHashMap);
    }

    public static void writeFile(String path, HashMap myHashMap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            myHashMap.forEach((key, value) -> {
                String rezult = key + "=" + value;
                try {
                    writer.write(rezult + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
//                System.out.println(value);
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

