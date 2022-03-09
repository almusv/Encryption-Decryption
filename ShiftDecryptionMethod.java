package encryptdecrypt;

public class ShiftDecryptionMethod extends InitialData implements DecryptionBehaviour {

    @Override
    public String decrypt(UserData userData) {
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
            indexForOutputChar = indexForInputChar - userData.getKey();
            if (indexForOutputChar < startIndex) {
                if (userData.getKey() % (endIndex - startIndex + 1) == userData.getKey()) {
                    indexForOutputChar = endIndex + indexForInputChar - (startIndex + userData.getKey()) + 1;
                } else {
                    indexForOutputChar = indexForInputChar - indexForInputChar % (endIndex - startIndex + 1) - 1;
                }
            }
            changedChar = (char) indexForOutputChar + "";
            userData.getChangedMessage().append(changedChar);
        }
        return userData.getChangedMessage() + "";
    }
}
