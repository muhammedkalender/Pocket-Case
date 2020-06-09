package software.kalender.pocketcase.database;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

import software.kalender.pocketcase.interfaces.DaoInterface;
import software.kalender.pocketcase.models.UserModel;

@Dao
public interface UserDao extends DaoInterface<UserModel> {
    @Query("SELECT * FROM users WHERE userId = :id")
    public UserModel get(long id);

    @Query("SELECT * FROM users")
    public List<UserModel> list();

    @Query("SELECT * FROM users LIMIT 1")
    public UserModel defaultUser();
}
