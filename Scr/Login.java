package Scr;

import java.util.HashMap;

public class Login {


    HashMap<String, String> loginInfo = new HashMap<String,String>();

    public Login ()
    {
        loginInfo.put("Carl long", "12345678");
        loginInfo.put("Tris tall", "1");//"9934959");
        loginInfo.put("Can This", "34242593");
        loginInfo.put("nick gan", "50600302");

    }

    public HashMap getLoginInfo()
    {
        return loginInfo;
    }
    
}
