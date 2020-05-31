package software.kalender.pocketcase.interfaces;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

public interface DaoInterface<T> {
    @Insert
    public long insert(T model);

    @Update
    public void update(T model);
}
