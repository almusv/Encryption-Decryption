package encryptdecrypt;

public class UserData {
    private InputBehaviour inputBehaviour;
    private OutputBehaviour outputBehaviour;
    private DecryptionBehaviour decryptionBehaviour;
    private EncryptionBehaviour encryptionBehaviour;
    private String mode;
    private String data;
    private String algorithm;
    private int key;
    private final StringBuilder changedMessage = new StringBuilder();
    private String readFileName; //-in
    private String writeFileName; // -out


    public UserData() {
    }

    public StringBuilder getChangedMessage() {
        return changedMessage;
    }

    public String getMode() {
        return mode;
    }

    public String getData() {
        return data;
    }

    public int getKey() {
        return key;
    }

    void eliminateNull() {
        mode = mode == null ? "enc" : mode;
        algorithm = algorithm == null ? "shift" : algorithm;
        data = data == null && readFileName == null ? "" : data;
    }

    public void fill(String[] data) {
        for (int i = 0; i < data.length; i++) {
            switch (data[i]) {
                case "-mode":
                    mode = data[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(data[i + 1]);
                    break;
                case "-data":
                    this.data = data[i + 1];
                    break;
                case "-alg":
                    algorithm = data[i + 1];
                    break;
                case "-in":
                    readFileName = data[i + 1];
                    break;
                case "-out":
                    writeFileName = data[i + 1];
                    break;
            }
        }
    }

    public void setDecryptionBehaviour(DecryptionBehaviour decryptionBehaviour) {
        this.decryptionBehaviour = decryptionBehaviour;
    }

    public void setEncryptionBehaviour(EncryptionBehaviour encryptionBehaviour) {
        this.encryptionBehaviour = encryptionBehaviour;
    }

    public void setInputBehaviour(InputBehaviour inputBehaviour) {
        this.inputBehaviour = inputBehaviour;
    }

    public void setOutputBehaviour(OutputBehaviour outputBehaviour) {
        this.outputBehaviour = outputBehaviour;
    }

    public void performEncrypt() {
        encryptionBehaviour.encrypt(this);
    }

    public void performDecrypt() {
        decryptionBehaviour.decrypt(this);
    }

    public void performRead() {
        inputBehaviour.read(this);
    }

    public void performWrite() {
        outputBehaviour.write(this);
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getReadFileName() {
        return readFileName;
    }

    public String getWriteFileName() {
        return writeFileName;
    }

    public String getAlgorithm() {
        return algorithm;
    }

}
