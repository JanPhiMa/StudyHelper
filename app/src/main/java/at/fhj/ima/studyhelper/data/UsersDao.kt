package at.fhj.ima.studyhelper.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import at.fhj.ima.studyhelper.classes.Users

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: Users)

    @Query("SELECT username, password FROM Users where username = :name")
    fun findUsersByUsername(name: String): Users?
}
