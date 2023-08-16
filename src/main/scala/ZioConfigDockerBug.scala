//> using scala 3.3
//> using lib "dev.zio::zio:2.0.15"
//> using lib "dev.zio::zio-config:4.0.0-RC16"
//> using lib "dev.zio::zio-config-typesafe:4.0.0-RC16"
//> using lib "dev.zio::zio-config-magnolia:4.0.0-RC16"

import zio.*
import zio.config.*
import zio.config.magnolia.*
import zio.config.typesafe.TypesafeConfigProvider.fromResourcePath

object ZioConfigDockerBug extends ZIOAppDefault:
  override def run =
    printSubconfigValue.provide(AppSetup.configLayer)

  private def printSubconfigValue =
    ZIO.serviceWithZIO[AppConfig](config => Console.printLine(config.subconfig.value))

case class AppConfig(subconfig: Subconfig)
case class Subconfig(value: String)

object AppSetup:
  val configLayer: TaskLayer[AppConfig] = ZLayer {
    read(deriveConfig[AppConfig].from(fromResourcePath()))
  }
    
