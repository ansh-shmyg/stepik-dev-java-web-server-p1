package accountServer;

/**
 * @author a.akbashev
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountServerController implements AccountServerControllerMBean {
    private final AccountServerI accountServer;

    public AccountServerController(AccountServerI accountServer) {
        this.accountServer = accountServer;
    }

    @Override
    public long getUsers() {
        return accountServer.getUsersCount();
    }

    @Override
    public long getUsersLimit() {
        return accountServer.getUsersLimit();
    }

    @Override
    public void setUsersLimit(long bla) {
        accountServer.setUsersLimit(bla);
    }
}
