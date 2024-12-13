package org.umaxcode.designPatterns.structural.adapter.adapter;

import org.umaxcode.designPatterns.structural.adapter.service.LegacyPaymentProcessor;
import org.umaxcode.designPatterns.structural.adapter.service.XMLPaymentRequest;
import org.umaxcode.designPatterns.structural.adapter.service.XMLPaymentResponse;
import org.umaxcode.designPatterns.structural.adapter.client.JSONPaymentRequest;
import org.umaxcode.designPatterns.structural.adapter.client.JSONPaymentResponse;
import org.umaxcode.designPatterns.structural.adapter.client.ModernPaymentProcessor;

public class LegacyPaymentProcessorAdapter implements ModernPaymentProcessor {

    private final LegacyPaymentProcessor legacyPaymentProcessor;

    public LegacyPaymentProcessorAdapter(LegacyPaymentProcessor legacyPaymentProcessor) {
        this.legacyPaymentProcessor = legacyPaymentProcessor;
    }

    @Override
    public JSONPaymentResponse process(JSONPaymentRequest request) {

        // process json request to xml request
        double amount = request.amount();
        String email = request.email();

        XMLPaymentRequest xmlRequest = new XMLPaymentRequest(email, amount);

        XMLPaymentResponse xmlResponse = this.legacyPaymentProcessor.process(xmlRequest);

        // process xml response to json response
        int statusCode = xmlResponse.statusCode();
        String message = xmlResponse.message();

        return new JSONPaymentResponse(statusCode, message);
    }
}
