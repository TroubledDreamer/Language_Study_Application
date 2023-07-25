package src.ProgramDemo;

import java.util.HashMap;

public class Login {


    HashMap<String, String> loginInfo = new HashMap<String,String>();

    public Login ()
    {
        loginInfo.put("Carl long", "12345678/620157742");
        loginInfo.put("Tris tall", "1/620157741");//"9934959");
        loginInfo.put("Can This", "34242593/620157743");
        loginInfo.put("nick gan", "50600302/620157744");

    }

    public HashMap<String, String> getLoginInfo()
    {
        return loginInfo;
    }
    
}
