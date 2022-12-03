package model;

public class RegexModel {
    public static boolean isNumber(String str){
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    public static boolean isSpecialCharacter(String str){
        return str.matches("\\.[{(*+?^$|]");
    }
    public static boolean dateRegex(String str){
        return str.matches("^\\d{2}[-|/]\\d{2}[-|/]\\d{4}$");
    }
    public static boolean isAlphabet(String str){
        return !RegexModel.isNumber(str) && !str.isBlank() && !RegexModel.isSpecialCharacter(str);
    }
}
