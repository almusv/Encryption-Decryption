package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFileMethod implements InputBehaviour {
    @Override
    public void read(UserData userData) {
        File readFile = new File(userData.getReadFileName());
        try (Scanner scanner = new Scanner(readFile)) {
            userData.setData(scanner.nextLine());
        } catch (FileNotFoundException e) {
            System.out.printf("Error! %s has not found. Try again", userData.getReadFileName());
            userData.setData("");
        }
    }
}
