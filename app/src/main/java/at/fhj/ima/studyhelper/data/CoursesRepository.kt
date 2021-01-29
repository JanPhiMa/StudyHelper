package at.fhj.ima.studyhelper.data

import at.fhj.ima.studyhelper.classes.Courses
import at.fhj.ima.studyhelper.classes.StudyProgram

object CoursesRepository {

    private val coursesList: MutableList<Courses>

    init {
        coursesList = mutableListOf(
            Courses(
                "Mathematik 1 für Informationsmanagerinnen",
                "Rüdiger Rudolf",
                1,
                5.0,
                4.0,
                    "Informationsmanagement"
            ),
            Courses(
                "Einführung in das Informationsmanagement",
                "Werner Fritz",
                1,
                1.0,
                1.0,
                    "Informationsmanagement"
            ),
            Courses (
                "Informatik 1 für Informationsmanagerinnen",
                "Andreas Avender",
                1,
                4.0,
                3.0,
                    "Informationsmanagement"
            ),
            Courses (
                "Grundlagen des Betriebssystems Linux",
                "Gerd Radl",
                1,
                2.5,
                2.0,
                    "Informationsmanagement"
            ),
            Courses(
                "Grundlagen des Betriebssystems Windows",
                "Benjamin Gürtel",
                1,
                2.5,
                2.0,
                    "Informationsmanagement"
            ),
            Courses(
                "Grundlagen der Internet Technologien",
                "Georg Mittenecker",
                1,
                5.0,
                4.0,
                    "Informationsmanagement"
            ),
            Courses(
                "Grundlagen der Digitalen Medien Technologien",
                "Gerhard Sprung",
                1,
                2.5,
                2.0,
                    "Informationsmanagement"
            ),
            Courses(
                "Grundlagen der Datenbanksysteme und Datenmodellierung",
                "Klemens Konopasek",
                1,
                2.5,
                2.0,
                    "Informationsmanagement"
            ),
            Courses(
                "English for ICT and Business: Language Basics 1",
                "Lisa Zimmermann",
                1,
                2.5,
                2.5,
                    "Informationsmanagement"
            ),
            Courses(
                "Lern- und Arbeitstechniken",
                "Werner Fritz",
                1,
                1.0,
                1.0,
                    "Informationsmanagement"
            ),
            Courses(
                "PC Anwendungen",
                "Gernot Fritz, Rüdiger Rudolf",
                1,
                1.5,
                1.5,
                    "Informationsmanagement"
            ),
            Courses(
                "Grundlagen der Angewandten Statistik",
                "Johannes Hofrichter",
                2,
                2.0,
                2.0,
                    "Informationsmanagement"
            ),
            Courses(
                "Mathematik 2 für Informationsmanagerinnen",
                "Rüdiger Rudolf",
                2,
                3.0,
                2.0,
                    "Informationsmanagement"
            ),
            Courses(
                "Informatik 2 für informationsmanagerinnen",
                "Peter Salhofer",
                2,
                5.0,
                4.0,
                    "Informationsmanagement"
            ),
            Courses(
                "Serveradministration Linux",
                "Gerd Radl",
                2,
                2.5,
                1.5,
                    "Informationsmanagement"
            ),
            Courses(
                "Serveradministration Windows",
                "Benjamin Gürtl",
                2,
                2.5,
                1.5,
                    "Informationsmanagement"
            ),
            Courses(
                "Digital Asset Produktion und Management",
                "Gerhard Sprung",
                2,
                2.5,
                1.5,
                    "Informationsmanagement"
            ),
            Courses(
                "Datenbanksprachen",
                "Klemens Konopasek",
                2,
                5.0,
                4.0,
                    "Informationsmanagement"
            ),
            Courses(
                "Grundlagen der Betriebswirtschaftslehre",
                "Alexander Herbst",
                2,
                2.5,
                2.0,
                    "Informationsmanagement"
            ),
            Courses(
                "Sicher Unternehmensnetzwerke 1",
                "Georg Mittenecker, Dietmar Gaar",
                2,
                2.5,
                2.0,
                    "Informationsmanagement"
            ),
            Courses(
                "English for ICT and Business: Language Basics 2",
                "Lisa Zimmermann",
                2,
                1.5,
                1.5,
                    "Informationsmanagement"
            ),
            Courses(
                "Präsentationstraining",
                "Lisa Zimmermann",
                2,
                1.0,
                1.0,
                    "Informationsmanagement"
            ),
                Courses(
                        "English Foundation for eHealth 1",
                        "Anita Töchterle",
                        1,
                        2.5,
                        2.0,
                        "Gesundheitsinformatik"
                ),
                Courses(
                        "Mathematik 1 für Informatik",
                        "Clemens Keil",
                        1,
                        5.0,
                        3.0,
                        "Gesundheitsinformatik"
                ),
                Courses(
                        "Einführung in die Medizin",
                        "Erich Sorantin",
                        1,
                        2.5,
                        2.0,
                        "Gesundheitsinformatik"
                ),
                Courses(
                        "Grundlegende Begriffe der Medizin",
                        "Norbert Adelwöhrer",
                        1,
                        2.5,
                        2.0,
                        "Gesundheitsinformatik"
                ),
                Courses(
                        "Einführung in die Informatik für eHealth",
                        "Robert Rehb",
                        1,
                        2.5,
                        2.0,
                        "Gesundheitsinformatik"
                ),
                Courses(
                        "Grundlagen Naturwissenschaften",
                        "Bernhard Neumayer",
                        1,
                        2.5,
                        2.0,
                        "Gesundheitsinformatik"
                ),
                Courses(
                        "Lern- und Arbeitstechniken",
                        "Peter Altmann",
                        1,
                        2.5,
                        2.0,
                        "Gesundheitsinformatik"
                ),
                Courses(
                        "Softwareentwicklung Grundlagen",
                        "Baptiste Alcalde, Christoph Reiter",
                        1,
                        5.0,
                        3.0,
                        "Gesundheitsinformatik"
                ),
                Courses(
                        "Gesundheitsökonomische Grundlagen",
                        "Robert Mischak",
                        1,
                        3.5,
                        3.0,
                        "Gesundheitsinformatik"
                ),
                Courses(
                        "Gesundheitsrecht",
                        "Werner Hauser",
                        1,
                        1.5,
                        1.0,
                        "Gesundheitsinformatik"
                )

        )
    }
    fun coursesList(): MutableList<Courses>{
        return CoursesRepository.coursesList
    }
}