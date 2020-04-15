package accounts;

import java.util.HashMap;
import java.util.Map;
import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {
    DBService dbService = new DBService();
    private final Map<String, UserProfile> loginToProfile;
    private final Map<String, UserProfile> sessionIdToProfile;

    public AccountService() {
        loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
    }

    public void addNewUserDB(String login, String password) {
        try {
            dbService.addUser(login, password);
            // test
//            dbService.getAllTable();
        }
        catch (DBException e){
            e.printStackTrace();
        }
    }

    public UsersDataSet getUserData(String login) throws DBException {
        return dbService.getUser(dbService.getUserId(login));
    }

    public long getUserByLoginDB(String login) throws DBException {
        return dbService.getUserId(login);
    }

    public void addNewUser(UserProfile userProfile) {
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    public UserProfile getUserByLogin(String login) {
        return loginToProfile.get(login);
    }

    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }
}
