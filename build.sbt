val appName = "debt-transoformation-performance-tests"
val appVersion = "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(GatlingPlugin)
  .enablePlugins(SbtAutoBuildPlugin)
  .settings(
    name := appName,
    version := appVersion,
    scalaVersion := "2.12.12",
    //implicitConversions & postfixOps are Gatling recommended -language settings
    scalacOptions ++= Seq("-feature", "-language:implicitConversions", "-language:postfixOps"),
    // Enabling sbt-auto-build plugin provides DefaultBuildSettings with default `testOptions` from `sbt-settings` plugin.
    // These testOptions are not compatible with `sbt gatling:test`. So we have to override testOptions here.
    retrieveManaged := true,
    initialCommands in console := "import uk.gov.hmrc._",
    parallelExecution in Test := false,
    publishArtifact in Test := true,
    testOptions in Test := Seq.empty,
    libraryDependencies ++= Dependencies.test,
    resolvers ++= Seq(Resolver.bintrayRepo("hmrc", "releases"))
  )