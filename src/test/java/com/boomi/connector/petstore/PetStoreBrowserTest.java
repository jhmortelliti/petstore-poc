package com.boomi.connector.petstore;

import com.boomi.connector.api.*;
import com.boomi.connector.testutil.ConnectorTestContext;
import com.boomi.connector.testutil.ConnectorTester;
import com.boomi.connector.testutil.SimpleAtomConfig;
import com.boomi.connector.testutil.SimpleBrowseContext;
import com.boomi.connector.testutil.junit.ConnectorTest;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

public class PetStoreBrowserTest {

    final String URL = "https://petstore3.swagger.io/api/v3";
    final String SPEC = "https://petstore3.swagger.io/api/v3/openapi.json";

    final String TYPE_DOC = "/PetstoreGetTypeDoc.xml";
    final String DEF_DOC = "/PetstoreGetPetByIdDef.xml";

    final String API_PATH = "/pet/{petId}";

    @Test
    public void testTypes() throws Exception {


        PetStoreConnector connector = new PetStoreConnector();
        ConnectorTester tester = new ConnectorTester(connector);

        Map<String, Object> connProps = new HashMap<String, Object>() {{
            put("URL", URL);
            put("spec", SPEC);
        }};

        SimpleBrowseContext browseContext = new SimpleBrowseContext(new SimpleAtomConfig(),
                tester.getConnector(),
                null,
                "GET",
                connProps,
                null);

        //This method of the Connection Tester is not working with the OpenAPI Connector. It requires a customOpType.
        //tester.setBrowseContext(OperationType.QUERY, connProps, null);

        tester.setBrowseContext(browseContext);
        String expectedTypeDoc = getXMLResource(TYPE_DOC);
        tester.testBrowseTypes(expectedTypeDoc);
    }


    @Test
    public void testProfile() throws Exception {
        PetStoreConnector connector = new PetStoreConnector();
        ConnectorTester tester = new ConnectorTester(connector);

        Map<String, Object> connProps = new HashMap<String, Object>() {{
            put("URL", URL);
            put("spec", SPEC);
        }};

        SimpleBrowseContext browseContext = new SimpleBrowseContext(new SimpleAtomConfig(),
                tester.getConnector(),
                OperationType.GET,
                "GET",
                connProps,
                null);

        tester.setBrowseContext(browseContext);

        String objectTypeId = API_PATH;
        String expectedDefDoc = getXMLResource(DEF_DOC);
        tester.testBrowseProfiles(objectTypeId, expectedDefDoc);
    }

    public String trim(String input) {
        BufferedReader reader = new BufferedReader(new StringReader(input));
        StringBuffer result = new StringBuffer();
        try {
            String line;
            while ((line = reader.readLine()) != null)
                result.append(line.trim());
            return result.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getXMLResource(String resource) {
        String xml = null;
        try {
            xml = IOUtils.toString(
                    this.getClass().getResourceAsStream(resource),
                    "UTF-8"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Trim to remove newlines
        return trim(xml);
    }

}
