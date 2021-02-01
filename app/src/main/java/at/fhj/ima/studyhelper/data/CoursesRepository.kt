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
                "Peter Salhofer, Lukas Bloder",
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
            ),
            Courses(
                "Mediengeschichte und Medienentwicklung",
                "Heinz Peter Wassermann",
                1,
                4.0,
                3.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Theorie und Praxis in der Kommunikation",
                "Heinz Fischer",
                1,
                4.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Berufe im Journalismus und in der Kommunikationsbranche",
                "Nikolaus Koller, Wolfgang Kühnelt",
                1,
                4.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Grundlagen der PR",
                "Gudrun Reimerth",
                1,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Grundlagen des Journalismus",
                "Nikolaus Koller, Thomas Wolkinger",
                1,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Englisch: News Writing",
                "Edith Podhovnik",
                1,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses (
                "Newsroom: Journalistisches Schreiben",
                "Peter Kolb, Donja Noormofidi",
                1,
                4.0,
                3.0,
                "Journalismus und Public Relations"
            ),
            Courses (
                "PR-Labor: Texten in der Kommunikationspraxis",
                "Wolfgang Kühnelt, Gudrun Reimerth",
                1,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses (
                "Grundlagen der Webtechnik",
                "Boris Böttinger",
                1,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Webkompetenz für Kommunikationsberufe",
                "Eva Goldgruber, Jutta Pauschenwein",
                1,
                4.0,
                3.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "English Foundation for eHealth 2",
                "Anita Töchterle",
                2,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Grundlagen Biostatistik",
                "Simone Huber, Hans Peter Stüger",
                2,
                2.0,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Mathematik 2 für Informatik",
                "Clemens Keil, Herbert Lichtenegger",
                2,
                3.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Informationssysteme im Gesundheits- und Sozialwesen",
                "Dominik Panwinkler",
                2,
                2.5,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Medizinische Dokumentation",
                "Bianca Schnalzer",
                2,
                5.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Grundlagen Naturwissenschaften 2",
                "Robert Arnold",
                2,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Kommunikation im Gesundheitswesen",
                "Sascha Alexandra Gross-Jussel",
                2,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Softwareentwicklung - Objektorientierte Programmierung",
                "Christoph Reiter",
                2,
                5.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Gesundheitsrecht - Vertiefung",
                "Werner Hauser",
                2,
                2.0,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Nationale und internationale GEsundheitssysteme",
                "Bianca Schnalzer",
                2,
                3.0,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Abriss internationaler wirtschaftlicher, politischer und kultureller Entwicklungen",
                "Heinz Peter Wassermann",
                2,
                6.0,
                3.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "PR - Konzeption und -Konzeptanalyse",
                "Gudrun Reimerth",
                2,
                2.0,
                1.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "PR - Labor: Kreation und Projektmanagement",
                "Wolfgang Kühnelt, Gudrun Reimerth",
                2,
                4.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Journalistische Arbeitstechniken",
                "Ute Baumhackl, Werner Schandor, Thomas Wolkinger",
                2,
                6.0,
                3.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Bild und Bildbearbeitung",
                "Boris Böttinger",
                2,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Content Management",
                "Boris Böttinger",
                2,
                3.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Newsroom: Web - Publishing",
                "Thomas Wolkinger",
                2,
                3.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Einführung in das wissenschaftliche Arbeiten",
                "Heinz Peter Wassermann",
                2,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Englisch: Research - based Writing",
                "Edith Podhovnik, Ulrike Pölzl-Hobusch",
                2,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Sichere Unternehmensnetzwerke",
                "Georg Mittenecker, Dietmar Gaar",
                3,
                5.0,
                4.0,
                "Informationsmanagement"
            ),
            Courses(
                "Datenbank - Anwendungsentwicklungen",
                "Klemens Konopasek, Gerhard Jauk",
                3,
                5.0,
                3.5,
                "Informationsmanagement"
            ),
            Courses(
                "English for Business Purposes",
                "Gerhild Janser - Munro",
                3,
                2.5,
                2.5,
                "Informationsmanagement"
            ),
            Courses(
                "IT Infrastructure Design",
                "Christopher Schwarz, Erwin Zinser",
                3,
                5.0,
                4.0,
                "Informationsmanagement"
            ),
            Courses(
                "Kommunikationstraining",
                "Lisa Zimmermann",
                3,
                1.5,
                1.5,
                "Informationsmanagement"
            ),
            Courses(
                "Präsentationstechnik",
                "Lisa Zimmermann",
                3,
                1.0,
                1.0,
                "Informationsmanagement"
            ),
            Courses(
                "Software Engineering Basic",
                "Lukas BLoder, Peter Salhofer",
                3,
                5.0,
                4.0,
                "Informationsmanagement"
            ),
            Courses(
                "Projektmanagement Grundlagen",
                "Gerhild Janser - Munro",
                3,
                1.5,
                1.5,
                "Unternehmensführung Grundlagen"
            ),
            Courses(
                "Datenbanksysteme Grundlagen",
                "Baptiste Alcalde, Robert Rehb",
                3,
                5.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Global Issues in Healthcare 1",
                "Anita Töchterle",
                3,
                2.5,
                2.5,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Standards in der Gesundheitsinformatik",
                "Bianca Schnalzer, Carina Seerainer",
                3,
                5.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Basis - Netzwerktechnologien für eHealth",
                "Sten Hanke, Erich Häupl",
                3,
                5.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Einführung Projektmanagement",
                "Karin Messer - Misak",
                3,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Prozessmanagement Grundlagen",
                "Susanne Altendorfer - Kaiser",
                3,
                5.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Softwareentwicklung - Datenstrukturen und Algorithmen",
                "Markus Pscheidt, Doris Ulrich",
                3,
                5.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Angewandte empirische Sozialforschung",
                "Heinz Peter Wassermann",
                3,
                5.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Medienkonvergenz und Redaktion",
                "Ingrid Brodnig, Heinz Peter Wassermann, Thomas Wolkinger",
                3,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Medientheorien und Medienkritik",
                "Heinz M. Fischer, Matthias Forenbacher, Eva Goldgruber, Gudrun Reimerth, Susanne Sackl - Sharif, Heinz Peter Wassermann, Thomas Wolkinger",
                3,
                4.0,
                3.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Audio- und Videoproduktion",
                "Boris Böttinger, Günter Encic, Werner Goger, Maria Reisinger",
                3,
                5.0,
                5.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Datenschutz",
                "Elisabeth Hödl",
                3,
                2.0,
                1.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Newsroom: Die Reportage",
                "Denise Hruby, Thomas Wolkinger",
                3,
                4.0,
                1.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Englisch: Campaigning",
                "Edith Podhovnik",
                3,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "PR - Labor: Planung, Evaluierung und Analyse",
                "Wolfgang Kühnelt, Gudrun Reimerth",
                3,
                4.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Strategische Unternehmenskommunikation",
                "Wolfgang Kühnelt",
                3,
                2.0,
                1.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Bachelorarbeit 1",
                "Georg Mittenecker",
                4,
                5.0,
                2.0,
                "Informationsmanagement"
            ),
            Courses(
                "Heterogene vernetzte Systeme",
                "Georg Mittenecker",
                4,
                5.0,
                3.0,
                "Informationsmanagement"
            ),
            Courses(
                "Digitale Medien Technologien 3 - Interaktionsprogrammierung",
                "Alexander Nischelwitzer, Robert Strohmaier",
                4,
                5.0,
                3.0,
                "Informationsmanagement"
            ),
            Courses(
                "Communications Infrastructure Design",
                "Christopher Schwarz",
                4,
                2.5,
                1.5,
                "Informationsmanagement"
            ),
            Courses(
                "Einführung in das wissenschaftliche Arbeiten und Schreiben",
                "Markus Königstorfer",
                4,
                1.5,
                1.5,
                "Informationsmanagement"
            ),
            Courses(
                "Teamtraining",
                "Gerhild Janser - Munro",
                4,
                1.5,
                1.5,
                "Informationsmanagement"
            ),
            Courses(
                "Software Engineering Advanced",
                "Stefan Krausler - Baumann, Peter Salhofer",
                4,
                5.0,
                3.5,
                "Informationsmanagement"
            ),
            Courses(
                "Geschäftsprozessmanagement",
                "Robert Singer",
                4,
                3.5,
                3.0,
                "Informationsmanagement"
            ),
            Courses(
                "Geschäftsprozessmanagement",
                "Robert Singer",
                4,
                1.5,
                1.0,
                "Informationsmanagement"
            ),
            Courses(
                "Datengestützte Analysemethoden",
                "Flooh Perlot",
                4,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Scripting & Coding",
                "Alexander Neuherz",
                4,
                4.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Englisch: International Media",
                "Edith Podhovnik, Ulrike Pölzl - Hobusch",
                4,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Medien und Gesellschaft",
                "Heinz M. Fischer, Eva Goldgruber, Robert Gutounig, Tanja Hatzl - Schönbacher, Wolfgang Kühnelt, Gudrun Reimerth, Susanne Sackl - Sharif, Heinz Peter Wassermann, Thomas Wolkinger",
                4,
                8.0,
                3.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Medienrecht",
                "Thomas Zacharias",
                4,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Datenjournalismus",
                "Ernst Peter Sim, Thomas Wolkinger",
                4,
                6.0,
                4.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Digitaler Magazinjournalismus",
                "Thomas Wolkinger",
                4,
                6.0,
                4.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Content Strategie",
                "Wolfgang Kühnelt, Gudrun Reimerth",
                4,
                6.0,
                4.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Integrierte Kommunikation",
                "Christoph Pelzl, Gudrun Reimerth",
                4,
                6.0,
                4.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Datenbanksysteme - Vertiefung",
                "Baptiste Alcalde, Robert Rehb",
                4,
                5.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Datenschutz und Datensicherheit",
                "Franz Hoheiser - Pförtner",
                4,
                5.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Global Issuses in Healthcare 2",
                "Anita Töchterle",
                4,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Biosignale",
                "Sten Hanke",
                4,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Projekt- und Programm - Management",
                "Karin Messer - Miak",
                4,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Softwareentwicklung - Mobile Anwendungen",
                "Baptiste Alcalde",
                4,
                5.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Gesundheitsbetriebslehre",
                "Eva Schwarz",
                4,
                5.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Einführung in Gesundheits- und Sozialberufe 1",
                "Sonja Savic",
                4,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Kernprozesse im Gesundheitswesen",
                "Hartwig Zenz",
                4,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Bachelorarbeit 2",
                "Georg Mittenecker",
                5,
                10.0,
                2.0,
                "Informationsmanagement"
            ),
            Courses(
                "Betriebsübergreifende Projektarbeit",
                "Erwin Zinser",
                5,
                4.0,
                1.5,
                "Informationsmanagement"
            ),
            Courses(
                "Projektmanagement - Fallstudie",
                "Werner Fritz",
                5,
                1.0,
                1.0,
                "Informationsmanagement"
            ),
            Courses(
                "Software Engineering Selective",
                "Stefan Krausler - Baumann, Karl Kreiner",
                5,
                5.0,
                3.0,
                "Informationsmanagement"
            ),
            Courses(
                "Operations Management",
                "Robert Singer",
                5,
                5.0,
                3.5,
                "Informationsmanagement"
            ),
            Courses(
                "Freies Wahlfach im Fachbereich \"Information, Design und Technologien\"",
                "-",
                5,
                5.0,
                3.0,
                "Informationsmanagement"
            ),
            Courses(
                "It Business Case",
                "Clemens Wiesinger",
                5,
                5.0,
                3.0,
                "Informationsmanagement"
            ),
            Courses(
                "Application Infrastructure Design",
                "Christopher Schwarz",
                5,
                2.5,
                1.5,
                "Informationsmanagement"
            ),
            Courses(
                "Network Infrastructure Design",
                "gerog Mittenecker",
                5,
                2.5,
                1.5,
                "Informationsmanagement"
            ),
            Courses(
                "SW - Engineering - Mobile and Location based Computing",
                "Gerhard Sprung",
                5,
                5.0,
                3.0,
                "Informationsmanagement"
            ),
            Courses(
                "Media Trends",
                "Robert Gutounig, Thomas Wolkinger",
                5,
                5.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Online Monitoring and Opinion Mining",
                "Gudrun Reimerth",
                5,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Vorbereitendes Seminar zur Bachelorarbeit",
                "Heinz M. Fischer, Eva Goldgruber, Gudrun Reimerth, Heinz Peter Wassermann, Thomas Wolkinger",
                5,
                2.0,
                1.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Englisch: Global Comunication and Negotiations",
                "Dominic Welsh",
                5,
                2.0,
                2.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Medienwirtschaft und unternehmerische Kompetenzen",
                "Tanja Hatzl - Schönbacher",
                5,
                6.0,
                4.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Mobile Reporting",
                "David Kleinl, Thomas Wolkinger",
                5,
                5.0,
                3.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Newsroom: Projekt",
                "Boris Böttinger, Stefan Schmid, Alfred Schwarzenberger, Thomas Wolkinger",
                5,
                8.0,
                4.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Corporate Publishing",
                "Gudrun Reimerth",
                5,
                5.0,
                3.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "PR - Labor: Projekt",
                "Wolfgang Kühnelt",
                5,
                8.0,
                4.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Theorien und Methoden des wissenschaftlichen Arbeitens",
                "Sten Hanke, Robert Rehb",
                5,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Bildgebende Verfahren",
                "Bernhard Neumayer",
                5,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Medizin, Technik und Ethik",
                "Walter Peissl",
                5,
                2.0,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Qualitäts- und Risikomanagement im Gesundheitswesen",
                "Karin Messer - Misak",
                5,
                4.0,
                3.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Biosensoren",
                "Bernhard Neumayer",
                5,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "pHealth - Anwendungen",
                "Carina Seerainer",
                5,
                5.0,
                4.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Einführung in die Gesundheits- und Sozialberufe 2",
                "Andreas Jocham",
                5,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "eHealth - Projekt - DPA",
                "Karin Messer - Misak",
                5,
                9.0,
                4.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "eHealth - Anwendungen",
                "Harald Kornfeil",
                5,
                5.0,
                4.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Hochverfügbare Systeme",
                "Baptiste Alcalde",
                5,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "eHealth - Projekt - HIS",
                "Karin Messer - Misak",
                5,
                9.0,
                4.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Führungs- und Unterstützungsprozesse im Gesundheitswesen",
                "Eva Schwarz",
                5,
                2.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Telekommunikationsanwendungen",
                "Georg Mittenecker",
                6,
                2.5,
                1.5,
                "Informationsmanagement"
            ),
            Courses(
                "Wirtschaftsrecht",
                "Werner Hauser",
                6,
                2.5,
                2.5,
                "Informationsmanagement"
            ),
            Courses(
                "Effective Meetings & Presentations",
                "Gerhild Janser - Munro, Ulrike Pölzl - Hobusch",
                6,
                2.5,
                2.5,
                "Informationsmanagement"
            ),
            Courses(
                "Berufspraktikum",
                "Gerhard Sprung",
                6,
                19.0,
                0.0,
                "Informationsmanagement"
            ),
            Courses(
                "Seminar zum Berufspraktikum",
                "Gerhard Sprung",
                6,
                1.0,
                1.0,
                "Informationsmanagement"
            ),
            Courses(
                "Unternehmensinformationssysteme",
                "Christian Hauptmann, Robert Singer",
                6,
                2.5,
                1.5,
                "Informationsmanagement"
            ),
            Courses(
                "Bachelorarbeit",
                "Boris Böttinger, Heinz M. Fischer",
                6,
                9.0,
                1.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Bachelorprüfung",
                "Heinz M. Fischer",
                6,
                1.0,
                0.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Seminar zur Bachelorarbeit",
                "Boris Böttinger, Heinz M. Fischer, Eva Goldgruber, Tanja Hatzl - Schönbacher, Wolfgang Kühnelt, Edith Podhovnik, Ulrike Pölzl - Hobusch, Gudrun Reimerth, Heinz Peter Wassermann, Thomas Wolkinger",
                6,
                2.0,
                1.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Pflichtpraktikum",
                "Heinz M. Fischer, Thomas Wolkinger",
                6,
                17.0,
                0.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Praktikumsbegleitendes Seminar",
                "Boris Böttinger, Heinz M. Fischer, Eva Goldgruber, Tanja Hatzl - Schönbacher, Wolfgang Kühnelt, Edith Podhovnik, Ulrike Pölzl - Hobusch, Gudrun Reimerth, Heinz Peter Wassermann, Thomas Wolkinger",
                6,
                1.0,
                1.0,
                "Journalismus und Public Relations"
            ),
            Courses(
                "Bachelorprüfung",
                "Baptiste Alcalde, Markus Bödenler, Sten Hanke, Karin Messer - Misak, Robert Mischak, Bernhard Neumayer, Anita Töchterle",
                6,
                1.0,
                0.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "eHealth in der Praxis - Ringvorlesung",
                "Bernhard Neumayer",
                6,
                1.5,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Berufspraktikum 12 Wochen",
                "Rober Rehb, Christoph Reiter, Bianca Schnalzer",
                6,
                15.0,
                2.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Wahlpflichtfach Informatik",
                " - ",
                6,
                2.5,
                0.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Bachelorarbeit - DPA",
                "Baptiste Alcalde, Markus Bödenler, Sten Hanke, Karin Messer - Misak, Robert Mischak, Bernhard Neumayer",
                6,
                9.0,
                1.25,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Seminar zur Bachelorarbeit",
                "Karin Messer - Misak, Robert Mischak",
                6,
                1.0,
                1.0,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Bachelorarbeit - HIS",
                "Baptiste Alcalde, Markus Bödenler, Sten Hanke, Karin Messer - Misak, Robert Mischak, Bernhard Neumayer",
                6,
                9.0,
                1.25,
                "Gesundheitsinformatik"
            ),
            Courses(
                "Seminar zur Bachelorarbeit - HIS",
                "Karin Messer - Misak, Robert Mischak",
                6,
                1.0,
                1.0,
                "Gesundheitsinformatik"
            )
        )
    }
    fun coursesList(): MutableList<Courses>{
        return CoursesRepository.coursesList
    }
}