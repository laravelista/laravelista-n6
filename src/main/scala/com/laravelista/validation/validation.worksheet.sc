import com.laravelista.validation.*
import scala.util.{Success, Failure}
import org.http4s.UrlForm

val error = validateString(
  Some(""),
  "full_name"
) /*>  : Try[Boolean] = Failure(com.laravelista.validation.EmptyString: Polje fu…  */

// val response = error match
//   case Failure(error2) => error2.getMessage()
//   case _ => ""

validateString(
  Some("ajme"),
  "full_name"
) /*>  : Try[Boolean] = Success(true)  */
val test =
  validateString(
    _,
    "full_name"
  ) /*>  : Function1[Option[String], Try[Boolean]] = repl.MdocSession$MdocApp$$Lambda$78…  */

validateEmail(
  Some("test@test.com"),
  "email_address"
) /*>  : Try[Boolean] = Success(true)  */
validateEmail(
  Some("test@test."),
  "email_address"
) /*>  : Try[Boolean] = Failure(com.laravelista.validation.InvalidEmail: Polje …  */

validateTag(
  Some("directory-listing"),
  "subject"
) /*>  : Try[Boolean] = Success(true)  */
validateTag(
  Some("directorylisting"),
  "subject"
) /*>  : Try[Boolean] = Failure(com.laravelista.validation.InvalidTag: Polje subj…  */

validateConsent(Some("on"), "something") /*>  : Try[Boolean] = Success(true)  */
validateConsent(
  Some("off"),
  "something"
) /*>  : Try[Boolean] = Failure(com.laravelista.validation.NoConsent: Polje something mo…  */

val data = UrlForm(
  "full_name" -> "Mario",
  "email_address" -> "test@test.com",
  "gdpr_consent" -> "on",
  "subject" -> "web-shop",
  "message" -> "Neka poruka."
) /*>  : UrlForm = HashMap(email_address -> Chain(test@test.com), full_name -> Chain(Mario), message -> Chain(Neka poruka.), s…  */

// validate(contactMessageValidationRules, data)  /*>  : ValidationStatus = ValidationStatus(true,HashMap(email_address -> test@te…  */

val invalidData = UrlForm(
  "full_name" -> "Mario",
  "email_address" -> "test@test.",
  "gdpr_consent" -> "",
  "subject" -> "web-shop2"
) /*>  : UrlForm = Map(full_name -> Chain(Mario), email_address -> Chain(test@test.), gdpr_consent -> Chain(), subject -> Chai…  */

// validate(contactMessageValidationRules, invalidData)  /*>  : ValidationStatus = ValidationStatus(false,HashMap(full_name -> Mar…  */
