package be.kdg.componenten;

import be.kdg.componenten.contacts.ContactsSkeleton;


public class StartContacts {
    /**
     * Starts this component.
     *
     * @param args the ip-address and port-number of the ZipCodes component.
     */
    public static void main(String[] args) {
        ContactsSkeleton contactsSkeleton = new ContactsSkeleton();
        contactsSkeleton.run();
    }

}
