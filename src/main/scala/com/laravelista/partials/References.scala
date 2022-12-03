package com.laravelista.partials

import com.laravelista.{Route, Reference, Tag}
import scalatags.Text.all.*
import java.net.URL
import com.laravelista.{typography => typo}

def renderReferences(
    references: List[Reference],
    heading: String,
    headingTag: ConcreteHtmlTag[String] = h2,
    isFeatured: Boolean = false
) =
  def tag(tag: Tag) =
    span(
      cls := "ml-auto w-32 relative font-normal md:hidden text-xs",
      tag.toString
    )

  def externalWebsiteLink(url: URL) =
    a(
      cls := "py-2 px-4 font-medium bg-black text-white rounded-sm inline-block",
      href := url.toString,
      target := "_blank",
      rel := "nofollow noopener",
      "View"
    )

  def itemHeading(reference: Reference) =
    div(
      a(
        href := Reference.getUrl(reference).toString,
        rel := "noopener nofollow",
        target := "_blank",
        reference.name
      ),
      br(),
      tag(reference.tag)
    )

  def itemTag(tag: Tag) =
    div(
      cls := "ml-auto w-32 relative font-normal hidden lg:inline text-sm",
      tag.toString
    )

  def itemActions(url: URL) =
    div(
      cls := "flex items-center justify-end ml-auto w-44",
      externalWebsiteLink(url)
    )

  div(
    cls := (if isFeatured then "my-24 flex flex-col"
            else "my-10 flex flex-col"),
    div(
      cls := "flex justify-between",
      headingTag(
        cls := "text-xl md:text-2xl uppercase font-extrabold text-zinc-700 dark:text-zinc-100 mb-2",
        heading
      ),
      if isFeatured then
        div(
          cls := "mb-2 mt-0.5",
          typo.link("View all", Route.References.url)
        )
      else ""
    ),
    p(
      cls := "mb-3.5",
      (if isFeatured then
         "These are some of the projects that I am most proud of"
       else "Here are all the projects that I have done and can talk about.")
    ),
    div(
      cls := "grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 w-full mt-10 gap-12",
      for reference <- references
      yield div(
        cls := "p-12 z-10 bg-zinc-100 dark:bg-zinc-900 box box-sm relative hover:scale-[1.01] duration-300 rounded-lg hover:before:opacity-100",
        div(
          cls := "flex",
          reference.tag.getSvg,
          div(
            h3(
              cls := "text-lg",
              reference.url match
                case Some(url) => typo.outboundLink(reference.name, url)
                case None      => reference.name
            ),
            div(
              cls := "text-xs",
              reference.tag.toString
            )
          )
        ),
        p(
          cls := "mt-5 pb-5",
          reference.description
        )
      )
    )
  )
