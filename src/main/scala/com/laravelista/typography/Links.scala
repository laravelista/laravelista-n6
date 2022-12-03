package com.laravelista.typography

import com.laravelista.Route
import org.http4s.Uri.Path
import scalatags.Text.all.*

import java.net.URL

/** It returns a search engine optimized HTML `a` tag which points to an
  * external URL.
  *
  * @param text
  *   The text which is displayed on the link.
  * @param url
  *   The URL to which the link points to.
  * @param includeRel
  *   By setting this to false the link does not include the SEO optimization.
  *   Useful when the outgoing link points to your own website.
  * @return
  *   It returns a scalatags tag.
  */
def outboundLink(text: String, url: URL, includeRel: Boolean = true) =
  a(
    cls := "underline hover:no-underline dark:hover:text-zinc-200 hover:text-zinc-700 duration-300",
    href := url.toString,
    if includeRel then rel := "nofollow noopener"
    else "",
    target := "_blank",
    text
  )

def link(text: String, path: Path) =
  a(
    cls := "underline hover:no-underline dark:hover:text-zinc-200 hover:text-zinc-700 duration-300",
    href := path.toString,
    text
  )

def routeLink(route: Route) =
  link(route.name, route.url)

def outboundIcon(icon: String, url: URL, iconTitle: String) =
  a(
    cls := "dark:hover:fill-zinc-200 hover:fill-zinc-700 duration-300",
    href := url.toString,
    rel := "nofollow noopener",
    target := "_blank",
    title := iconTitle,
    raw(icon)
  )
