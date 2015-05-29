name := """varic"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala).settings(
  // Ensure that the very old webjar npm is not run
  JsEngineKeys.npmNodeModules in Assets := Nil,
  JsEngineKeys.npmNodeModules in TestAssets := Nil
)

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

// Heroku deployment
herokuAppName in Compile := "varic"

// Alias for running tests, coverage and style check
addCommandAlias("full-test", ";clean;coverage;test;scalastyle;test:scalastyle")

// scoverage settings

ScoverageSbtPlugin.ScoverageKeys.coverageExcludedPackages := "<empty>;.*Reverse.*;views.*"

ScoverageSbtPlugin.ScoverageKeys.coverageMinimum := 70

ScoverageSbtPlugin.ScoverageKeys.coverageFailOnMinimum := true

ScoverageSbtPlugin.ScoverageKeys.coverageHighlighting := false

// scalastyle settings

scalastyleConfig := file("linters/scalastyle/scalastyle-config.xml")

scalastyleFailOnError := true
