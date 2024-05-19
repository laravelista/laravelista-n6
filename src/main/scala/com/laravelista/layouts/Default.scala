package com.laravelista.layouts

import org.http4s.dsl.io.Root
import scalatags.Text.all.*
import scalatags.Text.tags2.title
import scalatags.Text.svgTags.{
  circle,
  defs,
  g,
  linearGradient,
  path,
  rect,
  stop,
  svg
}
import scalatags.Text.svgAttrs.{
  cx,
  cy,
  d,
  fill,
  gradientTransform,
  gradientUnits,
  offset,
  r,
  stroke,
  strokeLinecap,
  strokeLinejoin,
  strokeWidth,
  transform,
  viewBox,
  x,
  x1,
  x2,
  y,
  y1,
  y2,
  preserveAspectRatio
}
import com.laravelista.{Route, svgs, Config, appName}
import org.http4s.Uri.Path
import com.laravelista.{typography => typo}

import java.net.URL
import java.net.URI
import java.time.Year

val logo =
  div(
    cls := "ml-1",
    a(
      cls := "flex gap-2 items-center",
      href := Route.Home.url.toString,
      aria.label := "Go to home page",
      raw(svgs.laravelistaLogo),
      div(
        cls := "text-theme-color font-bold dark:text-zinc-100 text-3xl",
        "Laravelista"
      )
    )
  )

def menuItem(
    text: String,
    href: String = "#",
    isActive: Boolean = false,
    isMobile: Boolean = false
) =
  val activeCls =
    "py-2 px-2 text-zinc-900 font-normal dark:text-zinc-100"
  val inactiveCls =
    "py-2 px-2 text-zinc-500 dark:text-zinc-400 hover:text-zinc-700 dark:hover:text-zinc-100 font-normal duration-100"

  val activeClsMobile =
    "no-underline text-zinc-700 dark:text-zinc-100 p-2 duration-100 rounded-lg hover:bg-hover-menu-bg dark:hover:bg-dark-hover-menu-bg"
  val inactiveClsMobile =
    "no-underline text-zinc-600 dark:text-zinc-400 p-2 duration-100 rounded-lg hover:bg-hover-menu-bg dark:hover:bg-dark-hover-menu-bg"

  val itemClass =
    (isMobile, isActive) match
      case (true, true)   => activeClsMobile
      case (true, false)  => inactiveClsMobile
      case (false, true)  => activeCls
      case (false, false) => inactiveCls

  a(
    cls := itemClass,
    attr("href") := href,
    text
  )

def isActiveRoute(currentRoute: Option[Route], targetRoute: Route) =
  currentRoute match
    case Some(route) => route == targetRoute
    case None        => false

def themeSwitchButton =
  button(
    `type` := "button",
    id := "theme-switch",
    cls := "p-2 rounded-full flex focus-visible:outline-none",
    aria.label := "Switch theme",
    svg(
      id := "theme-dark",
      fill := "currentColor",
      cls := "hidden w-6 shrink-0 dark:fill-dark-light-svg dark:stroke-dark-light-svg duration-500",
      viewBox := "0 0 512 512",
      xmlns := "http://www.w3.org/2000/svg",
      path(
        d := "M32 256c0-123.8 100.3-224 223.8-224c11.36 0 29.7 1.668 40.9 3.746c9.616 1.777 11.75 14.63 3.279 19.44C245 86.5 211.2 144.6 211.2 207.8c0 109.7 99.71 193 208.3 172.3c9.561-1.805 16.28 9.324 10.11 16.95C387.9 448.6 324.8 480 255.8 480C132.1 480 32 379.6 32 256z"
      )
    ),
    svg(
      id := "theme-light",
      fill := "currentColor",
      cls := "hidden w-6 shrink-0 dark:fill-dark-light-svg dark:stroke-dark-light-svg duration-500",
      viewBox := "0 0 512 512",
      xmlns := "http://www.w3.org/2000/svg",
      path(
        d := "M256 159.1c-53.02 0-95.1 42.98-95.1 95.1S202.1 351.1 256 351.1s95.1-42.98 95.1-95.1S309 159.1 256 159.1zM509.3 347L446.1 255.1l63.15-91.01c6.332-9.125 1.104-21.74-9.826-23.72l-109-19.7l-19.7-109c-1.975-10.93-14.59-16.16-23.72-9.824L256 65.89L164.1 2.736c-9.125-6.332-21.74-1.107-23.72 9.824L121.6 121.6L12.56 141.3C1.633 143.2-3.596 155.9 2.736 164.1L65.89 256l-63.15 91.01c-6.332 9.125-1.105 21.74 9.824 23.72l109 19.7l19.7 109c1.975 10.93 14.59 16.16 23.72 9.824L256 446.1l91.01 63.15c9.127 6.334 21.75 1.107 23.72-9.822l19.7-109l109-19.7C510.4 368.8 515.6 356.1 509.3 347zM256 383.1c-70.69 0-127.1-57.31-127.1-127.1c0-70.69 57.31-127.1 127.1-127.1s127.1 57.3 127.1 127.1C383.1 326.7 326.7 383.1 256 383.1z"
      )
    ),
    svg(
      id := "theme-automatic",
      fill := "currentColor",
      cls := "w-6 shrink-0 dark:fill-dark-light-svg dark:stroke-dark-light-svg duration-500",
      viewBox := "0 0 512 512",
      xmlns := "http://www.w3.org/2000/svg",
      path(
        d := "M512 256C512 397.4 397.4 512 256 512C114.6 512 0 397.4 0 256C0 114.6 114.6 0 256 0C397.4 0 512 114.6 512 256zM256 64V448C362 448 448 362 448 256C448 149.1 362 64 256 64z"
      )
    )
  )

