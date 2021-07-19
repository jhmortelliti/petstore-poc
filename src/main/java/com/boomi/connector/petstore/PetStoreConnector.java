package com.boomi.connector.petstore;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.Operation;
import com.boomi.connector.api.OperationContext;
import com.boomi.connector.openapi.OpenAPIConnector;

public class PetStoreConnector extends OpenAPIConnector {

    @Override
    protected Operation createQueryOperation(OperationContext context) {
        return new PetStoreQueryOperation(createConnection(context));
    }

    protected PetStoreConnection createConnection(BrowseContext context) {
        return new PetStoreConnection(context);
    }
}