package com.boomi.connector.petstore;

import com.boomi.connector.api.BrowseContext;
import com.boomi.connector.api.ConnectorException;
import com.boomi.connector.api.PropertyMap;
import com.boomi.connector.openapi.OpenAPIConnection;
import com.boomi.connector.util.BaseConnection;
import com.boomi.util.DOMUtil;
import com.boomi.util.IOUtil;
import com.boomi.util.URLUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PetStoreConnection extends OpenAPIConnection {

    public PetStoreConnection(BrowseContext context) {
        super(context);
    }
}


