name := "debt-transformation-performance-tests"
version := "0.1"

enablePlugins(GatlingPlugin)
enablePlugins(CorePlugin)
enablePlugins(JvmPlugin)
enablePlugins(IvyPlugin)

organization := "uk.gov.hmrc"

organization := "uk.gov.hmrc"
scalaVersion := "3.3.7"
val scalaOptionSettings = Seq("-no-indent", "-Yretain-trees", "-Xfatal-warnings", "-source:future-migration","-feature", "-language:postfixOps")
Test / testOptions := Seq.empty

scalacOptions ++=scalaOptionSettings

resolvers ++= Seq(Resolver.typesafeRepo("releases"))

libraryDependencies ++= Dependencies.test
dependencyOverrides ++= Dependencies.dependencyOverrides

retrieveManaged := true
Compile / console / initialCommands := "import uk.gov.hmrc.*"
Test / parallelExecution := false
Test / publishArtifact := true

