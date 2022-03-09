package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFileMethod implements OutputBehaviour {
    @Override
    public void write(UserData userData) {
        File writeFile = new File(userData.getWriteFileName());
        try (PrintWriter printWriter = new PrintWriter(writeFile)) {
            printWriter.print(userData.getChangedMessage());
        } catch (IOException e) {
            System.out.printf("Error! An exception occurred %s", e.getMessage());
        }
    }
}
