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
  Resolver.typesafeRepo("releases")
)

resolvers += "HMRC-open-artefacts-maven" at "https://open.artefacts.tax.service.gov.uk/maven2"
resolvers += Resolver.url("HMRC-open-artefacts-ivy", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(Resolver.ivyStylePatterns)

libraryDependencies ++= Seq(
  "com.typesafe.play"      %% "play-ahc-ws-standalone"    % "1.1.7",
  "com.github.nscala-time" %% "nscala-time"               % "2.22.0",
  "io.gatling"              % "gatling-test-framework"    % gatlingDependencies,
  "io.gatling.highcharts"   % "gatling-charts-highcharts" % gatlingDependencies,
  "com.typesafe"            % "config"                    % "1.4.0",
  "uk.gov.hmrc"            %% "performance-test-runner"   % "4.6.0",
  "uk.gov.hmrc"             %% "simple-reactivemongo"    % "8.0.0-play-28",
  "com.github.mifmif"       % "generex"                   % "1.0.2",
  "com.typesafe.akka"      %% "akka-stream"               % "2.6.8" % "test",
  "org.scalaj"             %% "scalaj-http"               % "2.4.2",
  "io.circe"               %% "circe-core"                % "0.11.2",
  "io.circe"               %% "circe-generic"             % "0.11.2",
  "io.circe"               %% "circe-parser"              % "0.11.2"
)

retrieveManaged := true
initialCommands in console := "import uk.gov.hmrc._"
parallelExecution in Test := false
publishArtifact in Test := true
