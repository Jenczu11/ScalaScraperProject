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