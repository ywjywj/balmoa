package springproject.springfb.email;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private final RedisUtil redisUtil;

    private String createdCode() {
        int leftLimit = 48; // number '0'
        int rightLimit = 122; // alphabet 'z'
        int targetStringLength = 6;
        Random random = new Random();

        return random.ints(targetStringLength,leftLimit, rightLimit + 1)
                .filter(i -> (i <=57 || i >=65) && (i <= 90 || i>= 97))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)//collect(Stream의 자료형을 변환시켜준다.),appendCodePoint(int codePoint) : 해당 아스키코드의 character를 추가
                .toString();
    }
    public SimpleMailMessage createMail(String email){
        ArrayList<String> toUserList = new ArrayList<>();

//        toUserList.add("gmw0421@naver.com");
//        toUserList.add("vcfdxzsa12@gmail.com");
//        toUserList.add("21960029@st.yc.ac.kr");
        //여러 유저들의 동시다발적인 호출에 의한 대처도 생각해야할듯.
        toUserList.add(email);
        int toUserSize = toUserList.size();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String code = createdCode();//난수로 생성해야함.
        simpleMailMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));
//        simpleMailMessage.setTo(address);
        simpleMailMessage.setSubject("Test Subject");
//        simpleMailMessage.setFrom("풋살장 예약 어플");
        simpleMailMessage.setText("풋살장 인증 코드 : "+ code);

        redisUtil.setDataExpire(email,code,60*30L);
        return simpleMailMessage;
    }

    public void sendMail(String email){
        if(redisUtil.existData(email)){
            redisUtil.deleteData(email);
        }
        SimpleMailMessage simpleMailMessage = createMail(email);
        javaMailSender.send(simpleMailMessage);
    }

//    public boolean verifyEmailCode(String email,String code) {
//        if(email.isEmpty()&&code.isEmpty())return false;
//        return true;
//    }
    public Boolean verifyEmailCode(String email, String code) {
        String codeFoundByEmail = redisUtil.getData(email);
        if (codeFoundByEmail == null) {
            return false;
        }
        return codeFoundByEmail.equals(code);
    }
}
