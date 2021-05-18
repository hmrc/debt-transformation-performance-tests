
resolvers += Resolver.url("hmrc-sbt-plugin-releases", url("https://https://dl.bintray.com/gatling/sbt-plugins"))(Resolver.ivyStylePatterns)
resolvers += Resolver.url("gatling", url("https://search.maven.org/artifact/io.gatling/gatling-sbt"))(Resolver.ivyStylePatterns)

addSbtPlugin("io.gatling"    % "gatling-sbt"  % "3.2.2")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")
