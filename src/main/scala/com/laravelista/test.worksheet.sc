import org.scalactic.*
import com.laravelista.validation.ValidationError

val test = Many(
  ValidationError("name", "Ime nije ispravno"),
  ValidationError("email", "Email nije ispravan")
) /*>  : Many[ValidationErr…  */
val test1 = One(
  ValidationError("name", "Ime nije ispravno")
) /*>  : One[ValidationError] = One(ValidationError(name,Ime nije …  */
val test2 = Every(
  Good("super"),
  Bad(One(ValidationError("email", "email nije ispravan.")))
)

test2 match
  case Good(good)  => good
  case Bad(errors) => errors.first.inputName

test.head.inputName /*>  : String = name  */

test1.head.inputName /*>  : String = name  */
