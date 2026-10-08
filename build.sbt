ThisBuild / scalaVersion := "3.8.4"
ThisBuild / version := "0.1.0-SNAPSHOT"

lazy val root = project
  .in(file("."))
  .aggregate(`circe-json`)
  .settings(publish / skip := true)

lazy val `circe-json` = project
  .in(file("modules/circe-json"))
  .settings(
    publish / skip := true,
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core" % Versions.circe,
      "org.scalameta" %% "munit" % Versions.munit % Test,
      "org.typelevel" %% "discipline-munit" % Versions.disciplineMunit % Test,
      "io.circe" %% "circe-golden" % Versions.circeGolden % Test
    ),
    Test / classLoaderLayeringStrategy := ClassLoaderLayeringStrategy.Flat,
    Test / fork := true,
    Test / javaOptions +=
      s"-Dexample.resourceDirectory=${(Test / resourceDirectory).value.getAbsolutePath}"
  )
