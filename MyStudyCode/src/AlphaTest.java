
/*/
invalid creds 3x, account locked
account status -
status {
locked,
available,
blocked,

}

 */
public class AlphaTest {


        @Controller
        class LoginController {
            @Autowired
            LoginService loginService

            @POST
            ModelAndView login(String username, String password){
                boolean status = loginService.authenticate(username, password);

                Model model = new Model();
                String viewName = status ? "Home" : "Login"
                If(!status) {
                    model.error("Invalid credentials entered");
                }

                return new ModelAndView(viewName, model);

            }
        }

        @Service
        class LoginService {

            @Autowired
            UserDao userDao;

            boolean authenticate(String username, String password) throws Exception{
                User user = userDao.fetchUser(username);
                int retryCounter = user.retryCounter++; // 1, 2,
                saveUser(user);
                // Compare password
                if(retryCounter==3) {
                    user.status=Status.LOCKED;
                    saveUser(user);
                    throws new Exception("AccountLocked Error");
                } else if (password != user.getPassword())
                    throws new Exception("Password Error");
                else
                    return !user.status.equals(Status.LOCKED) && password == user.getPassword();
            }
        }

    class LoginServiceTest {

        @Mock
        UserDao userDao;

        @Test(expected=Exception.class)
        boolean authenticateTestForAccountLocked(String username, String password) throws Exception{
            User user = new User();
            user.setRetryCounter = 2;
            when(userDao.fetchUser(Mockito.anyString())).thenReturn (user);

            LoginService loginService = new LoginService();
            loginService.authenticate("","");

        }
    }


        @Bean
        class UserDao {

            User fetchUser(String name) {
     ...
            }

        }

        public enum Status {
            LOCKED, //UNLOC, BLOCK, RESTRICTED
        }

        class User {
            private String name;
            private String password;
            private Status status;
            private int retryCounter; // starting with 0
            public User(){

            }
        }
}




bad_ip_addresses.txt
        1.12.3.23
        1.12.4.23
        2.12.4.23
        ...

        --- 100000 entries


class BadIPFilter {

    @autowired
    IPChecker ipchecker
    @ Autowire
    WorkFlowContext workFlowContext; hashMap<Object, Object>
    void filter(req, res){
        boolean status = ipchecker.isBadIP(req.getIpAddress())
 ...
    }

}

class IpValidation implements IPChecker {
    boolean isBadIP(String ipaddress, ) {
        HashSet<String> inputBadIps;
        for inputBadIp : inputBadIps

    }
}
       |
[] [] [] [] []

interface IPChecker {
    boolean isBadIP(String ipaddress)
}

Application.java -> HashSet<String> inputBadIps;





