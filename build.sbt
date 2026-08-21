name := "debt-transformation-performance-tests"

version := "0.1"

enablePlugins(GatlingPlugin)
enablePlugins(CorePlugin)
enablePlugins(JvmPlugin)
enablePlugins(IvyPlugin)

organization := "uk.gov.hmrc"

organization := "uk.gov.hmrc"
scalaVersion := "2.13.18"
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
console / initialCommands := "import uk.gov.hmrc._"
Test / parallelExecution := false
Test / publishArtifact := true

