name := "debt-transformation-performance-tests"

version := "0.1"

enablePlugins(GatlingPlugin)
enablePlugins(CorePlugin)
enablePlugins(JvmPlugin)
enablePlugins(IvyPlugin)

organization := "uk.gov.hmrc"

organization := "uk.gov.hmrc"
scalaVersion := "2.13.12"
Test / testOptions := Seq.empty

scalacOptions ++= Seq(
  "-feature",
  "-language:implicitConversions",
  "-language:postfixOps"
)

resolvers ++= Seq(Resolver.typesafeRepo("releases"))

libraryDependencies ++= Dependencies.test
dependencyOverrides ++= Dependencies.dependencyOverrides

retrieveManaged := true
initialCommands in console := "import uk.gov.hmrc._"
parallelExecution in Test := false
publishArtifact in Test := true

