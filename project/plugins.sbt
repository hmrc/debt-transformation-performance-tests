
resolvers += "HMRC-open-artefacts-maven" at "https://open.artefacts.tax.service.gov.uk/maven2"
resolvers += Resolver.url("HMRC-open-artefacts-ivy", url("https://open.artefacts.tax.service.gov.uk/ivy2"))(Resolver.ivyStylePatterns)
resolvers += Resolver.url("gatling", url("https://search.maven.org/artifact/io.gatling/gatling-sbt"))(Resolver.ivyStylePatterns)

addSbtPlugin("io.gatling"    % "gatling-sbt"  % "3.2.2")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")
