import com.laravelista.pages.ContactMessage
import com.laravelista.mail.aws.v2.{sendContactMessage => sendContactMessageV2}
import com.laravelista.mail.aws.v1.{sendContactMessage => sendContactMessageV1}

val message = ContactMessage(
  full_name = "Mario",
  email_address = "test@example.com",
  subject = com.laravelista.Tag.WebStandard,
  message = "Ovo je test poruka.",
  gdpr_consent = true
) /*>  : ContactMessage = ContactMessage(Mario,test@example.com,#web-standard,Ovo je test poruka.,true)  */

// sendContactMessageV1(message)  /*>  : SendEmailResult = {MessageId: 01020184a090c8c2-f54ba123-6b25-4623-8c82-15af18651e26-00000…  */
// sendContactMessageV2(message)  /*>  : SendEmailResponse = SendEmailResponse(MessageId=01020184a090cc3d-c4cd35f0-0fd8-4198-8933-…  */
