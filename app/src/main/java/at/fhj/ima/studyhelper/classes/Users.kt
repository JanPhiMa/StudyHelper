package at.fhj.ima.studyhelper.classes

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Users(@PrimaryKey val username:String, val password: String) {
}