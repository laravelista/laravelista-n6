package com.laravelista.pages

import scalatags.Text.all.*
import scalatags.Text.tags2.{abbr, address}
import com.laravelista.{Route, references, Config, appName}
import com.laravelista.layouts.defaultLayout
import com.laravelista.partials.renderReferences
import com.laravelista.typography as typo

import java.net.URL

val privacyNoticePageContent = Seq(
  typo.page(
    Seq(
      typo.pageTitle("Privacy notice"),
      typo.pageSubtitle(
        "This notice obligates me to protect user privacy and personal data provided via this website."
      ),
      typo.pageBox(
        Seq(
          typo.pageParagraph(
            "This notice provides information about the types of information I may collect from you when you visit my website and explains how I use such data, as well as describes the steps I take in order to protect them. The notice also describes the options you have with regard to the collection and use of your data when you visit my website."
          ),
          typo.pageHeading("Forms"),
          typo.pageParagraph(
            Seq(
              "The data provided through my contact form (name, e-mail address, subject, message, consent) will be stored in my inbox for an indefinite period of time for the purposes of future analysis and contact. If you want me to delete your email from my inbox send me an email at ",
              typo.outboundLink(
                text = Config.emailAddress,
                url = URL(s"mailto:${Config.emailAddress}"),
                includeRel = false
              ),
              "."
            )
          ),
          typo.pageHeading("Analytics"),
          typo.pageParagraph(
            Seq(
              "I use a self-hosted version of ",
              typo.outboundLink(
                url = URL("https://plausible.io/"),
                text = "Plausible"
              ),
              " for the purpose of collecting and analyzing website visit frequency. It is an open source web analytics software, built in the EU, with no cookies, no tracking and no personal data collection. ",
              typo.outboundLink(
                url = URL("https://plausible.laravelista.com/laravelista.com"),
                text = "Stats are open to the public."
              )
            )
          ),
          typo.pageHeading("Cookies"),
          typo.pageParagraph("This website does not use cookies."),
          typo.pageHeading("Contact"),
          address(
            cls := "my-3",
            b("Mario Bašić"),
            ", ",
            appName,
            br(),
            "Markov Jose 1",
            br(),
            "Murter, HR 22243",
            br(),
            abbr(title := "E-mail", "E:"),
            " ",
            typo.outboundLink(
              text = Config.emailAddress,
              url = URL(s"mailto:${Config.emailAddress}"),
              includeRel = false
            ),
            br(),
            abbr(title := "Web", "W:"),
            " ",
            typo.outboundLink(
              url = URL("https://mariobasic.com"),
              text = "mariobasic.com",
              includeRel = false
            )
          )
        )
      )
    )
  )
)

def privacyNoticePage =
  defaultLayout(
    privacyNoticePageContent,
    activeRoute = Route.PrivacyNotice,
    metaTitle = "Privacy notice"
  )
