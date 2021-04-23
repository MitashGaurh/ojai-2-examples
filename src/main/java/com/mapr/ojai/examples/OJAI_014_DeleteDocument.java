package com.mapr.ojai.examples;

import org.ojai.Document;
import org.ojai.DocumentStream;
import org.ojai.store.Connection;
import org.ojai.store.DocumentStore;
import org.ojai.store.DriverManager;

public class OJAI_014_DeleteDocument {

    public static void main(String[] args) {

        System.out.println("==== Start Application ===");


        // Create an OJAI connection to MapR cluster
        final Connection connection = DriverManager.getConnection("ojai:mapr:");

        // Get an instance of OJAI DocumentStore
        final DocumentStore store = connection.getStore("/demo_table");

        // fetch all OJAI Documents from this store
        final DocumentStream streamBeforeDelete = store.find();

        for (final Document userDocument : streamBeforeDelete) {
            // Print the OJAI Document
            System.out.println(userDocument.asJsonString());
        }

        String docId = "";

        store.delete(docId);

        // fetch all OJAI Documents from this store
        final DocumentStream streamAfterDelete = store.find();

        for (final Document userDocument : streamAfterDelete) {
            // Print the OJAI Document
            System.out.println(userDocument.asJsonString());
        }

        // Close this instance of OJAI DocumentStore
        store.close();

        // close the OJAI connection and release any resources held by the connection
        connection.close();

        System.out.println("==== End Application ===");
    }
}
