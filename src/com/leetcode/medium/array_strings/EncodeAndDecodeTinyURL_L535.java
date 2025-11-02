package com.leetcode.medium.array_strings;

//TODO: refer https://copilot.microsoft.com/shares/a3sXchnmYUEpwgcRbJybz for better solution without using Base64
//prob #535 - encode and decode tiny url
public class EncodeAndDecodeTinyURL_L535 {
    public static void main(String[] args) {
        String url = "https://leetcode.com/problems/design-tinyurl";
        String encodedUrl = encode(url);
        //System.out.println("encodedURL = "+encodedUrl);
        String decodedUrl = decode(encodedUrl);
        //System.out.println("decodedURL = "+decodedUrl);
        System.out.println(decodedUrl.equals(url));
    }

    //https://leetcode.com/problems/design-tinyurl
    //http://tinyurl.com/4e9iAk
    public static String encode(String longUrl) {
        //return java.util.Base64.getUrlEncoder().encodeToString(longUrl.getBytes());
        return new String(java.util.Base64.getUrlEncoder().encode(longUrl.getBytes()));
    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        return new String(java.util.Base64.getUrlDecoder().decode(shortUrl));
    }
}
