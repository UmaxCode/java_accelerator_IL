package org.umaxcode.designPatterns.behavioral.templateMethod;

public class AESEncryption extends EncryptionTemplate {

    @Override
    protected String generateKey() {
        return "AES_key";
    }

    @Override
    protected String encrypt(String data, String key) {
        return "[AES_ENCRYPTED:" + data + "]";
    }

    @Override
    protected String decrypt(String data, String key) {
        return data.replace("[AES_ENCRYPTED:", "").replace("]", "");
    }
}
