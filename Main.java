package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        UserData userData = new UserData();

        userData.fill(args);
        userData.eliminateNull();

        if (userData.getReadFileName() != null && userData.getData() == null) {
            userData.setInputBehaviour(new ReadFromFileMethod());
            userData.performRead();
        }

        if (userData.getMode().contains("enc")) {
            if (userData.getAlgorithm().contains("shift")) {
                userData.setEncryptionBehaviour(new ShiftEncryptionMethod());
            } else {
                userData.setEncryptionBehaviour(new UnicodeEncryptionMethod());
            }
            userData.performEncrypt();
        } else {
            if (userData.getAlgorithm().contains("shift")) {
                userData.setDecryptionBehaviour(new ShiftDecryptionMethod());
            } else {
                userData.setDecryptionBehaviour(new UnicodeDecryptionMethod());
            }
            userData.performDecrypt();
        }

        if (userData.getWriteFileName() != null) {
            userData.setOutputBehaviour(new WriteToFileMethod());
            userData.performWrite();
        } else {
            System.out.println(userData.getChangedMessage());
        }
    }
}



