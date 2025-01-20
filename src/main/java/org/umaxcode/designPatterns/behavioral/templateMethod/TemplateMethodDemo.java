package org.umaxcode.designPatterns.behavioral.templateMethod;

public class TemplateMethodDemo {

    public static void main(String[] args) {

        System.out.println("--- AES Encryption Process ---");
        EncryptionTemplate aesEncryption = new AESEncryption();
        aesEncryption.process("Hello, World!");

        System.out.println("\n--- RSA Encryption Process ---");
        EncryptionTemplate rsaEncryption = new RSAEncryption();
        rsaEncryption.process("Hello, World!");
    }
}
