package com.laravelista.pages

import scalatags.Text.all.*

import com.laravelista.{Route, references}
import com.laravelista.layouts.defaultLayout
import com.laravelista.partials.renderReferences

val referencesPageContent = Seq(
  renderReferences(
    references
      .sortBy(_.name)
      .reverse
      .sortBy(_.yearMade)
      .reverse,
    "Portfolio",
    headingTag = h1
  )
)

def referencesPage =
  defaultLayout(
    referencesPageContent,
    activeRoute = Some(Route.References),
    metaTitle = "Portfolio"
  )
