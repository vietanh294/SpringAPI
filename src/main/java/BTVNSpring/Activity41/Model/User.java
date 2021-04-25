package BTVNSpring.Activity41.Model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User implements ValidInput {
    private  String userEmail;
    private  String userPhoneNumber;
    private  String userPassword;

    @Override
    public boolean checkPhoneNumber(String userPhoneNumber) {
        if (userPhoneNumber.length() != 10){
            return false;

        } else return true;
    }

    @Override
    public boolean checkPassword(String userPassword) {
        if (userPassword.length() < 6){
            return false;
        } else return true;

    }

    @Override
    public boolean checkEmail(String userEmail) {
        if (userEmail.endsWith("@gmail.com") == false){
            return  false;
        } else  return  true;

    }

}
