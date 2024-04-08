package com.example.util;

import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;

public class XmlConverter {
    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
//    public static String TEST_XML_STRING = "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";

    public static String toJson(String xmlString) {
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
            String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(jsonPrettyPrintString);
            return jsonPrettyPrintString;
        } catch (JSONException je) {
            System.out.println("Error converting XML to JSON: " + je.getMessage());
            return je.getLocalizedMessage();
        }
    }
}
