package org.umaxcode.designPatterns.behavioral.templateMethod;

public class RSAEncryption extends EncryptionTemplate {

    @Override
    protected String generateKey() {
        return "RSA_key";
    }

    @Override
    protected String encrypt(String data, String key) {
        return "[RSA_ENCRYPTED:" + data + "]";
    }

    @Override
    protected String decrypt(String data, String key) {
        return data.replace("[RSA_ENCRYPTED:", "").replace("]", "");
    }
}
