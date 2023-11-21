package springproject.springfb.email.util;

import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

    public boolean vaild(String id){
        if(id.length() != 8) return false;

        char majorCode = id.charAt(3);
        if(!(1 <= majorCode && majorCode <= 6)) return false;

        return true;
    }

    public String toEmail(String id){
        return id + "@st.yc.ac.kr";
    }
}
