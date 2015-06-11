resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"

resolvers += Classpaths.sbtPluginReleases

resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.3.8")

// Needed for heroku

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "0.7.4")

addSbtPlugin("com.heroku" % "sbt-heroku" % "0.4.1")

// scoverage for code coverage
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.2.0")

// scalastyle for scala style checking
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.7.0")
