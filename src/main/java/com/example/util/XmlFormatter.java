package com.example.util;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

public class XmlFormatter {

    public static String formatXmlString(String unformattedXml) throws Exception {
        // Create a new Transformer
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        // Set properties for pretty printing
        transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(unformattedXml)));

        // Initialize StreamResult with StringWriter to save the formatted XML
        StreamResult result = new StreamResult(new StringWriter());
        DOMSource source = new DOMSource(doc);

        // Transform the source to the result
        transformer.transform(source, result);

        // Get the formatted XML as a string
        String formattedXml = result.getWriter().toString();
        return formattedXml;
    }

    public static void main(String[] args) {
        try {
            String unformattedXml = "<tag><nested>hello</nested></tag>";
            String formattedXml = formatXmlString(unformattedXml);
            System.out.println(formattedXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
