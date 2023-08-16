scalaVersion := "3.3.0"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.0.15" ,
  "dev.zio" %% "zio-config" % "4.0.0-RC16" ,
  "dev.zio" %% "zio-config-typesafe" % "4.0.0-RC16" ,
  "dev.zio" %% "zio-config-magnolia" % "4.0.0-RC16" 
)

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.0.15" % Test,
  "dev.zio" %% "zio-config" % "4.0.0-RC16" % Test,
  "dev.zio" %% "zio-config-typesafe" % "4.0.0-RC16" % Test,
  "dev.zio" %% "zio-config-magnolia" % "4.0.0-RC16" % Test
)

enablePlugins(JavaAppPackaging)

