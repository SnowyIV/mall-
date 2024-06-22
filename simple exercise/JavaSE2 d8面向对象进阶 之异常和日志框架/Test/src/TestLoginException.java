import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLoginException {
    private static Logger logger = LoggerFactory.getLogger(TestLoginException.class);
    private String Name = "张无忌";
    private String Passwd = "aa123";

    public static void main(String[] args) {
        TestLoginException login = new TestLoginException();

        try {
            login.Login("张无忌", "bb00");
        } catch (NameException e) {
            logger.info(e.getMessage());
        } catch (PasswdException e) {
            logger.info(e.getMessage());
        }
    }


    public void Login(String Name, String Passwd) throws NameException, PasswdException {
        if (!this.Name.equals(Name)) {
            throw new NameException("用户名错误");
        }
        if (!this.Passwd.equals(Passwd)) {
            throw new PasswdException("密码错误");
        }
    }

    class NameException extends RuntimeException {
        public NameException(String message) {

            super(message);
        }


    }
    class PasswdException extends RuntimeException {
        public PasswdException(String message) {

            super(message);
        }


    }
}
