/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

/**
 *
 * @author njuser
 */
@Service
public class RegxUtil {

    private static final String REGEX = "\\{{2}[A-Z_]*\\}{2}";

    private String createRegex(String s) { // Testing Purpose
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if ("\\.^$|?*+[]{}()".indexOf(ch) != -1) {
                b.append('\\').append(ch);
            } else if (Character.isLetter(ch)) {
                b.append("[A-Za-z]");
            } else if (Character.isDigit(ch)) {
                b.append("\\d");
            } else {
                b.append(ch);
            }
        }
        return b.toString();
    }

    public List<String> getPlaceholderList(String input) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(input);   // get a matcher object

          Set<String> placeholderSet = new LinkedHashSet<>();  
        while (m.find()) {
            String placeholder = input.substring(m.start(), m.end());
            placeholder = placeholder.substring(2, placeholder.length() - 2);
            placeholder = placeholder.replace("_", " ");
            placeholderSet.add(placeholder);
        }
        List<String> placeholderList = new ArrayList(placeholderSet);
        return placeholderList;

    }
    
    public String regx(HashMap<String, String> data,String input) {
        
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(input);

        String replacedStringHtml = input;

        while (m.find()) {
            String placeholder = input.substring(m.start(), m.end());
            replacedStringHtml = replacedStringHtml.replace(placeholder, (CharSequence) data.get(placeholder));
        }

        System.out.println(replacedStringHtml);
        return replacedStringHtml;

    }
}
