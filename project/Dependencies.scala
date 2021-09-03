import sbt._

object Dependencies {

  private val gatlingVersion = "3.4.2"

  val test = Seq(
    "com.typesafe" % "config" % "1.4.1" % Test,
    "uk.gov.hmrc" %% "performance-test-runner" % "4.11.0" % Test,
    "io.gatling" % "gatling-test-framework" % gatlingVersion % Test,
    "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion % Test,
    "io.circe" %% "circe-core" % "0.11.2" % Test,
    "io.circe" %% "circe-generic" % "0.11.2" % Test,
    "io.circe" %% "circe-parser" % "0.11.2" % Test,
    "com.typesafe.play"      %% "play-ahc-ws-standalone"    % "1.1.7",
    "com.github.nscala-time" %% "nscala-time"               % "2.22.0",
    "io.gatling"              % "gatling-test-framework"    % gatlingVersion,
    "io.gatling.highcharts"   % "gatling-charts-highcharts" % gatlingVersion,
    "com.typesafe"            % "config"                    % "1.4.0",
    "uk.gov.hmrc"            %% "performance-test-runner"   % "4.6.0",
    "com.github.mifmif"       % "generex"                   % "1.0.2",
    "com.typesafe.akka"      %% "akka-stream"               % "2.6.8" % "test",
    "org.scalaj"             %% "scalaj-http"               % "2.4.2"
  )
}