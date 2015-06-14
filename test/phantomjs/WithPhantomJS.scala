package com.github.reverbi.test.phantomjs

import play.api.test._

import scala.collection.JavaConverters._

import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.phantomjs.PhantomJSDriverService

/**
 * Used to run specs using PhantomJS as a web browser
 *
 * @param phantomJSCLIArgs phantomjs cli args to be passed to the driver
 */
class WithPhantomJS(val phantomJSCLIArgs: List[String]) extends WithBrowser {
  override lazy val browser: TestBrowser = {
    val capabilities = DesiredCapabilities.phantomjs
    capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJSCLIArgs.asJava)
    val driver = new PhantomJSDriver(capabilities)
    TestBrowser(driver, Some("http://localhost:" + port))
  }
}
