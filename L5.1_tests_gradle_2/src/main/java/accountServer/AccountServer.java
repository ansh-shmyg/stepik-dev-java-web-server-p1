package accountServer;

/**
 * @author a.akbashev
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountServer implements AccountServerI {
    private long usersCount;
    private long usersLimit;

    public AccountServer(int usersLimit) {
        this.usersCount = 0;
        this.usersLimit = usersLimit;
    }

    @Override
    public void addNewUser() {
        usersCount += 1;
    }

    @Override
    public void removeUser() {
        usersCount -= 1;
    }

    @Override
    public long getUsersLimit() {
        return usersLimit;
    }

    @Override
    public void setUsersLimit(long usersLimit) {
        this.usersLimit = usersLimit;
    }

    @Override
    public long getUsersCount() {
        return usersCount;
    }
}
