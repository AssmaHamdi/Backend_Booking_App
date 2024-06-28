package com.hamdi.booking_management.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OperationNonPermettedException extends RuntimeException {

    private final String errorMsg;

    private final String operationId;

    private final String source;

    private final String dependency;
}
