//Zeye Gu
//101036562
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class comp3007_w19_101036562_a1_1 {

    public static void main (String args[]){
        boolean noUpper;
        Queue<String> alist = new LinkedList<>();
        Queue<String> convertList = new LinkedList<>();

        String input;


        System.out.print("Please enter Snake Case string\n");
        input = new Scanner(System.in).nextLine();



        noUpper = hasNoUpper(input);
       if(noUpper) {


           alist = splitUnderscore(input);

           System.out.println("The list of your input is: " + alist.toString());

           convertList = convertList(alist);

           System.out.println("The list of Pig Latin words is  " + convertList.toString());


       }
       else{
           System.out.println("Don't type Upper case letter! This is not Snake Case string.");
       }


    }
    // a)  a recursive function that will validate
    // that the string passed as an argument does not use any uppercase letters,
    public static boolean hasNoUpper(String myStr){

        if(myStr.isEmpty()){
            return true;
        }
        int ascii = (int)myStr.charAt(0);
        if(ascii>= 65 && ascii <=90 ){
            return false;
        }
        else{
            hasNoUpper(myStr.substring(1));
            return true;
        }

    }


//b)a recursive function that will take a string as an argument
// and produce an integer return value for the index of the leftmost underscore in the string,

//*** This is the function that call the recursive function.
    public static int indexOfUnderscore(String myStr){
        int index=0;
        index =indexOfUnderscoreRecursive(myStr,index);
        return index;
    }
//*** Here is the recursive part for b)
    public static int indexOfUnderscoreRecursive(String myStr, int index){

        if(myStr.equals("")){
            return -1;
        }
        if(myStr.charAt(0) == '_'){
            return index;
        }
        else{
            index++;
            //System.out.println("index to use is : " + index);
            return indexOfUnderscoreRecursive(myStr.substring(1),index);
        }

    }

//c) a recursive function that will take a string as an argument and produce a
// list of strings as a return value such that the argument string has been "split"
// at each instance of the underscore

//*** This is the function that call the recursive function.
    public static Queue<String> splitUnderscore(String myStr){
        String newStr = myStr;
        Queue<String> alist = new LinkedList<>();

        splitUnderscoreRecursive(newStr,alist);
        return alist;

    }

//*** Here is the recursive part for c)
    public static void splitUnderscoreRecursive(String myStr,Queue<String> myList){
        if (myStr.equals("")){
        }
        if(indexOfUnderscore(myStr)==-1){//"string"
            myList.add(myStr);
        }

        else if(indexOfUnderscore(myStr)==length(myStr)-1){ //"string_"
            myList.add(myStr.substring(0,length(myStr)-1));//The length function that I use here is written by myself.
        }
        else if(indexOfUnderscore(myStr)==0){ //"_String"
            splitUnderscoreRecursive(myStr.substring(1),myList);
        }
        else{
            myList.add(myStr.substring(0,indexOfUnderscore(myStr)));
            splitUnderscoreRecursive(myStr.substring(indexOfUnderscore(myStr)+1),myList);
        }
    }
//d) a recursive function that will take a string as an argument
// and produce an integer return value for the index of the leftmost vowel in the string,

    public static int getFirstVowelIndex(String myStr){
        if(myStr.isEmpty()){
            return -1;
        }
        if(
                myStr.charAt(0) == 'a'||
                myStr.charAt(0) == 'e'||
                myStr.charAt(0) == 'i'||
                myStr.charAt(0) == 'o'||
                myStr.charAt(0) == 'u'  ){

            return 0;


        }
        else{
            return getFirstVowelIndex(myStr.substring(1))+1;
        }
    }

//e)  a function that will take a string as an argument and produce a string
// return value by changing that "word" into "Pig Latin".

    public static String convert(String myStr){
        int indexOfVowel = -1;
        if(myStr.isEmpty()){
            return "";
        }
        indexOfVowel = getFirstVowelIndex(myStr);
        if(indexOfVowel >= 0){
            return myStr.substring(indexOfVowel) + myStr.substring(0,indexOfVowel) + "ay";

        }
        else{
            return myStr + "ay";
        }

    }

//f) a recursive function that will take a list of strings as an argument and
// produce a list of strings in Pig Latin format as a return value.

//*** This is the function that call the recursive function.
    public static Queue<String> convertList (Queue<String> myList){
        Queue<String> inList = myList;
        Queue<String> outList= new LinkedList<>();


        convertListRecursive(inList,outList);

        return outList;
    }

//*** Here is the recursive part for f)
    public static void convertListRecursive(Queue<String> inList, Queue<String> outList){

        if(!inList.isEmpty()){
            outList.add(convert(inList.peek()));
            inList.remove();
            convertListRecursive(inList, outList);
        }

    }


//This is the length function that I wrote by myself.

    public static int length(String s) {
        if (s.isEmpty())
            return 0;
        else
            return length(s.substring(1)) + 1;
    }



}
