package com.leetcode.easy.strings;

import java.util.HashSet;
import java.util.Set;

/**
 * If you add periods ('.') between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name.  For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.  (Note that this rule does not apply for domain names.)
 * <p>
 * If you add a plus ('+') in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered, for example m.y+name@email.com will be forwarded to my@email.com.  (Again, this rule does not apply for domain names.)
 * <p>
 * It is possible to use both of these rules at the same time.
 * <p>
 * Given a list of emails, we send one email to each address in the list.  How many different addresses actually receive mails?
 */
public class UniqueEmailAddresses {
    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }

    private static int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            //split by @
            String[] splitEmailStr = email.split("@");
            String localName = getFormattedLocalName(splitEmailStr[0]);
            String domainName = splitEmailStr[1];
            //No processing on domain names
            uniqueEmails.add(localName + "@" + domainName);
        }
        return uniqueEmails.size();
    }

    private static String getFormattedLocalName(String rawLocalName) {
        //Check for multiple dots
        rawLocalName = rawLocalName.replace(".", "");
        if (rawLocalName.contains("+")) {
            //get the part before +
            rawLocalName = rawLocalName.substring(0, rawLocalName.indexOf("+"));
        }
        return rawLocalName;
    }
}
