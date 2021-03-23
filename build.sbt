name := "debt-transformation-performance-tests"

version := "0.1"

enablePlugins(GatlingPlugin)
enablePlugins(CorePlugin)
enablePlugins(JvmPlugin)
enablePlugins(IvyPlugin)

organization := "uk.gov.hmrc"

val gatlingDependencies = "3.4.2"
scalacOptions ++= Seq(
    "-unchecked",
    "-deprecation",
    "-Xlint",
    "-language:_",
    "-target:jvm-1.8",
    "-Xmax-classfile-name",
    "100",
    "-encoding",
    "UTF-8"
)

resolvers ++= Seq(
    Resolver.bintrayRepo("hmrc", "releases"),
    Resolver.typesafeRepo("releases")
)
libraryDependencies ++= Seq(
    "com.github.nscala-time" %% "nscala-time"              % "2.22.0",
    "io.gatling"             % "gatling-test-framework"    % gatlingDependencies,
    "io.gatling.highcharts"  % "gatling-charts-highcharts" % gatlingDependencies,
    "com.typesafe"           % "config"                    % "1.4.0",
    "uk.gov.hmrc"            %% "performance-test-runner"  % "4.6.0",
    "com.github.mifmif"      % "generex"                   % "1.0.2",
    "org.scalaj"             %% "scalaj-http"              % "2.4.2",
    "io.circe" %% "circe-core"% "0.11.2",
    "io.circe" %% "circe-generic" % "0.11.2",
    "io.circe" %% "circe-parser" % "0.11.2"
)

retrieveManaged := true
initialCommands in console := "import uk.gov.hmrc._"
parallelExecution in Test := false
publishArtifact in Test := true