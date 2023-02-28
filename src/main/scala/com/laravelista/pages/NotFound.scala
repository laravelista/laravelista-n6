package com.laravelista.pages

import scalatags.Text.all.*
import scalatags.Text.tags2.{abbr, address}
import com.laravelista.{Route, references, Config, appName}
import com.laravelista.layouts.defaultLayout
import com.laravelista.partials.renderReferences
import com.laravelista.typography as typo

import java.net.URL

val notFoundPageContent = Seq(
  typo.page(
    Seq(
      typo.pageTitle("Page not found"),
      typo.pageSubtitle(
        "Error code: HTTP-404"
      ),
      typo.pageBox(
        Seq(
          typo.pageParagraph(
            "The page you are looking for, could not be found."
          ),
          typo.pageParagraph(
            Seq(
              a(
                cls := s"${ctaButtonClasses} ${CtaButtonSize.Medium.classes} mt-2",
                href := Route.Home.url.toString,
                "Back to home page"
              )
            )
          )
        )
      )
    )
  )
)

def notFoundPage =
  defaultLayout(
    notFoundPageContent,
    activeRoute = None,
    metaTitle = "Page not found"
  )
