package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.EmailAuthService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAuthManager implements EmailAuthService {
    @Override
    public boolean auth(String mail) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = pattern.matcher(mail);
        if (matcher.find()){
            return true;
        }
        return false;
    }
}
