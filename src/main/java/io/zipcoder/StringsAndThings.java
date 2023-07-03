package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,

     * count words ending in y or z


     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        int count = 0;
        int len = input.length();


        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) //loops through string
        {
            if (input.charAt(i) == 'y' || input.charAt(i) == 'z') //if input is y or z
            {
                if (i < len - 1 && !Character.isLetter(input.charAt(i + 1)))//if i is less than length and character is not a character after i
                    count++;
                else if (i == len - 1)
                    count++;

            }

        }
        return count;


    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        // remove what the user specifys
        //iterate through base and remove what user specifys

        String replace = base.replace(remove,"");
        System.out.println(replace);
        return replace;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)

     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        String strNotMissing = input.replaceAll("not", "");
        //replaces not with ""
        String strIsMissing = input.replaceAll("is", "");
        //replaces is with ""

        int notCount = (input.length() - strNotMissing.length()) / 3;
        //gets both lengths of strings and checks how many times is and not is in them
        int isCount = (input.length() - strIsMissing.length()) / 2;

        return isCount == notCount;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){

        
       return input.matches(".*gg.*") && !input.matches(".*(?<!g)g(?!g).*");


    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){

            int tripCount = 0;
            for(int i=0;i<input.length()-2;i++)//abcXXXabc
            {
                if(input.charAt(i+1) != input.charAt(i+2))
                    i++;
                else if(input.charAt(i) == input.charAt(i+1))
                    tripCount++;
            }
            return tripCount;
        }
    }

