package com.maxdexter.mvpmoxy.room.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.*;
import retrofit2.http.DELETE;

import com.maxdexter.mvpmoxy.room.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) //если будет такой же user то он его заменит
    Single<Long> addUser(User user);

    @Query("SELECT * FROM users")
    Single<List<User>>  getAllUser();

    @Query("SELECT * FROM users where name =:surname")
    Single<List<User>> selectUser(String surname);

    @Update
    Single<Integer> updateUser(User user);

    @Delete
    Single<Integer> deleteUser(User user);
}
