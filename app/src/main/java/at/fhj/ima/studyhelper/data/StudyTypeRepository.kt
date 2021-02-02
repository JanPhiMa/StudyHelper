package at.fhj.ima.studyhelper.data

import at.fhj.ima.studyhelper.classes.Questions
import at.fhj.ima.studyhelper.classes.StudyType

object StudyTypeRepository {

private val questions: List<Questions>
private val answers: List<StudyType>

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
    answers = listOf(
            StudyType("Visual",
                    "If you are a visual learner, you learn by reading or seeing pictures. You understand and remember things by sight. You can picture what you are learning in your head, and you learn best by using methods that are primarily visual. You like to see what you are learning.\n" +
                    "\n" +
                    "As a visual learner, you are usually neat and clean. You often close your eyes to visualize or remember something, and you will find something to watch if you become bored. You may have difficulty with spoken directions and may be easily distracted by sounds. You are attracted to color and to spoken language (like stories) that is rich in imagery.\n" +
                    "\n" +
                    "Here are some things that visual learners like you can do to learn better:\n" +
                    "\n" +
                    "Sit near the front of the classroom. (It won't mean you're the teacher's pet!)\n" +
                    "Have your eyesight checked on a regular basis.\n" +
                    "Use flashcards to learn new words.\n" +
                    "Try to visualize things that you hear or things that are read to you.\n" +
                    "Write down key words, ideas, or instructions.\n" +
                    "Draw pictures to help explain new concepts and then explain the pictures.\n" +
                    "Color code things.\n" +
                    "Avoid distractions during study times.\n" +
                    "Remember that you need to see things, not just hear things, to learn well."
            ),
            StudyType("Auditory",
                    "If you are an auditory learner, you learn by hearing and listening. You understand and remember things you have heard. You store information by the way it sounds, and you have an easier time understanding spoken instructions than written ones. You often learn by reading out loud because you have to hear it or speak it in order to know it.\n" +
                            "\n" +
                            "As an auditory learner, you probably hum or talk to yourself or others if you become bored. People may think you are not paying attention, even though you may be hearing and understanding everything being said.\n" +
                            "\n" +
                            "Here are some things that auditory learners like you can do to learn better.\n" +
                            "\n" +
                            "Sit where you can hear.\n" +
                            "Have your hearing checked on a regular basis.\n" +
                            "Use flashcards to learn new words; read them out loud.\n" +
                            "Read stories, assignments, or directions out loud.\n" +
                            "Record yourself spelling words and then listen to the recording.\n" +
                            "Have test questions read to you out loud.\n" +
                            "Study new material by reading it out loud.\n" +
                            "Remember that you need to hear things, not just see things, in order to learn well."
            ),
            StudyType("Tactile",
                    "If you are a tactile learner, you learn by touching and doing. You understand and remember things through physical movement. You are a \"hands-on\" learner who prefers to touch, move, build, or draw what you learn, and you tend to learn better when some type of physical activity is involved. You need to be active and take frequent breaks, you often speak with your hands and with gestures, and you may have difficulty sitting still.\n" +
                            "\n" +
                            "As a tactile learner, you like to take things apart and put things together, and you tend to find reasons to tinker or move around when you become bored. You may be very well coordinated and have good athletic ability. You can easily remember things that were done but may have difficulty remembering what you saw or heard in the process. You often communicate by touching, and you appreciate physically expressed forms of encouragement, such as a pat on the back.\n" +
                            "\n" +
                            "Here are some things that tactile learners like you can do to learn better:\n" +
                            "\n" +
                            "Participate in activities that involve touching, building, moving, or drawing.\n" +
                            "Do lots of hands-on activities like completing art projects, taking walks, or acting out stories.\n" +
                            "It's OK to chew gum, walk around, or rock in a chair while reading or studying.\n" +
                            "Use flashcards and arrange them in groups to show relationships between ideas.\n" +
                            "Trace words with your finger to learn spelling (finger spelling).\n" +
                            "Take frequent breaks during reading or studying periods (frequent, but not long).\n" +
                            "It's OK to tap a pencil, shake your foot, or hold on to something while learning.\n" +
                            "Use a computer to reinforce learning through the sense of touch.\n" +
                            "Remember that you learn best by doing, not just by reading, seeing, or hearing."
            ),
            StudyType("Mixed",
                    "You don't have a specific learn type."
            )
    )
}
    fun readQuestions(): List<QuestionAnswerWrapper>{
        return questions.map {
            QuestionAnswerWrapper(
                    question = it
            )
        }
    }
    fun readType(string:String): StudyType {
        for (entry in answers) {
            if (entry.type == string) {
                return entry
            }
        }
        return answers[3]
    }
}

data class QuestionAnswerWrapper(
        val question: Questions,
        var selectedType: Int? = null
)