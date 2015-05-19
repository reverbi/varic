name := """varic"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws,
  "org.webjars" % "bootstrap" % "3.3.1",
  "org.webjars" % "angularjs" % "1.3.15",
  "org.webjars" % "angular-ui-bootstrap" % "0.12.0",
  "com.github.detro.ghostdriver" % "phantomjsdriver" % "1.0.4" % "test"
)

// coffeelint

lazy val coffeelint = taskKey[Unit]("CoffeeLint")

coffeelint := {
  val sourceDir = (sourceDirectory in Assets).value
  val result = Seq("coffeelint", sourceDir.getAbsolutePath).!
  if (result != 0) {
    throw new Exception("coffeelint detected errors")
  }
}

// Alias for running tests, coverage and style check
addCommandAlias("full-test", ";clean;coverage;test;scalastyle;test:scalastyle;coffeelint")

// scoverage settings

ScoverageSbtPlugin.ScoverageKeys.coverageExcludedPackages := "<empty>;.*Reverse.*;views.*"

ScoverageSbtPlugin.ScoverageKeys.coverageMinimum := 70

ScoverageSbtPlugin.ScoverageKeys.coverageFailOnMinimum := true

ScoverageSbtPlugin.ScoverageKeys.coverageHighlighting := false

// scalastyle settings

scalastyleConfig := file("linters/scalastyle/scalastyle-config.xml")

scalastyleFailOnError := true
