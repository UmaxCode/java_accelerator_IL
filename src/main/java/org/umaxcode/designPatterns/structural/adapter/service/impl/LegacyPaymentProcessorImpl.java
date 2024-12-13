package org.umaxcode.designPatterns.structural.adapter.service.impl;

import org.umaxcode.designPatterns.structural.adapter.service.LegacyPaymentProcessor;
import org.umaxcode.designPatterns.structural.adapter.service.XMLPaymentRequest;
import org.umaxcode.designPatterns.structural.adapter.service.XMLPaymentResponse;

public class LegacyPaymentProcessorImpl implements LegacyPaymentProcessor {


    @Override
    public XMLPaymentResponse process(XMLPaymentRequest request) {

        // business logic
        return new XMLPaymentResponse(200, "Payment processed successfully");
    }

}
