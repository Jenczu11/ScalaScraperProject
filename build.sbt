name := "ScalaScraper"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"

// Scala test
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.5" % "test"

// Scala-scraper
// https://github.com/ruippeixotog/scala-scraper
libraryDependencies += "net.ruippeixotog" %% "scala-scraper" % "2.2.0"

// Parsing JSON
libraryDependencies += "io.circe" %% "circe-parser" % "0.14.0-M5"

// I18n
libraryDependencies += "com.osinka.i18n" %% "scala-i18n" % "1.0.3"