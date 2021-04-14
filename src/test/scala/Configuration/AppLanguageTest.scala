package Configuration

import com.osinka.i18n.{Lang,Messages}
import org.scalatest.GivenWhenThen
import org.scalatest.funsuite.AnyFunSuite

class AppLanguageTest extends AnyFunSuite with GivenWhenThen {

  test("User Lang (en-i18n)") {
    Given("English user language")
    implicit val userLang: Lang = Lang("en")

    When("Called AskForChoice string")
    val testmessage = Messages("test.testMessage")

    Then("Should return: Your Choice")
    val result = "Test message"
    assertResult(testmessage, "Should return 'Test message'")(result)
  }

  test("User Lang (pl-i18n)") {
    Given("Polish user language")
    implicit val userLang: Lang = Lang("pl")

    When("Called AskForChoice string")
    val testmessage = Messages("test.testMessage")

    Then("Should return: Wiadomość testowa")
    val result = "Wiadomość testowa"
    assertResult(testmessage, "Should return 'Wiadomość testowa'")(result)
  }

  test("No string found") {
    Given("English user language.")
    implicit val userLang: Lang = Lang("en")

    When("Called nonexisting string.")
    Then("Should throw: MissingResourceException.")
    withClue("Non existing string should throw this one.") {
      assertThrows[java.util.MissingResourceException] {
        val testmessage = Messages("test.thisstringshouldnotexist.txt")
      }
    }
  }

}
