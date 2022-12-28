package misc;

public class RegexTest {
    public static void main(String[] args){
        String username = "teja.tech10";
        String password = "Pass@123";
        String mobNo = "7654387645";

        //a to z 1 or more no of times, followed by ., followed by a to z 0 or more no of times, followed by number 1 or more
        String regex_username = "[a-z]+[\\.][a-z]*[0-9]+";
        String regex_password = "(?=.*[0-9])(?=.*[!&*])[A-Z]{1}[a-z A-Z]*[@][0-9]+[a-z A-Z]*";
        String regex_mob = "[789][0-9]{9}";

        boolean username_matches = username.matches(regex_username);
        boolean password_matches = password.matches(regex_password);
        boolean mob_matches = mobNo.matches(regex_mob);

        System.out.println("Username valid "+username_matches);
        System.out.println("Password valid "+password_matches);
        System.out.println("Mob valid "+mob_matches);


    }
}
