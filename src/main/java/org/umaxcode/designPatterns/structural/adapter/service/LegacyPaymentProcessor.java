package org.umaxcode.designPatterns.structural.adapter.service;

public interface LegacyPaymentProcessor {

    XMLPaymentResponse process(XMLPaymentRequest request);
}
