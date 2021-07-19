package com.boomi.connector.petstore;


import com.boomi.connector.api.OperationContext;
import com.boomi.connector.openapi.OpenAPIOperation;
import com.boomi.connector.openapi.OpenAPIConnection;
import com.boomi.connector.openapi.OpenAPIOperationConnection;

public class PetStoreQueryOperation extends OpenAPIOperation {

    protected PetStoreQueryOperation(OpenAPIConnection conn) {
        super(new OpenAPIOperationConnection((OperationContext) conn.getContext()));
    }

}