package com.laravelista.pages

import scalatags.Text.all.*
import scalatags.Text.tags2.{abbr, address}
import com.laravelista.{Route, references, Config}
import com.laravelista.layouts.defaultLayout
import com.laravelista.partials.renderReferences
import com.laravelista.typography as typo
import com.laravelista.validation.{Email, ValidationError}
import org.http4s.UrlForm
import org.scalactic.*
import scala.util.Try
import software.amazon.awssdk.services.sesv2.model.SendEmailResponse
import scala.util.Success
import scala.util.Failure

case class Subject(
    id: String,
    text: String
)

case class ContactMessage(
    full_name: String,
    email_address: Email,
    subject: com.laravelista.Tag,
    message: String,
    gdpr_consent: Boolean
)

def itemToSubject(item: Item) =
  Subject(text = item.name, id = item.tag.tag)

val productSubjects = products.map(itemToSubject)
val serviceSubjects = services.map(itemToSubject)

val subjects = (productSubjects ++ serviceSubjects).sortBy(_.text)

val requiredMark = span(cls := "text-red-500", "*")

def displayError(
    inputName: String,
    maybeErrors: Option[Every[ValidationError]]
): Modifier =
  maybeErrors match
    case Some(errors) =>
      errors.find(error => error.inputName == inputName) match
        case Some(error) =>
          div(
            cls := "text-sm font-bold text-red-500 mt-2",
            error.message
          )
        case None => ""
    case None => ""

def old(fieldName: String, oldData: UrlForm): Modifier =
  if oldData.values.contains(fieldName) then
    value := oldData.getFirstOrElse(fieldName, "")
  else ""

def getSubject(
    oldData: UrlForm,
    subjectId: String,
    querySubject: Option[com.laravelista.Tag]
): Modifier =
  querySubject match
    case None =>
      if oldData.values.contains("subject") && subjectId == oldData
          .getFirstOrElse("subject", "")
      then selected := true
      else ""
    case Some(tag) =>
      if subjectId == tag.tag then selected := true
      else ""

val respondSuccess =
  Seq(
    typo.pageTitle("Success 💌"),
    typo.pageSubtitle("Thank you for contacting us"),
    typo.pageParagraph(
      "We have received your message and will respond as soon as possible."
    )
  )

def messageReceivedPageContent(
    maybeEmailResponse: Option[Try[SendEmailResponse]]
) = Seq(
  typo.page(
    maybeEmailResponse match
      case Some(emailResponse) =>
        emailResponse match
          case Success(_) =>
            respondSuccess
          case Failure(exception) =>
            Seq(
              typo.pageTitle("Error 🐞"),
              typo.pageSubtitle("An error occured while sending the message."),
              typo.pageParagraph(exception.getMessage())
            )
      case None => respondSuccess
  )
)

def contactPageContent(
    oldData: UrlForm,
    errors: Option[Every[ValidationError]],
    querySubject: Option[com.laravelista.Tag]
) = Seq(
  typo.page(
    Seq(
      typo.pageTitle("Contact me"),
      typo.pageSubtitle(
        "Send me a message if you are interested in any of mine products or services."
      ),
      typo.pageBox(
        Seq(
          typo.pageParagraph(
            Seq(
              "Fields marked with ",
              requiredMark,
              " are required."
            )
          ),
          form(
            method := "POST",
            cls := "mt-4",
            action := Route.Contact.url.toString,
            div(
              cls := "mb-5",
              label(
                cls := "text-sm font-bold",
                `for` := "name",
                "Full name",
                requiredMark
              ),
              input(
                id := "name",
                `type` := "text",
                name := "full_name",
                placeholder := "Enter your full name",
                cls := "bg-white/30 dark:bg-black/20 rounded-sm mt-1 w-full block p-2",
                autocomplete := "name",
                old("full_name", oldData)
              ),
              displayError("full_name", errors)
            ),
            div(
              cls := "mb-5 hidden",
              label(
                cls := "text-sm font-bold",
                `for` := "name",
                "First name",
                requiredMark
              ),
              input(
                id := "first_name",
                `type` := "text",
                name := "first_name",
                placeholder := "Enter your first name",
                cls := "bg-white/30 dark:bg-black/20 rounded-sm mt-1 w-full block p-2",
                autocomplete := "off"
              )
            ),
            div(
              cls := "mb-5",
              label(
                cls := "text-sm font-bold",
                `for` := "email",
                "Email address",
                requiredMark
              ),
              input(
                id := "email",
                `type` := "email",
                name := "email_address",
                autocomplete := "email",
                placeholder := "Enter your email address",
                cls := "bg-white/30 dark:bg-black/20 rounded-sm mt-1 w-full block p-2",
                old("email_address", oldData)
              ),
              displayError("email_address", errors)
            ),
            div(
              cls := "mb-5",
              label(
                cls := "text-sm font-bold",
                `for` := "subject",
                "Subject",
                requiredMark
              ),
              select(
                id := "subject",
                name := "subject",
                cls := "bg-white/30 dark:bg-black/20 text-black dark:text-white rounded-sm mt-1 w-full block p-2",
                option(
                  value := "",
                  "Choose message subject",
                  disabled,
                  selected,
                  hidden
                ),
                for subject <- subjects
                yield option(
                  value := subject.id,
                  subject.text,
                  getSubject(oldData, subject.id, querySubject)
                )
              ),
              displayError("subject", errors)
            ),
            div(
              cls := "mb-5",
              label(
                cls := "text-sm font-bold",
                `for` := "message",
                "Message",
                requiredMark
              ),
              textarea(
                id := "message",
                name := "message",
                placeholder := "Enter your message",
                cls := "bg-white/30 dark:bg-black/20 rounded-sm mt-1 w-full block p-2 h-52",
                if oldData.values.contains("message") then
                  oldData.getFirstOrElse("message", "")
                else ""
              ),
              displayError("message", errors)
            ),
            div(
              cls := "mb-5",
              input(
                id := "gdpr_consent",
                `type` := "checkbox",
                name := "gdpr_consent",
                value := "on",
                cls := "mr-3",
                if oldData.values.contains("gdpr_consent") && oldData
                    .getFirstOrElse("gdpr_consent", "") == "on"
                then checked := true
                else ""
              ),
              label(
                `for` := "gdpr_consent",
                "I have read the ",
                typo.routeLink(Route.PrivacyNotice),
                " and I give my consent to be contacted in regard to this form."
              ),
              displayError("gdpr_consent", errors)
            ),
            button(
              `type` := "submit",
              cls := s"${ctaButtonClasses} ${CtaButtonSize.Medium.classes}",
              "Send message"
            )
          )
        )
      )
    )
  )
)

def contactPage(
    oldData: UrlForm = UrlForm(),
    errors: Option[Every[ValidationError]] = None,
    querySubject: Option[com.laravelista.Tag] = None
) =
  defaultLayout(
    contactPageContent(oldData, errors, querySubject),
    activeRoute = Route.Contact,
    metaTitle = "Contact"
  )

def messageReceivedPage(emailResponse: Option[Try[SendEmailResponse]] = None) =
  defaultLayout(
    messageReceivedPageContent(emailResponse),
    activeRoute = Route.Contact,
    metaTitle = "Contact"
  )
