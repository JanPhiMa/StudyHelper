package at.fhj.ima.studyhelper.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import at.fhj.ima.studyhelper.classes.Users

@Database(entities = [Users::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract val usersDao: UsersDao

    companion object {
        private var INSTANCE: UserDatabase? = null
        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): UserDatabase {
            return Room.databaseBuilder(
                context,
                UserDatabase::class.java, "user-db"
            )
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }
    }
}