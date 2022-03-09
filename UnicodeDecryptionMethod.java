package encryptdecrypt;

public class UnicodeDecryptionMethod extends InitialData implements DecryptionBehaviour {

    @Override
    public String decrypt(UserData userData) {
        for (int i = 0; i < userData.getData().length(); i++) {
            indexForInputChar = userData.getData().charAt(i);
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
