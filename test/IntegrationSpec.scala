package com.github.reverbi.test

import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._

import org.openqa.selenium.phantomjs.PhantomJSDriver

import com.github.reverbi.test.phantomjs.WithPhantomJS

/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
@RunWith(classOf[JUnitRunner])
class IntegrationSpec extends Specification {
  // Suppress INFO level logs from PhantomJS binary
  val phantomJSCLIArgs = List("--webdriver-loglevel=WARN")

  "Application" should {

    "work from within a browser" in new WithPhantomJS(phantomJSCLIArgs) {

      browser.goTo("http://localhost:" + port)

      browser.pageSource must contain("Testing 123.")
    }
  }
}