def menu(activeRoute: Option[Route]) =
  div(
    cls := "items-center hidden md:flex text-lg",
    menuItem(
      Route.Home.name,
      href = Route.Home.url.toString,
      isActive = isActiveRoute(activeRoute, Route.Home)
    ),
    menuItem(
      Route.References.name,
      href = Route.References.url.toString,
      isActive = isActiveRoute(activeRoute, Route.References)
    ),
    menuItem(
      Route.Contact.name,
      href = Route.Contact.url.toString,
      isActive = isActiveRoute(activeRoute, Route.Contact)
    )
  )

val dot =
  div(
    cls := "w-1.5 h-1.5 bg-inactive-color dark:bg-dark-inactive-color group-hover:bg-theme-color dark:group-hover:bg-dark-theme-color rounded-full my-0 mx-0.5"
  )

val mobileNavbarToggle =
  button(
    `type` := "button",
    aria.label := "Toggle navbar",
    id := "mobile-navbar-toggle",
    cls := "md:hidden flex py-3.5 px-2.5 rounded-lg group hover:bg-hover-menu-bg dark:hover:bg-dark-hover-menu-bg focus:bg-hover-menu-bg dark:focus:bg-dark-hover-menu-bg",
    dot,
    dot,
    dot
  )

def navbar(activeRoute: Option[Route]) =
  div(
    cls := "flex items-center justify-between shrink-0 h-14 w-full px-5 sm:px-10 py-0 mt-4 sm:mt-0 whitespace-nowrap",
    logo,
    div(
      cls := "flex items-center",
      menu(activeRoute),
      themeSwitchButton,
      mobileNavbarToggle
    )
  )

def mobileNavbar(activeRoute: Option[Route]) =
  div(
    id := "mobile-navbar",
    cls := "overflow-auto py-6 px-5 sm:px-10 shrink-0 hidden md:hidden",
    div(
      cls := "side-wrapper",
      div(
        cls := "flex flex-col whitespace-nowrap",
        menuItem(
          Route.Home.name,
          isMobile = true,
          href = Route.Home.url.toString,
          isActive = isActiveRoute(activeRoute, Route.Home)
        ),
        menuItem(
          Route.References.name,
          isMobile = true,
          href = Route.References.url.toString,
          isActive = isActiveRoute(activeRoute, Route.References)
        ),
        menuItem(
          Route.Contact.name,
          isMobile = true,
          href = Route.Contact.url.toString,
          isActive = isActiveRoute(activeRoute, Route.Contact)
        )
      )
    )
  )

