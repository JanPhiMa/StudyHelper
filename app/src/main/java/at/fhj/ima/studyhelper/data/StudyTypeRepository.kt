package at.fhj.ima.studyhelper.data

import at.fhj.ima.studyhelper.classes.Questions

object StudyTypeRepository {

private val questions: List<Questions>

init {
    questions = listOf(
        Questions(0,
            "What is most important to you on vacation?",
            "I want to see a lot of new things.",
            "I like to hear foreign languages.",
            "I want to get new impressions."
        ),
        Questions(1,
            "You need new clothes. What do you choose?",
            "Fashionable clothes in my favorite colors.",
            "Clothes are not that important to me.",
            "Comfortable clothes that feel good."
        ),
        Questions(2,
            "What do you like to do in your free time?",
            "Read",
            "Listen to music.",
            "Do sports or just laze around."
        ),
        Questions(3,
            "Which birthday surprise are you most excited about?",
            "About an exciting book",
            "About a favorite CD",
            "About sweets or an invitation to dinner"
        ),
        Questions(4,
            "What is particularly important to you in an apartment?",
            "That it is bright and has large windows.",
            "That you can be loud sometimes.",
            "That it is cozy."
        ),
        Questions(5,
            "Which type of trainer do you like most?",
            "The one who presents his material clearly with an overview.",
            "The one who explains a lot and often tells stories.",
            "The one who is nice and funny."
        ),
        Questions(6,
            "What is the first thing you would buy if you were furnishing a new home?",
            "Lots of pictures and photos.",
            "A new music system.",
            "A comfortable sofa."
        ),
        Questions(7,
            "What do you find particularly important in a boy-/ girlfriend?",
            "The good looks.",
            "That you can talk to each other.",
            "That you feel good together."
        ),
        Questions(8,
            "Which item do you definitely take with you on vacation?",
            "Your camera.",
            "Your MP3 player.",
            "Your favorite shoes."
        ),
        Questions(9,
            "How sure are you with your spelling?",
            "I am very sure.",
            "I make mistakes every now and then.",
            "I feel more insecure."
        ),
        Questions(10,
            "The instructor introduces a new game",
            "I want to watch first.",
            "I would like to have it explained in detail.",
            "I want to try it out right away."
        ),
        Questions(11,
            "How do you behave when riding a roller coaster?",
            "I look at the world from above.",
            "I scream very loud.",
            "I'm definitely holding on to something."
        ),
        Questions(12,
            "How do you get information on a new topic that interests you?",
            "I read books about it or search the internet.",
            "I listen to lectures.",
            "I try to gain my own experience."
        ),
        Questions(13,
            "Can you remember foreign words just by listening to them?",
            "No, I have to see it written too.",
            "Yeah, I'm pretty good at that.",
            "I can hardly remember foreign words."
        ),
        Questions(14,
            "Do you like to read?",
            "Yes, I read a lot.",
            "I don't read that much.",
            "I almost never read."
        ),
        Questions(15,
            "Which activity do you find most important?",
            "Watching television.",
            "Talking on the telephone.",
            "Go to the fitness studio."
        ),
        Questions(16,
            "How do you plan a weekend?",
            "I usually have very clear ideas.",
            "I discuss things with friends or family.",
            "I usually decide that spontaneously."
        ),
        Questions(17,
            "How do you get in touch with a friend after a long period of time?",
            "I write a letter.",
            "I'm calling them.",
            "I'll just stop by."
        ),
        Questions(18,
            "What would you like to do in the production of a newspaper?",
            "Plan and organize.",
            "Conduct interviews.",
            "Put together articles and pictures."
        ),
        Questions(19,
            "How do you prepare for a presentation?",
            "In any case, I will prepare slides / a Powerpoint presentation for it.",
            "I can actually talk quite well.",
            "I would rather hand in something written."
        ),
    )
}
    fun readQuestions(): List<Questions>{
        return questions
    }
}