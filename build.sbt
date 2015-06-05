// Grunt plugin specific imports
import org.rbayer.GruntSbtPlugin._
import GruntKeys._

name := """varic"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).settings(
  // Ensure that the very old webjar npm is not run
  JsEngineKeys.npmNodeModules in Assets := Nil,
  JsEngineKeys.npmNodeModules in TestAssets := Nil
)

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "com.github.detro.ghostdriver" % "phantomjsdriver" % "1.0.4" % "test"
)

// Init grunt plugin settings with defaults
gruntSettings

// Heroku deployment
herokuAppName in Compile := "varic"

// Alias for running tests, coverage and style check
addCommandAlias("full-test", ";clean;coverage;test;scalastyle;test:scalastyle")

// scoverage settings

ScoverageSbtPlugin.ScoverageKeys.coverageExcludedPackages := ".*Routes.*;.*Reverse.*"

ScoverageSbtPlugin.ScoverageKeys.coverageMinimum := 70

ScoverageSbtPlugin.ScoverageKeys.coverageFailOnMinimum := true

// scalastyle settings

scalastyleConfig := file("linters/scalastyle/scalastyle-config.xml")

scalastyleFailOnError := true
