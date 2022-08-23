import java.util.HashMap;

public class ProblemsSolutions {


    public static void main(String[] args){
        System.out.println(isAnagram("book","boos"));

    }


    /**
    A method to check if 2 strings is anagram or not

     */
     public static Boolean isAnagram( String s1, String s2 ) {

        if (s1.length() != s2.length())
            return false;

        HashMap<Character,Integer> firstOccurences = new HashMap<>();
        HashMap<Character,Integer> secondOccurences = new HashMap<>();
        for (int i=0;i<s1.length();i++){
            if (firstOccurences.get(s1.charAt(i) )!= null)
                firstOccurences.put(s1.charAt(i),firstOccurences.get(s1.charAt(i))+1);
            else
                firstOccurences.put(s1.charAt(i),1);



            if (secondOccurences.get(s2.charAt(i)) != null)
                secondOccurences.put(s2.charAt(i),secondOccurences.get(s2.charAt(i))+1);
            else
                secondOccurences.put(s2.charAt(i),1);
        }


        for (Character c : firstOccurences.keySet() ){


            if (secondOccurences.get(c) == null || !secondOccurences.get(c).equals(firstOccurences.get(c)))
                return false;

        }
        return true;
    }


    public static String findMostRepeatedWord( String text ) {
        java.util.HashMap<String, Integer> words = new java.util.HashMap<>();

        for (int i = 1;i<=text.length();i++){

            for (int j = i+1;j<= text.length();j++) {
                String subWord = text.substring(i,j);

                if(subWord.length()>1)
                    words.put(subWord, words.getOrDefault(subWord,0) + 1);
                else if (subWord.length() == 1 && (subWord.equals("a") || subWord.equals("i")))
                    words.put(subWord, words.getOrDefault(subWord,0) + 1);

            }
        }


        String s = "";
        for (String word : words.keySet()  ){
            if (words.get(word).intValue() > s.length())
                s = word;
        }

        return s;
    }


    public static Integer findYearWithMostLivingPeople( Integer[] birthYears, Integer[] deathYears ) {
        //Insert your code here
        java.util.HashMap<Integer,Integer> years = new java.util.HashMap<Integer,Integer>();

        for (int i = 0;i<birthYears.length;i++){
            Integer birth = birthYears[i].intValue();
            for (;birth<=deathYears[i];birth++){
                years.put(birth,years.getOrDefault(birth,0).intValue()+1);
            }
        }

        Integer year = years.keySet().iterator().next();
        for (Integer value : years.keySet()  ){

            if (years.get(value).intValue() > years.get(year).intValue())
                year = year;
        }

        return year;


    }
}
