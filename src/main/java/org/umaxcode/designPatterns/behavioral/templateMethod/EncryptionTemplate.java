package org.umaxcode.designPatterns.behavioral.templateMethod;

public abstract class EncryptionTemplate {

    public final void process(String data) {
        String key = generateKey();
        String encryptedData = encrypt(data, key);
        String decryptedData = decrypt(encryptedData, key);

        System.out.println("Original Data: " + data);
        System.out.println("Encrypted Data: " + encryptedData);
        System.out.println("Decrypted Data: " + decryptedData);
    }

    protected abstract String generateKey();

    protected abstract String encrypt(String data, String key);

    protected abstract String decrypt(String data, String key);
}
