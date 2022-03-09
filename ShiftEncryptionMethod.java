package encryptdecrypt;

public class ShiftEncryptionMethod extends InitialData implements EncryptionBehaviour {
    @Override
    public String encrypt(UserData userData) {
        for (int i = 0; i < userData.getData().length(); i++) {
            indexForInputChar = userData.getData().charAt(i);
            if (indexForInputChar > 64 && indexForInputChar < 91) {
                startIndex = 65;
                endIndex = 90;
            } else if (indexForInputChar > 96 && indexForInputChar < 123) {
                startIndex = 97;
                endIndex = 122;
            } else {
                userData.getChangedMessage().append((char) indexForInputChar);
                continue;
            }
            indexForOutputChar = indexForInputChar + userData.getKey();
            if (indexForOutputChar > endIndex) {
                indexForOutputChar = indexForOutputChar % endIndex + startIndex - 1;
            }
            changedChar = (char) indexForOutputChar + "";
            userData.getChangedMessage().append(changedChar);
        }
        return userData.getChangedMessage() + "";
    }
}
