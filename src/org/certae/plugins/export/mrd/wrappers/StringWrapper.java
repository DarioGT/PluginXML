/*************************************************************************
Copyright (C) 2011  CERTAE  Universite Laval  
Dario Gomez 
 **********************************************************************/

package org.certae.plugins.export.mrd.wrappers;

public class StringWrapper {
    private String s;

    public StringWrapper(String s) {
        this.s = (s == null) ? "" : s;
    }

    @Override
    public String toString() {
        return s;
    }

    //convert "camel_case" to "camelCase"
    public StringWrapper getCamelCase() {

    	String result = "";
        boolean nextUpper = false;
        String s0 = toISO(this.s); 
        
        for (int i = 0; i < s0.length(); i++) {
            Character currentChar = s0.charAt(i);
            if (currentChar == '_' || currentChar == ' ' || currentChar == '-') {
                nextUpper = true;
            } else {
                if (nextUpper) {
                    currentChar = Character.toUpperCase(currentChar);
                    nextUpper = false;
                }
                result = result.concat(currentChar.toString());
            }
        }

        return new StringWrapper(result);
    }

    public StringWrapper getCapitalized() {

    	String capitalized = getCamelCase().toString();

        if ((this.s != null) && (this.s.length() > 1)) {
            capitalized = Character.toUpperCase(capitalized.charAt(0)) + capitalized.substring(1);
        } //end if

        return new StringWrapper(capitalized);
    }

    public StringWrapper getUncapitalized() {
        String uncapitalized = "";

        if ((this.s != null) && (this.s.length() > 1)) {
            uncapitalized = Character.toLowerCase(this.s.charAt(0)) + this.s.substring(1);
        } //end if
        return new StringWrapper(uncapitalized);
    }

    public String  toISO() {
    	String s = toISO(this.s);
    	return s;
    }

    private String  toISO( String s0) {  

      s0 = s0.toLowerCase();

  	  s0 = s0.replace("é", "e"); 

  	  s0 = s0.replace("è", "e");
  	  s0 = s0.replace("à", "a");

  	  s0 = s0.replace("â", "a");
  	  s0 = s0.replace("ê", "e");
  	  s0 = s0.replace("î", "i");
  	  s0 = s0.replace("ô", "o");
  	  s0 = s0.replace("û", "u");
  	  
  	  s0 = s0.replace("ä", "a");
  	  s0 = s0.replace("ë", "e");
  	  s0 = s0.replace("ï", "i");
  	  s0 = s0.replace("ö", "o");
  	  s0 = s0.replace("ü", "u");

  	  return s0; 
    }

}
