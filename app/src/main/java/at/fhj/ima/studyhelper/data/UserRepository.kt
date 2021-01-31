package at.fhj.ima.studyhelper.data

import android.content.Context
import androidx.room.Ignore
import at.fhj.ima.studyhelper.classes.Users


object UserRepository {

    fun addUser(context: Context, user: Users) {
        val applicationContext = context.applicationContext
        val db = UserDatabase.getDatabase(applicationContext)
        db.usersDao.insert(user)
    }

    fun findUser(context: Context, username: String):Users? {
        val applicationContext = context.applicationContext
        val db = UserDatabase.getDatabase(applicationContext)
        return db.usersDao.findUsersByUsername(username)
    }

    fun addStudyProgram(context: Context, username: String, studyProgram: String) {
        val applicationContext = context.applicationContext
        val db = UserDatabase.getDatabase(applicationContext)
        return db.usersDao.insertStudyProgram(username, studyProgram)
    }
    fun addSemester(context: Context, username: String, semester: String) {
        val applicationContext = context.applicationContext
        val db = UserDatabase.getDatabase(applicationContext)
        return db.usersDao.insertSemester(username, semester)
    }
}