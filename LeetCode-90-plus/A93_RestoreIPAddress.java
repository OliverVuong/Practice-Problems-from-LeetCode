import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;

public class A93_RestoreIPAddress{
    public static List<String> restoreIpAddresses(String s) {

        List<String> IpAddresses = new ArrayList<>();
        int len = s.length();

        for(int a = 1; a <= 3; a++){
        for(int b = 1; b <= 3; b++){
        for(int c = 1; c <= 3; c++){
        for(int d = 1; d <= 3; d++){
            if(a + b + c + d == s.length()){

                if(a > 1 && s.charAt(0) == '0') continue;   //handle leading 0
                String aStr = s.substring(0, a);
                if(Integer.parseInt(aStr) > 255) continue;

                if(b > 1 && s.charAt(a) == '0') continue;
                String bStr = s.substring(a, a + b);
                if(Integer.parseInt(bStr) > 255) continue;

                if(c > 1 && s.charAt(a + b) == '0') continue;
                String cStr = s.substring(a + b, a + b + c);
                if(Integer.parseInt(cStr) > 255) continue;

                if(d > 1 && s.charAt(a + b + c) == '0') continue;
                String dStr = s.substring(a + b + c, len);
                if(Integer.parseInt(dStr) > 255) continue;

                IpAddresses.add(String.format("%s.%s.%s.%s",aStr,bStr,cStr,dStr));
            }
        }}}}

        return IpAddresses;
    }

    public static void test(){

        List<String> results = restoreIpAddresses("010010");

        for(String it : results){
            System.out.println(it);
        }
    }
}