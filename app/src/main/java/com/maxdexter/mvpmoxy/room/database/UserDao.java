package com.maxdexter.mvpmoxy.room.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.maxdexter.retrofituser.model.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) //если будет такой же user то он его заменит
    void addUser(User user);

    @Query("SELECT * FROM users")
    List<User> getAllUser();

    @Query("SELECT * FROM users where name =:name")
    List<User> selectUser(String name);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);
}
