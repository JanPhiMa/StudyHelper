package at.fhj.ima.studyhelper.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import at.fhj.ima.studyhelper.classes.StudyProgram
import at.fhj.ima.studyhelper.classes.Users

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(users: Users)

    @Query("SELECT username, password, studyProgram, semester FROM Users where username = :name")
    fun findUsersByUsername(name: String): Users?

    @Query("UPDATE Users SET studyProgram = :studyProgram WHERE username = :name")
    fun insertStudyProgram (name: String, studyProgram: String)

    @Query("UPDATE Users SET semester = :semester WHERE username = :name")
    fun insertSemester (name:String, semester: String)

}
