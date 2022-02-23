package task;
import java.util.HashMap;
import java.util.HashSet;

class Scratch {
    public static void main(String[] args) {
        String example = "scheme://login:password@host:9999/Url-path?parameters#anchor";
        WebAddressParser test = new WebAddressParser(example);
        HashMap<String, String> par = test.getParameters();
        String login = test.getLogin();
        String password = test.getPassword();
        String port = test.getPort();
        String fragment = test.getFragment();
    }
}
