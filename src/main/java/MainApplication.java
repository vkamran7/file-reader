import java.io.*;
import java.util.Random;

public class MainApplication {
    public static void main(String[] args) {
        if (args.length >= 1) {
            File file = new File(args[0] + ".txt");
            try {
                if (file.createNewFile()) {
                    System.out.println("No file");
                    FileWriter writer = new FileWriter(file.getName());
                    int number = new Random().nextInt(10) + 1;
                    writer.write(String.valueOf(number));
                    writer.close();
                } else {
                    System.out.println("Already exists");
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String st;
                    StringBuilder builder = new StringBuilder();
                    while ((st = bufferedReader.readLine()) != null) {
                        builder.append(st);
                    }
                    System.out.println("Current value in a file:" + builder);
                    int num = Integer.parseInt(builder.toString()) + 3;
                    if (file.delete()) {
                        FileWriter writer = new FileWriter(file.getName());
                        writer.write(String.valueOf(num));
                        System.out.println("New value in a file: " + num);
                        writer.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File Name not provided");
        }
    }
}
