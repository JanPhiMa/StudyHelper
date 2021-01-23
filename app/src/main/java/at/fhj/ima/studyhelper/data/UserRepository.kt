package at.fhj.ima.studyhelper.data

import at.fhj.ima.studyhelper.classes.Users
import at.fhj.ima.studyhelper.data.UserRepository.userList

object UserRepository {
    private val userList: MutableList<Users>

    init {
        userList = mutableListOf(
            Users("Test", "Pa55w.rd")
        )
    }

    fun readUserList(): MutableList<Users>{
        return userList
    }

    fun addUser(username: String, password:String) {
        val User = Users(username, password)
        userList.add(User)
    }
}