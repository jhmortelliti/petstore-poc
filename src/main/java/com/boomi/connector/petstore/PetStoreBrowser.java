package com.boomi.connector.petstore;

import com.boomi.connector.api.*;
import com.boomi.connector.openapi.OpenAPIBrowser;
import com.boomi.connector.openapi.OpenAPIConnection;
import com.boomi.connector.util.BaseBrowser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.Collection;

public class PetStoreBrowser extends OpenAPIBrowser {
    public PetStoreBrowser(OpenAPIConnection conn) {
        super(conn);
    }

    @Override
    public PetStoreConnection getConnection() {
        return (PetStoreConnection) super.getConnection();
    }
}