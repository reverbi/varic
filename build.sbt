name := """varic"""

version := "1.0-SNAPSHOT"

organization := "com.github.reverbi"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.2"

javaOptions ++= Seq(
  "-Djava.util.logging.config.file=conf/javalog.properties"
)

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "com.github.detro.ghostdriver" % "phantomjsdriver" % "1.0.4" % "test"
)

lazy val npmInstall = taskKey[Unit]("Installs dependencies with npm.")
lazy val grunt = taskKey[Unit]("Runs grunt.")

// Custom task bodies
// TODO: Make them DRY

npmInstall := {
  val command = "npm install --silent"
  val log = streams.value.log
  log.info(s"Running '$command'")
  if (command.! != 0) sys.error(s"Command '$command' returned a non-zero value")
}

grunt in Compile := {
  val command = "grunt build"
  val log = streams.value.log
  log.info(s"Running '$command'")
  if (command.! != 0) sys.error(s"Command '$command' returned a non-zero value")
}

grunt in Test := {
  val command = "grunt test"
  val log = streams.value.log
  log.info(s"Running '$command'")
  if (command.! != 0) sys.error(s"Command '$command' returned a non-zero value")
}

// Integration tests will fail because of missing javascripts
// if we don't ensure that 'grunt build' is run before tests
test in Test <<= test.in(Test).dependsOn(grunt.in(Compile))

// Ensure grunt has built the javascripts before running the app
run in Compile <<= run.in(Compile).dependsOn(grunt.in(Compile))

// Suppress the filth that compile and coverage tasks output
logLevel in compile := Level.Warn

// Suppress the unnecessary log polluting 'success' messages
showSuccess := false

// Heroku deployment
herokuAppName in Compile := "varic"

// Alias for running tests, coverage and style check
addCommandAlias("fullTest", ";clean;npmInstall;scalastyle;test:scalastyle;coverage;test;coverageOff;test:grunt")

// scoverage settings

ScoverageSbtPlugin.ScoverageKeys.coverageExcludedPackages := ".*Routes.*;.*Reverse.*"

ScoverageSbtPlugin.ScoverageKeys.coverageOutputCobertua := false

ScoverageSbtPlugin.ScoverageKeys.coverageOutputXML := false

ScoverageSbtPlugin.ScoverageKeys.coverageMinimum := 70

ScoverageSbtPlugin.ScoverageKeys.coverageFailOnMinimum := true

// scalastyle settings

scalastyleConfig := file("linters/scalastyle/scalastyle-config.xml")

scalastyleFailOnError := true
