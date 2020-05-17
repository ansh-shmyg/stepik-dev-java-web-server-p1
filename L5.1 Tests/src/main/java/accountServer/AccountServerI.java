package accountServer;

/**
 * @author v.chibrikov
 *         <p/>
 *         Пример кода для курса на https://stepic.org/
 *         <p/>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public interface AccountServerI {
    void addNewUser();

    void removeUser();

    long getUsersLimit();

    void setUsersLimit(long usersLimit);

    long getUsersCount();
}
