package Task2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.io.File.createTempFile;

/*
Serializable Solution
*/
public class Solution implements Serializable {
    transient private final String pattern = "dd MMMM yyyy, EEEE";
    String string;
    transient private Date currentDate;
    transient private int temperature;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = createTempFile("Serrialization File", null);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        Solution solutionWrite = new Solution(14);
        oos.writeObject(solutionWrite);
        oos.flush();
        oos.close();

        Solution solutionReadObject = new Solution(28);
        solutionReadObject = (Solution) ois.readObject();

        if (solutionWrite.equals(solutionReadObject)) {
            System.out.println("равны");
        } else System.out.println("объекты не равны");
        if (solutionWrite.string.equals(solutionReadObject.string)) {
            System.out.println("равны строки");
        }


        System.out.println(new Solution(4));
    }

    @Override
    public String toString() {
        return this.string;
    }
}