def footer =
  div(
    cls := "flex flex-col lg:flex-row justify-between py-5 px-5 sm:px-10 items-start lg:items-baseline",
    div(
      cls := "text-sm",
      div(
        "©️  ",
        typo.outboundLink(
          "Mario Bašić",
          URI.create("https://mariobasic.com").toURL(),
          includeRel = false
        ),
        " 2011-",
        Year.now.getValue.toString,
        ". All rights reserved. Built with ",
        typo
          .outboundLink("Scala", URI.create("https://scala-lang.org").toURL()),
        " and ",
        typo.outboundLink(
          "Tailwind CSS",
          URI.create("https://tailwindcss.com").toURL()
        ),
        "."
      ),
      div(
        cls := "flex mt-3 ml-0.5",
        typo.outboundIcon(
          svgs.patreonLogo,
          URI.create("https://patreon.com/laravelista").toURL(),
          "Patreon"
        ),
        typo.outboundIcon(
          svgs.paypalLogo,
          URI.create("https://www.paypal.me/laravelista").toURL(),
          "PayPal"
        ),
        typo.outboundIcon(
          svgs.digitaloceanLogo,
          URI.create("https://m.do.co/c/1bae3920f1e0").toURL(),
          "DigitalOcean"
        ),
        typo.outboundIcon(
          svgs.githubLogo,
          URI.create("https://github.com/laravelista").toURL(),
          "GitHub"
        )
      )
    ),
    div(
      cls := "text-sm mt-2 lg:mt-0 flex items-center justify-between",
      div(
        cls := "mr-2 flex gap-2",
        typo.outboundLink(
          "Go Visit",
          URI.create("https://govisit.hr").toURL(),
          false
        ),
        typo.outboundLink(
          "IzradaWeba",
          URI.create("https://izradaweba.eu").toURL(),
          false
        ),
        typo.routeLink(Route.PrivacyNotice),
        typo.outboundLink(
          "Source code",
          URI.create("https://github.com/laravelista/laravelista-n6").toURL()
        )
      )
    )
  )

def defaultLayout(
    children: Seq[ConcreteHtmlTag[String]],
    activeRoute: Option[Route],
    metaTitle: String,
    metaDescription: Option[String] = None,
    canonicalUrl: Option[Path] = None
) =
  doctype("html")(
    html(
      lang := "hr",
      head(
        title(metaTitle + " | " + appName),
        meta(charset := "UTF-8"),
        metaDescription match
          case Some(description) =>
            meta(name := "description", content := description)
          case None => ()
        ,
        meta(
          name := "viewport",
          content := "width=device-width, initial-scale=1.0"
        ),
        meta(
          name := "author",
          content := "Mario Bašić"
        ),
        canonicalUrl match
          case Some(path) =>
            link(
              href := s"https://laravelista.com${
                  if path == Root then "" else path.toString
                }",
              rel := "canonical"
            )
          case None => ()
        ,
        link(href := "/assets/css/index.css", rel := "stylesheet"),
        link(href := "/assets/img/favicon.ico", rel := "icon"),
        link(href := "/assets/img/favicon.png", rel := "shortcut icon"),
        link(
          href := "/assets/img/apple-touch-icon.png",
          rel := "apple-touch-icon"
        ),
        link(
          href := "/assets/img/apple-touch-icon-72x72.png",
          rel := "apple-touch-icon",
          attr("sizes") := "72x72"
        ),
        link(
          href := "/assets/img/apple-touch-icon-114x114.png",
          rel := "apple-touch-icon",
          attr("sizes") := "114x114"
        ),
        link(
          href := "/assets/img/apple-touch-icon-192x192.png",
          rel := "icon",
          attr("sizes") := "192x192"
        ),
        Config.analyticsEnabled match
          case true =>
            script(
              src := "https://plausible.laravelista.com/js/plausible.js",
              async,
              defer,
              attr("data-domain") := "laravelista.com"
            )
          case _ => ""
        ,
        script(src := "/assets/js/main.js")
      ),
      body(
        cls := s"flex items-center sm:p-8 w-full min-h-screen justify-center flex-col bg-zinc-100 dark:bg-zinc-900 text-zinc-700 dark:text-zinc-100",
        div(
          cls := "grow max-w-7xl w-full flex flex-col",
          navbar(activeRoute),
          mobileNavbar(activeRoute),
          div(
            cls := "flex flex-col grow w-full font-normal",
            div(
              cls := "flex flex-col px-5 py-4 sm:px-10 sm:py-7 h-full overflow-visible grow",
              children
            ),
            footer
          )
        )
      )
    )
  )
