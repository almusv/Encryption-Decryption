package encryptdecrypt;

public class UnicodeEncryptionMethod extends InitialData implements EncryptionBehaviour {

    @Override
    public String encrypt(UserData userData) {
        for (int i = 0; i < userData.getData().length(); i++) {
            indexForInputChar = userData.getData().charAt(i);
            indexForOutputChar = indexForInputChar + userData.getKey();
            if (indexForOutputChar > endIndex) {
                indexForOutputChar = indexForInputChar % (endIndex - startIndex + 1) + startIndex - 1;
            }
            changedChar = (char) indexForOutputChar + "";
            userData.getChangedMessage().append(changedChar);
        }
        return userData.getChangedMessage() + "";
    }
}

