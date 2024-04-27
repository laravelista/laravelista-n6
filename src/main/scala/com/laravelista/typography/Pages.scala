package com.laravelista.typography

import scalatags.Text.all.*

def page(children: Seq[ConcreteHtmlTag[String]]) =
  div(
    cls := "my-10 flex flex-col",
    children
  )

def pageBox(children: Seq[ConcreteHtmlTag[String]]) =
  div(
    cls := "box relative w-full p-12 bg-zinc-100 dark:bg-zinc-900 text-zinc-700 dark:text-zinc-100 mb-10 mt-10 rounded-lg hover:before:opacity-100 duration-300",
    children
  )

def pageTitle(text: String) =
  h1(
    cls := "text-xl md:text-2xl uppercase font-extrabold text-zinc-700 dark:text-zinc-100 mb-2",
    text
  )

def pageHeading(text: String, tag: ConcreteHtmlTag[String] = h2) =
  tag(
    cls := "text-xl md:text-xl uppercase font-extrabold text-zinc-700 dark:text-zinc-100 mt-5",
    text
  )

def pageSubtitle(text: String) =
  p(
    cls := "mb-3.5",
    text
  )

def pageParagraph(elements: String | Seq[Modifier]) =
  p(
    cls := "my-3",
    elements match
      case text: String            => text
      case elements: Seq[Modifier] => for element <- elements yield element
  )
